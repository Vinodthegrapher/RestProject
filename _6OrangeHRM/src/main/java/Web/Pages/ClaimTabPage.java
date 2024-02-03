package Web.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClaimTabPage {
	
	@FindBy (xpath = "//a[text()='Employee Claims']")
	private WebElement employeeClaimTab;
	
	private WebDriver driver;
	private Actions actions;
	
	public ClaimTabPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
	}
	
		
	public void clickOnEmployeeClaimTab() throws InterruptedException
	{
		actions.moveToElement(employeeClaimTab).click().build().perform();
		Thread.sleep(500);
	}

}
