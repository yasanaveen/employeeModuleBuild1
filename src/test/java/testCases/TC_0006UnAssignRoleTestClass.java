package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmployeePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.UnAssignRolePageObjects;
import pageObjects.UnmapObjects;

public class TC_0006UnAssignRoleTestClass extends BaseClass {
	
	
	
	@Test
	public void unAssignRoleTest() throws InterruptedException {
		
		System.out.println("************started TC_0006UnAssignRoleTestClass***********");
		
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
		
		UnmapObjects unmap = new UnmapObjects(driver);
		unmap.clickUnmapBtn();
		log.info("Clicked on unmap button");
		
		UnAssignRolePageObjects unAssignRole = new UnAssignRolePageObjects(driver);
		unAssignRole.clickOnUnAssignRoleBtn();
		log.info("Clicked on unassign role button");
		
		log.info("unAssignRoleHeaderText:"+unAssignRole.getUnAssignRoleHeaderTxt());
		
		unAssignRole.setToDate("21-02-2026");
		log.info("Entered to date");
		
		log.info("current location:"+unAssignRole.getCurrentLocation());
		log.info("current campus:"+unAssignRole.getCurrentCampus());
		log.info("current role:"+unAssignRole.getCurrentRole());
		unAssignRole.setRemark("test unassign role");
		log.info("Entered remark");
		
		
		
		
		
	}

}
