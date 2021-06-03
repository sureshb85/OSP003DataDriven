package com.framework.datadriven.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.datadriven.pages.DogPage;
import com.framework.datadriven.pages.ShoppingCartPage;

public class DogTest extends BaseTest {
	@Test(groups= {"smoke"},description = "add bull dog test")
	public void addBullDogTest() {
		DogPage dogPage = new DogPage(driver);
		dogPage.addBullDog();
		ShoppingCartPage sc = new ShoppingCartPage(driver);
		String title = sc.verifyTitle();
		Assert.assertEquals(title, "Shopping Cart");
	}
	
	@Test(groups= {"smoke", "regression"},description = "add bull dog test2")
	public void addBullDogTest2() {
		DogPage dogPage = new DogPage(driver);
		dogPage.addBullDog();
		ShoppingCartPage sc = new ShoppingCartPage(driver);
		String title = sc.verifyTitle();
		Assert.assertEquals(title, "Shopping Cart");
	}
}
