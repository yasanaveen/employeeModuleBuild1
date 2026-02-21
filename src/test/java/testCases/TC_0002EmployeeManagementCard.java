package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmployeePageObjects;
import pageObjects.LoginPageObjects;

public class TC_0002EmployeeManagementCard extends BaseClass {

	@Test
	public void EmployeeManagementCardTest() throws InterruptedException {

		System.out.println("************started TC_0002EmployeeManagementCard***********");

		LoginPageObjects lp = new LoginPageObjects(driver);
		lp.setuserNameAndPassword("rahulpatel@test.com", "d3f53133473ad17dd57ae126b281de78");
		log.info("Entered username and password");
		log.info("Clicking on login button");
		log.info("Logged in successfully");
		// lp.logout();
		log.info("Logged out successfully");

		EmployeePageObjects emp = new EmployeePageObjects(driver);
		emp.clickOnEmployeeBtn();
		log.info("Clicked on Employee module");
		emp.clickOnEmployeeManegementCard();
		log.info("Clicked on Employee Management card");

		String actual = emp.getEmployeeManagementHeaderTxt();
		Assert.assertEquals(actual, "Employee Management", "Employee Management header text is not matching");
		log.info("Employee Management header text is matching");

		emp.clksearchEmployee();
		log.info("Clicked on search input field");
		emp.filterOptions();

		// emp.campusFilter("NALLAKUNTA IPL");

		emp.clksearchBtn();
		log.info("Clicked on a search button");

		emp.clkProfileCards();
		log.info("Clicked on profile card");

		emp.clkNxtBtn();
		log.info("Clicked on next button");

		log.info("Selected filter option from dropdown");

		emp.clickOnMappingRemappingBtn();
		log.info("Clicked on mapping remapping button");

		emp.clickOnAssignGroupBtn();
		log.info("Clicked on assign group button");

		log.info("working start date:" + emp.getWorkingStartDate());

		log.info("city field:" + emp.getCity());
		log.info("campus field:" + emp.getCampus());

		emp.clickOnManagerDropdown();
		log.info("Clicked on manager dropdown");

		emp.clickOnReportingManagerDropdown();
		log.info("Clicked on reporting manager dropdown");

		emp.enterRemarks("remarks added");
		log.info("Entered remarks");

		// emp.clickOnConfirmBtn();
		// log.info("Clicked on confirm button");

		emp.clickOnCancelBtn();
		log.info("Clicked on cancel button");

		System.out.println("************completed TC_0002EmployeeManagementCard***********");
	}

}
