package utilitiesFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	public static String getValueForKey(String Key) throws IOException
	{
		Properties p=new Properties();
		FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"\\Propertiesfile\\Environment.properties");
		p.load(fi);
		return p.getProperty(Key);
		
		
		
	}

}
