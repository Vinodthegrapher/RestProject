package Web.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (xpath = "//input[@name='username']")
	private WebElement userNameFeild;
	
	@FindBy (xpath = "//input[@name='password']")
	private WebElement passwordFeild;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement submitButton;
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void clickOnUserNameFeild() throws InterruptedException
	{
		userNameFeild.click();	
		Thread.sleep(500);
	}
	
	public void sendDataIntoUserNameFeild(String username)
	{
		userNameFeild.sendKeys(username);
	}
	
	public void clickOnPasswordFeild()
	{
		passwordFeild.click();
	}
	
	public void sendDataIntoPasswordFeild(String password)
	{
		passwordFeild.sendKeys(password);
	}
	
	public void clickOnSubmitButton() throws InterruptedException
	{
		submitButton.click();
		Thread.sleep(2000);
	}
}
