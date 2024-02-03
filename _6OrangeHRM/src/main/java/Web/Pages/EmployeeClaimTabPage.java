package Web.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeClaimTabPage {
	
	@FindBy (xpath = "(//button[@type='button'])[6]")
	private WebElement viewDetailsButton;
	
	@FindBy (xpath = "(//button[@type='button'])[4]")
	private WebElement cancelButton;
	
	private WebDriver driver;
	private Actions actions;
	
	public EmployeeClaimTabPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	
	public void clickOnViewDetailsButton() throws InterruptedException
	{
		actions.moveToElement(viewDetailsButton).click().build().perform();
		Thread.sleep(500);
	}
	
	public void clickOnCancelButton() throws InterruptedException
	{
		actions.moveToElement(cancelButton).click().build().perform();
		Thread.sleep(500);

	}

}
