package com.gointegro.Tests.Social;

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
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Profile.OtherProfile;
import com.gointegro.Pages.Profile.Profile;
import com.gointegro.Pages.Social.AppSocial;
import com.gointegro.Pages.Social.PostForm;
import com.gointegro.Pages.Social.SocialWall;
import com.gointegro.Pages.Social.TagFeed;
import com.gointegro.Pages.Social.WallFeeds;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testHashtagPost extends AllTests {
	
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
	public void test_hashtag_en_muro_social() {
		String textopost = "#hashtag2 "+DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_hashtag_en_app_social() {
		String textopost = "#hashtag2 "+DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		AppSocial appsocial = PageFactory.initElements(driver, AppSocial.class);
		appsocial.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		WaitTool.setImplicitWait(driver, 10);
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		feeds.waitDeleteAction();
		
		driver.get(ConfigElements.getURL());
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreEspacio()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombreEspacio()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_hashtag_en_mi_perfil() {
		String textopost = "#hashtag2 "+DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		
		driver.get(ConfigElements.getURL());
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		profile.open();
		feeds = PageFactory.initElements(driver, WallFeeds.class);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_hashtag_en_otro_perfil() {
		String textopost = "#hashtag2 "+DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		OtherProfile otherprof = PageFactory.initElements(driver, OtherProfile.class);
		otherprof.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó en el muro de "+ConfigElements.getNameOtherUser()+"\n"+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_select_hashtag() {
		String textopost = "#hashtag2 "+DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		TagFeed tagfeeds = feeds.selectHashtag("#hashtag2");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(textopost, tagfeeds.getFeedContent());
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, tagfeeds.getFeedFullContent());
		assertEquals("Contenidos etiquetados con #hashtag2", tagfeeds.getModalTitle());
	}
	
	@Test
	public void test_hashtag_en_post_file() {
		String textopost = "#hashtag2 "+DataGenerator.horaactual();
		String title = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostFile(textopost, title, ConfigElements.getFileNoImage());
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertEquals(title, feeds.getFileName());
		assertEquals("Descargar "+title, feeds.getDescargarFile());
		TagFeed tagfeeds = feeds.selectHashtag("#hashtag2");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(textopost, tagfeeds.getFeedContent());
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, tagfeeds.getFeedFullContent());
		assertEquals("Contenidos etiquetados con #hashtag2", tagfeeds.getModalTitle());
		assertEquals("Descargar "+title, tagfeeds.getFeedFileTitle());
		assertEquals(title, tagfeeds.getFileName());
	}
	
	@Test
	public void test_hashtag_en_post_de_imagen() {
		String textopost = "#hashtag2 "+DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostFileImagen(textopost, ConfigElements.getFileImagen());
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertTrue(ConfigElements.getFileImagen().contains(feeds.getFeedImage()));
		
		TagFeed tagfeeds = feeds.selectHashtag("#hashtag2");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(textopost, tagfeeds.getFeedContent());
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, tagfeeds.getFeedFullContent());
		assertEquals("Contenidos etiquetados con #hashtag2", tagfeeds.getModalTitle());
		
		assertTrue(ConfigElements.getFileImagen().contains(tagfeeds.getFeedImage()));
	}
	
	@Test
	public void test_hashtag_en_post_de_vinculo() {
		String textopost = "#hashtag2 "+DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostLink(ConfigElements.getUrlTest(), textopost);
		WaitTool.setImplicitWait(driver, 3);
		post.waitForLinkLoad();
		post.submitPostLink();
		
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertEquals(ConfigElements.getUrlTest(), feeds.getURLFeed());
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		TagFeed tagfeeds = feeds.selectHashtag("#hashtag2");
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		assertEquals(textopost, tagfeeds.getFeedContent());
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, tagfeeds.getFeedFullContent());
		assertEquals("Contenidos etiquetados con #hashtag2", tagfeeds.getModalTitle());
		
		assertEquals(ConfigElements.getUrlTest(), tagfeeds.getURLFeed());
	}
	
	
	@Test(enabled = false)
	public void test_hashtag_en_post_extenso() {
		String textopost = "#hashtag2 "+DataGenerator.horaactual()+StringUtils.getTextoLargo();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		//Fix Temporal
		WaitTool.waitForJQueryProcessing(driver, 5);
		social.open();
		//
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertTrue(textopost.contains(feeds.getTextVerMas()));
		
		TagFeed tagfeeds = feeds.selectHashtag("#hashtag2");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(textopost, tagfeeds.getFeedContent());
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, tagfeeds.getFeedFullContent());
		assertEquals("Contenidos etiquetados con #hashtag2", tagfeeds.getModalTitle());
		
		assertTrue(textopost.contains(tagfeeds.getTextVerMas()));
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}
	

}
