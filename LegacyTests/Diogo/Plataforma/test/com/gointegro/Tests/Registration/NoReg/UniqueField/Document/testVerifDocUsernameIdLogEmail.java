package com.gointegro.Tests.Registration.NoReg.UniqueField.Document;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Helpers.ConfigElementsRegistration;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Platform.Profile;
import com.gointegro.Pages.Registration.SignUp;
import com.gointegro.Pages.Registration.Verification;
import com.gointegro.Tests.CommonMethods.CommonTestMethods;
import com.gointegro.Util.WaitTool;
import com.gointegro.Util.WorkbookUtils;

public class testVerifDocUsernameIdLogEmail extends AllTestsNoRegUniqDocument {

	private WebDriver driver;
	
	WorkbookUtils workbook = new WorkbookUtils();
	
	CommonTestMethods common;
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = getDriver();
		CommonTestMethods common = new CommonTestMethods(workbook, driver);
		this.common = common;
	}
	
	@Test
	public void test_VerifDocUsernameId_LogEmail_WithoutGenderFNPass_row57() {
		common.readxls(57);
		
		common.configPlatform(false, false, false, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), true, "Documento", "Id", "Email");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				"", workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		
		signup.setEmail(workbook.getMail());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDocUsernameId_LogEmail_WithoutGenderPass_row58() {
		common.readxls(58);
		
		common.configPlatform(true, false, false, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), true, "Documento", "Id", "Email");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				"", "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isBirthdatePresent());
		
		signup.setBirthdate(workbook.getFechanac());
		signup.setEmail(workbook.getMail());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDocUsernameId_LogEmail_WithoutFNPass_row59() {
		common.readxls(59);
		
		common.configPlatform(false, true, false, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), true, "Documento", "Id", "Email");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				"", workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isGenderPresent());
		
		signup.setGender();
		signup.setEmail(workbook.getMail());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDocUsernameId_LogEmail_WithoutPass_row60() {
		common.readxls(60);
		
		common.configPlatform(true, true, false, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), true, "Documento", "Id", "Email");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				"", "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		signup.setEmail(workbook.getMail());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDocUsernameId_LogEmail_WithoutGenderFN_row61() {
		common.readxls(61);
		
		common.configPlatform(false, false, true, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), true, "Documento", "Id", "Email");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				"", workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		signup.setEmail(workbook.getMail());
		signup.setPassword("integro12");
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDocUsernameId_LogEmail_WithoutGender_row62() {
		common.readxls(62);
		
		common.configPlatform(true, false, true, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), true, "Documento", "Id", "Email");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				"", "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		signup.setEmail(workbook.getMail());
		signup.setPassword("integro12");
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDocUsernameId_LogEmail_WithoutFN_row63() {
		common.readxls(63);
		
		common.configPlatform(false, true, true, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), true, "Documento", "Id", "Email");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				"", workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		signup.setEmail(workbook.getMail());
		signup.setPassword("integro12");
		signup.setGender();
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifDocUsernameId_LogEmail_row64() {
		common.readxls(64);
		
		common.configPlatform(true, true, true, ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), true, "Documento", "Id", "Email");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getPlatformIdUniqueFieldDocument(), workbook.getNombre(), 
				"", "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getDocumento(), workbook.getId());
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		assertEquals(workbook.getDocumento(), signup.getDocument());
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		
		signup.setPassword("integro12");
		signup.setEmail(workbook.getMail());
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.get(ConfigElementsRegistration.getPlatformurlUniqueFieldDocument()+"/auth/signout");
		WaitTool.waitForJQueryProcessing(driver, 10);
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}
}
