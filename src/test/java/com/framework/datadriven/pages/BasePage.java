package com.framework.datadriven.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class BasePage {

	WebDriver driver = null;
	Wait<WebDriver> wait = null;
	private static Duration timeoutSeconds = Duration.ofSeconds(30);
	private static Duration pollingSeconds = Duration.ofSeconds(4);

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new FluentWait<WebDriver>(driver).withTimeout(timeoutSeconds).pollingEvery(pollingSeconds)
				.withMessage("Timeout occured!")
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
	}

	public WebElement getWebElement(By by) {
		WebElement element = null;
		try {
			element = driver.findElement(by);
		} catch (Exception e) {
			System.out.println("Unable to find the element using the By locator: " + e.getMessage());
			Assert.fail("Unable to find the element using the By locator: " + "<" + by.toString() + ">");
		}
		return element;
	}

	public void sendKeysToWebElement(By by, String textToSend) {
		WebElement element = null;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			element = getWebElement(by);
			System.out.println("element found: " + "<" + by.toString() + ">");
			element.clear();
			element.sendKeys(textToSend);
			System.out.println("entered text: " + "<" + by.toString() + ">\t" + textToSend);
		} catch (Exception e) {
			System.out.println("Unable to find the element using the By locator: " + e.getMessage());
			Assert.fail("Unable to find the element using the By locator: " + "<" + by.toString() + ">");
		}
	}

	public void waitAndClickElement(By by) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(by)).click();
			System.out.println("clicked on element: " + "<" + by.toString() + ">");
		} catch (Exception e) {
			System.out.println("Unable to click on the element using the By locator: " + e.getMessage());
			Assert.fail("Unable to click on the element using the By locator: " + "<" + by.toString() + ">");
		}
	}

	public void waitAndClickElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			System.out.println("clicked on element: " + "<" + element.toString() + ">");
		} catch (Exception e) {
			System.out.println("Unable to click on the element using the By locator: " + e.getMessage());
			Assert.fail("Unable to click on the element using the By locator: " + "<" + element.toString() + ">");
		}
	}

	public static String returnDateStamp(String fileExtension) {
		Date d = new Date();
		String date = d.toString().replace(":", "_").replace(" ", "_") + fileExtension;
		return date;
	}

	public String captureScreenshot() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotName = returnDateStamp(".png");
		String screenShotLoc = System.getProperty("user.dir") + "\\reports\\" + screenshotName;
		FileUtils.copyFile(srcFile, new File(screenShotLoc));
		return screenShotLoc;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getText(By by) {
		WebElement element = null;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			element = getWebElement(by);
			System.out.println("element found: " + "<" + by.toString() + ">");
			System.out.println("element text: " + "<" + by.toString() + ">\t" + element.getText());
			return element.getText();

		} catch (Exception e) {
			System.out.println("Unable to find the element using the By locator: " + e.getMessage());
			Assert.fail("Unable to find the element using the By locator: " + "<" + by.toString() + ">");
		}
		return "";
	}

}
