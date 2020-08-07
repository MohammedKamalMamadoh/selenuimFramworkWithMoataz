package utilitites;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper{
	
	public static void CaptureScreenShots(WebDriver driver,String screenshotName) throws IOException 
	{
		Path destnation = Paths.get("./screenshoots",screenshotName+".png");
		Files.createDirectories(destnation.getParent());
		FileOutputStream out= new FileOutputStream(destnation.toString());
		out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
		out.close();
	
	}
	
}
