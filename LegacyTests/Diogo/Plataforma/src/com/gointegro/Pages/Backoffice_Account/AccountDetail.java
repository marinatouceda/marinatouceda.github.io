package com.gointegro.Pages.Backoffice_Account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Base.PageBase;

public class AccountDetail extends PageBase{
	
	@FindBy(className = "icon-edit")
	private WebElement linkEditar;
	
	@FindBy(xpath = "//div[@id='account']/span/div[2]/span")
	private WebElement name;
	
	@FindBy(xpath = "//div[@id='principal-logo']/span/div[2]/a")
	private WebElement website;
	
	@FindBy(xpath = "//div[@id='account']/span/div[6]/span")
	private WebElement salesforceId;
	
	@FindBy(xpath = "//div[@id='account']/span/div[8]/span")
	private WebElement regional;

	@FindBy(xpath = "//div[@id='account']/span/div[10]/span")
	private WebElement registration;
	
	@FindBy(xpath = "//div[@id='login-type']/div[2]/span")
	private WebElement logintype;
	
	@FindBy(xpath = "//div[@id='user-field']/div[2]/span")
	private WebElement userfield;
	
	@FindBy(xpath = "//div[@id='recover-password']/div[2]/span")
	private WebElement recoverpassword;
	
	@FindBy(xpath = "//div[@id='verif-field-1']/div[2]/span")
	private WebElement veriffield1;
	
	@FindBy(xpath = "//div[@id='verif-field-2']/div[2]/span")
	private WebElement veriffield2;
	
	@FindBy(xpath = "//div[@id='content']/div[11]/span/div[2]/span")
	private WebElement uniqueField;
	
	@FindBy(id = "showUserEmail")
	private WebElement showUserEmail;
	
	@FindBy(xpath = "//div[@id='content']/div[16]/span/div[2]/span")
	private WebElement backgroundcolor;
	
	@FindBy(xpath = "//div[@id='content']/div[17]/span/div[2]/span")
	private WebElement backgroundcolorheader;
	
	@FindBy(xpath = "//div[@id='content']/div[18]/span/div[2]/span")
	private WebElement textcolorheader;
	
	@FindBy(xpath = "//div[@id='content']/div[19]/span/div[2]/span")
	private WebElement textcolorbtn;
	
	@FindBy(xpath = "//div[@id='content']/div[20]/span/div[2]/span")
	private WebElement backgroundcolorbtn;
	
	@FindBy(xpath = "//div[@id='content']/div[21]/span/div[2]/span")
	private WebElement colorlineheader;
	
	@FindBy(xpath = "//div[@id='content']/div[22]/span/div[2]/span")
	private WebElement iconcolor;
	
	@FindBy(xpath = "//div[@id='content']/div[23]/span/div[2]/span")
	private WebElement defaultlang;
	
	@FindBy(xpath = "//div[@id='content']/div[24]/span/div[2]")
	private WebElement htmllogin;
	
	@FindBy(xpath = "//legend[contains(text(),'Cuenta principal')]/following-sibling::div")
	private WebElement accountprincipal;
	
	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public AccountDetail(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Obtener el nombre de la plataforma
	 * 
	 * @return String
	 */
	public String getName() {
		return name.getText();
	}
	
	/**
	 * Obtener el website
	 * 
	 * @return String
	 */
	public String getWebSite() {
		return website.getText();
	}
	
	/**
	 * Obtener el salesforce Id
	 * 
	 * @return String
	 */
	public String getSalesForceId() {
		return salesforceId.getText();
	}
	
	/**
	 * Obtener si es regional
	 * 
	 * @return String
	 */
	public String getRegional() {
		return regional.getText();
	}
	
	/**
	 * Obtener el label registracion
	 * 
	 * @return String
	 */
	public String getRegistration() {
		return registration.getText();
	}
	
	/**
	 * Obtener el html de login
	 * 
	 * @return String
	 */
	public String getHtmlLogin() {
		return htmllogin.getText();
	}
	
	/**
	 * Obtener el tipo de login
	 * 
	 * @return String
	 */
	public String getLoginType() {
		return logintype.getText();
	}
	
	/**
	 * Obtener el user field
	 * 
	 * @return String
	 */
	public String getUserField() {
		return userfield.getText();
	}
	
	/**
	 * Obtener el recover password
	 * 
	 * @return String
	 */
	public String getRecoverPassword() {
		return recoverpassword.getText();
	}
	
	/**
	 * Obtener el verif field 1
	 * 
	 * @return String
	 */
	public String getVerifField1() {
		return veriffield1.getText();
	}
	
	/**
	 * Obtener el verif field 2
	 * 
	 * @return String
	 */
	public String getVerifField2() {
		return veriffield2.getText();
	}
	
	/**
	 * Obtener el unique field
	 * 
	 * @return String
	 */
	public String getUniqueField() {
		return uniqueField.getText();
	}
	
	/**
	 * Obtener si muestra el mail de usuario
	 * 
	 * @return String
	 */
	public String getShowUserMail() {
		return showUserEmail.getText();
	}
	
	/**
	 * Obtener el backgroundcolor
	 * 
	 * @return String
	 */
	public String getBackgroundColor() {
		return backgroundcolor.getText();
	}
	
	/**
	 * Obtener el backgroundcolorheader
	 * 
	 * @return String
	 */
	public String getBackgroundColorHeader() {
		return backgroundcolorheader.getText();
	}
	
	/**
	 * Obtener el textcolorheader
	 * 
	 * @return String
	 */
	public String getTextColorHeader() {
		return textcolorheader.getText();
	}
	
	/**
	 * Obtener el textcolorbtn
	 * 
	 * @return String
	 */
	public String getTextColorBtn() {
		return textcolorbtn.getText();
	}
	
	/**
	 * Obtener el backgroundcolorbtn
	 * 
	 * @return String
	 */
	public String getBackgroundColorBtn() {
		return backgroundcolorbtn.getText();
	}
	
	/**
	 * Obtener el colorlineheader
	 * 
	 * @return String
	 */
	public String getColorLineHeader() {
		return colorlineheader.getText();
	}
	
	/**
	 * Obtener el icon color
	 * 
	 * @return String
	 */
	public String getIconColor() {
		return iconcolor.getText();
	}
	
	/**
	 * Obtener el default lang
	 * 
	 * @return String
	 */
	public String getDefaultLang() {
		return defaultlang.getText();
	}
	/**
	 * Seleccionar Editar
	 * 
	 * @return {@link EditAccountStandard}
	 */
	public EditAccountStandard selectEdit() {
		linkEditar.click();
		
		return PageFactory.initElements(driver, EditAccountStandard.class);
	}
	
	/**
	 * Obtener la cuenta padre
	 * 
	 * @return String
	 */
	public String getAccountFather() {
		return accountprincipal.getText();
	}
	
	public boolean isFatherAccountPresent() {
		return isElementPresent(By.xpath("//legend[contains(text(),'Cuenta principal')]/following-sibling::div"));
	}

}
