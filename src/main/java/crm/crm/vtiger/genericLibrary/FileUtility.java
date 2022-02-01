package crm.crm.vtiger.genericLibrary;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * This Class has method which reads the data from .properties file.
 * @author rohit
 *
 */
public class FileUtility 
{
	/**
	 * This Method is used to read data from .properties file and returns value based on key passed in the argument.
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);
		Properties pLoad = new Properties();
		pLoad.load(fis);
		String value = pLoad.getProperty(key);
		return value;
		
	}

}
