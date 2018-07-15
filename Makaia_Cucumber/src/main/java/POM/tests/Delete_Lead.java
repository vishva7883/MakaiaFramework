package POM.tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Page.CreateLead_Page;
import Page.MyHome_Page;
import Page.ViewLead_Page;
import lib.selenium.PreAndPost;
import data.reader.ReadExcel;

public class Delete_Lead extends PreAndPost {
	
	@BeforeTest
	public void setValue() {
		
			tcn = "TC003_Delete Lead";
			td = "To Delete an existing Lead";
			nn = "Lead";
			au = "Vishnu";
			ct = "System Test";
			ds = "DeleteLead";
	}
	
	//@Test(dependsOnMethods = {"tests.Create_Lead.createLead"}, alwaysRun = true, groups = {"Sanity"})
	//@Test
	@Test(dataProvider = "ST")
	public void DeleteLead(String phn) throws InterruptedException {

		new MyHome_Page(driver, test)
		
		//WebElement eleLeads = locateElement("link", "Leads");
		.clickLeadModule()
		
		//WebElement eleFindLeads = locateElement("xpath", "//a[text()='Find Leads']");
		.clickFindLeads()
		
		//WebElement eleSrchPhone = locateElement("link", "Phone");
		.clickFindByPhone()
		
		//WebElement eleEnterPhone = locateElement("name", "phoneNumber");
		.typePhoneNumber(phn)
		
		//WebElement eleSrchFindLeads = locateElement("xpath", "//button[text()='Find Leads']");
		.clickSearchLead()
		
		//Capture name of First Resulting lead
		.retrieveFirstLead()
		
		//Click on first resulting lead
		.clickFirstLead()

		//Click Delete
		.clickDeleteLead()

		//Click Find leads		
		.clickFindLeads()

		//Enter captured lead ID
		//WebElement eleCapLeadId = locateElement("name","id" );
		.typeLeadID(LeadID)
		
		//Click Find leads button
		.clickSearchLead()

		//Verify error msg
		.verifyDeleteLead("No records to display")
		
	}

}
