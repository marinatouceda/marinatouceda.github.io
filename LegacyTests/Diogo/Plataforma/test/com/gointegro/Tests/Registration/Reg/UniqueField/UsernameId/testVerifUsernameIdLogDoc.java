package com.gointegro.Tests.Registration.Reg.UniqueField.UsernameId;

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

public class testVerifUsernameIdLogDoc extends AllTestsRegUniqUsernameId {

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
	public void test_VerifEmail_LogDoc_WithoutGenderFNPass_row121() {
		common.readxls(121);
		
		common.configAccount(false, false, false, ConfigElementsRegistration.getUniqueFieldUsernameIdAccountId(), true, "Id", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getUniqueFieldUsernameIdPlatformChild1Id(), workbook.getNombre(), 
				"", workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				"");
		
		driver.get(ConfigElementsRegistration.getUniqueFieldUsernameIdAccountUrl());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getId(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldUsernameIdPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_WithoutGenderPass_row122() {
		common.readxls(122);
		
		common.configAccount(true, false, false, ConfigElementsRegistration.getUniqueFieldUsernameIdAccountId(), true, "Id", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getUniqueFieldUsernameIdPlatformChild1Id(), workbook.getNombre(), 
				"", "", workbook.getApellido(), workbook.getId(), 
				"");
		
		driver.get(ConfigElementsRegistration.getUniqueFieldUsernameIdAccountUrl());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getId(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldUsernameIdPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_WithoutFNPass_row123() {
		common.readxls(123);
		
		common.configAccount(false, true, false, ConfigElementsRegistration.getUniqueFieldUsernameIdAccountId(), true, "Id", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getUniqueFieldUsernameIdPlatformChild1Id(), workbook.getNombre(), 
				"", workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				"");
		
		driver.get(ConfigElementsRegistration.getUniqueFieldUsernameIdAccountUrl());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getId(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setGender();
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldUsernameIdPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_WithoutPass_row124() {
		common.readxls(124);
		
		common.configAccount(true, true, false, ConfigElementsRegistration.getUniqueFieldUsernameIdAccountId(), true, "Id", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getUniqueFieldUsernameIdPlatformChild1Id(), workbook.getNombre(), 
				"", "", workbook.getApellido(), workbook.getId(), 
				"");
		
		driver.get(ConfigElementsRegistration.getUniqueFieldUsernameIdAccountUrl());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getId(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldUsernameIdPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_WithoutGenderFN_row125() {
		common.readxls(125);
		
		common.configAccount(false, false, true, ConfigElementsRegistration.getUniqueFieldUsernameIdAccountId(), true, "Id", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getUniqueFieldUsernameIdPlatformChild1Id(), workbook.getNombre(), 
				"", workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				"");
		
		driver.get(ConfigElementsRegistration.getUniqueFieldUsernameIdAccountUrl());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getId(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setPassword("integro12");
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldUsernameIdPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_WithoutGender_row126() {
		common.readxls(126);
		
		common.configAccount(true, false, true, ConfigElementsRegistration.getUniqueFieldUsernameIdAccountId(), true, "Id", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getUniqueFieldUsernameIdPlatformChild1Id(), workbook.getNombre(), 
				"", "", workbook.getApellido(), workbook.getId(), 
				"");
		
		driver.get(ConfigElementsRegistration.getUniqueFieldUsernameIdAccountUrl());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getId(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setPassword("integro12");
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldUsernameIdPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_WithoutFN_row127() {
		common.readxls(127);
		
		common.configAccount(false, true, true, ConfigElementsRegistration.getUniqueFieldUsernameIdAccountId(), true, "Id", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getUniqueFieldUsernameIdPlatformChild1Id(), workbook.getNombre(), 
				"", workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				"");
		
		driver.get(ConfigElementsRegistration.getUniqueFieldUsernameIdAccountUrl());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getId(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);		
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setPassword("integro12");
		signup.setGender();
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldUsernameIdPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_row128() {
		common.readxls(128);
		
		common.configAccount(true, true, true, ConfigElementsRegistration.getUniqueFieldUsernameIdAccountId(), true, "Id", "-- Sin segundo campo de verificación", "Documento");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getUniqueFieldUsernameIdPlatformChild1Id(), workbook.getNombre(), 
				"", "", workbook.getApellido(), workbook.getId(), 
				"");
		
		driver.get(ConfigElementsRegistration.getUniqueFieldUsernameIdAccountUrl());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		Verification verif = PageFactory.initElements(driver, Verification.class);
		verif.completeVerif(workbook.getId(), "");
		
		SignUp signup = verif.selectVerifSubmit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.VerifRegistrationFields(signup);
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		assertTrue(signup.isUsernameIdPresent());
		assertEquals(workbook.getId(), signup.getUsernameId());
		assertTrue(signup.isDocumentPresent());
		
		signup.setEmail(workbook.getMail());
		signup.setDocument(workbook.getDocumento());
		signup.setPassword("integro12");
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getDocumento(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldUsernameIdPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.get(ConfigElementsRegistration.getUniqueFieldUsernameIdPlatformChild1Url()+"/auth/signout");
		WaitTool.waitForJQueryProcessing(driver, 10);
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}
}
