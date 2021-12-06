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

public class EligibilityCriteriaForSCCGPA extends BaseClass implements BHEdData {

	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "Result";
	int rowCount = constants.fileone.getRowCount(sheetName);

	@Test(priority = 0)
	public void Login() throws Exception {

		BHEdLogin login = new BHEdLogin(driver);

		BrowserFactoryNew bc = new BrowserFactoryNew();
		bc.Login(MobileNumber, Password);
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
	public void HindiHonoursPassElectiveWithMoreThan45Percentage() throws Exception {

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
		Form.Gender(GenderM);
		Thread.sleep(1000);
		Form.ValidDateOfBirth();
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Selecting Social Category as SC");
		Form.SocialCategory(SocialCategorySC);
		Thread.sleep(1000);
		Form.MaritalStatus(MaritalStatusU);
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info(
				"Selecting Hindi Qualification as 1.Studied Hindi as an Honours/Pass/Elective Subject in Graduation Level");
		Form.HindiQualificationCriteria(HindiQualification1);
		Thread.sleep(1000);
		Form.AddressLine1().clear();
		Form.AddressLine1().sendKeys(Add1);
		Thread.sleep(1000);
		Form.AddressLine2().clear();
		Form.AddressLine2().sendKeys(Add2);
		Thread.sleep(1000);
		Form.PresentState(StateO);
		Thread.sleep(1000);
		Form.PresentDistrict(District1);
		Thread.sleep(1000);
		Form.PresentPinCode().clear();
		Form.PresentPinCode().sendKeys(Pincode);
		Thread.sleep(1000);
		Form.SameAsPresent().click();
		Thread.sleep(1000);
		Form.OdiaStudied().click();
		Thread.sleep(1000);

		Form.TenthExamType(TenthExamName);
		Thread.sleep(1000);
		Form.TenthMarkType(MarkTypeC);
		Thread.sleep(1000);
		
		Form.TenthObtainedMark().sendKeys(TenthCGPA);
		Thread.sleep(1000);
		Form.TwelthExamPassed(TwelthExamName);
		Thread.sleep(1000);
		Form.TwelthBoard(TwelthBoardName);
		Thread.sleep(1000);
		Form.TwelthYOP(TwelthYOP);
		Thread.sleep(1000);
		Form.TwelthRollNo().sendKeys(TwelthRollNumber);
		Thread.sleep(1000);
		Form.TwelthMarkType(MarkTypeC);
		Thread.sleep(1000);
		
		Form.TwelthObtainedMark().sendKeys(TwelthCGPA);
		Thread.sleep(1000);
		Form.GraduationExamPassed(GraduationExamName);
		Thread.sleep(1000);
		Form.GraduationBoard(GraduationBoardName);
		Thread.sleep(1000);
		Form.GraduationYOP(GraduationYOP);
		Thread.sleep(1000);
		Form.GraduationRollNo().sendKeys(GradRollNumber);
		Thread.sleep(1000);
		Form.GraduationMarkType(MarkTypeC);
		Thread.sleep(1000);
		
		ExtentFactory.getInstance().getExtent().info("Entering more than 45 percentage marks in Graduation");
		Form.GraduationObtainedMark().sendKeys(GradCGPA);
		Thread.sleep(1000);

		Form.Submit().click();
		Thread.sleep(600);

		String msg = Form.GetMsg();
		Thread.sleep(600);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("Are you sure you want to proceed ?")) {
			System.out.println(msg);
			Form.JavaDismissAlert();

			constants.fileone.setCellData(sheetName, "Status", 168, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 168, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "Are you sure you want to proceed ?");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info(
				"Successfully checked Hindi as an Honours/Pass/Elective Subject in Graduation Level With More Than 45 Percentage In Graduation scenario");
	}

	@Test(priority = 2)
	public void HindiHonoursPassElectiveWithLessThan45Percentage() throws Exception {

		// logger = report.createTest("Arts With less than 45 Percentage In
		// Graduation");

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
		Form.Gender(GenderF);
		Thread.sleep(1000);
		Form.ValidDateOfBirth();
		Thread.sleep(1000);
		Form.AadhaarNumber().clear();
		Form.AadhaarNumber().sendKeys(AadhaarNo);
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Selecting Social Category as SC");
		Form.SocialCategory(SocialCategorySC);
		Thread.sleep(1000);
		Form.MaritalStatus(MaritalStatusU);
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info(
				"Selecting Hindi Qualification as 1.Studied Hindi as an Honours/Pass/Elective Subject in Graduation Level");
		Form.HindiQualificationCriteria(HindiQualification1);
		Thread.sleep(1000);
		Form.AddressLine1().clear();
		Form.AddressLine1().sendKeys(Add1);
		Thread.sleep(1000);
		Form.AddressLine2().clear();
		Form.AddressLine2().sendKeys(Add2);
		Thread.sleep(1000);
		Form.PresentState(StateO);
		Thread.sleep(1000);
		Form.PresentDistrict(District1);
		Thread.sleep(1000);
		Form.PresentPinCode().clear();
		Form.PresentPinCode().sendKeys(Pincode);
		Thread.sleep(1000);
		Form.SameAsPresent().click();
		Thread.sleep(1000);
		Form.OdiaStudied().click();

		Thread.sleep(1000);
		Form.TenthExamType(TenthExamName);
		Thread.sleep(1000);
		Form.TenthMarkType(MarkTypeC);
		Thread.sleep(1000);
		
		Form.TenthObtainedMark().sendKeys(TenthCGPA);
		Thread.sleep(1000);
		Form.TwelthExamPassed(TwelthExamName);
		Thread.sleep(1000);
		Form.TwelthBoard(TwelthBoardName);
		Thread.sleep(1000);
		Form.TwelthYOP(TwelthYOP);
		Thread.sleep(1000);
		Form.TwelthRollNo().sendKeys(TwelthRollNumber);
		Thread.sleep(1000);
		Form.TwelthMarkType(MarkTypeC);
		Thread.sleep(1000);
		
		Form.TwelthObtainedMark().sendKeys(TwelthCGPA);
		Thread.sleep(1000);
		Form.GraduationExamPassed(GraduationExamName);
		Thread.sleep(1000);
		Form.GraduationBoard(GraduationBoardName);
		Thread.sleep(1000);
		Form.GraduationYOP(GraduationYOP);
		Thread.sleep(1000);
		Form.GraduationRollNo().sendKeys(GradRollNumber);
		Thread.sleep(1000);
		Form.GraduationMarkType(MarkTypeC);
		Thread.sleep(1000);
		
		ExtentFactory.getInstance().getExtent().info("Entering less than 45 percentage marks");
		Form.GraduationObtainedMark().sendKeys(SecuredCGPAL45);
		Thread.sleep(1000);
		Form.Submit().click();
		Thread.sleep(600);

		String msg = Form.GetMsg();
		Thread.sleep(600);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("Please enter PG Details if you have secured less than 45 Percentage in Graduation")) {
			System.out.println(msg);
			Form.JavaDismissAlert();

			constants.fileone.setCellData(sheetName, "Status", 169, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 169, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg,
				"Please enter PG Details if you have secured less than 45 Percentage in Graduation");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info(
				"Successfully checked Hindi as an Honours/Pass/Elective Subject in Graduation Level With less than 45 Percentage In Graduation scenario");
	}

	@Test(priority = 3)
	public void RastraBhasaRatnaWithMoreThan45Percentage() throws Exception {

		// logger = report.createTest("General With More Than 45 Percentage In PG");

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
		Form.Gender(GenderM);
		Thread.sleep(1000);
		Form.ValidDateOfBirth();
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Selecting Social Category as SC");
		Form.SocialCategory(SocialCategorySC);
		Thread.sleep(1000);
		Form.MaritalStatus(MaritalStatusU);
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info(
				"Selecting Hindi Qualification as 2.Passed Rastra Bhasa Ratna from Rastra Bhasa Prachar Samiti, Wardha");
		Form.HindiQualificationCriteria(HindiQualification2);
		Thread.sleep(1000);
		Form.AddressLine1().clear();
		Form.AddressLine1().sendKeys(Add1);
		Thread.sleep(1000);
		Form.AddressLine2().clear();
		Form.AddressLine2().sendKeys(Add2);
		Thread.sleep(1000);
		Form.PresentState(StateO);
		Thread.sleep(1000);
		Form.PresentDistrict(District1);
		Thread.sleep(1000);
		Form.PresentPinCode().clear();
		Form.PresentPinCode().sendKeys(Pincode);
		Thread.sleep(1000);
		Form.SameAsPresent().click();
		Thread.sleep(1000);
		Form.OdiaStudied().click();
		Thread.sleep(1000);

		Form.TenthExamType(TenthExamName);
		Thread.sleep(1000);
		Form.TenthMarkType(MarkTypeC);
		Thread.sleep(1000);
		
		Form.TenthObtainedMark().sendKeys(TenthCGPA);
		Thread.sleep(1000);
		Form.TwelthExamPassed(TwelthExamName);
		Thread.sleep(1000);
		Form.TwelthBoard(TwelthBoardName);
		Thread.sleep(1000);
		Form.TwelthYOP(TwelthYOP);
		Thread.sleep(1000);
		Form.TwelthRollNo().sendKeys(TwelthRollNumber);
		Thread.sleep(1000);
		Form.TwelthMarkType(MarkTypeC);
		Thread.sleep(1000);
		
		Form.TwelthObtainedMark().sendKeys(TwelthCGPA);
		Thread.sleep(1000);
		Form.GraduationExamPassed(GraduationExamName);
		Thread.sleep(1000);
		Form.GraduationBoard(GraduationBoardName);
		Thread.sleep(1000);
		Form.GraduationYOP(GraduationYOP);
		Thread.sleep(1000);
		Form.GraduationRollNo().sendKeys(GradRollNumber);
		Thread.sleep(1000);
		Form.GraduationMarkType(MarkTypeC);
		Thread.sleep(1000);
		
		ExtentFactory.getInstance().getExtent().info("Entering more than 45 percentage marks in Graduation");
		Form.GraduationObtainedMark().sendKeys(GradCGPA);
		Thread.sleep(1000);

		Form.Submit().click();
		Thread.sleep(600);

		String msg = Form.GetMsg();
		Thread.sleep(600);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("Are you sure you want to proceed ?")) {
			System.out.println(msg);
			Thread.sleep(600);
			Form.JavaDismissAlert();

			constants.fileone.setCellData(sheetName, "Status", 170, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 170, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "Are you sure you want to proceed ?");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info(
				"Successfully checked Passed Rastra Bhasa Ratna from Rastra Bhasa Prachar Samiti With More Than 45 Percentage In PG scenario");
	}

	@Test(priority = 4)
	public void RastraBhasaRatnaWithLessThan45Percentage() throws Exception {

		// logger = report.createTest("Science With less than 45 Percentage In PG");

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
		Form.Gender(GenderM);
		Thread.sleep(1000);
		Form.ValidDateOfBirth();
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Selecting Social Category as SC");
		Form.SocialCategory(SocialCategorySC);
		Thread.sleep(1000);
		Form.MaritalStatus(MaritalStatusU);
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info(
				"Selecting Hindi Qualification as 2.Passed Rastra Bhasa Ratna from Rastra Bhasa Prachar Samiti, Wardha");
		Form.HindiQualificationCriteria(HindiQualification2);
		Thread.sleep(1000);
		Form.AddressLine1().clear();
		Form.AddressLine1().sendKeys(Add1);
		Thread.sleep(1000);
		Form.AddressLine2().clear();
		Form.AddressLine2().sendKeys(Add2);
		Thread.sleep(1000);
		Form.PresentState(StateO);
		Thread.sleep(1000);
		Form.PresentDistrict(District1);
		Thread.sleep(1000);
		Form.PresentPinCode().clear();
		Form.PresentPinCode().sendKeys(Pincode);
		Thread.sleep(1000);
		Form.SameAsPresent().click();
		Thread.sleep(1000);
		Form.OdiaStudied().click();
		Thread.sleep(1000);

		Form.TenthExamType(TenthExamName);
		Thread.sleep(1000);
		Form.TenthMarkType(MarkTypeC);
		Thread.sleep(1000);
		
		Form.TenthObtainedMark().sendKeys(TenthCGPA);
		Thread.sleep(1000);
		Form.TwelthExamPassed(TwelthExamName);
		Thread.sleep(1000);
		Form.TwelthBoard(TwelthBoardName);
		Thread.sleep(1000);
		Form.TwelthYOP(TwelthYOP);
		Thread.sleep(1000);
		Form.TwelthRollNo().sendKeys(TwelthRollNumber);
		Thread.sleep(1000);
		Form.TwelthMarkType(MarkTypeC);
		Thread.sleep(1000);
		
		Form.TwelthObtainedMark().sendKeys(TwelthCGPA);
		Thread.sleep(1000);
		Form.GraduationExamPassed(GraduationExamName);
		Thread.sleep(1000);
		Form.GraduationBoard(GraduationBoardName);
		Thread.sleep(1000);
		Form.GraduationYOP(GraduationYOP);
		Thread.sleep(1000);
		Form.GraduationRollNo().sendKeys(GradRollNumber);
		Thread.sleep(1000);
		Form.GraduationMarkType(MarkTypeC);
		Thread.sleep(1000);
		
		ExtentFactory.getInstance().getExtent().info("Entering less than 45 percentage marks in Graduation");
		Form.GraduationObtainedMark().sendKeys(SecuredCGPAL45);
		Thread.sleep(1000);
		Form.PGExamPassed(PGExamName);
		Thread.sleep(1000);
		Form.PGBoard(PGBoardName);
		Thread.sleep(1000);
		Form.PGYOP(PGYOP);
		Thread.sleep(1000);
		Form.PGRollNo().sendKeys(PGRollNumber);
		Thread.sleep(1000);
		Form.PGMarkType(MarkTypeC);
		Thread.sleep(1000);
		
		ExtentFactory.getInstance().getExtent().info("Entering less than 45 percentage marks in PG");
		Form.PGObtainedMark().sendKeys(SecuredCGPAL45);
		Thread.sleep(1000);
		Form.Submit().click();
		Thread.sleep(600);

		String msg = Form.GetMsg();
		Thread.sleep(600);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("PG Percentage cannot be less than 45")) {
			System.out.println(msg);
			Form.JavaDismissAlert();

			constants.fileone.setCellData(sheetName, "Status", 171, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 171, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "PG Percentage cannot be less than 45");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info(
				"Successfully checked Passed Rastra Bhasa Ratna from Rastra Bhasa Prachar Samiti With less than 45 Percentage In PG scenario");
	}

	@Test(priority = 5)
	public void ShastriFromOdishaWithMoreThan45Percentage() throws Exception {

		// logger = report.createTest("General With More Than 45 Percentage In PG");

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
		Form.Gender(GenderM);
		Thread.sleep(1000);
		Form.ValidDateOfBirth();
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Selecting Social Category as SC");
		Form.SocialCategory(SocialCategorySC);
		Thread.sleep(1000);
		Form.MaritalStatus(MaritalStatusU);
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent()
				.info("Selecting Hindi Qualification as 3.Shastri from Odisha Rastra Bhasa Parishad, Puri");
		Form.HindiQualificationCriteria(HindiQualification3);
		Thread.sleep(1000);
		Form.AddressLine1().clear();
		Form.AddressLine1().sendKeys(Add1);
		Thread.sleep(1000);
		Form.AddressLine2().clear();
		Form.AddressLine2().sendKeys(Add2);
		Thread.sleep(1000);
		Form.PresentState(StateO);
		Thread.sleep(1000);
		Form.PresentDistrict(District1);
		Thread.sleep(1000);
		Form.PresentPinCode().clear();
		Form.PresentPinCode().sendKeys(Pincode);
		Thread.sleep(1000);
		Form.SameAsPresent().click();
		Thread.sleep(1000);
		Form.OdiaStudied().click();
		Thread.sleep(1000);

		Form.TenthExamType(TenthExamName);
		Thread.sleep(1000);
		Form.TenthMarkType(MarkTypeC);
		Thread.sleep(1000);
		
		Form.TenthObtainedMark().sendKeys(TenthCGPA);
		Thread.sleep(1000);
		Form.TwelthExamPassed(TwelthExamName);
		Thread.sleep(1000);
		Form.TwelthBoard(TwelthBoardName);
		Thread.sleep(1000);
		Form.TwelthYOP(TwelthYOP);
		Thread.sleep(1000);
		Form.TwelthRollNo().sendKeys(TwelthRollNumber);
		Thread.sleep(1000);
		Form.TwelthMarkType(MarkTypeC);
		Thread.sleep(1000);
	
		Form.TwelthObtainedMark().sendKeys(TwelthCGPA);
		Thread.sleep(1000);
		Form.GraduationExamPassed(GraduationExamName);
		Thread.sleep(1000);
		Form.GraduationBoard(GraduationBoardName);
		Thread.sleep(1000);
		Form.GraduationYOP(GraduationYOP);
		Thread.sleep(1000);
		Form.GraduationRollNo().sendKeys(GradRollNumber);
		Thread.sleep(1000);
		Form.GraduationMarkType(MarkTypeC);
		Thread.sleep(1000);
		
		ExtentFactory.getInstance().getExtent().info("Entering more than 45 percentage marks in Graduation");
		Form.GraduationObtainedMark().sendKeys(GradCGPA);
		Thread.sleep(1000);

		Form.Submit().click();
		Thread.sleep(600);

		String msg = Form.GetMsg();
		Thread.sleep(600);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("Are you sure you want to proceed ?")) {
			System.out.println(msg);
			Form.JavaDismissAlert();

			constants.fileone.setCellData(sheetName, "Status", 172, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 172, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "Are you sure you want to proceed ?");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info(
				"Successfully checked Shastri from Odisha Rastra Bhasa Parishad With More Than 45 Percentage In PG scenario");
	}

	@Test(priority = 6)
	public void ShastriFromOdishaWithLessThan45Percentage() throws Exception {

		// logger = report.createTest("Science With less than 45 Percentage In PG");

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
		Form.Gender(GenderM);
		Thread.sleep(1000);
		Form.ValidDateOfBirth();
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Selecting Social Category as SC");
		Form.SocialCategory(SocialCategorySC);
		Thread.sleep(1000);
		Form.MaritalStatus(MaritalStatusU);
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent()
				.info("Selecting Hindi Qualification as 3.Shastri from Odisha Rastra Bhasa Parishad, Puri");
		Form.HindiQualificationCriteria(HindiQualification3);
		Thread.sleep(1000);
		Form.AddressLine1().clear();
		Form.AddressLine1().sendKeys(Add1);
		Thread.sleep(1000);
		Form.AddressLine2().clear();
		Form.AddressLine2().sendKeys(Add2);
		Thread.sleep(1000);
		Form.PresentState(StateO);
		Thread.sleep(1000);
		Form.PresentDistrict(District1);
		Thread.sleep(1000);
		Form.PresentPinCode().clear();
		Form.PresentPinCode().sendKeys(Pincode);
		Thread.sleep(1000);
		Form.SameAsPresent().click();
		Thread.sleep(1000);
		Form.OdiaStudied().click();
		Thread.sleep(1000);

		Form.TenthExamType(TenthExamName);
		Thread.sleep(1000);
		Form.TenthMarkType(MarkTypeC);

		Thread.sleep(1000);
		Form.TenthObtainedMark().sendKeys(TenthCGPA);
		Thread.sleep(1000);
		Form.TwelthExamPassed(TwelthExamName);
		Thread.sleep(1000);
		Form.TwelthBoard(TwelthBoardName);
		Thread.sleep(1000);
		Form.TwelthYOP(TwelthYOP);
		Thread.sleep(1000);
		Form.TwelthRollNo().sendKeys(TwelthRollNumber);
		Thread.sleep(1000);
		Form.TwelthMarkType(MarkTypeC);
		Thread.sleep(1000);

		Form.TwelthObtainedMark().sendKeys(TwelthCGPA);
		Thread.sleep(1000);
		Form.GraduationExamPassed(GraduationExamName);
		Thread.sleep(1000);
		Form.GraduationBoard(GraduationBoardName);
		Thread.sleep(1000);
		Form.GraduationYOP(GraduationYOP);
		Thread.sleep(1000);
		Form.GraduationRollNo().sendKeys(GradRollNumber);
		Thread.sleep(1000);
		Form.GraduationMarkType(MarkTypeC);
		Thread.sleep(1000);

		ExtentFactory.getInstance().getExtent().info("Entering less than 45 percentage marks in Graduation");
		Form.GraduationObtainedMark().sendKeys(SecuredCGPAL45);
		Thread.sleep(1000);
		Form.PGExamPassed(PGExamName);
		Thread.sleep(1000);
		Form.PGBoard(PGBoardName);
		Thread.sleep(1000);
		Form.PGYOP(PGYOP);
		Thread.sleep(1000);
		Form.PGRollNo().sendKeys(PGRollNumber);
		Thread.sleep(1000);
		Form.PGMarkType(MarkTypeC);
		Thread.sleep(1000);

		ExtentFactory.getInstance().getExtent().info("Entering less than 45 percentage marks in PG");
		Form.PGObtainedMark().sendKeys(SecuredCGPAL45);
		Thread.sleep(1000);
		Form.Submit().click();
		Thread.sleep(600);

		String msg = Form.GetMsg();
		Thread.sleep(600);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("PG Percentage cannot be less than 45")) {
			System.out.println(msg);
			Form.JavaDismissAlert();

			constants.fileone.setCellData(sheetName, "Status", 173, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 173, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "PG Percentage cannot be less than 45");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info(
				"Successfully checked Shastri from Odisha Rastra Bhasa Parishad With less than 45 Percentage In PG scenario");
	}

	@Test(priority = 7)
	public void SnatakWithMoreThan45Percentage() throws Exception {

		// logger = report.createTest("General With More Than 45 Percentage In PG");

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
		Form.Gender(GenderM);
		Thread.sleep(1000);
		Form.ValidDateOfBirth();
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Selecting Social Category as SC");
		Form.SocialCategory(SocialCategorySC);
		Thread.sleep(1000);
		Form.MaritalStatus(MaritalStatusU);
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info(
				"Selecting Hindi Qualification as 4.Snatak (Up to june, 2005 the date upto which temporary recognization has been granted)");
		Form.HindiQualificationCriteria(HindiQualification4);
		Thread.sleep(1000);
		Form.AddressLine1().clear();
		Form.AddressLine1().sendKeys(Add1);
		Thread.sleep(1000);
		Form.AddressLine2().clear();
		Form.AddressLine2().sendKeys(Add2);
		Thread.sleep(1000);
		Form.PresentState(StateO);
		Thread.sleep(1000);
		Form.PresentDistrict(District1);
		Thread.sleep(1000);
		Form.PresentPinCode().clear();
		Form.PresentPinCode().sendKeys(Pincode);
		Thread.sleep(1000);
		Form.SameAsPresent().click();
		Thread.sleep(1000);
		Form.OdiaStudied().click();
		Thread.sleep(1000);

		Form.TenthExamType(TenthExamName);
		Thread.sleep(1000);
		Form.TenthMarkType(MarkTypeC);
		Thread.sleep(1000);
		Form.TenthObtainedMark().sendKeys(TenthCGPA);
		Thread.sleep(1000);
		Form.TwelthExamPassed(TwelthExamName);
		Thread.sleep(1000);
		Form.TwelthBoard(TwelthBoardName);
		Thread.sleep(1000);
		Form.TwelthYOP(TwelthYOP);
		Thread.sleep(1000);
		Form.TwelthRollNo().sendKeys(TwelthRollNumber);
		Thread.sleep(1000);
		Form.TwelthMarkType(MarkTypeC);
		Thread.sleep(1000);
		Form.TwelthObtainedMark().sendKeys(TwelthCGPA);
		Thread.sleep(1000);
		Form.GraduationExamPassed(GraduationExamName);
		Thread.sleep(1000);
		Form.GraduationBoard(GraduationBoardName);
		Thread.sleep(1000);
		Form.GraduationYOP(GraduationYOP);
		Thread.sleep(1000);
		Form.GraduationRollNo().sendKeys(GradRollNumber);
		Thread.sleep(1000);
		Form.GraduationMarkType(MarkTypeC);
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Entering more than 45 percentage marks in Graduation");
		Form.GraduationObtainedMark().sendKeys(GradCGPA);
		Thread.sleep(1000);

		Form.Submit().click();
		Thread.sleep(600);

		String msg = Form.GetMsg();
		Thread.sleep(600);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("Are you sure you want to proceed ?")) {
			System.out.println(msg);
			Form.JavaDismissAlert();

			constants.fileone.setCellData(sheetName, "Status", 174, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 174, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "Are you sure you want to proceed ?");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info(
				"Successfully checked Snatak (Up to june, 2005 the date upto which temporary recognization has been granted) With More Than 45 Percentage In PG scenario");
	}

	@Test(priority = 8)
	public void SnatakWithLessThan45Percentage() throws Exception {

		// logger = report.createTest("Science With less than 45 Percentage In PG");

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
		Form.Gender(GenderM);
		Thread.sleep(1000);
		Form.ValidDateOfBirth();
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Selecting Social Category as SC");
		Form.SocialCategory(SocialCategorySC);
		Thread.sleep(1000);
		Form.MaritalStatus(MaritalStatusU);
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info(
				"Selecting Hindi Qualification as 4.Snatak (Up to june, 2005 the date upto which temporary recognization has been granted)");
		Form.HindiQualificationCriteria(HindiQualification4);
		Thread.sleep(1000);
		Form.AddressLine1().clear();
		Form.AddressLine1().sendKeys(Add1);
		Thread.sleep(1000);
		Form.AddressLine2().clear();
		Form.AddressLine2().sendKeys(Add2);
		Thread.sleep(1000);
		Form.PresentState(StateO);
		Thread.sleep(1000);
		Form.PresentDistrict(District1);
		Thread.sleep(1000);
		Form.PresentPinCode().clear();
		Form.PresentPinCode().sendKeys(Pincode);
		Thread.sleep(1000);
		Form.SameAsPresent().click();
		Thread.sleep(1000);
		Form.OdiaStudied().click();
		Thread.sleep(1000);

		Form.TenthExamType(TenthExamName);
		Thread.sleep(1000);
		Form.TenthMarkType(MarkTypeC);
		Thread.sleep(1000);
		Form.TenthObtainedMark().sendKeys(TenthCGPA);
		Thread.sleep(1000);
		Form.TwelthExamPassed(TwelthExamName);
		Thread.sleep(1000);
		Form.TwelthBoard(TwelthBoardName);
		Thread.sleep(1000);
		Form.TwelthYOP(TwelthYOP);
		Thread.sleep(1000);
		Form.TwelthRollNo().sendKeys(TwelthRollNumber);
		Thread.sleep(1000);
		Form.TwelthMarkType(MarkTypeC);
		Thread.sleep(1000);
		Form.TwelthObtainedMark().sendKeys(TwelthCGPA);
		Thread.sleep(1000);
		Form.GraduationExamPassed(GraduationExamName);
		Thread.sleep(1000);
		Form.GraduationBoard(GraduationBoardName);
		Thread.sleep(1000);
		Form.GraduationYOP(GraduationYOP);
		Thread.sleep(1000);
		Form.GraduationRollNo().sendKeys(GradRollNumber);
		Thread.sleep(1000);
		Form.GraduationMarkType(MarkTypeC);
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Entering less than 45 percentage marks in Graduation");
		Form.GraduationObtainedMark().sendKeys(SecuredCGPAL45);
		Thread.sleep(1000);
		Form.PGExamPassed(PGExamName);
		Thread.sleep(1000);
		Form.PGBoard(PGBoardName);
		Thread.sleep(1000);
		Form.PGYOP(PGYOP);
		Thread.sleep(1000);
		Form.PGRollNo().sendKeys(PGRollNumber);
		Thread.sleep(1000);
		Form.PGMarkType(MarkTypeC);
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Entering less than 45 percentage marks in PG");
		Form.PGObtainedMark().sendKeys(SecuredCGPAL45);
		Thread.sleep(1000);
		Form.Submit().click();
		Thread.sleep(600);

		String msg = Form.GetMsg();
		Thread.sleep(600);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("PG Percentage cannot be less than 45")) {
			System.out.println(msg);
			Form.JavaDismissAlert();

			constants.fileone.setCellData(sheetName, "Status", 175, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 175, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "PG Percentage cannot be less than 45");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info(
				"Successfully checked Snatak (Up to june, 2005 the date upto which temporary recognization has been granted) With less than 45 Percentage In PG scenario");
	}

}