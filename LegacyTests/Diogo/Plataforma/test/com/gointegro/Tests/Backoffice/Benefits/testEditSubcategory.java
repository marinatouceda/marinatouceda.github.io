package com.gointegro.Tests.Backoffice.Benefits;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Pages.Backoffice_Benefits.CategoriesList;
import com.gointegro.Pages.Backoffice_Benefits.DetailCategory;
import com.gointegro.Pages.Backoffice_Benefits.HomeBenefits;
import com.gointegro.Pages.Backoffice_Benefits.NewCategory;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testEditSubcategory extends AllTestsBackOfficeBenefits {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = getDriver();
	}
	
	
	@Test
	public void test_edit_subcategory() {
		String newName = DataGenerator.nombreFile();
		
		DetailCategory detail = createSubCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		NewCategory newCategory = detail.selectEdit();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(newName, newName, newName);
		WaitTool.waitForJQueryProcessing(driver, 5);
	
		newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(newName, detail.getCatES());
	}
	
	private DetailCategory createSubCategory() {
		String name = DataGenerator.nombreFile();
		String nameSubcat = DataGenerator.nombreFile();
		
		loginBackoffice(driver);
		
		HomeBenefits home = PageFactory.initElements(driver, HomeBenefits.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		CategoriesList category = home.selectAdminCategory();
		NewCategory newCategory = category.selectNewCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(name, name, name);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DetailCategory detail = newCategory.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		detail.selectNewSubCategory();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		newCategory.createCategory(nameSubcat, nameSubcat, nameSubcat);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		return newCategory.selectSave();
		
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
