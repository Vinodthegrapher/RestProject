package Web.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
	
	@FindBy (xpath = "//p[@class='oxd-userdropdown-name']")
	private WebElement userDropDown;
	
	@FindBy (xpath = "//a[text()='Logout']")
	private WebElement logOutTab;
	
	private WebDriver driver;
	private Actions actions;
	
	public Header(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
		
	}

	public void clickOnUserDropDown() throws InterruptedException
	{
		actions.moveToElement(userDropDown).click().build().perform();
		Thread.sleep(500);
	}
	
	public void clickOnLogOutTab() throws InterruptedException
	{
		actions.moveToElement(logOutTab).click().build().perform();
		Thread.sleep(500);
	}
}
