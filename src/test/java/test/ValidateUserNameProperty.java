package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.LoginPage;
import pom.MyProfile;
import utility.Utility;
import base.Base;

public class ValidateUserNameProperty extends Base 
{
	
		LoginPage login;
		MyProfile myProfile;
		String TCID ="PB_TC2580";
		
	@BeforeClass
	public void launchPolicyBazaar() throws InterruptedException, IOException
	{
		Utility.waitUse(2000);
		launchBrowser();
		login=new LoginPage(driver);
		myProfile=new MyProfile(driver);
	  }
	@BeforeMethod
	public void signInPolicyBazaar() throws EncryptedDocumentException, IOException, InterruptedException
	{
		login.clickOnHomePageSignInButton();
		Utility.waitUse(2000);
		login.enterMobileNumber(Utility.readDataFromPropertyFile("moNum"));
		login.clickOnSignInWithPassword();
		Utility.waitUse(2000);
		login.enterPassword(Utility.readDataFromPropertyFile("pswd"));
		login.clickOnSignInButton();
		Utility.waitUse(2000);
		login.clickOnMyAccountButton();
		Utility.waitUse(2000);
		login.clickOnMyProfileButton();
		Utility.waitUse(2000);
		
		Set<String> allPageID = driver.getWindowHandles();
		ArrayList<String> allID=new ArrayList<>(allPageID);
		//String mainPage = allID.get(0);
		String childPage = allID.get(1);
		driver.switchTo().window(childPage);
		Reporter.log("Switching to childpage.", true);
		Utility.waitUse(2000);
	}
	@Test
	public void validateUserName() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String expectedUN = Utility.readDataFromPropertyFile("UN");
		Utility.waitUse(2000);
		String actualUN = myProfile.getActualUserName();
		
		Assert.assertEquals(actualUN, expectedUN, "Actual & Expected username are not matching, TC is failed.");
		
		Utility.takeScreenshot(driver, actualUN +" "+TCID);
		Utility.waitUse(2000);
	}
	@AfterMethod
	public void logOut()
	{
		myProfile.clickOnLogOutButton();
	}
	@AfterClass
	public void close() throws InterruptedException
	{
		Utility.waitUse(2000);
		closeBrowser();
	}
}
