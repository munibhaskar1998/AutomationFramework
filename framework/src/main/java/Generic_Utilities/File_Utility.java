package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	
	/**
	 * This method is used to read data from properties file
	 * @param key
	 * @return
	 * @throws Throwable
	 */

	public String getKeyAndValuePair(String key) throws Throwable 
	{
	//	FileInputStream fis1 = new FileInputStream("./src/test/resources/files.properties");
		FileInputStream fis1 = new FileInputStream(IpathConstant.filepath);
		Properties pro = new Properties();
		
		pro.load(fis1);
		String value = pro.getProperty(key);
		return value;
		
		
	}

}
