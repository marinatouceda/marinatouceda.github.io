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
import com.gointegro.Pages.Profile.OtherProfile;
import com.gointegro.Pages.Profile.Profile;
import com.gointegro.Pages.Social.AppSocial;
import com.gointegro.Pages.Social.PostForm;
import com.gointegro.Pages.Social.SocialWall;
import com.gointegro.Pages.Social.WallFeeds;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;


/**
 * Prueba de eliminar un post
 * 
 * @author gustavomoreira
 *
 */
public class testPostEliminar {
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTests.getDriver();
	}

	@Test
	public void test_Eliminar_post_en_Social_wall() {
		String textopost = DataGenerator.horaactual();
		
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
		
		feeds.deletePost();
		
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		social.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_Eliminar_post_en_social_app() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		AppSocial appSocial = PageFactory.initElements(driver, AppSocial.class);
		appSocial.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		feeds.deletePost();
		
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		appSocial.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_Eliminar_post_en_mi_perfil() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		feeds.deletePost();
		
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_Eliminar_post_otro_perfil() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		OtherProfile otherprofile = PageFactory.initElements(driver, OtherProfile.class);
		otherprofile.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		feeds.deletePost();
		
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		otherprofile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_Eliminar_post_cancelar() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall socialwall = PageFactory.initElements(driver, SocialWall.class);
		socialwall.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		feeds.deleteCancelPost();
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_Eliminar_post_vinculo() {
		String textopost = DataGenerator.horaactual();
		
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
		social.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		feeds.deletePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		social.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_Eliminar_post_imagen() {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostFileImagen(textopost, ConfigElements.getFileImagen());
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		feeds.deletePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		social.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_Eliminar_post_file() {
		String textopost = DataGenerator.horaactual();
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
		social.open();
		feeds.deletePost();
		WaitTool.waitForJQueryProcessing(driver, 5);
		social.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertNotEquals(textopost, feeds.getFeedContent());
		assertNotEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
	}
	
	@Test
	public void test_Eliminar_post_extenso() {
		String textopost = DataGenerator.horaactual()+StringUtils.getTextoLargo();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.setImplicitWait(driver, 3);
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		feeds.deletePost();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertFalse(textopost.contains(feeds.getFeedContent()+"..."));
		
		social.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertFalse(textopost.contains(feeds.getFeedContent()+"..."));
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertFalse(textopost.contains(feeds.getFeedContent()+"..."));
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
