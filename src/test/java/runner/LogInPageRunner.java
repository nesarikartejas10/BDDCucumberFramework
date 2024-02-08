package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src\\test\\resource\\features\\LoginPage.feature"},
		//features = {"@target/FailedRun.txt"},
		glue = {"stepdefs", "hooks"},
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/FailedRun.txt"},
		publish = true,
		monochrome = false,
		dryRun = false
		)



public class LogInPageRunner extends AbstractTestNGCucumberTests{

}
