package bigdata.hadoop.configuration;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import http.HttpClient;
import http.Response;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class TestSqlToUindex {

	private String createTableJson;
	private String hmasterIp;
	private String hregionServerIp;
	private String dataSource;
	private int partitions;
	private String columnDelimiter;
	private int batchSize;
	private String primaryKey;

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
		System.out.println(System.getenv("USER"));

//		process.waitFor();
	}

}
