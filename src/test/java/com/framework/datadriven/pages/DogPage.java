package com.framework.datadriven.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DogPage extends BasePage {

	public DogPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='SidebarContent']/a[2]")
	private WebElement dogPage;

	@FindBy(xpath = "//a[text()='K9-BD-01']")
	private WebElement bullDogLnk;

	@FindBy(xpath = "//a[text()='K9-PO-02']")
	private WebElement poodleLnk;

	@FindBy(xpath = "//a[text()='K9-DL-01']")
	private WebElement dalmationLnk;

	final String bullDogAddToCartBtnXpath = "//td[text()[normalize-space()='Male Adult Bulldog']]/parent::*//td/a[text()='Add to Cart']";
	@FindBy(xpath = bullDogAddToCartBtnXpath)
	private WebElement bullDogAddToCartBtn;

	public void gotoBullDog() {
		waitAndClickElement(dogPage);
		waitAndClickElement(bullDogLnk);
	}

	public void gotoPoodleDog() {
		waitAndClickElement(poodleLnk);
	}

	public void gotoDalmationDog() {
		waitAndClickElement(dalmationLnk);
	}

	public void addBullDog() {
		gotoBullDog();
		waitAndClickElement(bullDogAddToCartBtn);
	}

}
