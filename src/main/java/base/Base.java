package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import utility.Utility;

public class Base 
{
//driver and browser setup
protected WebDriver driver;
public void launchBrowser()
{
	driver=new ChromeDriver();
	driver.get("https://policybazaar.com/");
	Reporter.log("Launching Browser.",true);
}
public void closeBrowser() throws InterruptedException
{
	Utility.waitUse(2000);
	driver.quit();
	Reporter.log("Closing Browser.", true);
}
}
