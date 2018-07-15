package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class ViewLead_Page extends WebDriverServiceImpl {
	
	/*public ViewLead_Page(EventFiringWebDriver efwdriver, ExtentTest exttest) {
		this.driver = efwdriver;
		this.test = exttest;
		PageFactory.initElements(efwdriver, this);
	}*/
	
	public ViewLead_Page() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "viewLead_companyName_sp")
	WebElement eleView_Company_Name;
	
	@FindBy(xpath = "//a[text()='Delete']")
	WebElement eleDelete_Lead;
	
	@FindBy(xpath = "//a[text()='Edit']")
	WebElement eleEdit_Lead;
	

	
	public ViewLead_Page verifyCompanyName(String expectedText)
	{
		verifyPartialText(eleView_Company_Name, expectedText);
		return this;
	}
	
	public ViewLead_Page clickDeleteLead() throws InterruptedException
	{
		click(eleDelete_Lead);
		Thread.sleep(3000);
		return this;
	}
	
	public ViewLead_Page clickEditLead() throws InterruptedException
	{
		click(eleEdit_Lead);
		Thread.sleep(3000);
		return this;
	}

		
}
