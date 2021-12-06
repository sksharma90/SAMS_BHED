package com.BHEd.Listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.BHEd.browser.BrowserFactoryNew;
import com.aventstack.extentreports.Status;

public class Retry extends BrowserFactoryNew implements IRetryAnalyzer {
	private int count = 0;
	private static int maxTry = 1; // Run the failed test 2 times

	@Override
	public boolean retry(ITestResult iTestResult) {
		if (!iTestResult.isSuccess()) { // Check if test not succeed
			if (count < maxTry) { // Check if maxTry count is reached
				count++; // Increase the maxTry count by 1
				iTestResult.setStatus(ITestResult.FAILURE); // Mark test as failed and take base64Screenshot
//				extentReportsFailOperations(iTestResult); // ExtentReports fail operations
				return true; // Tells TestNG to re-run the test
			}
		} else {
			iTestResult.setStatus(ITestResult.SUCCESS); // If test passes, TestNG marks it as passed
		}
		return false;
	}

	public void extentReportsFailOperations(ITestResult result) throws IOException {
//		ExtentFactory.getInstance().getExtent().log(Status.FAIL,"Testcase: "+result.getMethod().getMethodName()+ " is Failed.");
//		ExtentFactory.getInstance().getExtent().log(Status.FAIL,result.getThrowable());
		
		// Extend BrowserFactory Class here (under TestListener Class)
		// Add the access of static WebDriver as protected under BrowserFactoryNew
		// Replace BrowserFactoryNew.StartApplication() with driver under TestListener
		// Class
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		//File src = ((TakesScreenshot) BaseTest.openBrowser()).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format= new SimpleDateFormat("dd-MM-yy HH-mm-ss");
		Date date = new Date();
		String actualDate=format.format(date);
		
		String SSPath=System.getProperty("user.dir")+"/Screenshots/" +actualDate +".png";
		
		File dest =new File(SSPath);

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {

			System.out.println("Unable to capture screenshot" + e.getMessage());
			e.printStackTrace();
		}
		ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(SSPath,"Failed Testcase Screenshot");
		ExtentFactory.getInstance().removeExtentObject();
	}
}
