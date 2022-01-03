package com.framework.datadriven.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	String title = "//*[@id='Cart']/h2";

	public String VerifyHeader() {
		return getText(By.xpath(title));
	}

	public void checkoutCart() {

	}
}
