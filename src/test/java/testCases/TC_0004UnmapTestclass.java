package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmployeePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.UnmapObjects;

public class TC_0004UnmapTestclass extends BaseClass {

	@Test
	public void UnmapTest() throws InterruptedException, IOException {
		System.out.println("************started TC_0004UnmapTestclass***********");

		LoginPageObjects lp = new LoginPageObjects(driver);
		lp.setuserNameAndPassword("rahulpatel@test.com", "d3f53133473ad17dd57ae126b281de78");
		log.info("Entered username and password");
		log.info("Clicking on login button");

		EmployeePageObjects emp = new EmployeePageObjects(driver);
		emp.clickOnEmployeeBtn();
		emp.clickOnEmployeeManegementCard();
		emp.clksearchEmployee();
		emp.clksearchBtn();
		emp.clkProfileCards();
		emp.clkNxtBtn();

		UnmapObjects unmap = new UnmapObjects(driver);
		unmap.clickUnmapBtn();
		log.info("Clicked on unmap button");
		unmap.clickUnAssignGroupBtn();
		log.info("Clicked on unassign group button");
		unmap.popUpsshot();
		log.info("Unmap pop up screen shot taken");
		unmap.clickUnassignIndividualBtn();
		log.info("Clicked on unassign individual button");
		
		Assert.assertEquals(unmap.getSelectUnassignTypeHeaderTxt(), "Select UnAssign Type", "the text was not matched");
		log.info("Select Unassign Type header text is matching");
		
		unmap.clickPartialUnassignOption();
		log.info("Clicked on partial unassign option");
		unmap.setToDate("21-02-2026");
		log.info("Entered to date");
		unmap.clkmgrAndreportingMgrCheckbox();
		log.info("Clicked on manager and reporting manager checkbox");
		unmap.clksharedAndMaincmpsCheckbox();
		log.info("Clicked on shared and main campus checkbox");
		unmap.setRemark("test unmap");
		log.info("Entered remark");
//		unmap.clickConfirmBtn();
//		log.info("Clicked on confirm button");
		log.info("************completed TC_0004UnmapTestclass***********");
		
		
		

	}

}
