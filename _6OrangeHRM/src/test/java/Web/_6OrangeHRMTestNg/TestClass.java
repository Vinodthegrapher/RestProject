package Web._6OrangeHRMTestNg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Web.Pages.*;


public class TestClass {
	
	private WebDriver driver;
	
	@BeforeClass
	public void lunchBrowser()
	{
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nagea\\Desktop\\Automation\\Tools\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		
	    driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}

	@BeforeMethod 
	public void login() throws InterruptedException
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(500);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnUserNameFeild();
		loginPage.sendDataIntoUserNameFeild("Admin"); //Admin
		loginPage.clickOnPasswordFeild();
		loginPage.sendDataIntoPasswordFeild("admin123");   //admin123
		loginPage.clickOnSubmitButton();
		
		
	}
	
	
	@Test 
	
	public void veifyAddEmployeeFunctionalty() throws InterruptedException
	{
		MenuIndex menuIndex = new MenuIndex(driver);
		menuIndex.clickOnPIMTab();
		
		Pages.PIMTabPage pIMTabPage = new Pages.PIMTabPage(driver);
		pIMTabPage.clickOnAddButton();
		
		AddEmployeeeTabPage addEmployeeeTabPage = new AddEmployeeeTabPage(driver);
		addEmployeeeTabPage.clickOnFirstNameFeild();
		addEmployeeeTabPage.sendDataIntoFirstNameFeild("uday");
		addEmployeeeTabPage.clickOnMiddleNameFeild();
		addEmployeeeTabPage.sendDataIntoMiddleNameFeild("doke");
		addEmployeeeTabPage.clickOnLastNameFeild();
		addEmployeeeTabPage.sendDataIntoLastNameFeild("patil");
		addEmployeeeTabPage.clickOnCreateLoginDetailsTogalButton();
		
		addEmployeeeTabPage.clickOnUserNameFeild();
		addEmployeeeTabPage.sendDataIntoUserNameFeild("tester@Uday");
		addEmployeeeTabPage.clickOnPasswordFeild();
		addEmployeeeTabPage.sendDataIntoPasswordFeild("uaday2023");
		addEmployeeeTabPage.clickOnConfirmPasswordFeild();
		addEmployeeeTabPage.sendDataIntoConfirmPasswordFeild("uday2023");
		addEmployeeeTabPage.clickOnRadioButton();
		addEmployeeeTabPage.clickOnSaveButton();
		
	
		 
		
		
		
	}
	@Test (priority = 1)
	public void verifyclaimFunctionalty() throws InterruptedException
	{

		MenuIndex menuIndex = new MenuIndex(driver);
		menuIndex.clickOnClaimTab();
		
		ClaimTabPage claimTabPage = new ClaimTabPage(driver);
		claimTabPage.clickOnEmployeeClaimTab();
		
		EmployeeClaimTabPage employeeClaimTabPage = new EmployeeClaimTabPage(driver);
		employeeClaimTabPage.clickOnViewDetailsButton();
		employeeClaimTabPage.clickOnCancelButton();
	}

	@AfterMethod
	public void logout() throws InterruptedException
	{
		Header header = new Header(driver);
		header.clickOnUserDropDown();
		header.clickOnLogOutTab();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}

}
