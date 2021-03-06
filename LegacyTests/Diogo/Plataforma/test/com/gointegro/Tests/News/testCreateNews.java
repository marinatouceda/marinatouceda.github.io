package com.gointegro.Tests.News;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.News.CreateNews;
import com.gointegro.Pages.News.DetailNews;
import com.gointegro.Pages.News.HomeNews;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.DateTool;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testCreateNews extends AllTestsNews {
	
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
	public void test_create_news() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		String date = DataGenerator.fechaactual();
		String hour = "19:00";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createHour(hour);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSocialCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailNews detail = createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText, detail.getTitle());
		assertEquals(descriptionText, detail.getDescription());
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement newsElement = home.getNewsElement(titleText);
		
		assertEquals(titleText, home.getTitleNews(newsElement));
		assertTrue(descriptionText.contains(home.getShortDescription(newsElement)));
		assertEquals(DateTool.getDateAsText(date).toLowerCase(), home.getDate(newsElement));
		assertEquals(hour + " hs", home.getHour(newsElement));
	}
	
	
	@Test
	public void test_create_news_without_title() {
		String titleText = "";
		String descriptionText = DataGenerator.nombreFile();
		String date = DataGenerator.fechaactual();
		String hour = "19:00";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createHour(hour);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSocialCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El título no puede estar vacío.", createNews.getTitleError());
		assertEquals("Atención ¡Existen errores en el formulario!", createNews.getSaveError());
	}
	
	
	@Test
	public void test_create_news_without_description() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = "";
		String date = DataGenerator.fechaactual();
		String hour = "19:00";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createHour(hour);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSocialCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El detalle no puede estar vacío.", createNews.getDescriptionError());
		assertEquals("Atención ¡Existen errores en el formulario!", createNews.getSaveError());
	}
	
	
	@Test
	public void test_create_news_without_date() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = DataGenerator.nombreFile();
		String date = "";
		String hour = "19:00";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createHour(hour);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSocialCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("La fecha de publicación es obligatoria.", createNews.getDateError());
		assertEquals("Atención ¡Existen errores en el formulario!", createNews.getSaveError());
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		if (isAlertPresent()) {
			driver.switchTo().alert();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
		}
	}
	
	
	@Test
	public void test_create_news_without_hour() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = DataGenerator.nombreFile();
		String date = DataGenerator.fechaactual();
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSocialCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailNews detail = createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText, detail.getTitle());
		assertEquals(descriptionText, detail.getDescription());
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement newsElement = home.getNewsElement(titleText);
		
		assertEquals(titleText, home.getTitleNews(newsElement));
		assertEquals(descriptionText, home.getDescription(newsElement));
		assertEquals(DateTool.getDateAsText(date).toLowerCase(), home.getDate(newsElement));
	}
	
	
	@Test
	public void test_create_news_empty() {
		String titleText = "";
		String descriptionText = "";
		String date = "";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSocialCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El título no puede estar vacío.", createNews.getTitleError());
		assertEquals("El detalle no puede estar vacío.", createNews.getDescriptionError());
		assertEquals("La fecha de publicación es obligatoria.", createNews.getDateError());
		assertEquals("Atención ¡Existen errores en el formulario!", createNews.getSaveError());
	}
	
	
	@Test
	public void test_create_news_description_max_chars() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = StringUtils.getTextoLargo();
		
		do {
			descriptionText = descriptionText.concat(descriptionText);
		} while(descriptionText.length() < 32000);
		
		
		String date = DataGenerator.fechaactual();
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El detalle no puede superar los 32000 caracteres.", createNews.getDescriptionError());
		assertEquals("Atención ¡Existen errores en el formulario!", createNews.getSaveError());
	}
	
	
	@Test
	public void test_create_news_press_cancel() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = DataGenerator.nombreFile();
		String date = "26/12/2014";
		String hour = "19:00";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createHour(hour);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSocialCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectCancelBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement newsElement = home.getNewsElement(titleText);
		
		assertTrue(newsElement == null);
	}
	
	
	@Test
	public void test_create_news_upload_file() {
		String titleText = DataGenerator.nombreFile();
		String descriptionText = DataGenerator.nombreFile();
		String date = "26/12/2014";
		String hour = "19:00";
		String imageFile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescription(descriptionText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createHour(hour);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.fileUpload(imageFile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailNews detail = createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText, detail.getTitle());
		assertEquals(descriptionText, detail.getDescription());
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement newsElement = home.getNewsElement(titleText);
		
		assertEquals(titleText, home.getTitleNews(newsElement));
		assertEquals(descriptionText, home.getDescription(newsElement));
		assertEquals(DateTool.getDateAsText(date).toLowerCase(), home.getDate(newsElement));
		assertTrue(home.isImagePresent(newsElement));
		assertEquals(hour + " hs", home.getHour(newsElement));
	}
	
	
	@Test
	public void test_create_news_basic_user() {
		
		loginBasicUser(driver);
		
		CreateNews createHome = PageFactory.initElements(driver, CreateNews.class);
		createHome.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertNotEquals(driver.getCurrentUrl(), createHome.getURL());
	}
	
	
	@Test
	public void test_create_news_tinymce_link() {
		String titleText = DataGenerator.nombreFile();
		String date = DataGenerator.fechaactual();
		String url = ConfigElements.getUrlTest();
		String hour = "19:00";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescriptionWithURL(url);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createHour(hour);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSocialCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailNews detail = createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(titleText, detail.getTitle());
		assertTrue(detail.getDescription().contains(url));
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		WebElement newsElement = home.getNewsElement(titleText);
		
		assertEquals(titleText, home.getTitleNews(newsElement));
		assertTrue(home.getDescription(newsElement).contains(url));
	}
	
	
	@Test
	public void test_create_news_tinymce_image() {
		String titleText = DataGenerator.nombreFile();
		String date = DataGenerator.fechaactual();
		String image = ConfigElements.getFileImagen();
		String hour = "19:00";
		
		login(driver);
		
		HomeNews home = PageFactory.initElements(driver, HomeNews.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		CreateNews createNews = home.selectCreateNews();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createTitle(titleText);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectDate(date);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createHour(hour);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.selectSocialCheckBox();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createNews.createDescriptionWithPic(image);
		WaitTool.waitForJQueryProcessing(driver, 20);
		
		DetailNews detail = createNews.selectSaveBtn();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(titleText, detail.getTitle());
		assertTrue(detail.hasImage());
	}
	
	public boolean isAlertPresent(){
        try{
            driver.switchTo().alert();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
	
	@AfterMethod
	public void tearDown() {
		Logout logOut = PageFactory.initElements(driver, Logout.class);
		logOut.open();
	}

}
