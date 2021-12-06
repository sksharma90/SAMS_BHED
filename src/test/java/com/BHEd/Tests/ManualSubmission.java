package com.BHEd.Tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import com.BHEd.GenericLibrary.constants;
import com.BHEd.ObjectRepository.BHEdCAF;
import com.BHEd.ObjectRepository.BHEdData;
import com.BHEd.ObjectRepository.BHEdLogin;
import com.BHEd.ObjectRepository.BaseClass;
import com.BHEd.browser.BrowserFactoryNew;

public class ManualSubmission extends BaseClass implements BHEdData {

	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "Result";
	int rowCount = constants.fileone.getRowCount(sheetName);

	@Test(priority = 0)
	public void Login() throws Exception {

		BHEdLogin login = new BHEdLogin(driver);

		BrowserFactoryNew bc = new BrowserFactoryNew();
		bc.Login("7978329590", Password);
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
	public void SuccessfulSaveAsDraft() throws Exception {

		BHEdCAF Form = new BHEdCAF(driver);
		Thread.sleep(1000);
		Form.TenthBoard(OtherBoard);
		Thread.sleep(1000);
		Form.TenthYOP(TenthYOP);
		Thread.sleep(1000);
		Form.Annual().click();
		Thread.sleep(1000);
		Form.GraduationPassed().click();
		Thread.sleep(1000);
		Form.TenthRollNo().sendKeys("001ERT567");
		Thread.sleep(3000);
		Form.MotherName().click();
		Thread.sleep(1000);
		Form.MotherName().sendKeys(MotherName);
		Thread.sleep(1000);
		Form.ApplicantName().sendKeys(ApplicantName);
		Thread.sleep(1000);
		Form.FatherSpouseGuardianName().sendKeys(FatherName);
		Thread.sleep(1000);
		Form.Gender(GenderT);
		Thread.sleep(1000);
		Form.ValidDateOfBirth();
		Thread.sleep(1000);
		Form.SocialCategory(SocialCategoryST);
		Thread.sleep(1000);
		
//		Form.ReserveCategory(ReserveCategoryE);
//		Thread.sleep(1000);
//		Form.RajyaSainikYes().click();
//		Thread.sleep(600);
//		Form.JavaAcceptAlert();
		
//		Form.ReserveCategory(ReserveCategoryPH);
//		Thread.sleep(600);
//		Form.UDIDNumber().clear();
//		Form.UDIDNumber().sendKeys(UDIDNumber);
//		Thread.sleep(600);
//		Form.ScribeNeeded().click();
//		Thread.sleep(600);
//		Form.DisabilityType(DisabilityTypeB);
//		Thread.sleep(600);
//		Form.DisabilityPercent().sendKeys(DisabilityPerc2);
//		Thread.sleep(600);
		Form.MaritalStatus(MaritalStatusU);
		Thread.sleep(1000);
		Form.HindiQualificationCriteria(HindiQualification2);
		Thread.sleep(1000);
		Form.AddressLine1().sendKeys(Add1);
		Thread.sleep(1000);
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
		Form.TenthExamType(TenthExamName);
		Thread.sleep(1000);
		Form.TenthMarkType(MarkTypeM);
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
		Form.TwelthRollNo().sendKeys(TwelthRollNumber);
		Thread.sleep(1000);
		Form.TwelthMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.TwelthMaxMark().sendKeys(TwelthMaxMark);
		Thread.sleep(1000);
		Form.TwelthObtainedMark().sendKeys(TwelthSecuredMark);
		Thread.sleep(1000);
		Form.GraduationExamPassed(GraduationExamName);
		Thread.sleep(1000);
		Form.GraduationBoard(GraduationBoardName);
		Thread.sleep(1000);
		Form.GraduationYOP(GraduationYOP);
		Thread.sleep(1000);
		Form.GraduationRollNo().sendKeys(GradRollNumber);
		Thread.sleep(1000);
		Form.GraduationMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.GraduationMaxMark().sendKeys(GradMaxMark);
		Thread.sleep(1000);
		Form.GraduationObtainedMark().sendKeys(GradSecuredMark);
		Thread.sleep(1000);
		Form.PGExamPassed(PGExamName);
		Thread.sleep(1000);
		Form.PGBoard(PGBoardName);
		Thread.sleep(1000);
		Form.PGYOP(PGYOP);
		Thread.sleep(1000);
		Form.PGRollNo().sendKeys(PGRollNumber);
		Thread.sleep(1000);
		Form.PGMarkType(MarkTypeM);
		Thread.sleep(1000);
		Form.PGMaxMark().sendKeys(PGMaxMark);
		Thread.sleep(1000);
		Form.PGObtainedMark().sendKeys(PGSecuredMark);
		
		//Save As Draft
		Thread.sleep(1000);
		Form.SaveAsDraft().click();
		Thread.sleep(1000);
		Form.JavaAcceptAlert();
		Thread.sleep(1000);
		
		//Submission
		Form.Submit().click();
		Thread.sleep(1000);
		Form.JavaAcceptAlert();
		Thread.sleep(1000);
		Form.JavaAcceptAlert();
		Thread.sleep(1000);
		
		//Final Confirmation
		Form.Confirm().click();
		Thread.sleep(1000);
		Form.JavaAcceptAlert();
		Thread.sleep(1000);
		Form.JavaAcceptAlert();
		Thread.sleep(1000);
		
	}

}