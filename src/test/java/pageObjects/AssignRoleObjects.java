package pageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utills.WaitUtill;

public class AssignRoleObjects {

	public WebDriver driver;
	public WaitUtill waitUtill;

	public AssignRoleObjects(WebDriver driver) {
		this.driver = driver;
		this.waitUtill = new WaitUtill(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//*[contains(@class,'__WunuO')])[2]")
	WebElement assignRoleBtn;

	@FindBy(xpath = "//*[contains(@class,'__ID42+ ')]")
	WebElement assignRoleProfileCard;

	@FindBy(xpath = "(//*[contains(@class,'__UaqIu')])[1]")
	WebElement remapLocationTnputField;
	@FindBy(xpath = "(//*[contains(@class,'__UaqIu')])[2]")
	WebElement currentCampusInputField;
	@FindBy(xpath = "(//*[contains(@class,'__UaqIu')])[3]")
	WebElement currentRoleInputField;

	@FindBy(xpath = "//*[contains(@class,'__k99Wn')]")
	WebElement lnkaddNewcampusAndRole;
	
	@FindBy(xpath = "(//*[contains(@class,'__8U-AK ')])[1]")
	WebElement selectCampusDpdown;
	@FindBy(xpath = "(//*[text()='CHANAKYA BHAVAN IPCC'])[2]")
	WebElement selectChanakyaOption;
	
	@FindBy(xpath = "(//*[contains(@class,'__8U-AK ')])[2]")
	WebElement selectRoleDpdown;
	@FindBy(xpath = "(//*[contains(@class,'__47FSz ')])[1]")
	WebElement selectRoleOption;
	
	@FindBy(xpath = "(//*[contains(@class,'__bV02r')])[2]")
	WebElement crossBtn;
	
	@FindBy(xpath = "//*[text()='Yes']")
	WebElement noBtnInConfirmationPopup;
	
	

	public void clickAssignRoleBtn() {
		waitUtill.waitForVisibility(assignRoleBtn).click();
	}

	public void sshotAssignRoleProfileCard() throws IOException {

		String timestamp = java.time.LocalDateTime.now()
				.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
		File src = assignRoleProfileCard.getScreenshotAs(OutputType.FILE);
		File tar = new File(
				System.getProperty("user.dir") + "\\Screenshots\\assignRoleProfileCard" + timestamp + ".png");
		FileUtils.copyFile(src, tar);
	}

	public String getRemapLocation() {
		return waitUtill.waitForVisibility(remapLocationTnputField).getAttribute("value");
	}

	public String getCurrentCampus() {

		WebElement firstCard = driver.findElement(By.xpath("(//*[contains(@class,'gridColumn__YOzX6')])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", firstCard);

		return waitUtill.waitForVisibility(currentCampusInputField).getAttribute("value");
	}
	
	public String getCurrentRole() {

		return waitUtill.waitForVisibility(currentRoleInputField).getAttribute("value");
	}
	
	public void clickLnkAddNewCampusAndRole() {
		waitUtill.waitForVisibility(lnkaddNewcampusAndRole).click();
	}
	
	public void selectCampusFromDpdown() {
		waitUtill.waitForClickable(selectCampusDpdown).click();
		waitUtill.waitForClickable(selectChanakyaOption).click();
	}
	
	public void selectRoleFromDpdown() {
		waitUtill.waitForClickable(selectRoleDpdown).click();
		waitUtill.waitForClickable(selectRoleOption).click();
	}
	
	public void clickCrossBtn() {
		waitUtill.waitForVisibility(crossBtn).click();
	}
	
	public void clickNoBtnInConfirmationPopup() {
		waitUtill.waitForVisibility(noBtnInConfirmationPopup).click();
	}
	
	
	
	
	
	
	
	
	
	

}
