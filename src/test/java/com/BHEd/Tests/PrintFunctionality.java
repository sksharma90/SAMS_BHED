package com.BHEd.Tests;

import java.util.Iterator;

import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.BHEd.GenericLibrary.constants;
import com.BHEd.ObjectRepository.BHEdData;
import com.BHEd.ObjectRepository.BaseClass;
import com.BHEd.ObjectRepository.PrintCAF;
import com.BHEd.browser.BrowserFactoryNew;

public class PrintFunctionality extends BaseClass implements BHEdData {

	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "Result";
	int rowCount = constants.fileone.getRowCount(sheetName);

	@Test(priority = 0)
	public void Login() throws Exception {

		PrintCAF Form = new PrintCAF(driver);

		BrowserFactoryNew bc = new BrowserFactoryNew();
		bc.Login(MobileNumber, Password);
		Thread.sleep(3000);

		Form.PrintCAF().click();
		Thread.sleep(300);
		Form.PrintButton().click();

		String parent = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String child = itr.next();
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
			}
		}
	}

	@Test(priority = 1)
	public void PrintFunctionalityCheckForFreshApplicant() throws Exception {

		// logger = report.createTest("Print Functionality Check For Fresh Applicant");

		PrintCAF Print = new PrintCAF(driver);
		Thread.sleep(1000);

		String Course = Print.Course().getText();
		String ApplicantType = Print.ApplicantType().getText();
		String Name = Print.ApplicantName().getText();
		String MotherNamee = Print.MotherName().getText();
		String FatherNamee = Print.FatherName().getText();
		String Genderr = Print.Gender().getText();
		String Emaill = Print.Email().getText();
		String MobNo = Print.MobileNumber().getText();
		String AlternateMobNoo = Print.AlternateNumber().getText();
		String MartialStatuss = Print.MartialStatus().getText();
		String Quotaa = Print.Quota().getText();
		String HigherSecondaryy = Print.HighSecondary().getText();
		String Addresss1 = Print.Address1().getText();
		String Addresss2 = Print.Address2().getText();
		String Statee = Print.State().getText();
		String Districtt = Print.District().getText();
		String PinCodee = Print.PinCode().getText();
//		String Streamm = Print.StreamName().getText();
		String Exam = Print.ExamPassed().getText();
		String CollegeBoard = Print.CollegeBoard().getText();
		String ExamType = Print.ExamType().getText();
		String YOP = Print.YOP().getText();
		String RollNo = Print.RollNumberr().getText();
		String Max = Print.MaxMark().getText();
		String Sec = Print.SecMark().getText();

		String TwelthExam = Print.TwelthExamPassed().getText();
		String TwelthCollegeBoard = Print.TwelthCollegeBoard().getText();
		String TwelthExamType = Print.TwelthExamType().getText();
		String TwelthYOPP = Print.TwelthYOP().getText();
		String TwelthRollNo = Print.TwelthRollNumberr().getText();
		String TwelthMax = Print.TwelthMaxMark().getText();
		String TwelthSec = Print.TwelthSecMark().getText();

		String GraduationExam = Print.GraduationExamPassed().getText();
		String GraduationCollegeBoard = Print.GraduationCollegeBoard().getText();
		String GraduationExamType = Print.GraduationExamType().getText();
		String GraduationYOPP = Print.GraduationYOP().getText();
		String GraduationRollNo = Print.GraduationRollNumberr().getText();
		String GraduationMax = Print.GraduationMaxMark().getText();
		String GraduationSec = Print.GraduationSecMark().getText();

		String PGExam = Print.PGExamPassed().getText();
		String PGCollegeBoard = Print.PGCollegeBoard().getText();
		String PGExamType = Print.PGExamType().getText();
		String PGYOPP = Print.PGYOP().getText();
		String PGRollNo = Print.PGRollNumberr().getText();
		String PGMax = Print.PGMaxMark().getText();
		String PGSec = Print.PGSecMark().getText();

		if (Course.equalsIgnoreCase(SelectCourse1) && ApplicantType.equalsIgnoreCase(ApplicantType1)
				&& Name.equals(ApplicantName) && MotherNamee.equals(FatherName) && FatherNamee.equals(MotherName)
				&& Genderr.equalsIgnoreCase(GenderM) && Emaill.equals("Subhasmita@gmail.com")
				&& MobNo.equals("8908758097") && AlternateMobNoo.equals(AlternateMobNo)
				&& MartialStatuss.equalsIgnoreCase(MaritalStatusM) && Quotaa.equalsIgnoreCase(QuotaS)
				&& HigherSecondaryy.equals("Passed") && Addresss1.equals(Add1) && Addresss2.equals(Add2)
				&& Statee.equalsIgnoreCase(StateO) && Districtt.equalsIgnoreCase(District1) && PinCodee.equals(Pincode)
				&& Exam.equalsIgnoreCase("10th") && CollegeBoard.equalsIgnoreCase(TenthBoard)
				&& ExamType.equals("Annual") && YOP.equals(TenthYOP) && RollNo.equals("21TC980")
				&& Max.equals(TenthMaxMark) && Sec.equals(TenthSecuredMark) && TwelthExam.equalsIgnoreCase("+2")
				&& TwelthCollegeBoard.equalsIgnoreCase(TwelthBoardName) && TwelthExamType.equals("Annual")
				&& TwelthYOPP.equals(TwelthYOP) && TwelthRollNo.equals("21TC114") && TwelthMax.equals(TenthMaxMark)
				&& TwelthSec.equals(TenthSecuredMark) && GraduationExam.equalsIgnoreCase("Graduation")
				&& GraduationCollegeBoard.equalsIgnoreCase(GraduationBoardName) && GraduationExamType.equals("Annual")
				&& GraduationYOPP.equals(GraduationYOP) && GraduationRollNo.equals("21TC114")
				&& GraduationMax.equals(TenthMaxMark) && GraduationSec.equals(TenthSecuredMark)
				&& PGExam.equalsIgnoreCase("Graduation") && PGCollegeBoard.equalsIgnoreCase(GraduationBoardName)
				&& PGExamType.equals("Annual") && PGYOPP.equals(GraduationYOP) && PGRollNo.equals("21TC114")
				&& PGMax.equals(TenthMaxMark) && PGSec.equals(TenthSecuredMark)) {
			System.out.println("All Data Displayed");
			constants.fileone.setCellData(sheetName, "Status", 191, "Pass");

		} else {
			System.out.println(Course + ApplicantType + Name + MotherNamee + FatherNamee + Genderr + Emaill + MobNo
					+ AlternateMobNoo + MartialStatuss + Quotaa + HigherSecondaryy + Addresss1 + Addresss2 + Statee
					+ Districtt);
			constants.fileone.setCellData(sheetName, "Status", 191, "Fail");
		}

	}

}