package properties.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

public class ReadProperty {

	public static String Par = "";
 
	public static String ReadData(String par) {
		File file = new File("src/main/resources/Config.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (Throwable e) {
			e.printStackTrace(System.out);
			Assert.fail("\nPlease check config file if exist\n");
		}
		Properties prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace(System.out);
			Assert.fail("\nPlease check config file Inputs\n");
		}

		return Par = prop.getProperty(par);
	}

}