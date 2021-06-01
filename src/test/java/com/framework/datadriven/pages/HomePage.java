package com.framework.datadriven.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	String signInLnk = "//a[text()='Sign In']";
	String registerNowLnk = "//a[text()='Register Now!']";
	// sign in
	String usernameTxt = "username";
	String passwordTxt = "password";
	String loginBtn = "signon";

	// signup
	String firstName = "account.firstName";
	String lastName = "account.lastName";
	String email = "account.email";
	String phone = "account.phone";
	String address1 = "account.address1";
	String city = "account.city";
	String address2 = "account.address2";
	String state = "account.state";
	String zip = "account.zip";
	String country = "account.country";
	String saveAccInfoBtn = "newAccount";

	public void clickSignIn() {
		waitAndClickElement(By.xpath(signInLnk));
	}

	public void clickSignUp() {
		waitAndClickElement(By.xpath(signInLnk));
		waitAndClickElement(By.xpath(registerNowLnk));
	}

	public void login() {
		clickSignIn();
		// enter username
		sendKeysToWebElement(By.name(usernameTxt), "sureshb85@yahoo.com");
		// enter password
		sendKeysToWebElement(By.name(passwordTxt), "Suresh85");
		// click login button
		waitAndClickElement(By.name(loginBtn));
	}

	public void signUp() {
		clickSignUp();

		sendKeysToWebElement(By.name(firstName), "Suresh");
		sendKeysToWebElement(By.name(lastName), "Bollina");
		sendKeysToWebElement(By.name(email), "sureshb85@yahoo.com");
		sendKeysToWebElement(By.name(phone), "9845012530");
		sendKeysToWebElement(By.name(address1), "KRLayout");
		sendKeysToWebElement(By.name(address2), "KR Puram");
		sendKeysToWebElement(By.name(city), "Bangalore");
		sendKeysToWebElement(By.name(state), "Karnataka");
		sendKeysToWebElement(By.name(zip), "560103");
		sendKeysToWebElement(By.name(country), "India");
		// waitAndClickElement(By.name(saveAccInfoBtn));
	}

	public void signUpDataProvider(String firstNameData, String lastNameData, String emailData, String phoneData,
			String address1Data, String address2Data, String cityData, String stateData, String zipData,
			String countryData) {
		clickSignUp();
		sendKeysToWebElement(By.name(firstName), firstNameData);
		sendKeysToWebElement(By.name(lastName), lastNameData);
		sendKeysToWebElement(By.name(email), emailData);
		sendKeysToWebElement(By.name(phone), phoneData);
		sendKeysToWebElement(By.name(address1), address1Data);
		sendKeysToWebElement(By.name(address2), address2Data);
		sendKeysToWebElement(By.name(city), cityData);
		sendKeysToWebElement(By.name(state), stateData);
		sendKeysToWebElement(By.name(zip), zipData);
		sendKeysToWebElement(By.name(country), countryData);
		// waitAndClickElement(By.name(saveAccInfoBtn));
	}
}
