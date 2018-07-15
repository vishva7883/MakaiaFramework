package lib.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import lib.listeners.WebDriverListener;

public class WebDriverServiceImpl extends WebDriverListener {

	public WebElement locateElement(String locator, String locValue) {

		try {
			switch (locator) {
			case "id":
				reportSteps("The (id) locator " + locator + "has been found successfully", "PASS");
				return driver.findElement(By.id(locValue));

			case "class":
				reportSteps("The (class) locator " + locator + "has been found successfully", "PASS");
				return driver.findElement(By.className(locValue));

			case "link":
				reportSteps("The (link) locator " + locator + "has been found successfully", "PASS");
				return driver.findElement(By.linkText(locValue));

			case "xpath":
				reportSteps("The (xpath) locator " + locator + "has been found successfully", "PASS");
				return driver.findElement(By.xpath(locValue));

			case "name":
				reportSteps("The (name) locator " + locator + "has been found successfully", "PASS");
				return driver.findElement(By.name(locValue));

			case "list":
				reportSteps("The (list) locator " + locator + "has been found successfully", "PASS");
				return driver.findElement(By.name(locValue));

			default:
				break;
			}
		} catch (NoSuchElementException e) {
			reportSteps("Element Not Found!! Locator : " + locator + ", Value : " + locValue, "FAIL");
		} catch (IllegalArgumentException e) {
			reportSteps("Invalid Argument passed as Locator  in : " + locator + ", Given value : " + locValue, "FAIL");
		}

		return null;
	}

	public void type(WebElement ele, String data) {
		// ele.clear();
		try {
			ele.sendKeys(data);
			reportSteps("The value " + data + " is entered successfully in " + ele, "PASS");
		} catch (IllegalStateException e) {
			reportSteps("Element Not in input acceptable state !! Locator : " + ele + ", Value : " + data, "FAIL");
		} catch (TypeNotPresentException e) {
			reportSteps("Type option not enabled !! Locator : " + ele + ", Value : " + data, "FAIL");
		} catch (NullPointerException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + driver.getTitle(), "FAIL");
		}
	}

	public void click(WebElement ele) {
		try {
			ele.click();
			reportSteps("The element " + ele + " clicked successfully", "PASS");
		} catch (NoSuchElementException e) {
			reportSteps("Element Not Found!! Webelement : " + ele, "FAIL");
		} catch (NullPointerException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + ele, "FAIL");
		}
	}

	public void clear(WebElement ele) {
		driver.unregister(this);
		try {
			ele.clear();
			reportSteps("The element " + ele + " cleared successfully", "PASS");
		} catch (NoSuchElementException e) {
			reportSteps("Element Not Found!! Webelement : " + ele, "FAIL");
		} catch (NullPointerException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + ele, "FAIL");
		}
		driver.register(this);
	}

	public String getText(WebElement ele) {

		String txt = "";
		try {
			txt = ele.getText();
			if (txt != "") {
				reportSteps("The text from element " + ele + " has been extracted", "PASS");
			} else {
				reportSteps("The text from element " + ele + " is BLANK or NULL", "FAIL");
			}
		} catch (NoSuchElementException e) {
			reportSteps("Element Not Found!! Webelement : " + ele, "FAIL");
		} catch (IllegalArgumentException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + ele, "FAIL");
		} catch (NullPointerException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + ele, "FAIL");
		}

		return txt;

	}

	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		// TODO Auto-generated method stub

		try {
			Select ddselection = new Select(ele);
			ddselection.selectByVisibleText(value);
			reportSteps("The value" + value + " is slected successfully form the dropdown " + ele, "PASS");
		} catch (NullPointerException e) {
			reportSteps("No value is passed to element " + ele + "Value : " + value, "FAIL");
		} catch (IllegalStateException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + ele + "Value : " + value, "FAIL");
		}

	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		// TODO Auto-generated method stub
		try {
			Select ddselection = new Select(ele);
			ddselection.selectByValue(value);
			reportSteps("The value" + value + " is selected successfully form the dropdown " + ele, "PASS");
		} catch (NullPointerException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + ele + "Value : " + value, "FAIL");
		} catch (IllegalStateException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + ele + "Value : " + value, "FAIL");
		}

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		try {
			Select ddselection = new Select(ele);
			ddselection.selectByIndex(index);
			reportSteps("The index" + index + " is selected successfully form the dropdown " + ele, "PASS");
		} catch (NullPointerException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + ele + "Value : " + index, "FAIL");
		} catch (IllegalStateException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + ele + "Value : " + index, "FAIL");
		}

	}

	public boolean verifyExactTitle(String expectedTitle) {

		boolean bReturn = false;

		try {
			String titleofpage = driver.getTitle();
			if (titleofpage.equals(expectedTitle)) {
				reportSteps(
						"The given title <" + expectedTitle + "> is matching with the UI title [" + titleofpage + "]",
						"PASS");
				bReturn = true;
			} else {
				reportSteps("The given title <" + expectedTitle + "> is NOT matching with the UI title [" + titleofpage
						+ "]", "FAIL");
			}
		} catch (NoSuchElementException e) {
			reportSteps("Element Not Found!! Webelement : " + driver.getTitle(), "FAIL");
		} catch (IllegalArgumentException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + driver.getTitle(), "FAIL");
		} catch (NullPointerException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + driver.getTitle(), "FAIL");
		}
		return bReturn;
	}

	public boolean verifyPartialTitle(String expectedTitle) {

		boolean bReturn = false;

		try {
			String titleofpage = driver.getTitle();
			if (titleofpage.contains(expectedTitle)) {
				reportSteps("The UI title [" + titleofpage + "] contains the given title <" + expectedTitle + ">",
						"PASS");
				bReturn = true;
			} else {
				reportSteps("The UI title [" + titleofpage + "] doesnt contain the given title <" + expectedTitle + ">",
						"PASS");
			}
		} catch (NoSuchElementException e) {
			reportSteps("Element Not Found!! Webelement : " + driver.getTitle(), "FAIL");
		} catch (IllegalArgumentException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + driver.getTitle(), "FAIL");
		} catch (NullPointerException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + driver.getTitle(), "FAIL");
		}
		return bReturn;
	}

	public void verifyExactText(WebElement ele, String expectedText) {

		try {
			String vercompnam = getText(ele);

			if (vercompnam.equals(expectedText)) {
				reportSteps("The UI text [" + vercompnam + "] matching the given text <" + expectedText + ">",
						"PASS");
				
			} else {
				reportSteps("The UI text [" + vercompnam + "] doesnt match with the given text <" + expectedText + ">",
						"PASS");
			}
		} catch (NoSuchElementException e) {
			reportSteps("Element Not Found!! Webelement : " + ele + " expected text " + expectedText, "FAIL");
		} catch (IllegalArgumentException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + ele + " expected text " + expectedText,
					"FAIL");
		} catch (NullPointerException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + ele + " expected text " + expectedText,
					"FAIL");
		}

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub

		try {
			String vercompnam = getText(ele);

			if (vercompnam.contains(expectedText)) {
				reportSteps("The UI text [" + vercompnam + "] contains the given text <" + expectedText + ">",
						"PASS");
	
			} else {
				reportSteps("The UI text [" + vercompnam + "] doesnt contain the given text <" + expectedText + ">",
						"PASS");
			}
		} catch (NoSuchElementException e) {
			reportSteps("Element Not Found!! Webelement : " + ele + " expected text " + expectedText, "FAIL");
		} catch (IllegalArgumentException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + ele + " expected text " + expectedText,
					"FAIL");
		} catch (NullPointerException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + ele + " expected text " + expectedText,
					"FAIL");
		}

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub

	}

	public void switchToWindow(int index) {
		// TODO Auto-generated method stub
		try {
			Set<String> winHand = driver.getWindowHandles();
			List<String> listHand = new ArrayList<String>();
			listHand.addAll(winHand);
			driver.switchTo().window(listHand.get(index));
		} catch (NoSuchWindowException e) {
			reportSteps("Window Not Found!! Window Index : " + index, "FAIL");
		}
	}

	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().frame(ele);
		} catch (NoSuchFrameException e) {
			reportSteps("Frame Not Exists!! Frame : " + ele, "FAIL");
		}
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			reportSteps("Alert Not Found!!!", "FAIL");
		}

	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			reportSteps("Alert Not Found!!!", "FAIL");
		}
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		String txt = "";

		try {
			txt = driver.switchTo().alert().getText();
		} catch (NoAlertPresentException e) {
			reportSteps("Alert Not Found!!!", "FAIL");
		}

		return txt;

	}

	public void closeActiveBrowser() {
		// TODO Auto-generated method stub
		driver.close();

	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		driver.quit();

	}

	public void moveToElement(WebElement ele) {

		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(ele).perform();
		} catch (NoSuchElementException e) {
			reportSteps("Element Not Found!! Webelement : " + driver.getTitle(), "FAIL");
		} catch (IllegalArgumentException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + driver.getTitle(), "FAIL");
		} catch (NullPointerException e) {
			reportSteps("Invalid/Incorrect argument from Webelement : " + driver.getTitle(), "FAIL");
		}

	}

	public void escape() {

		/*
		 * Actions builder = new Actions(driver); builder.keyDown(Keys.ESCAPE);
		 */
		driver.getKeyboard().sendKeys(Keys.ESCAPE);

	}

	public void mouseover(WebElement ele) {

		Actions builder = new Actions(driver);
		builder.moveToElement(ele).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mouseoverclick(WebElement ele) {

		Actions builder = new Actions(driver);
		builder.moveToElement(ele).click().perform();

	}

}
