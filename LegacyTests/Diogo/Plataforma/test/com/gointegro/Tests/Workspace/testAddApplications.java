package com.gointegro.Tests.Workspace;

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
import com.gointegro.Pages.Platform.AplicationAdd;
import com.gointegro.Pages.Platform.AplicationInstall;
import com.gointegro.Pages.Platform.Home;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Widgets.BenefitFilterDetail;
import com.gointegro.Pages.Workspace.WorkspaceCreate;
import com.gointegro.Pages.Workspace.WorkspaceList;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testAddApplications extends AllTestsWorkspace {
	
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
	public void test_add_application_gallery() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallGalery();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(workList.isApplicationInWorkspace(title, appTitle));
		assertTrue(driver.getCurrentUrl().contains("galleries"));
	}
	
	
	@Test
	public void test_add_application_title_empty() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = "";
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallGalery();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals("Ingrese el nombre de la aplicación", appInstall.getTitleErrorMsg());
		assertEquals("Existen errores en el formulario", appInstall.getSaveErrorMsg());
	}
	
	
	@Test
	public void test_add_application_max_visible_apps() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		int visibleApps = 2;
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectVisibleAppsNum(visibleApps);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		for(int i=0; i<= visibleApps; i++) {
			createApp(workList, title, DataGenerator.nombreFile());
			WaitTool.waitForJQueryProcessing(driver, 10);
		}
		
		assertTrue(workList.isMoreButtonPresent(title));
	}
	
	
	@Test
	public void test_add_application_title_exists() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectVisibleAppsNum(2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		createApp(workList, title, appTitle);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createApp(workList, title, appTitle);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		AplicationInstall appInstall = PageFactory.initElements(driver, AplicationInstall.class);
		
		assertEquals("Ya existe una aplicación con el nombre ingresado.", appInstall.getSaveErrorMsg());
	}
	
	
	@Test
	public void test_add_application_title_max_chars() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = StringUtils.getTextoLargo();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectVisibleAppsNum(2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		createApp(workList, title, appTitle);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		AplicationInstall appInstall = PageFactory.initElements(driver, AplicationInstall.class);
		
		assertEquals("Ingrese un nombre que no supere los 80 caracteres", appInstall.getTitleErrorMsg());
	}
	
	
	@Test
	public void test_add_application_content() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallContent();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(workList.isApplicationInWorkspace(title, appTitle));
		assertTrue(driver.getCurrentUrl().contains("articles"));
	}
	
	
	@Test
	public void test_add_application_news() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallNews();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(workList.isApplicationInWorkspace(title, appTitle));
		assertTrue(driver.getCurrentUrl().contains("news"));
	}
	
	
	@Test
	public void test_add_application_social() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallAppSocial();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(workList.isApplicationInWorkspace(title, appTitle));
		assertTrue(driver.getCurrentUrl().contains("social"));
	}
	
	
	@Test
	public void test_add_application_tournaments() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallTournaments();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, false);
		WaitTool.waitForJQueryProcessing(driver, 40);
		
		assertTrue(driver.getCurrentUrl().contains("tournaments"));
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		assertTrue(workList.isApplicationInWorkspace(title, appTitle));
	}
	
	
	@Test
	public void test_add_application_celebrations() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallCelebration();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.setAppName(appTitle);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		appInstall.celebrationComplete("", true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		appInstall.saveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(workList.isApplicationInWorkspace(title, appTitle));
		assertTrue(driver.getCurrentUrl().contains("celebrations"));
	}
	
	
	@Test
	public void test_add_application_private_access_url() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, true, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		
		AplicationInstall appInstall = appAdd.selectInstallNews();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		String appURL = driver.getCurrentUrl();
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		loginBasicUser(driver);
		
		driver.get(appURL);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(appURL, driver.getCurrentUrl());
	}
	
	
	@Test
	public void test_add_application_benefit_map() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallBenefitsCategoryMap();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, description, true, false, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(workList.isApplicationInWorkspace(title, appTitle));
		assertTrue(driver.getCurrentUrl().contains("benefits"));
	}
	
	
	@Test
	public void test_add_application_benefit_map_private() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, true, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallBenefitsCategoryMap();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, description, false, false, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		String appURL = driver.getCurrentUrl();
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		loginBasicUser(driver);
		
		driver.get(appURL);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(appURL, driver.getCurrentUrl());
	}
	
	
	@Test
	public void test_add_application_benefit_filter_category_empty() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallBenefitsFilter();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallBenefitFilter(appTitle, description, true, false, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		appInstall.selectCategoryAndSubcategory();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		appInstall.saveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("Debe seleccionar al menos una categoria", appInstall.getCategoriesError());
	}
	
	
	@Test
	public void test_add_application_benefit_filter() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		String fileupload = ConfigElements.getFileImagen();
		String address = "Córdoba, Córdoba, Argentina";
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallBenefitsFilter();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.fileUpload(fileupload);
		
		appInstall.completeInstallBenefitFilter(appTitle, description, true, true, false);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		appInstall.addLocation(address);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		appInstall.saveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		BenefitFilterDetail benefitDetail = PageFactory.initElements(driver, BenefitFilterDetail.class);
		
		assertTrue(benefitDetail.isImagePresent());
		assertTrue(address.contains(benefitDetail.getLocation()));
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		assertTrue(workList.isApplicationInWorkspace(title, appTitle));
	}
	
	
	@Test
	public void test_add_application_benefit_filter_with_special() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, false, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallBenefitsFilter();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallBenefitFilter(appTitle, description, true, false, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		appInstall.saveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		BenefitFilterDetail benefitDetail = PageFactory.initElements(driver, BenefitFilterDetail.class);
		
		assertTrue(benefitDetail.isSpecialFilterPresent());
	}
	
	
	@Test
	public void test_add_application_benefit_filter_private() {
		String title = DataGenerator.nombreFile();
		String description = StringUtils.getTextoLargo();
		String appTitle = DataGenerator.nombreFile();
		
		login(driver);
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		WorkspaceCreate workspace = home.workspaceCreate();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.createWorkspace(title, description, true, true, "");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		AplicationAdd appAdd = PageFactory.initElements(driver, AplicationAdd.class);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallBenefitsFilter();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallBenefitFilter(appTitle, description, true, false, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		appInstall.saveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		String appURL = driver.getCurrentUrl();
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		loginBasicUser(driver);
		
		driver.get(appURL);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertNotEquals(appURL, driver.getCurrentUrl());	
	}
	
	private void createApp(WorkspaceList workList, String title, String appTitle) {
		AplicationAdd appAdd = workList.selectAddAplicactions(title);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallContent();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
	}
	
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}
}
