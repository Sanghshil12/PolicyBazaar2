package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MyProfile 
{
	//variable
	
			@FindBy(xpath = "//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']") private WebElement userName;
			
			@FindBy(className = "h_l") private WebElement logOutButton;
			//constructor
			public MyProfile(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
			//method
			public String getActualUserName() 
			{
			Reporter.log("Getting actualUserName.", true);
			String actualUN=userName.getText();
			return actualUN;
			
			}
			public void clickOnLogOutButton()
			{
				logOutButton.click();
				Reporter.log("Logging out.", true);
			}
}
