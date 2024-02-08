package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LogInPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(id = "input-email")
	private WebElement emailInputLocator;
	
	@FindBy(id = "input-password")
	private WebElement passwordInputLocator;
	
	@FindBy(xpath = "//*[@type='submit']")
	private WebElement logInButtonInputLocator;
	
	private By errorMessageLocator = By.xpath("//div[contains(@class,'alert-danger')]");
	
	private By forgotpasswordLinkLocator = By.partialLinkText("Forgotton Password");
	
	private By logOutLinkLocator = By.linkText("Logout");

	
	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public void enterEmail(String email) {
		emailInputLocator.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordInputLocator.sendKeys(password);
	}
	
	public void clickLogInButton() {
		logInButtonInputLocator.submit();
	}
	
	public String getErrorMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
		String errorMessage = driver.findElement(errorMessageLocator).getText();
		return errorMessage;
	}
	
	public void clickForgotPasswordLink() {
		driver.findElement(forgotpasswordLinkLocator).click();
	}
	
	public boolean checkForgotPasswordLink() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(forgotpasswordLinkLocator));
		return driver.findElement(forgotpasswordLinkLocator).isDisplayed();
	}
	
	public boolean checkLogOutLink() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(logOutLinkLocator));
		return driver.findElement(logOutLinkLocator).isDisplayed();
	}
	
	public void logIn(String email, String password) {
		emailInputLocator.sendKeys(email);
		passwordInputLocator.sendKeys(password);
		logInButtonInputLocator.click();
	}
	
	public String getForgotPwdPageUrl()
	{
		String forgotPwdPageUrl = driver.getCurrentUrl();
		return forgotPwdPageUrl;
	}
	
}
