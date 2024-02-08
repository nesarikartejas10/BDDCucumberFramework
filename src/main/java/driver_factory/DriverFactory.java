package driver_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverFactory {

	static WebDriver driver; 

	public WebDriver initBrowser() {
		driver = new ChromeDriver();
		return driver;

	}

	public static WebDriver getDriver() {
		
		return driver;
	}

}
