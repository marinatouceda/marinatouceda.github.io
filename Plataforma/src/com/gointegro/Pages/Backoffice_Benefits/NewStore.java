package com.gointegro.Pages.Backoffice_Benefits;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.gointegro.Util.WaitTool;

public class NewStore extends NewCompany {
	
	@FindBy(id = "type")
	WebElement type;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "contact-list")
	WebElement contact;
	
	@FindBy(name = "txt-search")
	WebElement address;
	
	@FindBy(xpath = "//span[@class='input-group-btn']/button")
	WebElement addressBtn;
	
	@FindBy(xpath = "//div[@id='accordion']/div[2]/div[2]/div/div[2]/div/div/div/span/button")
	WebElement addressBtn2;
	
	@FindBy(xpath = "//div[@data-fields='contact']/div/div/div")
	WebElement contactError;
	
	@FindBy(xpath = "//div[contains(@class, 'geoarea-container')]/div[1]/div")
	WebElement addressError;
	
	@FindBy(xpath = "//button[contains(@class, 'add-new-area')]")
	WebElement addNewArea;
	
	@FindBy(xpath = "//div[contains(@class, 'geoarea-container')]/div[2]/div/div/div/input")
	WebElement addressArea;
	
	@FindBy(xpath = "//div[@id='accordion']/div[2]/div[2]/div/div[2]/div/div/div/input")
	WebElement addressArea2;
	
	@FindBy(xpath = "//div[@id='accordion']/div[1]/div/h4/a")
	WebElement collapseArea1;
	
	@FindBy(xpath = "//div[@id='accordion']/div[2]/div/h4/a")
	WebElement collapseArea2;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public NewStore(WebDriver driver) {
		super(driver);
	}
	
	
	/**
	 * Crear una nueva sucursal
	 */
	public void createNewStore(String type, String name, String phone, String companyName, String taxId, String email, String siteLink, String address, String zipcode, Boolean isDisabled) {
		selectType(type);
		createName(name);
		createPhone(phone);
		createCompanyName(companyName);
		createTaxId(taxId);
		createEmail(email);
		createWebSite(siteLink);
		
		if(isDisabled) {
			selectActive();
		}
		
		if(!address.isEmpty()) {
			createAddress(address);
		}
		
		if(!zipcode.isEmpty()) {
			createZipCode(zipcode);
		}
		
		Sleeper.sleepTightInSeconds(2);
	}

	/**
	 * Completar Correo Electrónico
	 * 
	 * @param mail
	 */
	public void createEmail(String mail) {
		email.clear();
		email.sendKeys(mail);
	}
	/**
	 * Seleccionar Tipo
	 * 
	 * @param name
	 */
	public void selectType(String name) {
		Select select = new Select(type);
		select.selectByVisibleText(name);
	}
	
	/**
	 * Completar Ubicar en el Mapa
	 */
	public void createAddress(String name) {
		address.clear();
		address.sendKeys(name);
		WaitTool.waitForJQueryProcessing(driver, 5);
		addressBtn.click();
		WaitTool.waitForJQueryProcessing(driver, 5);
	}
	
	/**
	 * Completar Ubicar en el Mapa
	 */
	public void createAddressArea(String name) {
		addressArea.clear();
		addressArea.sendKeys(name);
		WaitTool.waitForJQueryProcessing(driver, 5);
		addressBtn.click();
		WaitTool.waitForJQueryProcessing(driver, 5);
	}
	
	/**
	 * Completar Ubicar en el Mapa
	 */
	public void createAddressArea2(String name) {
		addressArea2.clear();
		addressArea2.sendKeys(name);
		WaitTool.waitForJQueryProcessing(driver, 5);
		addressBtn2.click();
		WaitTool.waitForJQueryProcessing(driver, 5);
	}
	
	/**
	 * Seleccionar lista de Contactos
	 * 
	 * @return String
	 */
	public String selectContact() {
		contact.click();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailContactListOverlay detail = PageFactory.initElements(driver, DetailContactListOverlay.class);
		
		String contactName = detail.selectFirstContact();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		return contactName;
	}
	
	public void makeFormVisible() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByClassName('pac-container')[0].style.display = 'none'; document.getElementById('backoffice-overlay').style.display = 'none';");
	}
	
	public void createContact() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName('input-contact')[0].removeAttribute('readonly'); document.getElementsByName('contact')[0].value = '802'");
	}
	
	/**
	 * Seleccionar el botón Guardar
	 * 
	 * @return DetailStore
	 */
	public DetailStore selectSave() {
		save.click();
		return PageFactory.initElements(driver, DetailStore.class);
	}
	
	/**
	 * Devuelve el mensaje de error del Contacto
	 * 
	 * @return String
	 */
	public String getContactError() {
		return contactError.getText();
	}
	
	/**
	 * Devuelve el mensaje de error de Ubicación
	 * 
	 * @return String
	 */
	public String getAddressError() {
		return addressError.getText();
	}
	
	/**
	 * Seleccionar el botón Agregar área geográfica
	 */
	public void selectAddNewArea() {
		addNewArea.click();
	}
	
	/**
	 * Seleccionar el botón Ingresar un área geográfica
	 */
	public void selectCollapseArea1() {
		collapseArea1.click();
	}
	
	/**
	 * Seleccionar el botón Ingresar un área geográfica
	 */
	public void selectCollapseArea2() {
		collapseArea2.click();
	}
}