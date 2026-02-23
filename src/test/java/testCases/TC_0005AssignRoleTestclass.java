package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AssignRoleObjects;
import pageObjects.EmployeePageObjects;
import pageObjects.LoginPageObjects;

public class TC_0005AssignRoleTestclass extends BaseClass {

	@Test
	public void assignRoleTest() throws InterruptedException, IOException {

		System.out.println("************started TC_0005AssignRoleTestclass***********");
		LoginPageObjects lp = new LoginPageObjects(driver);
		lp.setuserNameAndPassword("rahulpatel@test.com", "d3f53133473ad17dd57ae126b281de78");
		log.info("Entered username and password");
		log.info("Clicking on login button");

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
		emp.clickOnMappingRemappingBtn();
		log.info("Clicked on assign group button");

		AssignRoleObjects assignRole = new AssignRoleObjects(driver);
		assignRole.clickAssignRoleBtn();
		log.info("Clicked on assign role button");
		assignRole.sshotAssignRoleProfileCard();

		log.info("get currentremap location:" + assignRole.getRemapLocation());
		log.info("get currentremap campus:" + assignRole.getCurrentCampus());
		log.info("get currentrole city:" + assignRole.getCurrentRole());

		assignRole.clickLnkAddNewCampusAndRole();
		log.info("Clicked on add new campus and role link");

		assignRole.selectCampusFromDpdown();
		log.info("Selected campus from dropdown");
		assignRole.selectRoleFromDpdown();
		log.info("Selected role from dropdown");
		Thread.sleep(2000);
		assignRole.clickCrossBtn();
		log.info("Clicked on cross button");
		assignRole.clickNoBtnInConfirmationPopup();
		log.info("Clicked on no button in confirmation popup");

	}

}
