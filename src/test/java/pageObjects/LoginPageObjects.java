package pageObjects;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utills.WaitUtill;

public class LoginPageObjects {

	private WebDriver driver;
	private WaitUtill waitUtill;

	public LoginPageObjects(WebDriver driver) {
		this.driver = driver;
		this.waitUtill = new WaitUtill(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "emailId")
	WebElement emailInputField;
	@FindBy(id = "password")
	WebElement passwordInputField;
	@FindBy(xpath = "//*[text()='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//*[contains(@class,'userinfo__UeAp')]")
	WebElement userInfo;

	@FindBy(xpath = "//*[text()='Sign out']")
	WebElement logoutBtn;

	public void urlValidation() throws IOException {

		try {
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = "http://192.168.20.19:8081/";

			System.out.println("Expected URL: " + expectedUrl);
			System.out.println("Actual URL: " + actualUrl);

			Assert.assertEquals(actualUrl, expectedUrl, "URL is not matching");

			System.out.println("URL is matching");
		} catch (AssertionError e) {
			System.out.println("Assertion Failed — Taking Screenshot...");
			throw e;
		}

	}

	public void setuserNameAndPassword(String email, String password) {
		waitUtill.waitForVisibility(emailInputField).sendKeys(email);
		waitUtill.waitForVisibility(passwordInputField).sendKeys(password);
		waitUtill.waitForVisibility(loginBtn).click();

	}

	public void logout() {
		waitUtill.waitForVisibility(userInfo).click();
		waitUtill.waitForVisibility(logoutBtn).click();
	}

}
