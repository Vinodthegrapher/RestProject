package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMTabPage {
	
	@FindBy (xpath = "(//button[@type='button'])[4]")
	private WebElement addButton;
	
	private WebDriver driver;
	
	public PIMTabPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void clickOnAddButton() throws InterruptedException
	{
		addButton.click();
		Thread.sleep(3000);

	}
}
