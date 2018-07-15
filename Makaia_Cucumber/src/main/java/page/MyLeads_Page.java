package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import lib.selenium.WebDriverServiceImpl;

public class MyLeads_Page extends WebDriverServiceImpl {
	
	/*public MyLeads_Page(EventFiringWebDriver efwdriver, ExtentTest exttest) {
		this.driver = efwdriver;
		this.test = exttest;
		PageFactory.initElements(efwdriver, this);
	}*/
	
	public MyLeads_Page(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Create Lead")
	WebElement eleCreateLead;
	@Given("click Create Lead")
	public CreateLead_Page clickCreateLead()
	{
		click(eleCreateLead);
		return new CreateLead_Page();
	}

	@FindBy(linkText = "Find Leads")
	WebElement eleFindLeads;
	@Given("click Find Leads")
	public CreateLead_Page clickFindLeads()
	{
		click(eleFindLeads);
		return new CreateLead_Page();
	}
	
	@FindBy(linkText = "Merge Leads")
	WebElement eleMergeLeads;
	@Given("click Merge Leads")
	public CreateLead_Page clickMergeLeads()
	{
		click(eleMergeLeads);
		return new CreateLead_Page();
	}
	
	
}
