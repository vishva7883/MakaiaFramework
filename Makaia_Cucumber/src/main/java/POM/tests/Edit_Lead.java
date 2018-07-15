package POM.tests;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Page.MyHome_Page;
import data.reader.ReadExcel;
import lib.selenium.PreAndPost;

public class Edit_Lead extends PreAndPost{
	
	@BeforeClass
	public void setValye() {
		
			tcn = "TC001_Create Lead";
			td = "To Create a new Lead";
			nn = "Lead";
			au = "Vishnu";
			ct = "System Test";
			ds = "EditLead";
			
	}

	
	//@Test(dependsOnMethods = {"tsts.Create_Lead.createLead"}, description = "Objective is to Edit already created Lead by Create Lead method", groups = {"Smoke"})
	@Test(dataProvider = "ST")
	public void EditLead(String cn, String fn) throws InterruptedException {
		

		new MyHome_Page(driver, test)

		//WebElement eleLeads = locateElement("link", "Leads");
		.clickLeadModule()
		
		//WebElement eleFindLeads = locateElement("xpath", "//a[text()='Find Leads']");
		.clickFindLeads()
		
		//WebElement eleSrchFirstName = locateElement("xpath", "(//input[@name='firstName'])[3]");
		.typeFirstName(fn)		
		
		//WebElement eleSrchFindLeads = locateElement("xpath", "//button[text()='Find Leads']");
		.clickSearchLead()
		
		//Capture name of First Resulting lead
		.retrieveFirstLead()
		
		
		boolean titleverification = verifyPartialTitle("View Lead");
		if (titleverification == true) {
			System.out.println("Expected page, View Lead - Displayed"); 
		}
		else { 
			System.out.println("Expected page, View Lead - NOT Displayed - Fail"); 
		}

		
		//Click on first resulting lead
		.clickFirstLead()
		
		
		//WebElement eleEditFindLeads = locateElement("xpath", "//a[text()='Edit']");
		.clickEditLead()
		
		//WebElement eleEditCompanyName = locateElement("id", "updateLeadForm_companyName");
		.typeCompanyName(cn)
		
		
		WebElement eleSubmitEdit = locateElement("xpath", "(//input[@name='submitButton'])[1]");
		click(eleSubmitEdit);
		
		WebElement eleChangedText = locateElement("id", "viewLead_companyName_sp");
		verifyPartialText(eleChangedText, CompName);
		driver.close();
		
	}

	@DataProvider (name = "ST")
	public Object[][] getdata() throws IOException
	
	{
		ReadExcel rexl = new ReadExcel();
		Object[][] data = rexl.readdata("EditLead");

		
		return data;
		
	}

}
