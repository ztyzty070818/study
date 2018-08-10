import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestLog {
	public static void main(String[] args) throws IOException {
		Logger logger = getLogger();
//		logger.
		logger.info("info ---------");
		logger.warn("warn -------");
		logger.debug("debug ------");
		logger.error("error ------");

		System.out.println("test");
	}

	public static Logger getLogger() throws IOException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("src/main/java/velocity/controller/log4j.properties");
		properties.load(fis);
		PropertyConfigurator.configure(properties);
		return Logger.getRootLogger();
	}
}
