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

public class AssignIndividualPageObjects {

	public WebDriver driver;
	public WaitUtill waitUtill;

	public AssignIndividualPageObjects(WebDriver driver) {
		this.driver = driver;
		this.waitUtill = new WaitUtill(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[contains(@class,'__WunuO')])[1]")
	WebElement assignBtn;

	@FindBy(xpath = "//*[contains(@class,'__Eu6NI')]//div")
	WebElement assignHeaderTxt;

	@FindBy(xpath = "//*[contains(@class,'employeeDetailsCard__ID42+ ')]")
	WebElement employeeDetailsCard;

	@FindBy(xpath = "//*[contains(@title,'GNT313463')]")
	WebElement employeePayrollId;

	@FindBy(xpath = "(//*[contains(@class,'__UaqIu')])[1]")
	WebElement cityInputField;

	@FindBy(xpath = "(//*[contains(@class,'__UaqIu')])[2]")
	WebElement mainCmpsinputfield;

	@FindBy(xpath = "(//*[text()='ACADEMIC'])[2]")
	WebElement departmentDpdwn;
	@FindBy(xpath = "//*[text()='MANAGEMENT']")
	WebElement selectManagementOption;

	@FindBy(xpath = "(//*[contains(@class,'__8U-AK ')])[5]")
	WebElement designationDpdown;
	@FindBy(xpath = "//*[text()='DEAN']")
	WebElement selectDesignationOption;

	@FindBy(xpath = "(//*[contains(@class,'__8U-AK ')])[6]")
	WebElement reportingmanagerDpdown;
	@FindBy(xpath = "(//*[text()='Anuradha B'])[2]")
	WebElement selectReportingManagerOption;

	@FindBy(xpath = "(//*[contains(@class,'__8U-AK ')])[7]")
	WebElement managerDpdown;
	@FindBy(xpath = "//*[text()='Rajiya Shaik']")
	WebElement selectManagerOption;

	@FindBy(xpath = "//*[@name='workingStartDate']")
	WebElement dateInputField;
	
	@FindBy(xpath = "(//*[text()='Confirm'])[1]")
	WebElement confirmBtn;

	public void clickOnIndividualAssignBtn() {
		assignBtn.click();
	}

	public String getAssignHeaderTxt() {
		return assignHeaderTxt.getText();
	}

	public void employeeDetails() throws IOException {
		
		 String timeStamp = LocalDateTime.now()
				 .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
		
		
		File src = employeeDetailsCard.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "\\screenshots\\employeeDetails"+timeStamp+".png");
		FileUtils.copyFile(src, dest);

		// return employeeDetailsCard.getAttribute("value");

	}

	public String getEmployeePayrollId() {
		return employeePayrollId.getText();
	}

	public String getcityInputField() {
		return cityInputField.getAttribute("value");
	}

	public String getmainCmpsinputfield() {
		return mainCmpsinputfield.getAttribute("value");
	}

	public void clkDepartmentDpdown() {

		WebElement firstCard = driver.findElement(By.xpath("(//*[contains(@class,'gridColumn__YOzX6')])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", firstCard);

		waitUtill.waitForClickable(departmentDpdwn).click();
		waitUtill.waitForClickable(selectManagementOption).click();
	}

	public void selectDesignation() {
		waitUtill.waitForClickable(designationDpdown).click();
		waitUtill.waitForClickable(selectDesignationOption).click();
	}

	public void selectReportingManager() {
		waitUtill.waitForClickable(reportingmanagerDpdown).click();
		waitUtill.waitForClickable(selectReportingManagerOption).click();
	}

	public void selectManager() {
		waitUtill.waitForClickable(managerDpdown).click();
		waitUtill.waitForClickable(selectManagerOption).click();
	}
	
	public String getDateInputField() {
		return dateInputField.getAttribute("value");
	}
	
	public void clickOnConfirmBtn() {
		confirmBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	

}
