package com.framework.datadriven.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.datadriven.pages.BirdsPage;
import com.framework.datadriven.pages.ShoppingCartPage;

public class BirdsTest extends BaseTest {

	@Test(groups = { "smoke" }, description = "click and add amazon parrot to shopping cart", enabled = true)
	public void clickAmazonParrtoLink() {
		BirdsPage birdsTest = new BirdsPage(driver);
		birdsTest.clickAmazonParrot();
		birdsTest.addAmazonParrotToCart();

		ShoppingCartPage sc = new ShoppingCartPage(driver);
		String header = sc.VerifyHeader();
		Assert.assertEquals(header, "Shopping Cart");
	}

	@Test(description = "click finch link", enabled = true, groups = { "sanity" })
	public void clickFinchLink() {
		BirdsPage birdsTest = new BirdsPage(driver);
		birdsTest.clickFinch();
	}

}
