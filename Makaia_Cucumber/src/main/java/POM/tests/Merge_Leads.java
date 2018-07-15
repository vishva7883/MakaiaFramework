package POM.tests;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import lib.selenium.WebDriverServiceImpl;

public class Merge_Leads extends PreAndPost{
	
	
	@BeforeTest
	public void setValue() {
		
			tcn = "TC005_Merge Lead";
			td = "To Merge an existing Lead with an another Lead";
			nn = "Lead";
			au = "Vishnu";
			ct = "System Test";
			ds = "MergeLead";
	}
	
	//@Test(dependsOnMethods = {"tests.Create_Lead.createLead"}, alwaysRun = true, groups = {"Sanity"})
	//@Test
	@Test(dataProvider = "ST")
	
	
	//@Test(enabled = false)
	//@Test(groups = {"Sanity"})
	
	public void MergeLead(String ld1, String ld2) throws InterruptedException {

	
		WebElement eleLeads = locateElement("link", "Leads");
		click(eleLeads);

		WebElement eleMergeLeads = locateElement("link", "Merge Leads");
		click(eleMergeLeads);


		WebElement elegetTitle = locateElement("xpath", "(//td[@class='titleCell']//following::td/a)[1]");
		click(elegetTitle);

		switchToWindow(1);

		WebElement eleTypeLID = locateElement("xpath", "//input[@name='id']");
		type(eleTypeLID,ld1);		

		WebElement eleFindLeads = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLeads);

		try
		{
			Thread.sleep(5000);
			WebElement eleSwitchwindow = locateElement("xpath", "(//tbody//a)[1]");
			click(eleSwitchwindow);
		}
		catch(NoSuchElementException exception)
		{
			WebElement eleFindExecpt = locateElement("xpath", "//div[@class='x-paging-info']");
			String getFindExcept = getText(eleFindExecpt);
			System.out.println("Captured Lead Name : "+getFindExcept);
		}
		switchToWindow(0);

		WebElement elegetTitle_2 = locateElement("xpath", "(//td[@class='titleCell']//following::td/a)[2]");
		click(elegetTitle_2);
		switchToWindow(1);

		WebElement eleName = locateElement("xpath", "//input[@name='id']");
		type(eleName, ld2);

		WebElement eleFindLeads_2 = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLeads_2);
		try
		{
			Thread.sleep(5000);
			WebElement eleFindExtraWindow = locateElement("xpath", "(//tbody//a)[1]");
			click(eleFindExtraWindow);
		}
		catch(NoSuchElementException exception)
		{
			WebElement eleFindExecpt = locateElement("xpath", "//div[@class='x-paging-info']");
			String getFindExcept = getText(eleFindExecpt);
			System.out.println("Captured Lead Name : "+getFindExcept);

		}
		switchToWindow(0);

		WebElement eleMerge = locateElement("link", "Merge");
		click(eleMerge);
		acceptAlert();

		WebElement eleFindLeads_3 = locateElement("link", "Find Leads");
		click(eleFindLeads_3);

		WebElement eleLeadName = locateElement("xpath", "//input[@name='id']");
		type(eleLeadName,ld1);

		WebElement eleFindLeads_4 = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLeads_4);

		WebElement eleFindExecpt = locateElement("xpath", "//div[@class='x-paging-info']");
		String getFindExcept = getText(eleFindExecpt);
		System.out.println("Captured Lead Name : "+getFindExcept);
	}

}
