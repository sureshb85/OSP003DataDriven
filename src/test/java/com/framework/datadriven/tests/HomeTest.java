package com.framework.datadriven.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.framework.datadriven.pages.HomePage;

public class HomeTest extends BaseTest {
	@Test(groups = {"smoke"}, enabled = true, description = "title test case validation")
	public void validateTitle() {
		// System.out.println("validating application title");
		logger.log(Status.INFO, "validating application title");
		String actualTitle = driver.getTitle();
		logger.log(Status.INFO, "actual: " + actualTitle);
		logger.log(Status.INFO, "expected: JPetStore Demo1");
		Assert.assertEquals(actualTitle, "JPetStore Demo1");
	}

	@Test(groups = {"smoke"}, enabled = true, description = "sign in test case validation")
	public void signInTest() {
		// System.out.println("clicking on sign in link");
		logger.log(Status.INFO, "clicking on sign in link");
		HomePage homePage = new HomePage(driver);
		homePage.login();
	}

	@Test(groups = {"regression"}, enabled = true, description = "new user sign up test case validation without data provider")
	public void signUpTest() {
		logger.log(Status.INFO, "new user sign up");
		// System.out.println("new user sign up");
		HomePage homePage = new HomePage(driver);
		homePage.signUp();
	}

	@Test(groups = {"regression"}, enabled = true, dataProvider = "testData", description = "Sign up test case validation with data provider")
	public void signUpDataProviderTest(String firstNameData, String lastNameData, String emailData, String phoneData,
			String address1Data, String address2Data, String cityData, String stateData, String zipData,
			String countryData) throws IOException {
		logger.log(Status.INFO, firstNameData + ": new user sign up");
		// System.out.println("new user sign up");
		HomePage homePage = new HomePage(driver);
		homePage.signUpDataProvider(firstNameData, lastNameData, emailData, phoneData, address1Data, address2Data,
				cityData, stateData, zipData, countryData);
		logger.log(Status.PASS, firstNameData + ": Signup is successfull");
	}

	@DataProvider
	public Object[][] testData() {
		Object[][] data = new Object[2][10];
		data[0][0] = "John";
		data[0][1] = "Peter";
		data[0][2] = "rama@gmail.com";
		data[0][3] = "9845012345";
		data[0][4] = "KR Layout";
		data[0][5] = "KR Puram";
		data[0][6] = "Bangalore";
		data[0][7] = "Karnataka";
		data[0][8] = "560103";
		data[0][9] = "India";

		data[1][0] = "Rama";
		data[1][1] = "Krishna";
		data[1][2] = "rama@yahoo.com";
		data[1][3] = "9845012786";
		data[1][4] = "Patel Layout";
		data[1][5] = "IndiraNagar";
		data[1][6] = "Bangalore";
		data[1][7] = "Karnataka";
		data[1][8] = "561113";
		data[1][9] = "India";
		return data;
	}
}
