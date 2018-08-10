package bigdata.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

public class TestConf {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		System.out.println(configuration.get("fs.defaultFS"));
		System.out.println(configuration);

		configuration.addResource(new Path("/home/qwe/apps/hadoop-2.7.2/etc/hadoop/core-site.xml"));
		System.out.println(configuration.get("fs.defaultFS"));

		Configuration configuration1 = new Configuration();
		System.out.println(configuration1.get("fs.defaultFS"));
		System.out.println(configuration);

	}
}
