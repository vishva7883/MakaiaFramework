package weeklyactivity;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class Flip_Kart extends WebDriverServiceImpl {

	@Test
	public void flipkart() throws InterruptedException {

		Thread.sleep(2000);
		escape();
		WebElement eleTVAppliances = locateElement("xpath","//span[text() = 'TVs & Appliances']");
		mouseover(eleTVAppliances);
		
		
		WebElement eleSamsung = locateElement("link","Samsung");	
		click(eleSamsung);
		
		WebElement eleMinPrice = locateElement("xpath","//div[@class = '_1qKb_B']/select[1]");
		selectDropDownUsingVisibleText(eleMinPrice, "₹25000");
		
		Thread.sleep(2000);
		
		WebElement eleMaxPrice = locateElement("xpath","//div[@class = 'fPjUPw']/select[1]");
		selectDropDownUsingVisibleText(eleMaxPrice, "₹60000");
		
		Thread.sleep(4000);
		
		WebElement eleScreenSize = locateElement("xpath","(//div[@class='_3xglSm _1iMC4O'])[2]/div[1]");
		click(eleScreenSize);
		
		Thread.sleep(2000);
		
		WebElement eleActualSize = locateElement("xpath","//div[text()='48 - 55']");
		click(eleActualSize);
		
		Thread.sleep(2000);
		
		
		WebElement elefirstTVCost = locateElement("xpath","//div[@class='_1HmYoV _35HD7C col-10-12']/div[2]/div/div/div/a/div[2]/div[2]/div/div/div[1]");
		String extractTVCostfromMenu = getText(elefirstTVCost);
		System.out.println("TV Cost in Menu Details Page : "+extractTVCostfromMenu);
		
		WebElement elefirstTV = locateElement("xpath","//div[@class='_1HmYoV _35HD7C col-10-12']/div[2]");
		click(elefirstTV);
		
		switchToWindow(1);
		
		WebElement elefirstTVdetails = locateElement("xpath","//div[@class = '_1vC4OE _3qQ9m1']");
		String extractTVCostfromDetails = getText(elefirstTVdetails);
		System.out.println("TV Cost in Details Page : "+extractTVCostfromDetails);
	
		
		if (extractTVCostfromMenu.contains(extractTVCostfromDetails)) {
			System.out.println("Value Matches");
		}
		else {
			System.out.println("Value NOT Matches");
		}
			
		driver.close();
		switchToWindow(0);
		
		WebElement eleCompareTV1 = locateElement("xpath","//span[text()='Add to Compare'][1]");
		click(eleCompareTV1);
		
		WebElement eleCompareTV2 = locateElement("xpath","//span[text()='Add to Compare'][2]");
		click(eleCompareTV2);
		
		WebElement eleCompareTVs = locateElement("xpath","//span[text()='COMPARE']");
		click(eleCompareTVs);
		
		WebElement eleTextVerification = locateElement("xpath","//span[text()='Compare']");
		String extractText = getText(eleTextVerification);
		
		if (extractText.contains("Compare")) {
			System.out.println("Compare Text Exists");
		}
		else {
			System.out.println("Compare Text Not Exists");
		}
		
		
		WebElement elePriceCompare1 = locateElement("xpath","//div[@class = 'col col-4-12 _1ouGhW'][1]/div/div/div");
		String extractPrice1 = getText(elePriceCompare1);
		int price1 = Integer.parseInt(extractPrice1);		
		
		
		WebElement elePriceCompare2 = locateElement("xpath","//div[@class = 'col col-4-12 _1ouGhW'][1]/div/div/div");
		String extractPrice2 = getText(elePriceCompare2);
		int price2 = Integer.parseInt(extractPrice2);
		
		if (price1 < price2) {
			
			System.out.println("Lowest Price between two TV is : " + price1);
		}
		else {
			System.out.println("Lowest Price between two TV is : " + price2);
			
		}
			
		
		
	}
	
	
	
}
