package POM.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import lib.selenium.WebDriverServiceImpl;

public class MyHome_Page extends WebDriverServiceImpl {

	/*public MyHome_Page(EventFiringWebDriver efwdriver, ExtentTest exttest) {
		this.driver = efwdriver;
		this.test = exttest;
		PageFactory.initElements(efwdriver, this);
	}*/
	
	public MyHome_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Leads")
	WebElement eleLeadModule;

	@Given("click Leads module")
	public MyLeads_Page clickLeadModule() {
		click(eleLeadModule);
	/*	return new MyLeads_Page(driver, test);*/
		return new MyLeads_Page();
	}

}
