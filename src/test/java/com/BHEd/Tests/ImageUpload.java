package com.BHEd.Tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BHEd.GenericLibrary.constants;
import com.BHEd.Listeners.ExtentFactory;
import com.BHEd.ObjectRepository.BHEdData;
import com.BHEd.ObjectRepository.BHEdUploadImage;
import com.BHEd.ObjectRepository.BaseClass;
import com.BHEd.browser.BrowserFactoryNew;

public class ImageUpload extends BaseClass implements BHEdData {

	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "Result";
	int rowCount = constants.fileone.getRowCount(sheetName);

	@Test(priority = 0)
	public void Login() throws Exception {

		BHEdUploadImage Upload = new BHEdUploadImage(driver);

		BrowserFactoryNew bc = new BrowserFactoryNew();
		bc.Login("7978329584", Password);
		Thread.sleep(3000);

		Thread.sleep(1000);
		Upload.UploadImage().click();
	}

	@Test(priority = 1)
	public void ImageUploadWithValidData() throws Exception {

		// logger = report.createTest("Image Upload With Valid Data");

		BHEdUploadImage Upload = new BHEdUploadImage(driver);
		Thread.sleep(400);

		Upload.ChoosFile().sendKeys("D:\\SAMSBHEd2021\\1.jpg");
		Thread.sleep(400);
		Upload.ChooseSignature().sendKeys("D:\\SAMSBHEd2021\\11.jpg");

		Upload.Save().click();

		Thread.sleep(400);

		String msg = Upload.PopUpMessage().getText();
		Thread.sleep(400);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("Are you sure you want to Save?")) {
			System.out.println(msg);
			Upload.PopUpMsgCancel().click();
			constants.fileone.setCellData(sheetName, "Status", 144, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 144, "Fail");
		}

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "Are you sure you want to Save?");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully Checked Image Upload With Valid Data scenario");
	}

	@Test(priority = 2)
	public void ImageUploadWithInValidData() throws Exception {

		// logger = report.createTest("Image Upload With InValid Data");

		BHEdUploadImage Upload = new BHEdUploadImage(driver);
		Thread.sleep(400);

		Upload.ChoosFile().sendKeys("D:\\SAMSBHEd2021\\1mb.pdf");
		Thread.sleep(400);

		String msg = Upload.PopUpMessage().getText();
		Thread.sleep(400);
		ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
		if (msg.equals("Please select a valid file of type gif/jpeg/png.")) {
			System.out.println(msg);
			Upload.PopUpMsgOk().click();
			constants.fileone.setCellData(sheetName, "Status", 145, "Pass");
		} else {
			constants.fileone.setCellData(sheetName, "Status", 145, "Fail");
		}

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(msg, "Please select a valid file of type gif/jpeg/png.");

		softAssert.assertAll();

		ExtentFactory.getInstance().getExtent().info("Successfully Checked Image Upload With In Valid Data scenario");
	}
}