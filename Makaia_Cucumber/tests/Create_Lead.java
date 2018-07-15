package tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import lib.selenium.PreAndPost;
import data.reader.ReadExcel;

public class Create_Lead extends PreAndPost {

	@BeforeTest
	public void setValue() {
		
			tcn = "TC001_Create Lead";
			td = "To Create a new Lead";
			nn = "Lead";
			au = "Vishnu";
			ct = "System Test";
			ds = "CreateLead";
	}
	
	
	//@Test(invocationCount = 2, invocationTimeOut = 30000, groups = { "Smoke" })
	//@Test(dataProvider = "ST", retryAnalyzer = TestNGListener.class)
	@Test(dataProvider = "ST")
		
	public void createLead(String cn, String fn, String ln) {

		WebElement eleLeads = locateElement("link", "Leads");
		click(eleLeads);

		WebElement eleCreateLead = locateElement("link", "Create Lead");
		click(eleCreateLead);

		WebElement eleCompanyName = locateElement("id", "createLeadForm_companyName");
		type(eleCompanyName, cn);

		WebElement eleFirstName = locateElement("id", "createLeadForm_firstName");
		type(eleFirstName, fn);

		WebElement eleLastName = locateElement("id", "createLeadForm_lastName");
		type(eleLastName, ln);

		WebElement eleSubmit = locateElement("class", "smallSubmit");
		click(eleSubmit);

	}

/*	@DataProvider (name = "ST")
	public Object[][] getdata() throws IOException
	
	{
		ReadExcel rexl = new ReadExcel();
		Object[][] data = rexl.readdata("CreateLead");
		
		Object[][] data = new Object[2][3];
		
		
		data[0][0] = "CTS_1";
		data[0][1] = "Vishnu_1";
		data[0][2] = "Subram_1";
		
		data[1][0] = "CTS_2";
		data[1][1] = "Vishnu_2";
		data[1][2] = "Subram_2";
		
		
		
		return data;
		
	}
*/
}
