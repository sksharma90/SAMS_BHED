package com.BHEd.Tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BHEd.GenericLibrary.constants;
import com.BHEd.ObjectRepository.BHEdCAF;
import com.BHEd.ObjectRepository.BHEdData;
import com.BHEd.ObjectRepository.BHEdLogin;
import com.BHEd.ObjectRepository.BaseClass;
import com.BHEd.browser.BrowserFactoryNew;

public class Rough extends BaseClass implements BHEdData {

	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "Result";
	int rowCount = constants.fileone.getRowCount(sheetName);

	@Test(priority = 0)
	public void Login() throws Exception {

		BHEdLogin login = new BHEdLogin(driver);

		BrowserFactoryNew bc= new BrowserFactoryNew();
		bc.Login(MobileNumber, Password);
		Thread.sleep(3000);

		login.ApplicationFormButton().click();
		Thread.sleep(1000);
		login.Close().click();
		Thread.sleep(1000);
		login.BrochureYes().click();
		Thread.sleep(1000);
		login.SelectCourse(SelectCourse2);
		Thread.sleep(1000);
	}


	@Test(priority = 1)
	public void FemaleApplicantBornBeforeAgeAsOn() throws Exception {

		//logger = report.createTest("Female Applicant Born Before Age As On");

		BHEdCAF Form = new BHEdCAF(driver);
		Thread.sleep(1000);
		Form.TenthBoard(TenthBoard);
		Thread.sleep(1000);
		Form.TenthYOP(TenthYOP);
		Thread.sleep(1000);
		Form.Annual().click();
		Thread.sleep(1000);
		Form.GraduationPassed().click();
		Thread.sleep(1000);
		Form.TenthRollNo().clear();
		Form.TenthRollNo().sendKeys(TenthRollNumber);
		Thread.sleep(3000);
		Form.MotherName().click();
		Thread.sleep(1000);
		Form.MotherName().sendKeys(MotherName);
		Thread.sleep(1000);
		Form.ApplicantName().sendKeys(ApplicantName);
		Thread.sleep(1000);
		Form.FatherSpouseGuardianName().sendKeys(FatherName);
		Thread.sleep(1000);
		//logger.info("Selecting Gender As Female");
		Form.Gender(GenderF);
		Thread.sleep(1000);
		Form.SocialCategory(SocialCategoryG);
		Thread.sleep(1000);
		//logger.info("Selecting DOB Before Valid Date For Female Applicant");
		Form.FemaleBornBefore();
		Thread.sleep(1000);
		Form.SocialCategory(SocialCategoryG);
		
		Thread.sleep(1000);
		String msg = Form.GetMsg();
		Thread.sleep(1000);
		//logger.info("Assertion of Expected & Actual Result");
		if (msg.equals("Date Of Birth Should be On or  After 31-Aug-1987")) {
			System.out.println(msg);
			Thread.sleep(3000);
			Form.JavaAcceptAlert();

			constants.fileone.setCellData(sheetName, "Status", 118, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 118, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "Date Of Birth Should be On or  After 31-Aug-1987");

		softAssert.assertAll();

		// logger.info("Successfully Checked Female Applicant Born Before Age As On Scenario");

	}

}
