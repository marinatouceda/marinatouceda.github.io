package com.gointegro.Tests.Benefits;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Backoffice_Benefits.DetailBenefits;
import com.gointegro.Pages.Backoffice_Benefits.DetailCompany;
import com.gointegro.Pages.Backoffice_Benefits.NewBenefits;
import com.gointegro.Pages.Backoffice_Benefits.SelectStoreOverlay;
import com.gointegro.Pages.Benenfits.DetailBenefit;
import com.gointegro.Pages.Platform.Home;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Platform.SearchResult;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testNewBenefit extends AllTestsBenefits {
	
	String owner = DataGenerator.nombreFile();
	String name = DataGenerator.nombreFile();
	String discount = "2x1";
	String validFrom = DataGenerator.fechaactual();
	String validUntil = DataGenerator.fechamanana();
	String fileupload = ConfigElements.getFileImagen();
	String benefitCode = "54aAsd4542";
	String title = DataGenerator.nombreFile();
	String desc = DataGenerator.nombreFile();
	String paymentMethod = "Tarjeta de débito";
	String paymentMethod2 = "Efectivo";
	String redeeming = "Mobile";
	String address = "Avenida Alvarez Thomas 198, Buenos Aires, Ciudad Autónoma de Buenos Aires, Argentina";
	
	private WebDriver driver;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		@Override
		protected void starting(final Description description) {
			logger.info(description.getMethodName());
		}
	};
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	
	@Test
	public void test_new_benefit_check_front() {
		String redeemingName = "Celular";
		String targetUser = "General";
		String title = DataGenerator.nombreFile();
		
		DetailBenefits detail = createBenefit(name, targetUser);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectActive();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.confirmActive();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SearchResult search = home.searchForText(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailBenefit detailBeneficio = search.selectSeeBenefit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(title, detailBeneficio.getName());
		assertEquals(desc, detailBeneficio.getDescription());
		assertTrue(detailBeneficio.isPaymentInList(paymentMethod));
		assertTrue(detailBeneficio.isPaymentInList(paymentMethod2));
		assertTrue(detailBeneficio.isRedeemingInList(redeemingName));
	}
	
	
	@Test
	public void test_new_benefit_user_type_client() {
		String targetUser = "Clientes";
		String title = DataGenerator.nombreFile();
		
		DetailBenefits detail = createBenefit(name, targetUser);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectActive();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.confirmActive();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SearchResult search = home.searchForText(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("0 resultados", search.getResultsFoundMsg());
	}
	
	
	@Test
	public void test_new_benefit_user_type_employee() {
		String targetUser = "Empleados";
		String title = DataGenerator.nombreFile();
		
		DetailBenefits detail = createBenefit(name, targetUser);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectActive();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.confirmActive();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SearchResult search = home.searchForText(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("1 resultados", search.getResultsFoundMsg());
	}
	
	
	@Test
	public void test_new_benefit_restricted_platform() {
		String platform = "GoIntegro";
		String targetUser = "General";
		String title = DataGenerator.nombreFile();
		
		DetailBenefits detail = createBenefit(name, targetUser);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectActive();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.searchRestrictedPlataform(platform);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.addRestricted();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.confirmActive();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SearchResult search = home.searchForText(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("0 resultados", search.getResultsFoundMsg());
	}
	
	@Test
	public void test_new_benefit_exclusive_platform() {
		String platform = "GoIntegro";
		String targetUser = "General";
		String title = DataGenerator.nombreFile();
		
		DetailBenefits detail = createBenefit(name, targetUser);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewBenefits newBenefit = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectActive();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.selectExclusive();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.searchExclusivePlataform(platform);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.addExclusive();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		newBenefit.confirmActive();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SearchResult search = home.searchForText(title);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("1 resultados", search.getResultsFoundMsg());
	}
	
	private DetailBenefits createBenefit(String title, String targetUser) {
		loginBackoffice(driver);
		
		DetailCompany detailCompany = PageFactory.initElements(driver, DetailCompany.class);
		detailCompany.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewBenefits newBenefit = detailCompany.selectNewBenefit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectPaymentMethods(paymentMethod);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectPaymentMethods(paymentMethod2);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.selectRedeeming(redeeming);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.addCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailBenefits detail = newBenefit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		SelectStoreOverlay selectStore = detail.selectRelateStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		selectStore.selectFirstStore();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		return selectStore.selectClose();
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
