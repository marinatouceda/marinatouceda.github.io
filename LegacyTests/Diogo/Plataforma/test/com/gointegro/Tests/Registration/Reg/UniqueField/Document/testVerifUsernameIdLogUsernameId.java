package com.gointegro.Tests.Registration.Reg.UniqueField.Document;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

import com.gointegro.Helpers.ConfigElementsRegistration;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Platform.Profile;
import com.gointegro.Pages.Registration.SignUp;
import com.gointegro.Pages.Registration.Verification;
import com.gointegro.Tests.CommonMethods.CommonTestMethods;
import com.gointegro.Util.WaitTool;
import com.gointegro.Util.WorkbookUtils;

public class testVerifUsernameIdLogUsernameId extends AllTestsRegUniqDocument {
	
	private WebDriver driver;
	
	WorkbookUtils workbook = new WorkbookUtils();
	
	CommonTestMethods common;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		@Override
		protected void starting(final Description description) {
			logger.info(description.getMethodName());
		}
	};

	@BeforeMethod
	public void setUp() throws Exception {
		driver = getDriver();
		CommonTestMethods common = new CommonTestMethods(workbook, driver);
		this.common = common;
	}

	@Test
	public void test_VerifEmail_LogDoc_WithoutGenderFNPass_row137() {
		common.readxls(137);
		
		common.configAccount(false, false, false, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), true, "Id", "-- Sin segundo campo de verificación", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Id(), workbook.getNombre(), 
				"", workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url());
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
		
		signup.setEmail(workbook.getMail());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_WithoutGenderPass_row138() {
		common.readxls(138);
		
		common.configAccount(true, false, false, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), true, "Id", "-- Sin segundo campo de verificación", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Id(), workbook.getNombre(), 
				"", "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url());
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
		
		signup.setEmail(workbook.getMail());
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_WithoutFNPass_row139() {
		common.readxls(139);
		
		common.configAccount(false, true, false, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), true, "Id", "-- Sin segundo campo de verificación", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Id(), workbook.getNombre(), 
				"", workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url());
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
		
		signup.setEmail(workbook.getMail());
		signup.setGender();
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_WithoutPass_row140() {
		common.readxls(140);
		
		common.configAccount(true, true, false, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), true, "Id", "-- Sin segundo campo de verificación", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Id(), workbook.getNombre(), 
				"", "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url());
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
		
		signup.setEmail(workbook.getMail());
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_WithoutGenderFN_row141() {
		common.readxls(141);
		
		common.configAccount(false, false, true, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), true, "Id", "-- Sin segundo campo de verificación", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Id(), workbook.getNombre(), 
				"", workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url());
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
		
		signup.setEmail(workbook.getMail());
		signup.setPassword("integro12");
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_WithoutGender_row142() {
		common.readxls(142);
		
		common.configAccount(true, false, true, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), true, "Id", "-- Sin segundo campo de verificación", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Id(), workbook.getNombre(), 
				"", "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url());
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
		
		signup.setEmail(workbook.getMail());
		signup.setPassword("integro12");
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_WithoutFN_row143() {
		common.readxls(143);
		
		common.configAccount(false, true, true, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), true, "Id", "-- Sin segundo campo de verificación", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Id(), workbook.getNombre(), 
				"", workbook.getFechanac(), workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url());
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
		
		signup.setEmail(workbook.getMail());
		signup.setPassword("integro12");
		signup.setGender();
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_VerifEmail_LogDoc_row144() {
		common.readxls(144);
		
		common.configAccount(true, true, true, ConfigElementsRegistration.getUniqueFieldDocumentAccountId(), true, "Id", "-- Sin segundo campo de verificación", "Id");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		common.createUserBO(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Id(), workbook.getNombre(), 
				"", "", workbook.getApellido(), workbook.getId(), 
				workbook.getDocumento());
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url());
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
		
		signup.setEmail(workbook.getMail());
		signup.setPassword("integro12");
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getId(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.get(ConfigElementsRegistration.getUniqueFieldDocumentPlatformChild1Url()+"/auth/signout");
		WaitTool.waitForJQueryProcessing(driver, 10);
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}

}
