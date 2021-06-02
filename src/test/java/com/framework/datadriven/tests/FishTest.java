package com.framework.datadriven.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.datadriven.pages.FishPage;
import com.framework.datadriven.pages.ShoppingCartPage;

public class FishTest extends BaseTest {

	@Test(groups= {"smoke"},description = "add large angle fish test")
	public void addLargeAngelFishTest() {
		FishPage fishPage = new FishPage(driver);
		fishPage.addLargeAngelFish();
		ShoppingCartPage sc = new ShoppingCartPage(driver);
		String title = sc.verifyTitle();
		Assert.assertEquals(title, "Shopping Cart");
	}

}
