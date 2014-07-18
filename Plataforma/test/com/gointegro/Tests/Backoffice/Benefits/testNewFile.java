package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Backoffice_Benefits.DetailBenefits;
import com.gointegro.Pages.Backoffice_Benefits.DetailCompany;
import com.gointegro.Pages.Backoffice_Benefits.NewBenefits;
import com.gointegro.Pages.Backoffice_Benefits.NewFileOverlay;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testNewFile extends TestBase {
	
	private WebDriver driver;
		
	@Before
	public void setUp() {
		driver = AllTestsBackOfficeBenefits.getDriver();
	}
	
	
	@Test
	public void test_new_file_name_empty() {
		String name = DataGenerator.nombreFile();
		String desc = DataGenerator.nombreFile();
		String file = ConfigElements.getFileImagen();
		
		DetailBenefits detail = createBenefit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewFileOverlay newFile = detail.selectNewDocument();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.createFile(name, desc, file, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(detail.isFileInList(name));
		assertTrue(detail.isFileInList(desc));
		assertTrue(detail.isFileEnabled());
	}
	
	
	@Test
	public void test_new_file_name_max_char() {
		String name = StringUtils.getTextoLargo();
		String desc = DataGenerator.nombreFile();
		String file = ConfigElements.getFileImagen();
		
		DetailBenefits detail = createBenefit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewFileOverlay newFile = detail.selectNewDocument();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.createFile(name, desc, file, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("El nombre no puede superar los 80 caracteres", newFile.getNameErrorMsg());
	}
	
	
	@Test
	public void test_new_file_description_max_char() {
		String name = DataGenerator.nombreFile();
		String desc = StringUtils.getTextoLargo();
		String file = ConfigElements.getFileImagen();
		
		DetailBenefits detail = createBenefit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewFileOverlay newFile = detail.selectNewDocument();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.createFile(name, desc, file, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("La descripción no puede superar los 500 caracteres", newFile.getDescriptionErrorMsg());
	}
	
	
	@Test
	public void test_new_file_empty() {
		String name = DataGenerator.nombreFile();
		String desc = DataGenerator.nombreFile();
		
		DetailBenefits detail = createBenefit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewFileOverlay newFile = detail.selectNewDocument();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.createFile(name, desc, "", true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Debe subir un archivo", newFile.getFileErrorMsg());
	}
	
	
	@Test
	public void test_new_file_cancel() {
		String name = DataGenerator.nombreFile();
		String desc = DataGenerator.nombreFile();
		String file = ConfigElements.getFileImagen();
		
		DetailBenefits detail = createBenefit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewFileOverlay newFile = detail.selectNewDocument();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.createFile(name, desc, file, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(detail.isFileInList(name));
	}
	
	
	@Test
	public void test_new_file_check_link() {
		String name = DataGenerator.nombreFile();
		String desc = DataGenerator.nombreFile();
		String file = ConfigElements.getFileImagen();
		
		DetailBenefits detail = createBenefit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewFileOverlay newFile = detail.selectNewDocument();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.createFile(name, desc, file, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newFile.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertFalse(detail.getFileLink().isEmpty());
	}
	
	private DetailBenefits createBenefit() {
		String owner = DataGenerator.nombreFile();
		String name = DataGenerator.nombreFile();
		String targetUser = "Clientes";
		String discount = "2x1";
		String validFrom = DataGenerator.fechaactual();
		String fileupload = ConfigElements.getFileImagen();
		String benefitCode = "54aAsd4542";
		String title = DataGenerator.nombreFile();
		String desc = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		DetailCompany detail = PageFactory.initElements(driver, DetailCompany.class);
		detail.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		NewBenefits newBenefit = detail.selectNewBenefit(); 
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newBenefit.createBenefit(owner, name, targetUser, discount, validFrom, "", fileupload, true, benefitCode, title, desc);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		return newBenefit.selectSave(); 
	}
	
	@After
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
