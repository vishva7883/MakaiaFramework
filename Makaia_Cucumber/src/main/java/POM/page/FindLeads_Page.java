package POM.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class FindLeads_Page extends WebDriverServiceImpl {
	
	public FindLeads_Page(EventFiringWebDriver efwdriver, ExtentTest exttest) {
		this.driver = efwdriver;
		this.test = exttest;
		PageFactory.initElements(efwdriver, this);
	}
	
	
	@FindBy(linkText = "Name and ID")
	WebElement eleFind_Leads_by_NameID;
	public FindLeads_Page clickFindByNameID()
	{
		click(eleFind_Leads_by_NameID);
		return this;
	}
	
	
	@FindBy(name = "id")
	WebElement eleFind_Leads_by_NameID_Lead_ID;
	public FindLeads_Page typeLeadID(String LeadID)
	{
		type(eleFind_Leads_by_NameID_Lead_ID, LeadID);
		return this;
	}
	
	
	@FindBy(xpath = "(//input[@name='firstName'])[3]")
	WebElement eleFind_Leads_by_NameID_First_Name;
	public FindLeads_Page typeFirstName(String FName)
	{
		type(eleFind_Leads_by_NameID_First_Name, FName);
		return this;
	}
	
	
	@FindBy(xpath = "(//input[@name='lastName'])[3]")
	WebElement eleFind_Leads_by_NameID_Last_Name;
	public FindLeads_Page typeLastName(String LName)
	{
		type(eleFind_Leads_by_NameID_Last_Name, LName);
		return this;
	}
	
	
	@FindBy(xpath = "(//input[@name='companyName'])[2]")
	WebElement eleFind_Leads_by_NameID_Company_Name;
	public FindLeads_Page typeCompanyName(String CName)
	{
		type(eleFind_Leads_by_NameID_Company_Name, CName);
		return this;
	}
	
	
	@FindBy(linkText = "Phone")
	WebElement eleFind_Leads_by_Phone;
	public FindLeads_Page clickFindByPhone()
	{
		click(eleFind_Leads_by_Phone);
		return this;
	}

	
	@FindBy(name = "phoneNumber")
	WebElement eleFind_Leads_by_Phone_Phone_Number;
	public FindLeads_Page typePhoneNumber(String phn)
	{
		type(eleFind_Leads_by_Phone_Phone_Number, phn);
		return this;
	}

	@FindBy(name = "Email")
	WebElement eleFind_Leads_by_Email_Email_ID;
	@FindBy(linkText = "Email")
	WebElement eleFind_Leads_by_Email;
	public FindLeads_Page clickFindByEmail()
	{
		click(eleFind_Leads_by_Email);
		return this;
	}
	
	
	
	@FindBy(xpath = "//button[text()='Find Leads']")
	WebElement eleSearch_Leads;
	public FindLeads_Page clickSearchLead() throws InterruptedException
	{
		click(eleSearch_Leads);
		Thread.sleep(5000);
		return this;
	}
	
	
	@FindBy(xpath = "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")
	WebElement eleSearch_Result_First_Lead;
	public FindLeads_Page retrieveFirstLead()
	{
		String LeadID = getText(eleSearch_Result_First_Lead);
		System.out.println("Captured Lead Name : "+LeadID);
		return this;
	}
	public FindLeads_Page clickFirstLead() throws InterruptedException
	{
		click(eleSearch_Result_First_Lead);
		Thread.sleep(3000);
		return this;
	}
	
	
	@FindBy(xpath = "//div[@class = 'x-paging-info']")
	WebElement eleerr_Message;
	public ViewLead_Page verifyDeleteLead(String expectedText)
	{
		verifyPartialText(eleerr_Message, expectedText);
		return new ViewLead_Page();
	}
	
			
}
