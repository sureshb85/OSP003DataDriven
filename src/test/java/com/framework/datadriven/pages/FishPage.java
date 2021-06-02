package com.framework.datadriven.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FishPage extends BasePage {

	public FishPage(WebDriver driver) {
		super(driver);
	}

	String fishPage = "//*[@id=\"SidebarContent\"]/a[1]";
	String angelFishLnk = "//a[text()='FI-SW-01']";
	String tigerSharkFishLnk = "//a[text()='FI-SW-02']";
	String koiFishLnk = "//a[text()='FI-FW-01']";
	String goldFishLnk = "//a[text()='FI-FW-02']";

	String largeAngelFishAddToCartBtn = "//td[text()[normalize-space()='Large Angelfish']]/parent::*//td/a[text()='Add to Cart']";

	public void gotoAngleFish() {
		waitAndClickElement(By.xpath(fishPage));
		waitAndClickElement(By.xpath(angelFishLnk));
	}

	public void gotoTigerSharkFish() {
		waitAndClickElement(By.xpath(tigerSharkFishLnk));
	}

	public void gotoKoiFish() {
		waitAndClickElement(By.xpath(koiFishLnk));
	}

	public void gotoGoldFish() {
		waitAndClickElement(By.xpath(goldFishLnk));
	}

	public void addLargeAngelFish() {
		gotoAngleFish();
		waitAndClickElement(By.xpath(largeAngelFishAddToCartBtn));
	}

}
