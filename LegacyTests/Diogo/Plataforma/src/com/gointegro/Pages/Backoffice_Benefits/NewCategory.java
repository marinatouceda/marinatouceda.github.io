package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.WaitTool;

public class NewCategory extends PageBase {

	@FindBy(id = "active")
	WebElement active;
	
	@FindBy(id = "pt_BR")
	WebElement portuguese;
	
	@FindBy(id = "es_ES")
	WebElement spanish;
	
	@FindBy(id = "en_US")
	WebElement english;
	
	@FindBy(xpath = "//div[@id='translations']/div[1]/div/div/div/div")
	WebElement spanishErrorMsg;
	
	@FindBy(xpath = "//div[@id='translations']/div[2]/div/div/div/div")
	WebElement portugueseErrorMsg;
	
	@FindBy(xpath = "//div[@id='translations']/div[3]/div/div/div/div")
	WebElement englishErrorMsg;
	
	@FindBy(xpath = "//li[@class='tagit-new']/input")
	WebElement tags;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[1]")
	WebElement save;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[2]")
	WebElement saveAndNew;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[3]")
	WebElement cancel;
	
	@FindBy(id = "restrictedPlatforms-input")
	WebElement searchAccountsRestricted;
	
	@FindBy(xpath = "//div[@id='restrictedPlatforms']/div/div[2]/div/a")
	WebElement addRestrictedPlatforms;
	
	@FindBy(xpath = "//div[@id='restrictedPlatforms']/div/div[2]/div/a[2]")
	WebElement removeRestrictedPlatforms;
	
	@FindBy(xpath = "//a[@id='ui-id-3']")
	WebElement dropdownPlatform;
	
	String categoryURL = ConfigElementsBO.getUrlBackoffice() + "/benefits/category/create";
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public NewCategory(WebDriver driver) {
		super(driver);
		URL = categoryURL;
	}

	/**
	 * Devuelve la url de Crear categoría
	 * 
	 * @return String
	 */
	public String getNewCategoryURL() {
		return categoryURL;
	}
	
	/**
	 * Seleccionar el checkbox Activo
	 */
	public void selectActive() {
		active.click();
	}
	
	/**
	 * Completar el campo Español
	 * 
	 * @param name
	 */
	public void completeSpanish(String name) {
		spanish.clear();
		spanish.sendKeys(name);
	}
	
	/**
	 * Completar el campo Portugués
	 * 
	 * @param name
	 */
	public void completePortuguese(String name) {
		portuguese.clear();
		portuguese.sendKeys(name);
	}
	
	/**
	 * Completar el campo Inglés
	 * 
	 * @param name
	 */
	public void completeEnglish(String name) {
		english.clear();
		english.sendKeys(name);
	}
	
	/**
	 * Completar los 3 idiomas
	 * @param name
	 */
	public void createCategory(String nameES, String namePT, String nameEN) {
		completeSpanish(nameES);
		completePortuguese(namePT);
		completeEnglish(nameEN);
	}

	/**
	 * Devuelve el mensaje de error del campo Español
	 */
	public String getSpanishError() {
		return spanishErrorMsg.getText();
	}
	
	/**
	 * Devuelve el mensaje de error del campo Portugués
	 */
	public String getPortugueseError() {
		return portugueseErrorMsg.getText();
	}
	
	/**
	 * Devuelve el mensaje de error del campo Inglés
	 */
	public String getEnglishError() {
		return englishErrorMsg.getText();
	}
	
	/**
	 * Seleccionar el botón Guardar
	 * 
	 * @return DetailCategory
	 */
	public DetailCategory selectSave() {
		save.click();
		return PageFactory.initElements(driver, DetailCategory.class);
	}
	
	/**
	 * Seleccionar el botón Guardar y nuevo
	 */
	public void selectSaveAndNew() {
		saveAndNew.click();
	}
	
	/**
	 * Seleccionar el botón Cancelar
	 */
	public void selectCancel() {
		cancel.click();
	}
	
	/**
	 * Completar el campo Tags
	 * 
	 * @param name
	 */
	public void completeTags(String name) {
		tags.sendKeys(name);
		tags.sendKeys(Keys.RETURN);
	}
	
	/**
	 * Remover Tags
	 * 
	 * @param times
	 */
	public void removeTags(int times) {
		for (int i = 0; i < times; i++) {
			tags.sendKeys(Keys.BACK_SPACE);
			Sleeper.sleepTightInSeconds(1);
		}
	}
	
	/**
	 * Buscar una cuenta
	 * 
	 * @param name
	 */
	public void searchRestrictedPlataform(String name) {
		searchAccountsRestricted.sendKeys(name);
		WaitTool.waitForJQueryProcessing(driver, 5);
		dropdownPlatform.click();
	}
	
	/**
	 * Seleccionar Agregar Plataforma restringida
	 */
	public void addRestricted() {
		addRestrictedPlatforms.click();
	}
	
	/**
	 * Seleccionar Remover Plataforma restringida
	 */
	public void removeRestricted() {
		removeRestrictedPlatforms.click();
	}
}
