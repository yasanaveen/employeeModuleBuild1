package testCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public WebDriver driver;
	public static Logger log;
	
	
	@BeforeClass
	public void setUp() {

		log = LogManager.getLogger(this.getClass());

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("http://192.168.20.19:8081/login");
		log.info("Browser launched and navigated to login page");
	}
	
	
	public void pageScroll() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,1000)");
	}
	

	@AfterClass
	public void tearDown() {
		//driver.quit();
		log.info("Browser closed");
	}

}
