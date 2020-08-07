package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	
	public static Properties userdata=
		LoadData(System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.properties");
	
	private static Properties LoadData(String path)
	{
		Properties prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}	
		  catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return prop;
	}
	

}
