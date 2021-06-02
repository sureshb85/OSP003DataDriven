package com.framework.datadriven.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.framework.datadriven.utils.BrowserFactory;
import com.framework.datadriven.utils.ExtentReportManager;

public class BaseTest {

	public ExtentTest logger;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public WebDriver driver = null;
	private static Duration timeoutSeconds = Duration.ofSeconds(15);

	@BeforeMethod(groups = { "smoke", "regression" })
	// Java reflection api
	public void startTest(Method method) {
		BrowserFactory browserFactory = new BrowserFactory();
		driver = browserFactory.createDriver();
		Test test = method.getAnnotation(Test.class);
		System.out.println("Test description is " + test.description());
		logger = report.createTest(test.description());
		driver.get(browserFactory.launchURL());
		driver.manage().timeouts().implicitlyWait(timeoutSeconds);
		driver.manage().window().maximize();
		// driver.manage().window().fullscreen();
	}

	@AfterMethod(groups = { "smoke", "regression" })
	public void closeTest(ITestResult result) throws IOException {
		if (result.getStatus() == 2) {
			logger.fail(result.getThrowable(),
					MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot()).build());
		} else if (result.getStatus() == 1) {
			logger.pass(result.getTestName(),
					MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot()).build());
		}
		if (driver != null) {
			driver.quit();
			driver = null;
		}
		report.flush();
	}

	public String captureScreenshot() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotName = returnDateStamp(".png");
		String screenShotLoc = System.getProperty("user.dir") + "\\reports\\" + screenshotName;
		FileUtils.copyFile(srcFile, new File(screenShotLoc));
		return screenShotLoc;
	}

	public static String returnDateStamp(String fileExtension) {
		Date d = new Date();
		String date = d.toString().replace(":", "_").replace(" ", "_") + fileExtension;
		return date;
	}
}
