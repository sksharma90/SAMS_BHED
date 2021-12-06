package com.BHEd.ObjectRepository;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BHEdUploadImage {
	WebDriver driver;

	public BHEdUploadImage(WebDriver driver) {

		this.driver = driver;
	}

	By UpImage = By.xpath("//span[contains(text(),'Upload Photo/Signature ')]");

	public WebElement UploadImage() {

		return driver.findElement(UpImage);
	}

	By file = By.id("fldImage");

	public WebElement ChoosFile() {

		return driver.findElement(file);
	}

	By save = By.id("btnSave");

	public WebElement Save() {

		return driver.findElement(save);
	}

	By PopupMsgCancel = By.id("popup_cancel");

	public WebElement PopUpMsgCancel() {

		return driver.findElement(PopupMsgCancel);
	}

	By PopupMsgOk = By.id("popup_ok");

	public WebElement PopUpMsgOk() {

		return driver.findElement(PopupMsgOk);
	}

	By MsgCapture = By.id("popup_message");

	public WebElement PopUpMessage() {
		return driver.findElement(MsgCapture);
	}

	public static void uploadFile(String Data) throws Exception {
		try {
//			StringSelection ss = new StringSelection(Data);
			// StringSelection is a class that can be used for copy and paste operations.
			StringSelection stringSelection = new StringSelection(Data);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception exp) {
			exp.printStackTrace();
		}
		// Thread.sleep(3000);
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(6000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void ChooseFileClick() {

		WebElement element = driver.findElement(By.id("fldImage"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

	}

	By ChooseSignature = By.id("fldSignature");

	public WebElement ChooseSignature() {
		return driver.findElement(ChooseSignature);
	}

}
