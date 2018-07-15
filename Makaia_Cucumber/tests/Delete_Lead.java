package tests;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lib.selenium.PreAndPost;

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

		
		WebElement eleLeads = locateElement("link", "Leads");
		click(eleLeads);

		WebElement eleFindLeads = locateElement("xpath", "//a[text()='Find Leads']");
		click(eleFindLeads);		

		WebElement eleSrchPhone = locateElement("link", "Phone");
		click(eleSrchPhone);		

		WebElement eleEnterPhone = locateElement("name", "phoneNumber");
		type(eleEnterPhone, phn);	

		WebElement eleSrchFindLeads = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleSrchFindLeads);
		Thread.sleep(5000);


		//Capture name of First Resulting lead
		WebElement leadid = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		String getleadid = getText(leadid);
		System.out.println("Captured Lead Name : "+getleadid);

		//Click on first resulting lead
		WebElement eleFirstResultingLead = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");          
		click(eleFirstResultingLead);
		Thread.sleep(3000);

		//Click Delete
		WebElement eleDeleteLead = locateElement("xpath", "//a[text()='Delete']");
		click(eleDeleteLead);

		//Click Find leads		
		WebElement eleFindLead_2 = locateElement("xpath", "//a[text()='Find Leads']");
		click(eleFindLead_2);

		//Enter captured lead ID
		WebElement eleCapLeadId = locateElement("name","id" );
		type(eleCapLeadId, getleadid);


		//Click Find leads button
		WebElement eleSrchFindLeads_2 = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleSrchFindLeads_2);
		Thread.sleep(5000);

		//Verify error msg
		WebElement errm = locateElement("xpath", "//div[@class = 'x-paging-info']"); 
		verifyPartialText(errm, "No records to display");

	}

}
