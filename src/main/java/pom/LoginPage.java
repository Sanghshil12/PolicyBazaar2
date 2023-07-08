package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage 
{
	//Variable
	
		@FindBy(xpath = "//a[text()='Sign in']") private WebElement signInButtonHomePage;
		
		@FindBy(xpath =  "(//input[@type='number'])[2]") private WebElement mobileNumberField;
		
		@FindBy(xpath = "(//span[text()='Sign in with Password'])[2]") private WebElement signInWithPassword;
		
		@FindBy(name="password") private WebElement passwordField;
		
		@FindBy(xpath="//span[text()='Sign in']") private WebElement signInButton;
		
		@FindBy(xpath = "//div[text()='My Account']") private WebElement myAccountButton;
		
		@FindBy(xpath = "//span[text()=' My profile ']")private WebElement myProfile;
		
		//Constructor
		
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Method
		//1.click on signIn button
		public void clickOnHomePageSignInButton()
		{
			Reporter.log("clicking on home page signInButton", true);
			signInButtonHomePage.click();
		}
		
		//2.Enter mobile number
		public void enterMobileNumber(String mobNum)
		{
			Reporter.log("entering mobile number", true);
			mobileNumberField.sendKeys(mobNum);
		}
		
		//3.Click on Sign In With Password
		public void clickOnSignInWithPassword()
		{
			Reporter.log("clicking on signInWithPassword", true);
			signInWithPassword.click();
		}
		
		//4.enter password
		public void enterPassword(String pwd)
		{
			Reporter.log("entring password", true);
			passwordField.sendKeys(pwd);
		}
		
		//5.click on sign in button
		public void clickOnSignInButton()
		{
			Reporter.log("clicking on signInButton", true);
			signInButton.click();
		}
		
		//6.click on my account button
		public void clickOnMyAccountButton()
		{
			Reporter.log("clicking on myAccount Button", true);
			myAccountButton.click();
		}
		
		//7.click on my profile button
		public void clickOnMyProfileButton()
		{
			Reporter.log("clicking on myProfile Button", true);
			myProfile.click();
		}

}
