package com.gointegro.Pages.Backoffice_Benefits;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.gointegro.Pages.Base.PageBase;
import com.gointegro.Util.AttachmentUploads;
import com.gointegro.Util.WaitTool;

public class NewBenefits extends PageBase {
	
	@FindBy(id = "active")
	WebElement active;
	
	@FindBy(id = "owner")
	WebElement owner;
	
	@FindBy(id = "name")
	WebElement name;
	
	@FindBy(id = "targetUserType")
	WebElement targetUserType;
	
	@FindBy(id = "discount")
	WebElement discount;
	
	@FindBy(xpath = "//input[contains(@class, 'field-value')]")
	WebElement value;
	
	@FindBy(id = "highlight")
	WebElement highlight;
	
	@FindBy(id = "expires")
	WebElement expires;

	@FindBy(id = "benefitCode")
	WebElement benefitCode;
	
	@FindBy(id = "title")
	WebElement title;
	
	@FindBy(id = "description_ifr")
	WebElement description;
	
	@FindBy(id = "exclusive")
	WebElement exclusive;
	
	@FindBy(xpath = "//li[@class='tagit-new']/input")
	WebElement tags;
	
	@FindBy(id = "restrictedPlatforms-input")
	WebElement restrictedPlatforms_input;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[1]")
	WebElement save;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[2]")
	WebElement saveAndNew;
	
	@FindBy(xpath = "//section[@class='bottom-section-button-bar']/button[3]")
	WebElement cancel;
	
	@FindBy (xpath = "//div[@data-fields='image']/div/div/span/div/div/span[2]/a/input")
	WebElement imgUpload;
	
	@FindBy (xpath = "//div[contains(@class, 'form-owner')]/div/div/div")
	WebElement ownerErrorMsg;
	
	@FindBy (xpath = "//div[contains(@class, 'form-name')]/div/div/div")
	WebElement nameErrorMsg;
	
	@FindBy (xpath = "//div[contains(@class, 'form-discount')]/div/div/div")
	WebElement discountErrorMsg;
	
	@FindBy (xpath = "//div[contains(@class, 'form-validFrom')]/div/div/div")
	WebElement validFromErrorMsg;
	
	@FindBy (xpath = "//div[contains(@class, 'form-validUntil')]/div/div/div")
	WebElement validUntilErrorMsg;
	
	@FindBy (xpath = "//div[contains(@class, 'form-image')]/div/div/div")
	WebElement imageErrorMsg;
	
	@FindBy (xpath = "//div[@data-fields='title']/div/div[2]/div/div")
	WebElement titleErrorMsg;
	
	@FindBy (xpath = "//div[@data-fields='description']/div/div[2]/div/div")
	WebElement descriptionErrorMsg;
	
	@FindBy(xpath = "//div[@id='ms-categories']/div/ul/li")
	List<WebElement> categoryList;
	
	@FindBy(xpath = "//div[@id='ms-categories']/a[1]")
	WebElement addCategory;
	
	@FindBy(xpath = "//div[@id='ms-redeemingMethods']/div/ul/li")
	List<WebElement> redeemingList;
	
	@FindBy(xpath = "//div[@id='ms-validDays']/div/ul/li")
	List<WebElement> validDaysList;
	
	@FindBy(xpath = "//div[@id='ms-paymentMethods']/div/ul/li")
	List<WebElement> paymentMethodsList;
	
	@FindBy(xpath = "//div[@class='container']/div/div")
	WebElement saveError;
	
	@FindBy(xpath = "//div[@id='ms-redeemingMethods']/a")
	WebElement addRedeemings;
	
	@FindBy(xpath = "//div[@id='ms-redeemingMethods']/a[2]")
	WebElement removeRedeemings;
	
	@FindBy(xpath = "//div[@id='ms-validDays']/a")
	WebElement addValidDays;
	
	@FindBy(xpath = "//div[@id='ms-validDays']/a[2]")
	WebElement removeValidDays;
	
	@FindBy(xpath = "//div[@id='ms-paymentMethods']/a")
	WebElement addPaymentMethods;
	
	@FindBy(xpath = "//div[@id='ms-paymentMethods']/a[2]")
	WebElement removePaymentMethods;
	
	@FindBy(id = "exclusivePlatforms-input")
	WebElement searchAccountsExclusive;
	
	@FindBy(xpath = "//div[@id='exclusivePlatforms']/div/div[2]/div/a")
	WebElement addExclusivePlatforms;
	
	@FindBy(xpath = "//div[@id='exclusivePlatforms']/div/div[2]/div/a[2]")
	WebElement removeExclusivePlatforms;
	
	@FindBy(id = "restrictedPlatforms-input")
	WebElement searchAccountsRestricted;
	
	@FindBy(xpath = "//div[@id='restrictedPlatforms']/div/div[2]/div/a")
	WebElement addRestrictedPlatforms;
	
	@FindBy(xpath = "//div[@id='restrictedPlatforms']/div/div[2]/div/a[2]")
	WebElement removeRestrictedPlatforms;
	
	@FindBy(xpath = "//li[@class='ui-menu-item']")
	WebElement dropdownPlatform;
	
	@FindBy(xpath = "//button[@data-toggle='modal']")
	WebElement confirmActive;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public NewBenefits(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Seleccionar Activo
	 */
	public void selectActive() {
		active.click();
	}
	
	/**
	 * Completar Responsable
	 * 
	 * @param name
	 */
	public void createOwner(String name) {
		owner.clear();
		owner.sendKeys(name);
	}
	
	/**
	 * Completar Nombre
	 * 
	 * @param title
	 */
	public void createName(String title) {
		name.clear(); 
		name.sendKeys(title);
	}
	
	/**
	 * Seleccionar Segmento
	 * 
	 * @param name
	 */
	public void selectTargetUserType(String name) {
		Select select = new Select(targetUserType);
		select.selectByVisibleText(name);
	}
	
	/**
	 * Seleccionar Tipo de Oferta
	 * 
	 * @param number
	 */
	public void selectDiscount(String number) {
		Select select = new Select(discount);
		select.selectByVisibleText(number);
	}
	
	/**
	 * Completar Valor
	 * 
	 * @param number
	 */
	public void createValue(String number) {
		value.clear();
		value.sendKeys(number);
	}
	
	/**
	 * Seleccionar Destacado
	 */
	public void selectHighlight() {
		highlight.click();
	}
	
	/**
	 * Seleccionar Vencimiento
	 */
	public void selectExpires() {
		expires.click();
	}
	
	/**
	 * Completar Valido Desde
	 * 
	 * @param date
	 */
	public void selectValidFrom(String date) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName('validFrom')[1].value='"+date+"'");
	}
	
	/**
	 * Completar Valido Hasta
	 * 
	 * @param date
	 */
	public void selectValidUntil(String date) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName('validUntil')[1].value='"+date+"'");
	}
	
	/**
	 * Ingresar una imagen mayor a 188x95 para devolver un ImageCropOverlay
	 * 
	 * @param fileupload
	 * @return ImageCropOverlay
	 */
	public ImageCropOverlay imgUpload(String fileupload) {
		fileUpload(fileupload);
		return PageFactory.initElements(driver, ImageCropOverlay.class);
	}
	
	/**
	 * Ingresar una imagen menor a 188x95 para devolver un error
	 * 
	 * @param fileupload
	 */
	public void uploadSmallImg(String fileupload) {
		fileUpload(fileupload);
	}
	
	/**
	 * Subir un archivo
	 * 
	 * @param fileupload
	 */
	private void fileUpload(String fileupload) {
		AttachmentUploads.attachmentByElement(driver, imgUpload);
		imgUpload.sendKeys(fileupload);
	}
	
	/**
	 * Completar Código de beneficio
	 * 
	 * @param name
	 */
	public void createBenefitCode(String name) {
		benefitCode.clear();
		benefitCode.sendKeys(name);
	}
	
	/**
	 * Completar Titulo
	 * 
	 * @param titleText
	 */
	public void createTitle(String titleText) {
		title.clear();
		title.sendKeys(titleText);
	}
	
	/**
	 * Completar Descripción
	 * 
	 * @param name
	 */
	public void createDescription(String descriptionText) {
		driver.switchTo().frame(description);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.innerHTML = '<p>" + descriptionText + "</p>'");
		
		driver.switchTo().defaultContent();
	}
	
	/**
	 * Completar Titulo
	 * 
	 * @param titleText
	 */
	public void createTags(String name) {
		tags.clear();
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
	 * Crear beneficios
	 * 
	 * @param owner
	 * @param name
	 * @param targetUser
	 * @param discount
	 * @param validFrom
	 * @param validUntil
	 * @param imageFile
	 * @param benefitCode
	 * @param title
	 * @param desc
	 */
	public void createBenefit(String owner, String name, String targetUser, String discount, String validFrom, String validUntil, String fileupload, boolean isHighlighted, String benefitCode, String title, String desc) {
		createOwner(owner);
		createName(name);
		selectTargetUserType(targetUser);
		selectValidFrom(validFrom);
		
		if(!discount.isEmpty()) {
			selectDiscount(discount);
		}
		
		if(!validUntil.isEmpty()) {
			selectExpires();
			selectValidUntil(validUntil);
		}
		
		if(isHighlighted) {
			selectHighlight();
		}
		
		if(!fileupload.isEmpty()) {
			ImageCropOverlay imageCrop = imgUpload(fileupload);
			WaitTool.waitForJQueryProcessing(driver, 5);
			
			imageCrop.selectSave();
			WaitTool.waitForJQueryProcessing(driver, 5);
		}
		
		createBenefitCode(benefitCode);
		createTitle(title);
		createDescription(desc);
	}
	
	/**
	 * Seleccionar el botón Guardar
	 * 
	 * @return DetailBenefits
	 */
	public DetailBenefits selectSave() {
		save.click();
		return PageFactory.initElements(driver, DetailBenefits.class);
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
	 * Obtener el mensaje de error de Responsable
	 * 
	 * @return String
	 */
	public String getOwnerErrorMsg() {
		return ownerErrorMsg.getText();
	}
	
	/**
	 * Obtener el mensaje de error del Nombre
	 * 
	 * @return String
	 */
	public String getNameErrorMsg() {
		return nameErrorMsg.getText();
	}
	
	/**
	 * Obtener el mensaje de error del Tipo de oferta
	 * 
	 * @return String
	 */
	public String getDiscountErrorMsg() {
		return discountErrorMsg.getText();
	}
	
	/**
	 * Obtener el mensaje de error del Valido Desde 
	 * 
	 * @return String
	 */
	public String getValidFromErrorMsg() {
		return validFromErrorMsg.getText();
	}
	
	/**
	 * Obtener el mensaje de error del Valido Hasta 
	 * 
	 * @return String
	 */
	public String getValidUntilErrorMsg() {
		return validUntilErrorMsg.getText();
	}
	
	/**
	 * Obtener el mensaje de error de la imagen 
	 * 
	 * @return String
	 */
	public String getImageErrorMsg() {
		return imageErrorMsg.getText();
	}
	
	/**
	 * Obtener el mensaje de error del Titulo 
	 * 
	 * @return String
	 */
	public String getTitleErrorMsg() {
		return titleErrorMsg.getText();
	}
	
	/**
	 * Obtener el mensaje de error de la Descripcion 
	 * 
	 * @return String
	 */
	public String getDescriptionErrorMsg() {
		return descriptionErrorMsg.getText();
	}
	
	/**
	 * Obtener el mensaje de error de guardar
	 * 
	 * @return String
	 */
	public String getSaveErrorMsg() {
		return saveError.getText();
	}
	
	/**
	 * Seleccionar una categoria por el nombre
	 * 
	 * @param name
	 */
	public void selectCategory(String name) {
		for(WebElement element : categoryList) {
			if(element.getAttribute("innerHTML").contains(name)) {
				element.findElement(By.xpath("./ul/li/span")).click();
				break;
			}
		}
	}
	
	/**
	 * Seleccionar Agregar Categoria
	 */
	public void addCategory() {
		addCategory.click();
	}
	
	/**
	 * Seleccionar Modo de Acceso por el nombre
	 * 
	 * @param name
	 */
	public void selectRedeeming(String name) {
		for(WebElement element : redeemingList) {
			if(element.getAttribute("innerHTML").contains(name)) {
				element.findElement(By.xpath("./span")).click();
				break;
			}
		}
	}
	
	/**
	 * Seleccionar Dias Validos por el nombre
	 * 
	 * @param name
	 */
	public void selectValidDays(String name) {
		for(WebElement element : validDaysList) {
			if(element.getAttribute("innerHTML").contains(name)) {
				element.findElement(By.xpath("./span")).click();
				break;
			}
		}
	}
	
	/**
	 * Seleccionar Medios de Pago por el nombre
	 * 
	 * @param name
	 */
	public void selectPaymentMethods(String name) {
		for(WebElement element : paymentMethodsList) {
			if(element.getAttribute("innerHTML").contains(name)) {
				element.findElement(By.xpath("./span")).click();
				break;
			}
		}
	}
	
	/**
	 * Seleccionar Agregar Modo de Accesso
	 */
	public void addRedeeming() {
		addRedeemings.click();
	}
	
	/**
	 * Seleccionar Remover Modo de Accesso
	 */
	public void removeRedeeming() {
		removeRedeemings.click();
	}
	
	/**
	 * Seleccionar Agregar Dias Validos
	 */
	public void addValidDays() {
		addValidDays.click();
	}
	
	/**
	 * Seleccionar Remover Dias Validos
	 */
	public void removeValidDays() {
		removeValidDays.click();
	}
	
	/**
	 * Seleccionar Agregar Medios de Pago
	 */
	public void addPaymentMethods() {
		addPaymentMethods.click();
	}
	
	/**
	 * Seleccionar Remover Medios de Pago
	 */
	public void removePaymentMethods() {
		removePaymentMethods.click();
	}
	
	/**
	 * Buscar una cuenta
	 * 
	 * @param name
	 */
	public void searchExclusivePlataform(String name) {
		searchAccountsExclusive.sendKeys(name);
		WaitTool.waitForJQueryProcessing(driver, 5);
		dropdownPlatform.click();
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
	
	/**
	 * Seleccionar Agregar Plataforma exclusiva
	 */
	public void addExclusive() {
		addExclusivePlatforms.click();
	}
	
	/**
	 * Seleccionar Remover Plataforma exclusiva
	 */
	public void removeExclusive() {
		removeExclusivePlatforms.click();
	}
	
	/**
	 * Seleccionar Es exclusivo
	 */
	public void selectExclusive() {
		exclusive.click();
	}
	
	/**
	 * Seleccionar el botón Confirmar del modal Activación del Beneficio
	 */
	public void confirmActive() {
		confirmActive.click();
	}
}
