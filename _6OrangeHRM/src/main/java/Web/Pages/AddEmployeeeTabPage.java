package Web.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeeeTabPage {
	
	@FindBy (xpath = "//input[@name='firstName']")
	private WebElement firstNameFeild;
	
	@FindBy (xpath = "//input[@name='middleName']")
	private WebElement middleNameFeild;
	
	@FindBy (xpath = "//input[@name='lastName']")
	private WebElement lastNameFeild;
	
	@FindBy (xpath = "//input[@type='checkbox']")
	private WebElement createLoginDetailsTogalButton;
	
	@FindBy (xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
	private WebElement userNameInputFeild;
	
	@FindBy (xpath = "(//input[@type='password'])[1]")
	private WebElement passwordInputFeild;
	
	@FindBy (xpath = "(//input[@type='password'])[2]")
	private WebElement confirmPasswordInputFeild;
	
	
	@FindBy (xpath = "(//input[@type='radio'])[2]")
	private WebElement disabledRadioButton;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement saveButton;
	
	private WebDriver driver;
	private Actions actions;
	
	public AddEmployeeeTabPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	public void clickOnFirstNameFeild()
	{
		firstNameFeild.click();

	}
	
	public void sendDataIntoFirstNameFeild(String firstname) throws InterruptedException
	{
		firstNameFeild.sendKeys(firstname);
		Thread.sleep(2000);
	}
	
	public void clickOnMiddleNameFeild()
	{
		middleNameFeild.click();

	}
	
	public void sendDataIntoMiddleNameFeild(String middlename) throws InterruptedException
	{
		middleNameFeild.sendKeys(middlename);
		Thread.sleep(2000);
	}
	
	public void clickOnLastNameFeild() throws InterruptedException
	{
		lastNameFeild.click();

	}

	public void sendDataIntoLastNameFeild(String lastname) throws InterruptedException
	{
		lastNameFeild.click();
		lastNameFeild.sendKeys(lastname);
		Thread.sleep(1000);
	}
	
	public void clickOnCreateLoginDetailsTogalButton() throws InterruptedException
	{
		actions.moveToElement(createLoginDetailsTogalButton).click().build().perform();
		Thread.sleep(2000);
	}
	
	public void clickOnUserNameFeild()
	{
		actions.moveToElement(userNameInputFeild).click().build().perform();

	}
	
	public void sendDataIntoUserNameFeild(String username) throws InterruptedException
	{
		actions.moveToElement(userNameInputFeild).sendKeys(username).build().perform();
		Thread.sleep(500);

	}
	
	public void clickOnPasswordFeild()
	{
		actions.moveToElement(passwordInputFeild).click().build().perform();

	}
	
	public void sendDataIntoPasswordFeild(String password) throws InterruptedException
	{
		actions.moveToElement(passwordInputFeild).sendKeys(password).build().perform();
		Thread.sleep(2000);
	}
	
	public void clickOnConfirmPasswordFeild()
	{
		actions.moveToElement(confirmPasswordInputFeild).click().build().perform();

	}
	
	public void sendDataIntoConfirmPasswordFeild(String Cpassword) throws InterruptedException
	{
		actions.moveToElement(confirmPasswordInputFeild).sendKeys(Cpassword).build().perform();
		Thread.sleep(500);

	}
	
	public void clickOnRadioButton() throws InterruptedException
	{
		actions.moveToElement(disabledRadioButton).click().build().perform();
		Thread.sleep(500);
	}
	
	public void clickOnSaveButton()
	{
		actions.moveToElement(saveButton).click().build().perform();

	}
	
	
	
	
}
