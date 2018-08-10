package bigdata.hadoop.configuration;

import org.apache.hadoop.conf.Configuration;

public class TestCoreSite {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		System.out.println(configuration.get("fs.defaultFS"));

//		configuration.addDefaultResource("/home/qwe/Projects/azkaban-my/plugins/jobtype/azkaban-jobtype-3.0.0/gobblin/gobblin-site.xml");
//		System.out.println(configuration.get("fs.defaultFS"));
//
//		configuration.addResource("core-site.xml");
//		System.out.println(configuration.get("fs.defaultFS"));
//
//		System.out.println(configuration.get("hadoop.tmp.dir"));
	}
}
