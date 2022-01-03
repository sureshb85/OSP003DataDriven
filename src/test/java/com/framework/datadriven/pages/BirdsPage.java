package com.framework.datadriven.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BirdsPage extends BasePage {

	public BirdsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		waitAndClickElement(birdsLink);
	}

	@FindBy(xpath = "//a[text()='AV-CB-01']")
	private WebElement amzonParrot;

	@FindBy(xpath = "//a[text()='AV-SB-02']")
	private WebElement finch;

	@FindBy(xpath = "//*[@id='SidebarContent']/a[5]")
	private WebElement birdsLink;

	@FindBy(xpath = "//td[text()[normalize-space()='Adult Male Amazon Parrot']]/parent::*//td/a[text()='Add to Cart']")
	private WebElement amzonParrotAddToCart;

	public void clickAmazonParrot() {
		waitAndClickElement(amzonParrot);
	}

	public void clickFinch() {
		waitAndClickElement(finch);
	}

	public void addAmazonParrotToCart() {
		waitAndClickElement(amzonParrotAddToCart);
	}
}
