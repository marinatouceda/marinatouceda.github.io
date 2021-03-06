package com.gointegro.Tests.Galery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.gointegro.Tests.Base.TestBase;

public class AllTestsGalery extends TestBase {
	
private static WebDriver driver;
	
	@BeforeClass
	public static void setUpClass() {
		FirefoxBinary firefox = new FirefoxBinary();
		firefox.setEnvironmentProperty("DISPLAY", ":0");
		setDriver(new FirefoxDriver(firefox,null));
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriver(WebDriver driver) {
		AllTestsGalery.driver = driver;
	}
	
	@AfterClass
	public static void tearDownClass() {
		driver.quit();
	}

}
