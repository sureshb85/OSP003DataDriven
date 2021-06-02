package com.framework.datadriven.tests;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.framework.datadriven.pages.HomePage;
import com.framework.datadriven.utils.XLSReader;

public class HomeTestExcelDataMapExample extends BaseTest {

	@Test(groups = {"regression"}, enabled = true, dataProvider = "xlsSignUpData", description = "Sign up test case validation with data provider")
	public void signUpDataProviderTest(Map<Object, Object> excelDataMap) throws IOException {
		String firstNameData = (String) excelDataMap.get("firstName");
		String lastNameData = (String) excelDataMap.get("lastName");
		String emailData = (String) excelDataMap.get("email");
		String phoneData = (String) excelDataMap.get("phone");
		String address1Data = (String) excelDataMap.get("address1");
		String address2Data = (String) excelDataMap.get("address2");
		String cityData = (String) excelDataMap.get("city");
		String stateData = (String) excelDataMap.get("state");
		String zipData = (String) excelDataMap.get("zip");
		String countryData = (String) excelDataMap.get("country");
		logger.log(Status.INFO, firstNameData + ": new user sign up");
		// System.out.println("new user sign up");
		HomePage homePage = new HomePage(driver);
		homePage.signUpDataProvider(firstNameData, lastNameData, emailData, phoneData, address1Data, address2Data,
				cityData, stateData, zipData, countryData);
		logger.log(Status.PASS, firstNameData + ": Signup is successfull");
	}

	@DataProvider(name = "xlsSignUpData")
	public Object[][] getXlsData() throws IOException {
		String path = System.getProperty("user.dir") + "\\testdata\\JpetStore.xls";
		XLSReader xlsReader = new XLSReader(path);
		String sheetName = "registerNowData";
		return xlsReader.getSheetData(sheetName);
	}
}
