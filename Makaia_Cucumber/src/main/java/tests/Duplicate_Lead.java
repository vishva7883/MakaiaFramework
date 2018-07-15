package tests;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;

public class Duplicate_Lead extends PreAndPost{
	
	@BeforeTest
	public void setValue() {
		
			tcn = "TC004_Duplicate Lead";
			td = "To Duplicate an existing Lead";
			nn = "Lead";
			au = "Vishnu";
			ct = "System Test";
			ds = "DuplicateLead";
	}
	
	//@Test(dependsOnMethods = {"tests.Create_Lead.createLead"}, alwaysRun = true, groups = {"Sanity"})
	//@Test
	@Test(dataProvider = "ST")
	
	public void DuplicateLead(String eml) throws InterruptedException {
		
		
		WebElement eleLeads = locateElement("link", "Leads");
		click(eleLeads);
		
		WebElement eleFindLeads = locateElement("xpath", "//a[text()='Find Leads']");
		click(eleFindLeads);		
		
		WebElement eleSrchEmail = locateElement("link", "Email");
		click(eleSrchEmail);		
		
		WebElement eleEnterEmail = locateElement("name", "emailAddress");
		type(eleEnterEmail, eml);	
		
		WebElement eleSrchFindLeads = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleSrchFindLeads);
		Thread.sleep(5000);
		
		//Capture name of First Resulting lead
		WebElement getfname = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]"); 
		String getleadname = getText(getfname);
		System.out.println("Captured Lead Name : "+getleadname);
		click(getfname);
		
		//Click on first resulting lead
		WebElement eleFirstResultingLead = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");          
		click(eleFirstResultingLead);
		Thread.sleep(3000);
				
		//Click Duplicate Lead
		WebElement eleBtnDuplicateLead = locateElement("xpath", "//a[text()='Duplicate Lead']");          
		click(eleBtnDuplicateLead);
		Thread.sleep(3000);
		
		
		//Verify the title as 'Duplicate Lead's
		WebElement duplead = locateElement("xpath", "//div[@id='sectionHeaderTitle_leads']"); 
		verifyPartialText(duplead, "Duplicate");
		

		WebElement eleDuplicateSubmission = locateElement("class", "smallSubmit");          
		click(eleDuplicateSubmission);
		
		
		WebElement getduplicatefname = locateElement("xpath", "//span[@id='viewLead_firstName_sp']"); 
		verifyPartialText(getduplicatefname, getleadname);
		driver.close();
		
	}

}
