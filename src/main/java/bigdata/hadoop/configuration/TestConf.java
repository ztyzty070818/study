package bigdata.hadoop.configuration;

import org.apache.hadoop.conf.Configuration;

public class TestConf {
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.addResource("test.xml");
		System.out.println(conf.getInt("size", 0));
	}
}
