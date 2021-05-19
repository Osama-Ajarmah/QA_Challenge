package properties.properties;

import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadLocator extends ReadProperty {

	public static String getPageElement(String element) {

		String locator = null;
		File Resource = null;

		// Define Folder location
		try {
			Resource = new File(ReadData("LOCATORS_FILES"));
		} catch (NullPointerException e) {
			e.printStackTrace(System.out);
			Assert.fail("\nPlease create xmlfiles folder in resource and move all XML locator files into,"
					+ " then back to play test cases\n");
		}
		// Read all xml files in specified Folder as array
		File[] files = Resource.listFiles();
		File file = null;

		// Read each file and from each file read the element provided
		// in the method then return it's value
		for (int i = 0; i < files.length; i++) {
			try {
				if (!files[i].toString().isEmpty() || !files[i].equals(null)) {
					file = files[i];
				} else {
					Assert.fail("\nThere is no Locator files specified or the name is wrong, "
							+ "please check Locator_File_Name in config file\n");
				}

				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(file);

				doc.getDocumentElement().normalize();

				// Assign the element tag that specified then check If the
				// element exist or not
				// If exist then program assign it's value to locator if not
				// send program to for loop to read next file
				NodeList loc = doc.getElementsByTagName(element);

				if (loc.getLength() == 0)
					continue;

				// Assign locator value then Check if the locator founded and
				// not null then no need to stay in for loop so the system break
				// the loop
				locator = loc.item(0).getTextContent();
				if (locator.length() != 0)
					break;
			} catch (Throwable e) {
				e.printStackTrace(System.out);
				Assert.fail("Can't find specified element please check element name or provided files");
			}
		}
		Assert.assertNotNull(locator,
				"You provided element isn't exist in XML Files, please check element (" + element + ")");
		return locator;
	}
}
