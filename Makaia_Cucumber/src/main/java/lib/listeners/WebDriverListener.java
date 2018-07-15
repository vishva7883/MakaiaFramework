package lib.listeners;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import reports.Reports;


public class WebDriverListener extends Reports implements WebDriverEventListener {

	public static ChromeDriver webdriver;
	public static EventFiringWebDriver driver;
	public int i = 1;
	
	public WebDriverListener() {
/*		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		webdriver = new ChromeDriver();
		
		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);
		
		driver.manage().window().maximize();
		//driver.get("http://leaftaps.com/opentaps");
		driver.get("https://www.flipkart.com/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
	}

	public void beforeAlertAccept(WebDriver driver) {
	}

	public void afterAlertAccept(WebDriver driver) {
		reportSteps("The alert is accepted","PASS");
		takeSnap();
		

	}

	public void afterAlertDismiss(WebDriver driver) {
		reportSteps("The alert is dismissed","PASS");
		takeSnap();

	}

	public void beforeAlertDismiss(WebDriver driver) {		

	}

	public void beforeNavigateTo(String url, WebDriver driver) {

	}

	public void afterNavigateTo(String url, WebDriver driver) {
		reportSteps("The browser loaded the URL "+url,"PASS");
		takeSnap();
	}

	public void beforeNavigateBack(WebDriver driver) {

	}

	public void afterNavigateBack(WebDriver driver) {
		reportSteps("The browser has loaded the previous page from the history","PASS");
		takeSnap();
	}

	public void beforeNavigateForward(WebDriver driver) {

	}

	public void afterNavigateForward(WebDriver driver) {
		reportSteps("The browser has loaded the next page from the history","PASS");
		takeSnap();
	}

	public void beforeNavigateRefresh(WebDriver driver) {


	}

	public void afterNavigateRefresh(WebDriver driver) {
		reportSteps("The browser has reloaded successfully","PASS");
		takeSnap();
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {

	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {

	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		// Here we may have to wait for click		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		reportSteps("The element "+element +" is clicked successfully","PASS");
		takeSnap();

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		reportSteps("The value "+keysToSend[0]+" is entered successfully in element "+element,"PASS");
		takeSnap();

	}

	public void beforeScript(String script, WebDriver driver) {

	}

	public void afterScript(String script, WebDriver driver) {

	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {

	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		reportSteps("The driver is moved to the window with title "+driver.getTitle(),"PASS");
		takeSnap();

	}

	public void onException(Throwable throwable, WebDriver driver) {
		// We need to handle exception		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {

	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

	}

	@Override
	public long takeSnap() {
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./../reports/images/"+i+".png"));
		} catch (WebDriverException e) {
			e.printStackTrace();
			reportSteps("Web Driver Exception occured during Take Snap","FAIL");
		} catch (IOException e) {
			e.printStackTrace();
			reportSteps("IO Exception occured during Take Snap","FAIL");
		}
		i++;
		return 0;
	}

	
		

}
