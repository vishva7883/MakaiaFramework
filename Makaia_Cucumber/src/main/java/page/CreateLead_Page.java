package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import lib.selenium.WebDriverServiceImpl;

public class CreateLead_Page extends WebDriverServiceImpl {
	
/*	public CreateLead_Page(EventFiringWebDriver efwdriver, ExtentTest exttest) {
		this.driver = efwdriver;
		this.test = exttest;
		PageFactory.initElements(efwdriver, this);	
	}
*/	
	public CreateLead_Page() {
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how = How.ID, using = "createLeadForm_companyName")
	WebElement eleCompanyName;
	@Given("enter Company Name as (.*)")
	public CreateLead_Page typeCompanyName(String CompanyName)
	{
		type(eleCompanyName, CompanyName);
		return this;
	}
	
	@FindBy(id = "createLeadForm_firstName")
	WebElement eleFirstName;
	@Given("enter First Name as (.*)")
	public CreateLead_Page typeFirstName(String FirstName)
	{
		type(eleFirstName, FirstName);
		return this;
	}
	
	@FindBy(id = "createLeadForm_lastName")
	WebElement eleLastName;
	@Given("enter Last Name as (.*)")
	public CreateLead_Page typeLastName(String LastName)
	{
		type(eleLastName, LastName);
		return this;
	}
	
	@FindBy(className = "smallSubmit")
	WebElement eleCreateLead;
	@Given("click Submit")
	public ViewLead_Page clickCreateLead()
	{
		click(eleCreateLead);
		return new ViewLead_Page();
	}
	
	
	@FindBy(id = "viewLead_companyName_sp")
	WebElement rCD;
	@Then("lead should be created")
	public void verify_Create_Lead()
	{
		String rawCompanyDetails = rCD.getText();

		String[] rawCompanyName = (rawCompanyDetails.split("\\("));
		String companyName = rawCompanyName[0];

		String[] rawLeadID = (rawCompanyName[1].split("\\)"));
		String leadID = (rawLeadID[0]);
		
		if (leadID !="")
		{
			System.out.println("Lead Created Successfully!!");
			System.out.println("Created Company Name : " + companyName);
			System.out.println("Created Lead ID      : " + leadID);
		}
		
		else
		{
			System.out.println("Lead not created!!");
		}
		
		driver.close();
		
	}

	@FindBy(id = "//li[@class ='errorMessage']")
	WebElement rERR;
	@But("lead should NOT be created")
	public void verify_Create_Lead_Failure()
	{
		String eM = rERR.getText();
		
		if(eM.contains("parameter is missing"))
		{
			System.out.println(eM);
		}
		
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
