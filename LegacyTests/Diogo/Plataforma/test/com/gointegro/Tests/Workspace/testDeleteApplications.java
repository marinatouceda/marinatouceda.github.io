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

import com.gointegro.Pages.Platform.AplicationAdd;
import com.gointegro.Pages.Platform.AplicationInstall;
import com.gointegro.Pages.Platform.ApplicationAdmin;
import com.gointegro.Pages.Platform.Home;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Workspace.DeleteOverlay;
import com.gointegro.Pages.Workspace.WorkspaceCreate;
import com.gointegro.Pages.Workspace.WorkspaceList;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testDeleteApplications extends AllTestsWorkspace {
	
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
	public void test_delete_application() {
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
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = workList.selectAddAplicactions(title);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallGalery();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		ApplicationAdmin appAdmin = workList.selectAdminApps(title);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		DeleteOverlay delete = appAdmin.deleteApp(appTitle);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		delete.selectConfirmDeleteApps();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		home.openWorkspaceEnv();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		assertFalse(workList.isApplicationInWorkspace(title, appTitle));
	}
	
	
	@Test
	public void test_delete_press_cancel() {
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
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = workList.selectAddAplicactions(title);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallGalery();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		ApplicationAdmin appAdmin = workList.selectAdminApps(title);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		DeleteOverlay delete = appAdmin.deleteApp(appTitle);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		delete.selectCancelDelete();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertTrue(workList.isApplicationInWorkspace(title, appTitle));
	}
	
	@Test
	public void test_delete_application_access_url() {
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
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		workspace.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WorkspaceList workList = PageFactory.initElements(driver, WorkspaceList.class);
		
		AplicationAdd appAdd = workList.selectAddAplicactions(title);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		AplicationInstall appInstall = appAdd.selectInstallGalery();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		appInstall.completeInstallApp(appTitle, "", true, true, true);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		String appURL = driver.getCurrentUrl();
		
		ApplicationAdmin appAdmin = workList.selectAdminApps(title);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		DeleteOverlay delete = appAdmin.deleteApp(appTitle);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		delete.selectConfirmDeleteApps();
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		driver.get(appURL);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		assertNotEquals(appURL, driver.getCurrentUrl());
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
