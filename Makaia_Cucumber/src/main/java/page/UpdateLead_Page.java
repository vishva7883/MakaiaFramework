package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class UpdateLead_Page extends WebDriverServiceImpl {
	
	/*public UpdateLead_Page(EventFiringWebDriver efwdriver, ExtentTest exttest) {
		this.driver = efwdriver;
		this.test = exttest;
		PageFactory.initElements(efwdriver, this);
	}*/
	
	public UpdateLead_Page() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "updateLeadForm_companyName")
	WebElement eleEdit_Company_Name;
	public UpdateLead_Page typeCompanyName(String companyName)
	{
		type(eleEdit_Company_Name, companyName);
		return this;
	}
	
	@FindBy(xpath = "(//input[@name='submitButton'])[1]")
	WebElement ele_Submit_Edit;
	public UpdateLead_Page clickSubmitEdit(String companyName)
	{
		click(ele_Submit_Edit);
		return this;
	}
	
		
}
