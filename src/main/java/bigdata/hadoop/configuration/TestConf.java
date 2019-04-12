package bigdata.hadoop.configuration;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import http.HttpClient;
import http.Response;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class TestConf {

	private static Logger logger = LoggerFactory.getLogger(TestConf.class);


	private static int partitions;
	private static String columnDelimiter;
	private static String primaryKey;

	private static HttpClient httpClient = new HttpClient();
	private static Map<Integer, String> partitionAddressMap = Maps.newLinkedHashMap();
	private static Map<String, DimensionSpec> dimensionNameTypeMap = Maps.newLinkedHashMap();
	private static Map<String, String> columnNameTypeMap = Maps.newLinkedHashMap();

	private static int batchSize = 1000;
	private static String dataSource = "people";
	private static String hmasterAddress = "192.168.0.225:8086";
	private static String fileColumnDelimiter = "\t";
	private static String fileLineDelimiter = "\n";
	private static String filePath = "/tmp";
	private static String fileName = "sql-result.csv";

	public static void main(String[] args) throws IOException, JSONException, SQLException {

		TestConf t = new TestConf();
		t.init();
		t.checkColumn();
		t.saveToUindex();
	}

	private void saveToUindex() throws SQLException, IOException, JSONException {

		File recordFile = new File(filePath + "/" + fileName);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(recordFile));

		Map<Integer, String> dateDimensionIndexFormatMap = getDateDimensionIndexFormatMap();

		int primaryKeyIndex = 0;
		for(String name : dimensionNameTypeMap.keySet()) {
			if(name.equals(primaryKey)) {
				break;
			}
			primaryKeyIndex++;
		}

		Map<Integer, List<String>> recordMap = new HashMap<>();
		for(int i=0; i<partitions; i++) {
			recordMap.put(i, new ArrayList<>(batchSize));
		}

		String line;
		while ((line = bufferedReader.readLine()) != null) {
			String[] values = line.split(fileColumnDelimiter, -1);

			for(Map.Entry<Integer, String> indexFormatEntry : dateDimensionIndexFormatMap.entrySet()) {
				int index = indexFormatEntry.getKey();
				values[index] = parseTimestampToString(Long.parseLong(values[index]), indexFormatEntry.getValue());
			}

			int partitionNum = getPartitionNum(values[primaryKeyIndex]);

			List<String> recordList = recordMap.get(partitionNum);
			recordList.add(Joiner.on(columnDelimiter).join(values));
			if(recordList.size() >= batchSize) {
				addDataToDataSource(partitionNum, recordList);
				recordList.clear();
			}
		}

		for(Map.Entry<Integer, List<String>> entry : recordMap.entrySet()) {
			List<String> recordList = entry.getValue();
			if(recordList.size() > 0) {
				addDataToDataSource(entry.getKey(), recordList);
			}
		}
	}

	public Map<Integer, String> getDateDimensionIndexFormatMap() {
		Map<Integer, String> dateDimensionIndexFormatMap = Maps.newLinkedHashMap();
		int index = 0;
		for (DimensionSpec dimensionSpec : dimensionNameTypeMap.values()) {
			if (dimensionSpec.getType().equals("date")) {
				dateDimensionIndexFormatMap.put(index, dimensionSpec.getFormat());
			}
			index++;
		}
		return dateDimensionIndexFormatMap;
	}

	public String parseTimestampToString(long timestamp, String format) {
		switch (format) {
			case "posix":
				return String.valueOf(timestamp / 1000);
			case "nano":
				return String.valueOf(timestamp * 1000000L);
			default:
				return String.valueOf(timestamp);
		}
	}

	public boolean checkColumn() {
		// check length
		if (dimensionNameTypeMap.size() != columnNameTypeMap.size()) {
			logger.error("data base columns size is not equals uindex dimensions size.\n" +
							"data base size: " + columnNameTypeMap.size() +", columns: " + columnNameTypeMap.keySet() +
							"\nuindex size: " + dimensionNameTypeMap.size() + ", dimensions: " + dimensionNameTypeMap.keySet());
			return false;
		}

		// check column name
		if (!columnNameTypeMap.keySet().equals(dimensionNameTypeMap.keySet())) {
			logger.error("data base column name is not equals uindex dimensions name.\n" +
							"data base columns: " + columnNameTypeMap.keySet() + "\nuindex dimensions: " + dimensionNameTypeMap.keySet());
			return false;
		}

		// check column type
		for(String dimensionName : dimensionNameTypeMap.keySet()) {
			String primaryColumnType = columnNameTypeMap.get(dimensionName);
			String convertColumnType = convertDataBaseColumnTypeToJavaType(primaryColumnType);
			String dimensionType = dimensionNameTypeMap.get(dimensionName).getType();

			if(dimensionType.equals("date")) {
				if (!dimensionType.equals("long")) {
					logger.error("data base column type is not equals uindex dimensions type.\n" +
									"dimension name: " + dimensionName + "\n" +
									"expect column type: long");
				}
				return false;
			} else if(!convertColumnType.equals(dimensionType)) {
				logger.error("data base column type is not equals uindex dimensions type.\n" +
								"dimension name: " + dimensionName + "\n" +
								"data base column type primary: " + primaryColumnType + ", convert type: " + convertColumnType + "\n" +
								"uindex dimension type: " + dimensionType);
				return false;
			}
		}
		return true;
	}

	private String convertDataBaseColumnTypeToJavaType(String dataBaseColumnType) {
		if(dataBaseColumnType == null || dataBaseColumnType.length() == 0) {
			return null;
		}
		if(dataBaseColumnType.equals("bigint") || dataBaseColumnType.equals("int8")) {
			return "long";
		}
		if(dataBaseColumnType.contains("int")) {
			return "int";
		}
		if(dataBaseColumnType.equals("bit")) {
			return "boolean";
		}
		if(dataBaseColumnType.contains("float")) {
			return "double";
		}
		if(dataBaseColumnType.equals("decimal") || dataBaseColumnType.contains("money") || dataBaseColumnType.equals("numberic")) {
			return "decimal";
		}
		return "string";
	}

	private void getColumnNameTypeMapFromMetaFile() throws IOException {
		Map<String, String> columnNameTypeMap = Maps.newLinkedHashMap();

		File file = new File(filePath + "/meta.csv");
		String metaInfo = FileUtils.readFileToString(file);
		String[] metaInfoArr = metaInfo.split(fileLineDelimiter);
		String[] nameArr = metaInfoArr[0].split(fileColumnDelimiter);
		String[] typeArr = metaInfoArr[1].split(fileColumnDelimiter);

		if(nameArr.length != typeArr.length) {
			logger.error("name list size is not equals type array length!\n"
							+ "name list:" + Lists.newArrayList(nameArr) + "\ntype list:" + Lists.newArrayList(typeArr));
			throw new IOException("name list size is not equals type array length!");
		}

		for(int i=0; i<nameArr.length; i++) {
			columnNameTypeMap.put(nameArr[i], typeArr[i]);
		}

		TestConf.columnNameTypeMap = columnNameTypeMap;
	}

	private void init() throws IOException, JSONException {
		initPartitionAddressMap();
		initDataSourceMessage();
		getColumnNameTypeMapFromMetaFile();
	}

	private void initDataSourceMessage() throws IOException, JSONException {
		Response response = httpClient.get(String.format("http://%s/druid/hmaster/v1/datasources/dimensions/%s", hmasterAddress, dataSource));

		JSONObject dataSourceSpec = new JSONObject(response.getResult());

		// init param
		columnDelimiter = dataSourceSpec.getString("columnDelimiter");
		primaryKey = dataSourceSpec.getJSONObject("shardSpec").getString("dimension");
		partitions = dataSourceSpec.getInt("partitions");

		// get dimensionType map
		JSONArray dimensions = dataSourceSpec.getJSONArray("dimensions");
		for(int i=0; i<dimensions.length(); i++) {
			JSONObject dimension = dimensions.getJSONObject(i);
			String name = dimension.getString("name");
			String type = dimension.getString("type");
			String format = dimension.has("format") ? dimension.getString("format") : null;
			DimensionSpec dimensionSpec = new DimensionSpec(name, type, format);
			dimensionNameTypeMap.put(name, dimensionSpec);
		}
	}

	private void initPartitionAddressMap() throws IOException, JSONException {
		Response response = httpClient.get(String.format("http://%s/druid/hmaster/v1/datasources/serverview/writable/%s", hmasterAddress, dataSource));
		JSONObject partitionServerMap = new JSONObject(response.getResult());

		Iterator keyIterator = partitionServerMap.keys();
		while (keyIterator.hasNext()) {
			String key = (String) keyIterator.next();
			String address = (String) partitionServerMap.getJSONArray(key).get(0);
			partitionAddressMap.put(Integer.parseInt(key), address);
		}
	}

	private void addDataToDataSource(int partitionNum, List<String> datas) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("action", "U");
		jsonObject.put("dataSource", dataSource);
		jsonObject.put("partitionNum", partitionNum);
		jsonObject.put("columns", dimensionNameTypeMap.keySet());
		jsonObject.put("values", datas);

		String hregionServerAddress = partitionAddressMap.get(partitionNum);

		String url = String.format("http://%s/druid/regionServer/v1/push", hregionServerAddress);
		Response response = httpClient.post(url, jsonObject.toString());
		System.out.println(response.getResult());
	}

	private int getPartitionNum(String key) {
		final HashFunction hashFunction = Hashing.murmur3_32();
		return Math.abs(hashFunction.hashBytes(key.getBytes()).asInt()) % partitions;
	}


}
