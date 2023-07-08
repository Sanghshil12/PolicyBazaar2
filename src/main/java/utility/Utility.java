package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 
{
	//screenshot
	//scrolling
	//excel data reading
	//wait
	public static void takeScreenshot(WebDriver driver, String fileName) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File("C:\\Users\\HP SSD\\eclipse-workspace\\PolicyBazaar\\ScreenShot\\" +fileName+".png");
		
		FileHandler.copy(source, destination);
		
		Reporter.log("ScreenShot is stored in location : "+destination, true);
		
		Reporter.log("Taking Screenshot.", true);
	}
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", element);

	Reporter.log("Scroolling Into View", true);
	}
	
	public static void waitUse(int waitTime) throws InterruptedException
	{
		Reporter.log("Waiting for "+waitTime+"Milliseconds.",true);
		Thread.sleep(waitTime);
	}
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream myFile=new FileInputStream("C:\\Users\\HP SSD\\eclipse-workspace\\program_study\\Policy.properties");
		prop.load(myFile);
		String value = prop.getProperty(key);
		Reporter.log("reading data "+key+"from propertyFile", true);
		return value;
	}

}
