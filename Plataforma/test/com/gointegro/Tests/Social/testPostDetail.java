package com.gointegro.Tests.Social;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Platform.Profile;
import com.gointegro.Pages.Social.AppPrivateSocial;
import com.gointegro.Pages.Social.DetailPost;
import com.gointegro.Pages.Social.PostForm;
import com.gointegro.Pages.Social.SocialWall;
import com.gointegro.Pages.Social.TagFeed;
import com.gointegro.Pages.Social.WallFeeds;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testPostDetail {
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTests.getDriver();
	}

	@Test
	public void test_detalle_post_simple() {
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
		WaitTool.waitForJQueryProcessing(driver, 5);
		TagFeed tagfeeds = feeds.selectHashtag("#hashtag2");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailPost detailpost = tagfeeds.selectFeed();
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertEquals("Detalle de la publicación", detailpost.getTitle());
	}
	
	@Test
	public void test_detalle_post_file() {
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
		WaitTool.waitForJQueryProcessing(driver, 5);
		TagFeed tagfeeds = feeds.selectHashtag("#hashtag2");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailPost detailpost = tagfeeds.selectFeed();
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertEquals("Descargar "+title, feeds.getDescargarFile());
		assertEquals("Detalle de la publicación", detailpost.getTitle());
	}
	
	@Test
	public void test_detalle_post_imagen() {
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
		WaitTool.waitForJQueryProcessing(driver, 5);
		TagFeed tagfeeds = feeds.selectHashtag("#hashtag2");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailPost detailpost = tagfeeds.selectFeed();
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertTrue(ConfigElements.getFileImagen().contains(feeds.getFeedImage()));
		assertEquals("Detalle de la publicación", detailpost.getTitle());
	}
	
	@Test
	public void test_detalle_post_vinculo() {
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
		WaitTool.waitForJQueryProcessing(driver, 5);
		TagFeed tagfeeds = feeds.selectHashtag("#hashtag2");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailPost detailpost = tagfeeds.selectFeed();
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertEquals(ConfigElements.getUrlTest(), feeds.getURLFeed());
		assertEquals("Detalle de la publicación", detailpost.getTitle());
	}
	
	@Test
	public void test_detalle_post_extenso() {
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
		WaitTool.waitForJQueryProcessing(driver, 5);
		TagFeed tagfeeds = feeds.selectHashtag("#hashtag2");
		WaitTool.waitForJQueryProcessing(driver, 5);
		DetailPost detailpost = tagfeeds.selectFeed();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertTrue(textopost.contains(feeds.getTextVerMas()));
		feeds.selectViewMore();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(textopost+"\nVer menos", feeds.getFeedContent());
		feeds.selectViewLess();
		assertTrue(textopost.contains(feeds.getTextVerMas()));
		assertEquals("Detalle de la publicación", detailpost.getTitle());
	}
	
	@Test
	public void test_detalle_post_espacio_privado() {
		String textopost = "#hashtag2 "+DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		AppPrivateSocial appPrivate = PageFactory.initElements(driver, AppPrivateSocial.class);
		appPrivate.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		TagFeed tagfeeds = feeds.selectHashtag("#hashtag2");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DetailPost detailpost = tagfeeds.selectFeed();
		String urlpost = detailpost.getURL();
		System.out.println(urlpost);
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getOtherUsername(), ConfigElements.getPassword());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		driver.get(urlpost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(driver.getCurrentUrl(), urlpost);
		
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
