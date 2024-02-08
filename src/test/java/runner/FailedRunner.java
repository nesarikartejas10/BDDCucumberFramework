package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"@target/FailedRun.txt"},
		glue = {"stepdefs", "hooks"}
		)
public class FailedRunner extends AbstractTestNGCucumberTests{

}
