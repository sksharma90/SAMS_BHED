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

public class SubmissionofCAFBySameApplicantAgain extends BaseClass implements BHEdData {

	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "Result";
	int rowCount = constants.fileone.getRowCount(sheetName);

	@Test(priority = 0)
	public void Login() throws Exception {

		BrowserFactoryNew bc = new BrowserFactoryNew();
		bc.Login(MobileNumber3, Password);
		Thread.sleep(3000);

	}

	@Test(priority = 1)
	public void SubmissionBySameApplicant() throws Exception {

		// logger = report.createTest("Submission of B.P.Ed CAF By Same Applicant
		// Again");

		BHEdLogin login = new BHEdLogin(driver);
		Thread.sleep(3000);
		login.ApplicationFormButton().click();
		Thread.sleep(1000);
		login.Close().click();
		Thread.sleep(1000);
		login.BrochureYes().click();
		Thread.sleep(1000);
		login.SelectCourse(SelectCourse4);
		Thread.sleep(1000);

		BHEdCAF Form = new BHEdCAF(driver);

		String msg = Form.GetMsg();
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("You have already Submitted this Form against the Course Selected!")) {
			System.out.println(msg);
			Thread.sleep(600);
			Form.JavaAcceptAlert();

			constants.fileone.setCellData(sheetName, "Status", 136, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 136, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "You have already Submitted this Form against the Course Selected!");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent()
				.info("Successfully Checked Submission of B.Ed CAF By Same Applicant Again Scenario");

	}
}