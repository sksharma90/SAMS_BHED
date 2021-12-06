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

public class BacktoModifyfunctionalityOld extends BaseClass implements BHEdData {

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
	public void BackToModify() throws Exception {

		// logger = report.createTest("Verifying Back To Modify functionality");

		BHEdCAF Form = new BHEdCAF(driver);
		Thread.sleep(2000);
		Form.Submit().click();
		Thread.sleep(2000);
		Form.JavaAcceptAlert();
		Thread.sleep(2000);
		Form.JavaAcceptAlert();
		Thread.sleep(3000);
		Form.BackToModify().click();

		Form.TenthBoard(TenthBoard);
		Thread.sleep(1000);
		Form.TenthYOP(TenthYOP);
		Thread.sleep(1000);
		Form.Annual().click();
		Thread.sleep(1000);

		Form.TenthRollNo().clear();
		Form.TenthRollNo().sendKeys("21TC190");
		Thread.sleep(3000);
		Form.MotherName().clear();
		Form.MotherName().click();
		Thread.sleep(1000);
		Form.MotherName().sendKeys(MotherName);
		Thread.sleep(1000);
		Form.ApplicantName().clear();
		Form.ApplicantName().sendKeys(ApplicantName);
		Thread.sleep(1000);
		Form.FatherSpouseGuardianName().clear();
		Form.FatherSpouseGuardianName().sendKeys(FatherName);
		Thread.sleep(1000);
		Form.Gender(GenderM);
		Thread.sleep(1000);
		Form.ValidDateOfBirth();
		Thread.sleep(1000);
		Form.AadhaarNumber().clear();
		Form.AadhaarNumber().sendKeys("111111111221");
		Thread.sleep(1000);
		Form.AlternateMobileNumber().sendKeys(AlternateMobNo);
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
		Form.PresentPinCode().clear();
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
		Thread.sleep(1000);

		Thread.sleep(1000);
		Form.Submit().click();
		Thread.sleep(1000);
		Form.JavaAcceptAlert();
		Thread.sleep(1000);
		Form.JavaAcceptAlert();
		Thread.sleep(1000);

		String AppName = Form.LableApplicantName().getText();
		String FName = Form.LableFatherName().getText();
		String MName = Form.LableMotherName().getText();
		String Aadhar = Form.LableAadhar().getText();
		String Address1 = Form.LablePresentAddress1().getText();
		String Address2 = Form.LablePresentAddress2().getText();
		String Pin = Form.LablePinCde().getText();
		String RollNumber = Form.LableTenthRoll().getText();
		String TenthMax = Form.LableMaxMark().getText();
		String TenthMin = Form.LableSecMark().getText();

		String TwelthRollNumberr = Form.LableTwelthRoll().getText();
		String TwelthMax = Form.LableTwelthMaxMark().getText();
		String TwlthMin = Form.LableTwelthSecMark().getText();

		String Data = Form.LableApplicantType().getText();
		Thread.sleep(400);

		String Data1 = Form.LableTenthBoard().getText();
		Thread.sleep(400);

		String Data2 = Form.LableYOP().getText();
		Thread.sleep(400);

		String Data3 = Form.LableGender().getText();
		Thread.sleep(400);

		String Data4 = Form.LableSocialCategory().getText();
		Thread.sleep(400);

		String Data5 = Form.LableMartialStatus().getText();
		Thread.sleep(400);

		String Data6 = Form.LableState().getText();
		Thread.sleep(400);

		String Data7 = Form.LableDistrict().getText();
		Thread.sleep(400);

		String Data9 = Form.LableTenthExam().getText();
		Thread.sleep(400);

		String Data10 = Form.LableTwelthExam().getText();
		Thread.sleep(400);

		String Data11 = Form.LableTwelthBoard().getText();
		Thread.sleep(400);

		String Data12 = Form.LableTwelthYOP().getText();
		Thread.sleep(400);

		String Data17 = Form.LableGraduationExam().getText();
		Thread.sleep(400);

		String Data18 = Form.LableGraduationBoard().getText();
		Thread.sleep(400);

		String Data19 = Form.LableGraduationYOP().getText();
		Thread.sleep(400);

		String Data20 = Form.LableGraduationRoll().getText();
		Thread.sleep(400);

		String Data21 = Form.LableGraduationMaxMark().getText();
		Thread.sleep(400);

		String Data22 = Form.LableGraduationSecMark().getText();
		Thread.sleep(400);

		String Data23 = Form.LablePGExam().getText();
		Thread.sleep(400);

		String Data24 = Form.LablePGBoard().getText();
		Thread.sleep(400);

		String Data25 = Form.LablePGYOP().getText();
		Thread.sleep(400);

		String Data26 = Form.LablePGRoll().getText();
		Thread.sleep(400);

		String Data27 = Form.LablePGMaxMark().getText();
		Thread.sleep(400);

		String Data28 = Form.LablePGSecMark().getText();
		Thread.sleep(400);

		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (AppName.equals(ApplicantName) && FName.equals(FatherName) && MName.equals(MotherName)
				&& Aadhar.equals("111111111221") && Address1.equals(Add1) && Address2.equals(Add2)
				&& Pin.equals(Pincode) && RollNumber.equals("21TC190") && TenthMax.equals(TenthMaxMark)
				&& TenthMin.equals(TenthSecuredMark) && TwelthRollNumberr.equals(TwelthRollNumber)
				&& TwelthMax.equals(TwelthMaxMark) && TwlthMin.equals(TwelthSecuredMark)
				&& Data.equalsIgnoreCase(ApplicantType1) && Data1.equalsIgnoreCase(TenthBoard) && Data2.equals(TenthYOP)
				&& Data3.equalsIgnoreCase(GenderM) && Data4.equalsIgnoreCase(SocialCategoryG)
				&& Data9.equalsIgnoreCase(TenthExamName) && Data10.equalsIgnoreCase(TwelthExamName)
				&& Data11.equalsIgnoreCase(TwelthBoardName) && Data12.equals(TwelthYOP)
				&& Data17.equals(GraduationExamName) && Data18.equals(GraduationBoardName)
				&& Data19.equals(GraduationYOP) && Data20.equals(GradRollNumber) && Data21.equals(GradMaxMark)
				&& Data22.equals(GradSecuredMark) && Data23.equals(PGExamName) && Data24.equals(PGBoardName)
				&& Data25.equals(PGYOP) && Data26.equals(PGRollNumber) && Data27.equals(PGMaxMark)
				&& Data28.equals(PGSecuredMark)) {

			System.out.println("All Modification Data  Displaying");

			constants.fileone.setCellData(sheetName, "Status", 139, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 139, "Fail");
			System.out.println(AppName + Aadhar + Pin + TwelthRollNumberr + TwlthMin + Data2 + Data6 + Data11
					+ FName + Address1 + Address2 + MName + RollNumber + TenthMax + TenthMin + TwelthMax + Data + Data1
					+ Data3 + Data4 + Data5 + Data9 + Data7 + Data12 + Data10);

			System.out.println("All Modification Data Not Displaying");
		}
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully Checked Back To Modify scenario");

	}

	@Test(priority = 2)
	public void DuplicateRollNumberCheckBackToModify() throws Exception {

		// logger = report.createTest("Non Acceptance of Duplicate Roll Number during
		// Back To Modify");

		BHEdCAF Form = new BHEdCAF(driver);
		Thread.sleep(1000);

		Form.BackToModify().click();

		Form.TenthBoard(TenthBoard);
		Thread.sleep(1000);
		Form.TenthYOP(TenthYOP);
		Thread.sleep(1000);
		Form.Annual().click();
		Thread.sleep(1000);
		// Form.HSEPassed().click();
		Thread.sleep(1000);
		Form.TenthRollNo().clear();
		Form.TenthRollNo().sendKeys(DuplicateRollNo);
		Thread.sleep(3000);
		Form.MotherName().clear();
		Form.MotherName().click();
		Thread.sleep(1000);
		Form.MotherName().sendKeys(MotherName);
		Thread.sleep(1000);
		Form.ApplicantName().clear();
		Form.ApplicantName().sendKeys(ApplicantName);
		Thread.sleep(1000);
		Form.FatherSpouseGuardianName().clear();
		Form.FatherSpouseGuardianName().sendKeys(FatherName);
		Thread.sleep(1000);
		Form.Gender(GenderM);
		Thread.sleep(1000);
		Form.ValidDateOfBirth();
		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Entering Valid Aadhaar Number");
		Form.AadhaarNumber().clear();
		Form.AadhaarNumber().sendKeys("111111111158");
		Thread.sleep(1000);
		Form.AlternateMobileNumber().sendKeys(AlternateMobNo);
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
		Form.PresentPinCode().clear();
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
		Thread.sleep(1000);

		Thread.sleep(1000);
		Form.Submit().click();
		Thread.sleep(600);
		Form.JavaAcceptAlert();
		Thread.sleep(600);
		String msg = Form.GetMsg();

		Thread.sleep(1000);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("Duplicate 10th Roll No. Found which is already submitted by another applicant!")) {

			System.out.println(msg);
			Form.JavaAcceptAlert();

			constants.fileone.setCellData(sheetName, "Status", 140, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 140, "Fail");

		}
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent()
				.info("Successfully Checked Non Acceptance of Duplicate Roll Number during Back To Modify Scenario");

	}
}