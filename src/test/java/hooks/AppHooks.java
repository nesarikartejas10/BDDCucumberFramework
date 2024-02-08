package hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driver_factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	
	WebDriver driver;
	@Before
	public void launchBrowser()
	{
		DriverFactory df = new DriverFactory();
		driver = df.initBrowser();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@After(order = 2)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) 
		{
			String scenarioName = scenario.getName();
			scenarioName.replace(" ", "_");
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			byte[] source = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(source, "image/png", scenarioName);
		}
	}
	
	@After(order = 1)
	public void quitBrowser() 
	{
		try {
			Thread.sleep(2000);
			driver.close();
		} catch (Exception e) {
			
		}
	}


}
