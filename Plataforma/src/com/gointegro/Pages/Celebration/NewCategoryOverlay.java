package com.gointegro.Pages.Celebration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Pages.Base.PageBase;

public class NewCategoryOverlay extends PageBase{
	
	@FindBy (id = "category-name")
	private WebElement categoryname;
	
	@FindBy (id = "category-automations-0")
	private WebElement categoryautomation;
	
	@FindBy (name = "new-category")
	private WebElement savebtn;
	
	@FindBy (xpath = "//div[@class='modal-footer']/button")
	private WebElement cancelbtn;
	
	@FindBy (className = "close")
	private WebElement closebtn;
	
	@FindBy (xpath = "//div[@class='modal-body']/div/div/div/div")
	private WebElement categorynameerror;
	
	@FindBy (xpath = "//div[@class='modal-body']/div")
	private WebElement saveerror;
	

	public NewCategoryOverlay(WebDriver driver) {
		super(driver);
		
	}
	

}