package com.gointegro.Tests.Registration.Reg.UniqueField.Email;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
import com.gointegro.Tests.CommonMethods.CommonTestMethods;
import com.gointegro.Util.WaitTool;
import com.gointegro.Util.WorkbookUtils;

public class testSinVerifLogEmail extends AllTestsRegUniqEmail {

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
	public void test_SinVerif_LogEmail_WithoutGenderFNPass_row153() {
		common.readxls(153);
		
		common.configAccount(false, false, false, ConfigElementsRegistration.getUniqueFieldEmailAccountId(), false, "", "", "Email");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldEmailAccountUrl());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldEmailPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogEmail_WithoutGenderPass_row154() {
		common.readxls(154);
		
		common.configAccount(true, false, false, ConfigElementsRegistration.getUniqueFieldEmailAccountId(), false, "", "", "Email");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldEmailAccountUrl());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		assertTrue(signup.isBirthdatePresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldEmailPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogEmail_WithoutFNPass_row155() {
		common.readxls(155);
		
		common.configAccount(false, true, false, ConfigElementsRegistration.getUniqueFieldEmailAccountId(), false, "", "", "Email");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldEmailAccountUrl());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setGender();
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldEmailPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogEmail_WithoutPass_row156() {
		common.readxls(156);
		
		common.configAccount(true, true, false, ConfigElementsRegistration.getUniqueFieldEmailAccountId(), false, "", "", "Email");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldEmailAccountUrl());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();

		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldEmailPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogEmail_WithoutGenderFN_row157() {
		common.readxls(157);
		
		common.configAccount(false, false, true, ConfigElementsRegistration.getUniqueFieldEmailAccountId(), false, "", "", "Email");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldEmailAccountUrl());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setPassword("integro12");
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldEmailPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogEmail_WithoutGender_row158() {
		common.readxls(158);
		
		common.configAccount(true, false, true, ConfigElementsRegistration.getUniqueFieldEmailAccountId(), false, "", "", "Email");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldEmailAccountUrl());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();

		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setPassword("integro12");
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldEmailPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogEmail_WithoutFN_row159() {
		common.readxls(159);
		
		common.configAccount(false, true, true, ConfigElementsRegistration.getUniqueFieldEmailAccountId(), false, "", "", "Email");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldEmailAccountUrl());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setPassword("integro12");
		signup.setGender();
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldEmailPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@Test
	public void test_SinVerif_LogEmail_row160() {
		common.readxls(160);
		
		common.configAccount(true, true, true, ConfigElementsRegistration.getUniqueFieldEmailAccountId(), false, "", "", "Email");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldEmailAccountUrl());
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.selectSignUp();
		
		SignUp signup = PageFactory.initElements(driver, SignUp.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(signup.isGenderPresent());
		assertTrue(signup.isBirthdatePresent());
		assertTrue(signup.isPasswordPresent());
		assertTrue(signup.isRepeatPasswordPresent());
		assertTrue(signup.isNamePresent());
		assertTrue(signup.isSurnamePresent());
		assertTrue(signup.isEmailPresent());
		
		signup.setName(workbook.getNombre());
		signup.setSurname(workbook.getApellido());
		signup.setEmail(workbook.getMail());
		signup.setPassword("integro12");
		signup.setGender();
		signup.setBirthdate(workbook.getFechanac());
		signup.setTyC();
		
		login = signup.selectRegister();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		login.LoginPlatformNoReg(workbook.getMail(), "integro12");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		driver.get(ConfigElementsRegistration.getUniqueFieldEmailPlatformChild1Url()+"/profile");
		Profile profile = PageFactory.initElements(driver, Profile.class);
		
		assertEquals(workbook.getNombre()+" "+workbook.getApellido(), profile.getUserName());
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.get(ConfigElementsRegistration.getUniqueFieldEmailPlatformChild1Url()+"/auth/signout");
		WaitTool.waitForJQueryProcessing(driver, 10);
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
	}
}
