/*package runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateLead {
	
	
	ChromeDriver driver;
	
	@Given("open the browser")
	public void launchbrowser()
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@And("launch the url as (.*)")
	public void seturl(String url)
	{
		driver.get(url);
	}
	
	@Given("set the timeouts")
	public void waiting()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Given("maximize the browser")
	public void maxbrowser()
	{
		driver.manage().window().maximize();
	}
	
	@Given("enter the user name as (.*)")
	public void enterUserName(String unam)
	{
		driver.findElementById("username").sendKeys(unam);
	}
	
	@Given("enter the password as (.*)")
	public void enterPassword(String pwd)
	{
		driver.findElementById("password").sendKeys(pwd);
	}
	
	@Given("click Login")
	public void click_Login()
	{
		driver.findElementByClassName("decorativeSubmit").click();
	}
	
	
	@Given("click crmsfa")
	public void clickcrmsfa()
	{
		driver.findElementByLinkText("CRM/SFA").click();;
	}
	
	@Given("click Leads module")
	public void click_Lead_Module()
	{
		driver.findElementByLinkText("Leads").click();
	}
	
	@Given("click Create Lead")
	public void click_Create_Lead()
	{
		driver.findElementByLinkText("Create Lead").click();;
	}
	
	@Given("enter Company Name as (.*)")
	public void enter_Company_Name(String cnam)
	{
		driver.findElementById("createLeadForm_companyName").sendKeys(cnam);
	}
	
	@Given("enter First Name as (.*)")
	public void enter_First_Name(String fnam)
	{
		driver.findElementById("createLeadForm_firstName").sendKeys(fnam);
	}
	
	@Given("enter Last Name as (.*)")
	public void enter_Last_Name(String lnam)
	{
		driver.findElementById("createLeadForm_lastName").sendKeys(lnam);
	}
	
	@When("click Submit")
	public void click_Submit_Create_Lead() 
	{
		driver.findElementByClassName("smallSubmit").click();;
	}
	 
	@Then("lead should be created")
	public void verify_Create_Lead()
	{
		
		WebElement rCD = driver.findElementById("viewLead_companyName_sp");
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

	@But("lead should NOT be created")
	public void verify_Create_Lead_Failure()
	{
		WebElement rCD = driver.findElementByXPath("//li[@class ='errorMessage']");
		String eM = rCD.getText();
		
		if(eM.contains("parameter is missing"))
		{
			System.out.println(eM);
		}
		
		driver.close();
	}
	
	
	
}
*/