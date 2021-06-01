package com.framework.datadriven.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	WebDriver driver = null;
	FileReader config;
	Properties configFile = null;

	public WebDriver createDriver() {

		System.out.println("user.dir" + System.getProperty("user.dir"));
		try {
			configFile = new Properties();
			config = new FileReader(System.getProperty("user.dir") + "\\src\\test\\java\\com\\framework\\datadriven\\utils\\config.properties");
			configFile.load(config);
			System.out.println("browser: " + configFile.getProperty("browser"));
			if (configFile.getProperty("browser").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				System.out.println("launching chrome browser");
				driver = new ChromeDriver();
			} else if (configFile.getProperty("browser").equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				System.out.println("launching firefox browser");
				driver = new FirefoxDriver();
			} else if (configFile.getProperty("browser").equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				System.out.println("launching edge browser");
				driver = new EdgeDriver();
			} else {
				System.out.println("unknow browser");
				System.exit(0);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return driver;
	}

	public String launchURL() {
		return configFile.getProperty("appUrl");
	}
}
