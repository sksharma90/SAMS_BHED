package com.BHEd.Tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BHEd.GenericLibrary.constants;
import com.BHEd.Listeners.ExtentFactory;
import com.BHEd.ObjectRepository.BHEdCAF;
import com.BHEd.ObjectRepository.BHEdData;
import com.BHEd.ObjectRepository.BHEdLogin;
import com.BHEd.ObjectRepository.BaseClass;
import com.BHEd.browser.BrowserFactoryNew;


public class ReadonlyMobileNo extends BaseClass implements BHEdData {

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
		login.SelectCourse(SelectCourse4);
		Thread.sleep(1000);
	}


	@Test(priority = 1)
	public void MobileNoDisability() throws Exception {

		//logger = report.createTest("Disability of Registered Mobile No");
		
		BHEdCAF Form= new BHEdCAF(driver);
		Thread.sleep(1000);

		WebElement Data = Form.MobileNumber();

		String readonly = Data.getAttribute("readonly");
		Thread.sleep(600);
		System.out.println(readonly);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (Data.isEnabled()) {

			System.out.println("Mobile Number Enabled");

			constants.fileone.setCellData(sheetName, "Status", 14, "Fail");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 14, "Pass");
			System.out.println("Mobile Number Disabled");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(true, readonly);
		
//		softAssert.assertAll();
		
		ExtentFactory.getInstance().getExtent()
				.info("Successfully Checked Disability of Registered Mobile No. scenario");
	}
}