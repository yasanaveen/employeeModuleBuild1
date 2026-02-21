package pageObjects;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utills.WaitUtill;

public class UnmapObjects {

	public WebDriver driver;
	public WaitUtill waitUtill;

	public UnmapObjects(WebDriver driver) {
		this.driver = driver;
		this.waitUtill = new WaitUtill(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[contains(@class,'__EsQ8R  ')]")
	WebElement unmapBtn;
	
	@FindBy(xpath = "//*[text()='UnAssign Group']")
	WebElement unAssignGroupBtn;
	
	@FindBy(xpath = "//*[contains(@class,'__Xugrz')]")
	WebElement popMessage;
	
	@FindBy(xpath = "(//*[contains(@class,'__WunuO')])[1]")
	WebElement unassignIndividualBtn;
	
	@FindBy(xpath = "//*[contains(@class,'__-d5hC')]")
	WebElement selectUnassignTypeHeaderTxt;
	
	@FindBy(xpath = "//*[text()='Partial Unassign']")
	WebElement partialUnassignOption;
	@FindBy(xpath = "//*[text()='Next']")
	WebElement nxtBtn;
	
	@FindBy(xpath = "(//*[@name='lastDate'])[1]")
	WebElement toDateInputField;
	
	@FindBy(xpath = "(//*[contains(@class,'__RxUPO ')])[1]")
	WebElement managerCheckbox;
	
	@FindBy(xpath = "(//*[contains(@class,'__RxUPO ')])[2]")
	WebElement reportingManagerCheckbox;
	
	@FindBy(xpath = "(//*[contains(@class,'__RxUPO ')])[3]")
	WebElement sharedCmpsCheckbox;
	@FindBy(xpath = "(//*[contains(@class,'__RxUPO ')])[4]")
	WebElement clkManinCampsCheckbox;
	@FindBy(xpath = "(//*[@name='remark'])[1]")
	WebElement remarkInputField;
	@FindBy(xpath = "(//*[text()='Confirm'])[1]")
	WebElement confirmBtn;
	
	
	public void clickUnmapBtn() {
		waitUtill.waitForVisibility(unmapBtn).click();
	}
	
	public void clickUnAssignGroupBtn() {
		waitUtill.waitForVisibility(unAssignGroupBtn).click();
	}
	
	public void popUpsshot() throws IOException
	{
		 String timeStamp = LocalDateTime.now()
//		            .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
		
		File src = popMessage.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "/screenshots/unmapPopMessage_"+timeStamp+".png");
		FileUtils.copyFile(src, dest);
	}
	
	public void clickUnassignIndividualBtn() {
		waitUtill.waitForVisibility(unassignIndividualBtn).click();
	}
	
	public String getSelectUnassignTypeHeaderTxt() throws InterruptedException {
		return waitUtill.waitForVisibility(selectUnassignTypeHeaderTxt).getText();
	}
	
	public void clickPartialUnassignOption() {
		waitUtill.waitForVisibility(partialUnassignOption).click();
		nxtBtn.click();
	}
	
	public void setToDate(String toDate) {
		waitUtill.waitForVisibility(toDateInputField).sendKeys(toDate);
	}
	
	public void clkmgrAndreportingMgrCheckbox() {

		WebElement firstCard = driver.findElement(By.xpath("(//*[contains(@class,'gridColumn__YOzX6')])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", firstCard);
		waitUtill.waitForClickable(managerCheckbox).click();
		waitUtill.waitForClickable(reportingManagerCheckbox).click();
		
	}
	
	public void clksharedAndMaincmpsCheckbox() {
		waitUtill.waitForClickable(sharedCmpsCheckbox).click();
		waitUtill.waitForClickable(clkManinCampsCheckbox).click();
	}
	public void setRemark(String remark) {
		waitUtill.waitForVisibility(remarkInputField).sendKeys(remark);
	}
	public void clickConfirmBtn() {
		waitUtill.waitForVisibility(confirmBtn).click();
	}

}
