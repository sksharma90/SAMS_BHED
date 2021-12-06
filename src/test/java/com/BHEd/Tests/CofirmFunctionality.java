package com.BHEd.Tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BHEd.GenericLibrary.constants;
import com.BHEd.Listeners.ExtentFactory;
import com.BHEd.ObjectRepository.BHEdCAF;
import com.BHEd.ObjectRepository.BHEdData;
import com.BHEd.ObjectRepository.BHEdLogin;
import com.BHEd.ObjectRepository.BaseClass;
import com.BHEd.browser.BrowserFactoryNew;

public class CofirmFunctionality extends BaseClass implements BHEdData {

	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "Result";
	int rowCount = constants.fileone.getRowCount(sheetName);

	@Test(priority = 0)
	public void Login() throws Exception {

		BHEdLogin login = new BHEdLogin(driver);

		BrowserFactoryNew bc = new BrowserFactoryNew();
		bc.Login(MobileNumber1, Password);
		Thread.sleep(3000);

		login.ApplicationFormButton().click();
		Thread.sleep(1000);
		login.Close().click();
		Thread.sleep(1000);
		login.BrochureYes().click();
		Thread.sleep(1000);
		login.SelectCourse(SelectCourse4);
		Thread.sleep(1000);
	}

	@Test(priority = 1)
	public void ConfirmationBeforeFinalSubmission() throws Exception {

		// logger = report.createTest("Confirmation of CAF Before Final Submission");
		BHEdCAF Form = new BHEdCAF(driver);
		Thread.sleep(600);

		Form.Submit().click();
		Thread.sleep(1000);
		Form.JavaAcceptAlert();
		Thread.sleep(1000);
		Form.JavaAcceptAlert();
		Thread.sleep(2000);
		Form.Confirm().click();
		Thread.sleep(3000);
		String msg = Form.GetMsg();
		Thread.sleep(1000);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("Are you sure you want to Confirm the CAF ?")) {
			System.out.println(msg);
			Form.JavaDismissAlert();

			constants.fileone.setCellData(sheetName, "Status", 141, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 141, "Fail");

		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "Are you sure you want to Confirm the CAF ?");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent()
				.info("Successfully Checked Confirmation Before Final Submission scenario");
	}

	@Test(priority = 2)
	public void CancellationofFinalSubmission() throws Exception {

		// logger = report.createTest("Cancellation Before Final Submission");

		BHEdCAF Form = new BHEdCAF(driver);
		Thread.sleep(2000);

		Form.Confirm().click();
		Thread.sleep(1000);
		String msg = Form.GetMsg();
		Thread.sleep(600);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("Are you sure you want to Confirm the CAF ?")) {
			System.out.println(msg);
			Form.JavaDismissAlert();

			constants.fileone.setCellData(sheetName, "Status", 142, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 142, "Fail");

		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "Are you sure you want to Confirm the CAF ?");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent()
				.info("Successfully Checked Cancellation Before Final Submission scenario");
	}
}