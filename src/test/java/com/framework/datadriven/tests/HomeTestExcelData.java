package com.framework.datadriven.tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.framework.datadriven.pages.HomePage;
import com.framework.datadriven.utils.XLSReader;

public class HomeTestExcelData extends BaseTest {

	@Test(groups = {"smoke"}, enabled = true, dataProvider = "xlsSignUpData", description = "Sign up test case validation with data provider")
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

	@DataProvider(name = "xlsSignUpData")
	public String[][] getXlsData() throws IOException {
		String path = System.getProperty("user.dir") + "\\testdata\\JpetStore.xls";
		XLSReader xlsReader = new XLSReader(path);
		String sheetName = "registerNowData";
		int totalRows = xlsReader.getRowCount(sheetName);
		int totalCols = xlsReader.getCellCount(sheetName, 0);
		String testData[][] = new String[totalRows][totalCols];
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				testData[i - 1][j] = xlsReader.getCellData(sheetName, i, j);
			}
		}
		return testData;
	}
}
