package com.gointegro.Tests.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Backoffice.LoginBackoffice;
import com.gointegro.Pages.Platform.Login;

public class TestBase {
	
	/**
	 * Login con usuario normal
	 * 
	 * @param driver
	 */
	public void login(WebDriver driver) {
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
	}
	
	/**
	 * Login con usuario basico (sin permisos para crear contenido)
	 * 
	 * @param driver
	 */
	public void loginBasicUser(WebDriver driver) {
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
	}
	
	/**
	 * Login para BO
	 * 
	 * @param driver
	 */
	public void loginBackoffice(WebDriver driver) {
		LoginBackoffice login = PageFactory.initElements(driver, LoginBackoffice.class);
		login.open();
		login.loginBackoffice(ConfigElementsBO.getUser(), ConfigElementsBO.getPassw());
	}
}
