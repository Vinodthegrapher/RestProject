package Web.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuIndex {
	
	@FindBy (xpath = "//span[text()='PIM']")
	private WebElement PIMTab;

	
	@FindBy (xpath = "//span[text()='Claim']")
	private WebElement claimTab;
	
	private WebDriver driver;
	private Actions actions;
	
	public MenuIndex(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	public void  clickOnPIMTab() throws InterruptedException
	{
		PIMTab.click();
		Thread.sleep(2000);
	}

	public void clickOnClaimTab() throws InterruptedException
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(claimTab).click().build().perform();
		Thread.sleep(500);
}
}
