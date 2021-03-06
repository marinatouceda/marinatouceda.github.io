package com.gointegro.Pages.News;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Pages.Celebration.DeleteOverlay;
import com.gointegro.Util.WaitTool;

public class DetailNews extends PageBase {
	
	@FindBy(xpath = "//header[@class='titleEditable']/h3")
	WebElement title;
	
	@FindBy(xpath = "//header[@class='titleEditable']/div/div/a")
	WebElement newsOptionsBtn;
	
	@FindBy(className = "editArticle")
	WebElement editbtn;
	
	@FindBy(className = "delete-article")
	WebElement deletebtn;
	
	@FindBy(className = "news-content-detail")
	WebElement description;
	
	@FindBy(xpath = "//div[@class='news-content-detail']/p/img")
	WebElement descriptionImage;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public DetailNews(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Devuelve el titulo de la novedad
	 * 
	 * @return String
	 */
	public String getTitle() {
		return title.getText();
	}
	
	/**
	 * Devuelve la descripcion de la novedad
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description.getText();
	}
	
	/**
	 * Seleccionar el botón opciones
	 */
	private void selectNewsOptionsButton() {
		newsOptionsBtn.click();
	}
	
	/**
	 * Seleccionar el botón editar novedad
	 */
	private void selectEditNews() {
		WaitTool.waitForElement(driver, By.className("editArticle"), 5);
		editbtn.click();	
	}
	
	/**
	 * Seleccionar el botón eliminar novedad
	 */
	private void selectDeleteNews() {
		deletebtn.click();
	}
	
	/**
	 * Seleccionar news option y editar novedad
	 * 
	 * @return CreateNews
	 */
	public CreateNews editNews() {
		selectNewsOptionsButton();
		selectEditNews();
		
		return PageFactory.initElements(driver, CreateNews.class);
	}
	
	/**
	 * Seleccionar news option y editar novedad
	 * 
	 * @return DeleteOverlay
	 */
	public DeleteOverlay deleteNews() {
		selectNewsOptionsButton();
		selectDeleteNews();
		
		return PageFactory.initElements(driver, DeleteOverlay.class);
	}
	
	/**
	 * Devuelve si la descripión tiene una imagen
	 * 
	 * @return Boolean
	 */
	public Boolean hasImage() {
		return descriptionImage.isDisplayed();
	}

}
