package testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObjects.LoginPageObjects;

public class TC_0001LoginPageTestclass extends BaseClass {

	@Test
	public void LoginPageTest() throws IOException, InterruptedException {

		System.out.println("************started TC_0001LoginPageTestclass***********");
		LoginPageObjects lp = new LoginPageObjects(driver);
		lp.setuserNameAndPassword("rahulpatel@test.com", "d3f53133473ad17dd57ae126b281de78");
		log.info("Entered username and password");
		log.info("Clicking on login button");
		// lp.logout();
		log.info("Logged out successfully");
		System.out.println("************completed TC_0001LoginPageTestclass***********");
	}

}
