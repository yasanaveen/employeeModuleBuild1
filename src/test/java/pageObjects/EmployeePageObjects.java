package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utills.WaitUtill;

public class EmployeePageObjects {

	private WebDriver driver;
	private WaitUtill waitUtill;

	public EmployeePageObjects(WebDriver driver) {
		this.driver = driver;
		this.waitUtill = new WaitUtill(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[contains(@class,'item__Z--YO')])[4]")
	WebElement employeeBtn;

	@FindBy(xpath = "//*[contains(@class,'cardGreen__WLPta')]")
	WebElement employeeManegementCard;

	@FindBy(xpath = "//*[contains(@class,'header__wvQM9')]")
	WebElement employeeManagementHeaderTxt;

	@FindBy(xpath = "//*[contains(@class,'_input__8tnRD')]")
	WebElement searchInputField;

	@FindBy(xpath = "//*[text()='Location']")
	WebElement locationfilterBtn;

	@FindBy(xpath = "//*[text()='Campus']")
	WebElement campusFilterBtn;
	@FindBy(xpath = "(//*[contains(@type,'button')])[1]")
	WebElement campusDrpdown;
	@FindBy(xpath = "//*[contains(@id,'option-0')]")
	WebElement campusSelectOption;

	@FindBy(xpath = "//*[text()='Search']")
	WebElement clksearchBtn;

	@FindBy(xpath = "//*[contains(@class,'css-1rmzdyy')]")
	List<WebElement> profileCards;

	@FindBy(xpath = "//*[contains(@class,'__wIbg5')]")
	WebElement btnNxt;

	@FindBy(xpath = "//*[contains(@class,'__wUKVV  ')]")
	WebElement mappingRemappingBtn;

	@FindBy(xpath = "//*[contains(@class,'__NFSUg')]")
	WebElement assignGroupBtn;

	@FindBy(xpath = "//*[contains(@name,'workingStartDate')]")
	WebElement workingStartDateInputField;

	@FindBy(xpath = "//*[contains(@name,'city')]")
	WebElement cityInputField;

	@FindBy(xpath = "//*[contains(@name,'campus')]")
	WebElement campusInputField;

	@FindBy(xpath = "(//*[contains(@class,'__8U-AK ')])[1]")
	WebElement managerDropdown;

	@FindBy(xpath = "(//*[text()='Anuradha B'])[2]")
	WebElement managerSelectOption;

	@FindBy(xpath = "(//*[contains(@class,'__8U-AK ')])[2]")
	WebElement reportingManagerDropdown;

	@FindBy(xpath = "(//*[text()='Rajiya Shaik'])[2]")
	WebElement reportingManagerSelectOption;

	@FindBy(xpath = "//*[@name='remarks']")
	WebElement remarksInputField;

	@FindBy(xpath = "//*[contains(@class,'primary__wIbg5')]")
	WebElement confirmBtn;

	@FindBy(xpath = "//*[contains(@class,'__IEXua')]")
	WebElement cancelBtn;

	public void clickOnEmployeeBtn() {
		employeeBtn.click();
	}

	public void clickOnEmployeeManegementCard() {
		employeeManegementCard.click();
	}

	public String getEmployeeManagementHeaderTxt() {
		return employeeManagementHeaderTxt.getText();
	}

	public void clksearchEmployee() throws InterruptedException {
		Thread.sleep(2000);
		searchInputField.click();
		
	}

	public void filterOptions() throws InterruptedException {
		locationfilterBtn.click();
	}

//	public void campusFilter(String campusName)
//	{
//		campusFilterBtn.click();
//		campusDrpdown.click();
//		campusSelectOption.click();
//	}

	public void clksearchBtn() {
		waitUtill.waitForVisibility(clksearchBtn).click();
	}

	public void clkProfileCards() {

		int cardsToClick = Math.min(2, profileCards.size());

		for (int i = 0; i < cardsToClick; i++) {
			profileCards.get(i).click();

		}
	}

	public void clkNxtBtn() {
		btnNxt.click();
	}

	public void clickOnMappingRemappingBtn() {
		mappingRemappingBtn.click();
	}

	public void clickOnAssignGroupBtn() {
		assignGroupBtn.click();
	}

	public String getWorkingStartDate() {
		return workingStartDateInputField.getAttribute("value");
	}

	public String getCity() {
		return cityInputField.getAttribute("value");
	}

	public String getCampus() {
		return campusInputField.getAttribute("value");
	}

	public void clickOnManagerDropdown() {
		managerDropdown.click();
		managerSelectOption.click();
	}

	public void clickOnReportingManagerDropdown() {
		reportingManagerDropdown.click();
		reportingManagerSelectOption.click();
	}

	public void enterRemarks(String remarks) {
		remarksInputField.sendKeys(remarks);
	}

	public void clickOnConfirmBtn() {
		confirmBtn.click();
	}

	public void clickOnCancelBtn() {
		cancelBtn.click();
	}

}
