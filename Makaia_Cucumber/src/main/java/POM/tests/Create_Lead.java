package POM.tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import page.CreateLead_Page;
import page.MyHome_Page;
import page.ViewLead_Page;
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

	@Test(dataProvider = "ST")
	public void createLead(String cn, String fn, String ln) {

		new MyHome_Page(driver, test)
	
		.clickLeadModule()
		.clickCreateLead()
		.typeCompanyName(cn)
		.typeFirstName(fn)
		.typeLastName(ln)
	    .clickCreateLead()
		.verifyCompanyName(cn);
	}
}
