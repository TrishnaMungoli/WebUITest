package com.test.moneylion.testbase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.framework.Helper.WaitHelper;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.framework.Helper.ScreenShotHelper;
import com.framework.base.ExtentReport;
import com.framework.base.LocalBrowserInitialzation;
import com.framework.database.DataBaseConnection;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.moneylion.utility.ConfigReader;

public class TestBase {
	ConfigReader reader = new ConfigReader();
	DataBaseConnection concc = new DataBaseConnection();
	String screenshotPath = System.getProperty("user.dir") + "//Screenshots//" + timestamp() + ".png";
	ExtentTest Reportlogger;

	@BeforeSuite
	public void beforeSuite() {
		ExtentReport
		.initiliazeExtentReport(
		System.getProperty("user.dir") + "//" + "MoneyLionReport" + "//" + createFolder() + "//"
		+ timestamp() + "moneyLion.html",
		System.getProperty("user.dir") + reader.exten_XML_path());
	}
	
	@BeforeTest
 	@Parameters({"browser", "environment"})
   public void initialzeBrowser(String browser,String environment)  {
		reader= new ConfigReader();
		LocalBrowserInitialzation.setup(reader.url(),browser,environment);
		WaitHelper.implicitlyWait(LocalBrowserInitialzation.driver);
	}
	

	@BeforeMethod(alwaysRun = true)

	public void nameBefore(Method method) {
		String testName = method.getName();
		Reportlogger = ExtentReport.extent.startTest(testName);
	}

	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) {
		String screenshotPath = null;
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				screenshotPath = System.getProperty("user.dir") + "//Screenshots//" + timestamp() + ".png";
				ScreenShotHelper.captureScreenshot(LocalBrowserInitialzation.driver, screenshotPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Reportlogger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			Reportlogger.log(LogStatus.FAIL, "Snapshot below: " + Reportlogger.addScreenCapture(screenshotPath));
			Reportlogger.log(LogStatus.FAIL, "Test case Failed is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			Reportlogger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
			Reportlogger.log(LogStatus.SKIP, "Test case errors  are " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			Reportlogger.log(LogStatus.PASS, "Test case passed is " + result.getName());
		}
		ExtentReport.extent.endTest(Reportlogger);
	}

    @AfterTest
	public void TearDown() {
		LocalBrowserInitialzation.quitDriver();
	}

	@AfterSuite
	public void closeExtentReport() {
		ExtentReport.extent.flush();
		ExtentReport.extent.close();
	}

	public String createFolder() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String time = dateFormat.format(now);
		File dir = new File(time);
		dir.mkdir();
		return dir.toString();
	}

	public String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	public void reportLog(String message) {
		Reportlogger.log(LogStatus.INFO, message);// For extentTest HTML report

	}
}
