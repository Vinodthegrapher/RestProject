package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Browser {
	
	public  static WebDriver launchChrome()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\BrowserFiles\\chromedriver.exe");
         WebDriver driver = new ChromeDriver(options);
        
        return driver;
        
	}

	public static WebDriver launchFireFox()
	{
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\BrowserFiles\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
		
	}
	
	public static WebDriver launchEdge()
	{
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-orgins=*");
		
		WebDriver driver = new EdgeDriver();
		return driver;
		
	}
}
