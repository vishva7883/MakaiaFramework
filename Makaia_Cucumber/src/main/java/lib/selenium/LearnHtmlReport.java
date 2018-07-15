package lib.selenium;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnHtmlReport {
	public static void main(String[] args) throws IOException {
		
		ExtentHtmlReporter html =  new ExtentHtmlReporter("./reports/results.html");
		html.setAppendExisting(true);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
		
		ExtentTest test = extent.createTest("TC001_Create_Lead", "Creating new Lead");
		test.assignAuthor("Vishnu");
		test.assignCategory("Smoke");
		
		test.pass("Login is Successful", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap1.jpg").build());
		test.fail("Login is Unsuccessful", MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap2.jpg").build());
		
		extent.flush();

	}

}
