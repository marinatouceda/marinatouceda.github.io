package com.gointegro.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AttachmenteUploads {
	
	public static void SocialWallAttachment(WebDriver driver) {
		
		String nombreClass = "fileinput-button";
    	String jsstr = "arguments[0].setAttribute('id','algoloco')";
    	WebElement elem = driver.findElement(By.className(nombreClass));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript(jsstr, elem);
    	js.executeScript("document.getElementById('algoloco').setAttribute('class','className');");
		
		/*js = (JavascriptExecutor) driver;
    	
		js.executeScript("document.getElementById('attachment-upload').setAttribute('style','visible: visible; opacity: 1; position: static; transform: none;');");*/
		
	}
	
	public static void waitBar (WebDriver driver) {
		/*WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.className("bar")).getAttribute("style"), "width: 100%;"));
				//textToBePresentInElementValue(driver.findElement(By.className("bar")).getAttribute("style"), "width: 100%;")));
				//visibilityOf(driver.findElement(By.className("bar")))));*/
		
		for (int second = 0;; second++) {
			if (second >= 30)
			try { if (driver.findElement(By.className("bar")).getAttribute("style").equals("width: 100%;")) break; } catch (Exception e) {}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			
			}
		}
	}
	

}
