package lib.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.reader.ReadExcel;

public class PreAndPost extends WebDriverServiceImpl {

	public String tcn, td, nn, au, ct, ds;
	public String LeadID;
	
	@BeforeSuite
	public void beforeSuite() {
		startReport();
	}
	
	@BeforeClass
	public void beforeClass() {
		startTestCase(tcn, td); 

	}

	@BeforeTest
	public void beforeTest() {
		//startReport();	
	}

	@BeforeMethod
	@Parameters({ "url", "uname", "pwd" })
	public void beforeMethod(@Optional ("http://leaftaps.com/opentaps") String url, @Optional ("DemoSalesManager") String un, @Optional ("crmsfa") String pw) {
	
		startTestModule("Leads");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		webdriver = new ChromeDriver();

		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);

		driver.manage().window().maximize();
		driver.get(url);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, un);

		WebElement elePassword = locateElement("id", "password");
		type(elePassword, pw);

		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);

		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);

	}

	@AfterMethod
	public void afterMethod() {
		
		driver.close();

	}

	@AfterClass
	public void afterClass() {

	}

	@AfterTest
	public void afterTest() {

	}

	@AfterSuite
	public void afterSuit() {
			endResult();
	}
	
	@DataProvider (name = "ST")
	public Object[][] getdata() throws IOException
	
	{
		ReadExcel rexl = new ReadExcel();
		Object[][] data = rexl.readdata(ds);
		
		return data;
		
	}

	

}
