package stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver_factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogInPage;

public class LoginPageSteps {
	
	LogInPage logInPage = new LogInPage(DriverFactory.getDriver());
	
	@Given("I am on the OpenCart login page")
	public void i_am_on_the_open_cart_login_page() {
	  WebDriver driver = DriverFactory.getDriver();
	  driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	}

	@When("I have entered valid username and password")
	public void i_have_entered_valid_username_and_password() {
		logInPage.enterEmail("tejas.abc@gmail.com");
		logInPage.enterPassword("tejas@1795");
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
	   logInPage.clickLogInButton();
	}

	@Then("I should be able to logged in successfuly")
	public void i_should_be_able_to_logged_in_successfuly() {
	   Assert.assertEquals(logInPage.checkLogOutLink(), true);
	}

	@When("I have entered invalid {string} and {string}")
	public void i_have_entered_invalid_and(String username, String password) {
		logInPage.enterEmail(username);
		logInPage.enterPassword(password);
	}
	

	@Then("I should see an error message indicating {string}")
	public void i_should_see_an_error_message_indicating(String error_message) {
	  if(logInPage.getErrorMessage().contains(error_message))
	  {
		  Assert.assertTrue(true);
	  }
	  else 
	  {
		  Assert.assertTrue(false);
	  }
	}

	@When("I click on the forgotten password link")
	public void i_click_on_the_forgotten_password_link() {
		logInPage.clickForgotPasswordLink();	
	}

	@Then("I should be redirected to the password reset page")
	public void i_should_be_redirected_to_the_password_reset_page() {
	    Assert.assertTrue(logInPage.getForgotPwdPageUrl().contains("account/forgotten"));
	}

}
