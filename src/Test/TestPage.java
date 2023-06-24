package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Page.Page1;

public class TestPage {
	ExtentReports report;
	ExtentTest test;
	Page1 ptest = new Page1();

	@BeforeClass
		public void setUp() throws Exception {
			report = new ExtentReports ("C:\\Users\\irumf\\Desktop\\logintest.html");
			test = report.startTest ("verfify launch browser test");
			ptest.openBrowser();
			test. log(LogStatus.INFO,"Browser started");
		
	}
	@org.testng.annotations.Test

	public void test() throws InterruptedException {

		test. log(LogStatus.INFO,"opening page");
		ptest.openpage();
		
		test. log(LogStatus.INFO,"opening calculator");
		ptest.GoToCalculator();
		
		test. log(LogStatus.INFO,"clicking pre approved");
		ptest.ClickOnPreApproved();
		
		test. log(LogStatus.INFO,"getting mortgage rates");
		ptest.GetMortgagerates();
		
		test. log(LogStatus.INFO,"opening the calculate rates page");
		ptest.CalculateRates();
	}

	@AfterClass
	public void tearDown() throws Exception {
		test. log(LogStatus.INFO,"Browser closed");
		ptest.closeBrowser();
		report.endTest(test);
		report.flush();
		


	}



}
