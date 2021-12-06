package com.BHEd.Tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BHEd.GenericLibrary.constants;
import com.BHEd.Listeners.ExtentFactory;
import com.BHEd.ObjectRepository.BHEdCAF;
import com.BHEd.ObjectRepository.BHEdData;
import com.BHEd.ObjectRepository.BHEdLogin;
import com.BHEd.ObjectRepository.BaseClass;
import com.BHEd.browser.BrowserFactoryNew;

public class SaveAsDraftFunctionalityScenario extends BaseClass implements BHEdData {

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
	public void SaveAsDraftAfterLogoutAndLoggingInAgain() throws Exception {

		BHEdLogin login = new BHEdLogin(driver);

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
		Form.AadhaarNumber().sendKeys(AadhaarNo);
		Thread.sleep(1000);
		Form.SocialCategory(SocialCategoryG);
		Thread.sleep(1000);
		Form.MaritalStatus(MaritalStatusU);
		Thread.sleep(1000);
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
		Form.PresentPinCode().sendKeys(Pincode);
		Thread.sleep(1000);
		Form.SameAsPresent().click();
		Thread.sleep(1000);
		Form.OdiaStudied().click();
		Thread.sleep(1000);
		Form.TenthMaxMark().sendKeys(TenthMaxMark);
		Thread.sleep(1000);
		Form.TenthObtainedMark().sendKeys(TenthSecuredMark);
		Thread.sleep(1000);
		Form.TwelthExamPassed(TwelthExamName);
		Thread.sleep(1000);
		Form.TwelthBoard(TwelthBoardName);
		Thread.sleep(1000);
		Form.TwelthYOP(TwelthYOP);
		Thread.sleep(1000);
		Form.TwelthRollNo().clear();
		Thread.sleep(1000);
		Form.TwelthRollNo().sendKeys(TwelthRollNumber);
		Thread.sleep(1000);
		Form.TwelthMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.TwelthMaxMark().clear();
		Thread.sleep(1000);
		Form.JavaAcceptAlert();
		Thread.sleep(1000);
		Form.TwelthMaxMark().sendKeys(TwelthMaxMark);
		Thread.sleep(1000);
		Form.TwelthObtainedMark().clear();
		Thread.sleep(1000);
		Form.TwelthObtainedMark().sendKeys(TwelthSecuredMark);
		Thread.sleep(1000);
		Form.GraduationExamPassed(GraduationExamName);
		Thread.sleep(1000);
		Form.GraduationBoard(GraduationBoardName);
		Thread.sleep(1000);
		Form.GraduationYOP(GraduationYOP);
		Thread.sleep(1000);
		Form.GraduationRollNo().clear();
		Thread.sleep(1000);
		Form.GraduationRollNo().sendKeys(GradRollNumber);
		Thread.sleep(1000);
		Form.GraduationMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.GraduationMaxMark().clear();
		Thread.sleep(1000);
		Form.JavaAcceptAlert();
		Thread.sleep(1000);
		Form.GraduationMaxMark().sendKeys(GradMaxMark);
		Thread.sleep(1000);
		Form.GraduationObtainedMark().clear();
		Thread.sleep(1000);
		Form.GraduationObtainedMark().sendKeys(GradSecuredMark);
		Thread.sleep(1000);
		Form.PGExamPassed(PGExamName);
		Thread.sleep(1000);
		Form.PGBoard(PGBoardName);
		Thread.sleep(1000);
		Form.PGYOP(PGYOP);
		Thread.sleep(1000);
		Form.PGRollNo().clear();
		Form.PGRollNo().sendKeys(PGRollNumber);
		Thread.sleep(1000);
		Form.PGMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.PGMaxMark().clear();
		Thread.sleep(1000);
		Form.JavaAcceptAlert();
		Thread.sleep(1000);
		Form.PGMaxMark().sendKeys(PGMaxMark);
		Thread.sleep(1000);
		Form.PGObtainedMark().clear();
		Thread.sleep(1000);
		Form.PGObtainedMark().sendKeys(PGSecuredMark);
		Thread.sleep(1000);

		Thread.sleep(600);
		Form.SaveAsDraft().click();
		Thread.sleep(10000);
		Form.JavaAcceptAlert();
		Thread.sleep(1000);
		Form.LogOut().click();
		Thread.sleep(1000);

		BrowserFactoryNew bc = new BrowserFactoryNew();
		bc.Login(MobileNumber1, Password);
		Thread.sleep(3000);
		Thread.sleep(3000);

		login.ApplicationFormButton().click();
		Thread.sleep(1000);
		login.Close().click();
		Thread.sleep(1000);
		login.BrochureYes().click();
		Thread.sleep(1000);
		login.SelectCourse(SelectCourse4);
		Thread.sleep(1000);

		String RoNumber = Form.TenthRollNo().getAttribute("value");
		String Aname = Form.ApplicantName().getAttribute("value");
		String Fname = Form.FatherSpouseGuardianName().getAttribute("value");
		String MName = Form.MotherName().getAttribute("value");
		String Email = Form.Email().getAttribute("value");
		String Aadhar = Form.AadhaarNumber().getAttribute("value");

		String PAdd1 = Form.AddressLine1().getAttribute("value");
		String PAdd2 = Form.AddressLine2().getAttribute("value");
		String PPin = Form.PresentPinCode().getAttribute("value");
		String TwelthRoll = Form.TwelthRollNo().getAttribute("value");
		String TwelthMax = Form.TwelthMaxMark().getAttribute("value");
		String TwelthSec = Form.TwelthObtainedMark().getAttribute("value");
		String GradRoll = Form.GraduationRollNo().getAttribute("value");
		String GradMax = Form.GraduationMaxMark().getAttribute("value");
		String GradSec = Form.GraduationObtainedMark().getAttribute("value");
		String PostGradRoll = Form.PGRollNo().getAttribute("value");
		String PostGradMax = Form.PGMaxMark().getAttribute("value");
		String PostGradSec = Form.PGObtainedMark().getAttribute("value");

		Thread.sleep(600);

		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		
		if (!(RoNumber.equals(TenthRollNumber) && Aname.equals(ApplicantName) && Fname.equals(FatherName)
				&& MName.equals(MotherName) && Email.equals(Email) && Aadhar.equals(AadhaarNo) && PAdd1.equals(Add1)
				&& PAdd2.equals(Add2) && PPin.equals(Pincode) && TwelthRoll.equals(TwelthRollNumber)
				&& TwelthMax.equals(TwelthMaxMark) && TwelthSec.equals(TwelthSecuredMark)
				&& GradRoll.equals(GradRollNumber) && GradMax.equals(GradMaxMark) && GradSec.equals(GradSecuredMark)
				&& PostGradRoll.equals(PGRollNumber) && PostGradMax.equals(PGMaxMark)
				&& PostGradSec.equals(PGSecuredMark))) {
			
			System.out.println("All Data Showing");
			
			System.out.println(RoNumber + Aname + Fname + MName + Email + Aadhar + PAdd1 + PAdd2 + PPin + TwelthRoll
					+ TwelthMax + TwelthSec + GradRoll + GradMax + GradSec + PostGradRoll + PostGradMax + PostGradSec);

			constants.fileone.setCellData(sheetName, "Status", 133, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 133, "Fail");
		}
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(true,
				RoNumber.equals(TenthRollNumber) && Aname.equals(ApplicantName) && Fname.equals(FatherName)
				&& MName.equals(MotherName) && Email.equals(Email) && Aadhar.equals(AadhaarNo) && PAdd1.equals(Add1)
				&& PAdd2.equals(Add2) && PPin.equals(Pincode) && TwelthRoll.equals(TwelthRollNumber)
				&& TwelthMax.equals(TwelthMaxMark) && TwelthSec.equals(TwelthSecuredMark)
				&& GradRoll.equals(GradRollNumber) && GradMax.equals(GradMaxMark) && GradSec.equals(GradSecuredMark)
				&& PostGradRoll.equals(PGRollNumber) && PostGradMax.equals(PGMaxMark)
				&& PostGradSec.equals(PGSecuredMark));
		
		ExtentFactory.getInstance().getExtent()
				.info("Successfully Checked Save As Draft After Logout And Logging In Again Scenario");

	}
}