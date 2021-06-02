package com.framework.datadriven.tests;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.framework.datadriven.pages.HomePage;
import com.framework.datadriven.utils.CSVDataReader;

public class HomeTestCSVData extends BaseTest {

	@Test(groups = {"regression"}, enabled = true, dataProvider = "csvSignUpData", description = "Sign up test case validation with data provider")
	public void signUpDataProviderTest(Map<String, String> testData) throws IOException {
		// System.out.println("new user sign up");
		HomePage homePage = new HomePage(driver);
		String firstNameData = testData.get("firstName");
		logger.log(Status.INFO, firstNameData + ": new user sign up");
		String lastNameData = testData.get("lastName");
		String emailData = testData.get("email");
		String phoneData = testData.get("phone");
		String address1Data = testData.get("address1");
		String address2Data = testData.get("address2");
		String cityData = testData.get("city");
		String stateData = testData.get("state");
		String zipData = testData.get("zip");
		String countryData = testData.get("country");
		homePage.signUpDataProvider(firstNameData, lastNameData, emailData, phoneData, address1Data, address2Data,
				cityData, stateData, zipData, countryData);
		logger.log(Status.PASS, firstNameData + ": Signup is successfull");
	}

	@DataProvider(name = "csvSignUpData")
	Iterator<Object[]> getCSVData() throws IOException {
		String filePath = System.getProperty("user.dir") + File.separator + "testdata" + File.separator
				+ "JpetStoreCSV.csv";
		// System.out.println("csv " + filePath);
		CSVDataReader csvData = new CSVDataReader(filePath);
		return csvData.readCSVData();
	}
}
