package com.gointegro.Tests.Registration.NoReg.UniqueField.UsernameId;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Suite.class)
@SuiteClasses({
	testVerifDocEmailLogDoc.class,
	testVerifDocEmailLogEmail.class,
	testVerifDocEmailLogUsernameId.class,
	testVerifDocLogDoc.class,
	testVerifDocLogEmail.class,
	testVerifDocLogUsernameId.class,
	testVerifDocUsernameIdLogDoc.class,
	testVerifDocUsernameIdLogEmail.class,
	testVerifDocUsernameIdLogUsernameId.class,
	testVerifEmailLogDoc.class,
	testVerifEmailLogEmail.class,
	testVerifEmailLogUsernameId.class,
	testVerifEmailUsernameIdLogDoc.class,
	testVerifEmailUsernameIdLogEmail.class,
	testVerifEmailUsernameIdLogUsernameId.class,
	testVerifUsernameIdLogDoc.class,
	testVerifUsernameIdLogEmail.class,
	testVerifUsernameIdLogUsernameId.class,
	testSinVerifLogDoc.class,
	testSinVerifLogEmail.class,
	testSinVerifLogUsernameId.class
})
public class AllTestsNoRegUniqUsernameId {
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
		FirefoxBinary firefox = new FirefoxBinary();
		firefox.setEnvironmentProperty("DISPLAY", ":0");
		setDriver(new FirefoxDriver(firefox,null));
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setDriver(WebDriver driver) {
		AllTestsNoRegUniqUsernameId.driver = driver;
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}