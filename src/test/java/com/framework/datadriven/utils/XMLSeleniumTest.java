package com.framework.datadriven.utils;

import java.io.File;
import java.time.Duration;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

public class XMLSeleniumTest {

	private WebDriver driver = null;
	private static final String COMPANYXMLFILE = System.getProperty("user.dir") + "\\testdata\\shipment.xml";
	private static final String USERXMLFILE = System.getProperty("user.dir") + "\\testdata\\user.xml";
	Document document = null;
	XPath xpath = null;

	@BeforeMethod
	public void setup() {
		BrowserFactory browserFactory = new BrowserFactory();
		driver = browserFactory.createDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(enabled = true)
	public void testCompanyOffersDiscount() throws Exception {
		readXmlData(COMPANYXMLFILE);
		driver.get("https://webapps.tekstac.com/CompanyOffersDiscount");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("weight")).sendKeys(readXmlWeigthValue());
		driver.findElement(By.id("distance")).sendKeys(readXmlDistanceValue());
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);
	}

	@Test(enabled = false)
	public void testShopify() throws Exception {
		readXmlData(USERXMLFILE);
		driver.get("http://webapps.tekstac.com/Shopify");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(readXmlfirstname(2));
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(readXmllastname(2));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(readXmlusername(2));
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(readXmlpassword(2));
		driver.findElement(By.xpath("//button[@id='reg']")).click();
		Thread.sleep(5000);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	void readXmlData(String xmlFile) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		document = builder.parse(new File(xmlFile));
		XPathFactory xPathfactory = XPathFactory.newInstance();
		xpath = xPathfactory.newXPath();
	}

	String readXmlWeigthValue() throws Exception {
		XPathExpression expr = xpath.compile("/shipmentDetails/shipmentDetail/Weight");
		String weight = expr.evaluate(document, XPathConstants.STRING).toString();
		return weight;
	}

	String readXmlDistanceValue() throws Exception {
		XPathExpression expr = xpath.compile("/shipmentDetails/shipmentDetail/Distance");
		String distance = expr.evaluate(document, XPathConstants.STRING).toString();
		return distance;
	}

	String readXmlfirstname(int id) throws Exception {
		XPathExpression expr = xpath.compile("/UserDetails/User[@id=" + id + "]/Firstname");
		String weight = expr.evaluate(document, XPathConstants.STRING).toString();
		return weight;
	}

	String readXmllastname(int id) throws Exception {
		XPathExpression expr = xpath.compile("/UserDetails/User[@id=" + id + "]/Lastname");
		String distance = expr.evaluate(document, XPathConstants.STRING).toString();
		return distance;
	}

	String readXmlusername(int id) throws Exception {
		XPathExpression expr = xpath.compile("/UserDetails/User[@id=" + id + "]/Username");
		String distance = expr.evaluate(document, XPathConstants.STRING).toString();
		return distance;
	}

	String readXmlpassword(int id) throws Exception {
		XPathExpression expr = xpath.compile("/UserDetails/User[@id=" + id + "]/Password");
		String distance = expr.evaluate(document, XPathConstants.STRING).toString();
		return distance;
	}
}
