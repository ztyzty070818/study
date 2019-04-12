package bigdata.hive;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.IMetaStoreClient;
import org.apache.hadoop.hive.metastore.RetryingMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.Database;
import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.thrift.TException;
import org.slf4j.Logger;

import java.util.List;

public class HiveClient {
//	protected final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
//	IMetaStoreClient client;
//
//	public HiveClient() {
//		try {
//			HiveConf hiveConf = new HiveConf();
//			hiveConf.addResource("hive-site.xml");
//			client = RetryingMetaStoreClient.getProxy(hiveConf);
//		} catch (MetaException ex) {
//			logger.error(ex.getMessage());
//		}
//	}
//
//	public List<String> getAllDatabases() {
//		List<String> databases = null;
//		try {
//			databases = client.getAllDatabases();
//		} catch (TException ex) {
//			logger.error(ex.getMessage());
//		}
//		return databases;
//	}
//
//	public Database getDatabase(String db) {
//		Database database = null;
//		try {
//			database = client.getDatabase(db);
//		} catch (TException ex) {
//			logger.error(ex.getMessage());
//		}
//		return database;
//	}
//
//	public List<FieldSchema> getSchema(String db, String table) {
//		List<FieldSchema> schema = null;
//		try {
//			schema = client.getSchema(db, table);
//		} catch (TException ex) {
//			logger.error(ex.getMessage());
//		}
//		return schema;
//	}
//
//	public List<String> getAllTables(String db) {
//		List<String> tables = null;
//		try {
//			tables = client.getAllTables(db);
//		} catch (TException ex) {
//			logger.error(ex.getMessage());
//		}
//		return tables;
//	}
//
//	public String getLocation(String db, String table) {
//		String location = null;
//		try {
//			location = client.getTable(db, table).getSd().getLocation();
//		}catch (TException ex) {
//			logger.error(ex.getMessage());
//		}
//		return location;
//	}

}