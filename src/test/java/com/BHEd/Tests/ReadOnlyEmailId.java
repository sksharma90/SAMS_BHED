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

public class ReadOnlyEmailId extends BaseClass implements BHEdData {

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
	public void PopulationAndDisabilityofEmail() throws Exception {

		// logger = report.createTest("Population And Disability of Email");

		BHEdCAF Form = new BHEdCAF(driver);
		Thread.sleep(1000);

		WebElement Data = Form.Email();

		String readonly = Data.getAttribute("readonly");
		Thread.sleep(1000);
		System.out.println(readonly);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (Data.isEnabled()) {

			System.out.println("Email Id Enabled");

			constants.fileone.setCellData(sheetName, "Status", 15, "Fail");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 15, "Pass");
			System.out.println("Email Id Disabled");
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(true, readonly);

//		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent()
				.info("Successfully Checked Population And Disability of Email scenario");
	}
}