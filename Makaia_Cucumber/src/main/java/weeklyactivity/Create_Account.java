package weeklyactivity;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class Create_Account extends WebDriverServiceImpl {

	@Test
	public void createAccount() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver,10);
		
		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");

		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");

		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);

		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);

		WebElement eleAccounts = locateElement("link", "Accounts");
		click(eleAccounts);

		WebElement eleCreateAccount = locateElement("link", "Create Account");
		click(eleCreateAccount);

		String CompName = "TestLeaf_Vishnu_";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		
		CompName = CompName + date;

		WebElement eleCompanyName = locateElement("id", "accountName");
		type(eleCompanyName, CompName);
		//type(eleCompanyName, "VishnuSTestLeaf1234123");

		WebElement eleIndustry = locateElement("name", "industryEnumId");
		selectDropDownUsingVisibleText(eleIndustry, "Aerospace");

		WebElement elePreferredCurrency = locateElement("xpath", "//select[@id = 'currencyUomId']");
		selectDropDownUsingVisibleText(elePreferredCurrency, "INR - Indian Rupee");

		WebElement eleSource = locateElement("id", "dataSourceId");
		selectDropDownUsingVisibleText(eleSource, "Conference");

		WebElement eleMarketingCampaingn = locateElement("id", "marketingCampaignId");
		selectDropDownUsingVisibleText(eleMarketingCampaingn, "Automobile");

		WebElement elePhoneNumber = locateElement("xpath", "//input[@id = 'primaryPhoneNumber']");
		type(elePhoneNumber, "9987634254");

		WebElement eleCity = locateElement("id", "generalCity");
		type(eleCity, "Chennai");

		WebElement eleEmail = locateElement("xpath", "//input[@id='primaryEmail']");
		type(eleEmail, "TestLeaf@TestLeaf.com");

		WebElement eleCountry = locateElement("id", "generalCountryGeoId");
		selectDropDownUsingVisibleText(eleCountry, "India");

		Thread.sleep(2000);

		WebElement eleState = locateElement("id", "generalStateProvinceGeoId");
		selectDropDownUsingVisibleText(eleState, "TAMILNADU");

		WebElement eleSubmit = locateElement("class", "smallSubmit");
		click(eleSubmit);

		Thread.sleep(5000);

		WebElement eleCreatedAccountName = locateElement("xpath", "(//span[@class = 'tabletext'])[3]");
		String extractCreatedAccountName = getText(eleCreatedAccountName);
		System.out.println("Created Account Name : " + extractCreatedAccountName);

		
		/*String rawAccount_ = extractCreatedAccountName;
		
		String AccountID = (rawAccount_.replaceAll("\\D", ""));
		String[] rawAccountName_ = (rawAccount_.split(" "));
		String AccountName = rawAccountName_[0];
		
		*/
		
		String rawAccount_ = extractCreatedAccountName;
		String[] rawAccountName_ = (rawAccount_.split("\\("));
		String AccountName = rawAccountName_[0];

		String[] rawAccountID = (rawAccountName_[1].split("\\)"));
		String AccountID = (rawAccountID[0]);

		


		WebElement eleFindCreatedAccount = locateElement("link", "Find Accounts");
		click(eleFindCreatedAccount);

		Thread.sleep(3000);

		WebElement eleSearchAccID = locateElement("xpath", "//input[@name='id']");
		type(eleSearchAccID, AccountID);

		WebElement eleSearchAccName = locateElement("xpath", "(//input[@name='accountName'])[2]");
		type(eleSearchAccName, AccountName);

		WebElement eleSrchFindAccounts = locateElement("xpath", "//button[text()='Find Accounts']");
		click(eleSrchFindAccounts);
		Thread.sleep(5000);

		WebElement eleFirstResultingAccountName = locateElement("xpath",
				"//div[@class='x-grid3-cell-inner x-grid3-col-groupName']/a[1]");
		String getAccountName = getText(eleFirstResultingAccountName);

		
		WebElement eleFirstResultingAccountID = locateElement("xpath",
				"//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]");
		String getAccountID = getText(eleFirstResultingAccountID);

	
		System.out.println("Created Account ID : " + AccountID);
		System.out.println("Created Account Name : " + AccountName);
		System.out.println("Result Retrieved Account Name : "+ getAccountName);
		System.out.println("Result Retrieved Account ID : "+ getAccountID);
		
		
		if (AccountID.contains(getAccountID)) {
				System.out.println("Account Created : PASS");
		} else {
			System.out.println("Account Created : FAIL");
		}

	}

}
