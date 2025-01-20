package com.framework.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReport {
	
	public  static  ExtentReports extent;
	public static ExtentTest Reportlogger;
	private static ITestResult result;
	
	public static void initiliazeExtentReport(String filePath,String extentXML) {
		extent = new ExtentReports(filePath, false);
		extent.loadConfig(new File("core//test-output//extent-config.xml"));
	}

}
	 

		


