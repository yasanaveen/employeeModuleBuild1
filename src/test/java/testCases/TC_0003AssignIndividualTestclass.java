package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AssignIndividualPageObjects;
import pageObjects.EmployeePageObjects;
import pageObjects.LoginPageObjects;

public class TC_0003AssignIndividualTestclass extends BaseClass {

	@Test
	public void assignIndividual() throws InterruptedException, IOException {

		log.info("************started TC_0003AssignIndividualTestclass***********");

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
		emp.clickOnMappingRemappingBtn();
		log.info("Clicked on mapping remapping button");

		AssignIndividualPageObjects assignIn = new AssignIndividualPageObjects(driver);
		assignIn.clickOnIndividualAssignBtn();
		log.info("Clicked on assign button");

//		String actual=assignIn.getAssignHeaderTxt();
//		log.info("Assign header text is: "+actual);
//		Assert.assertEquals(actual, "Assign Campus To Employee", "Assign header text is not matching");
//		log.info("Assign header text is matching");

		assignIn.employeeDetails();
		log.info("employee screen shot taken");

		log.info("payrollid:" + assignIn.getEmployeePayrollId());

		log.info("remapping cityfield value:" + assignIn.getcityInputField());
		log.info("remapping campusfield value:" + assignIn.getmainCmpsinputfield());
		
		assignIn.clkDepartmentDpdown();
		log.info("Clicked on department dropdown");
		
		assignIn.selectDesignation();
		log.info("Selected designation from dropdown");
		
		assignIn.selectReportingManager();
		log.info("Selected reporting manager from dropdown");
		
		assignIn.selectManager();
		log.info("Selected manager from dropdown");
		
		log.info("date printed:"+assignIn.getDateInputField());
		
		assignIn.clickOnConfirmBtn();
		log.info("Clicked on confirm button");
		
		log.info("************completed TC_0003AssignIndividualTestclass***********");
		
		
		

//		pageScroll();
//		assignIn.clickOnSharedcmpscloseBtn();
//		log.info("Clicked on shared campus close button");

	}

}
