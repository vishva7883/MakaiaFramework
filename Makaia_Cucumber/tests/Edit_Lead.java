package tests;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
		

		
		WebElement eleLeads = locateElement("link", "Leads");
		click(eleLeads);
		
		WebElement eleFindLeads = locateElement("xpath", "//a[text()='Find Leads']");
		click(eleFindLeads);		
		
		WebElement eleSrchFirstName = locateElement("xpath", "(//input[@name='firstName'])[3]");
		type(eleSrchFirstName,fn);		
		
		WebElement eleSrchFindLeads = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleSrchFindLeads);
		Thread.sleep(5000);
		
		WebElement eleSrchfirstLead = locateElement("xpath", "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		click(eleSrchfirstLead);
		
		boolean titleverification = verifyPartialTitle("View Lead");
		if (titleverification == true) {
			System.out.println("Expected page, View Lead - Displayed"); 
		}
		else { 
			System.out.println("Expected page, View Lead - NOT Displayed - Fail"); 
		}
		
		WebElement eleEditFindLeads = locateElement("xpath", "//a[text()='Edit']");
		click(eleEditFindLeads);
		
		String CompName = cn;
		WebElement eleEditCompanyName = locateElement("id", "updateLeadForm_companyName");
		type(eleEditCompanyName,CompName);
		
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
		
		/*Object[][] data = new Object[2][3];
		
		
		data[0][0] = "CTS_1";
		data[0][1] = "Vishnu_1";
		data[0][2] = "Subram_1";
		
		data[1][0] = "CTS_2";
		data[1][1] = "Vishnu_2";
		data[1][2] = "Subram_2";
		
		*/
		
		return data;
		
	}

}
