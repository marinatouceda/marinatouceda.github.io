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
import com.gointegro.Pages.Social.Comment;
import com.gointegro.Pages.Social.WallFeeds;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testComment extends AllTests {
	
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
	public void test_Comentar_en_Social_Wall() {
		String textopost = DataGenerator.horaactual();
		String commentpost = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		Comment comment = createComment(commentpost);
		
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(commentpost, comment.getTextComment());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertFalse(feeds.getPublicoEn().contains(ConfigElements.getNombreUsuario()+" comentó la publicación de "+ConfigElements.getNombreUsuario()));
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertEquals(commentpost, comment.getTextComment());
		
	}
	
	@Test
	public void test_Comentar_en_Social_App() {
		String textopost = DataGenerator.horaactual();
		String commentpost = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		AppSocial appsocial = PageFactory.initElements(driver, AppSocial.class);
		appsocial.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		Comment comment = createComment(commentpost);
		
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(commentpost, comment.getTextComment());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertFalse(feeds.getPublicoEn().contains(ConfigElements.getNombreUsuario()+" comentó la publicación de "+ConfigElements.getNombreUsuario()));
		assertEquals(ConfigElements.getNombreEspacio()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertEquals(commentpost, comment.getTextComment());
	}
	
	@Test
	public void test_Comentar_en_mi_perfil() {
		String textopost = DataGenerator.horaactual();
		String commentpost = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		Comment comment = createComment(commentpost);
		
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(commentpost, comment.getTextComment());
		
	}
	
	@Test
	public void test_Comentar_en_otro_perfil() {
		String textopost = DataGenerator.horaactual();
		String commentpost = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		OtherProfile otherprof = PageFactory.initElements(driver, OtherProfile.class);
		otherprof.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		Comment comment = createComment(commentpost);
		
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(commentpost, comment.getTextComment());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertFalse(feeds.getPublicoEn().contains(ConfigElements.getNombreUsuario()+" comentó la publicación de "+ConfigElements.getNombreUsuario()));
		assertEquals(ConfigElements.getNombreUsuario()+" publicó en el muro de "+ConfigElements.getNameOtherUser()+"\n"+textopost, feeds.getPublicoEn());
		assertEquals(commentpost, comment.getTextComment());
	}
	
	@Test
	public void test_Comment_placeholder () {
		String textopost = DataGenerator.horaactual();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePost(textopost);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		Comment comment = PageFactory.initElements(driver, Comment.class);
		assertEquals("Ingresá tu comentario", comment.getPlaceholder());
	}
	
	@Test
	public void test_Comment_post_de_File_no_imagen() {
		String textopost = DataGenerator.horaactual();
		String title = DataGenerator.nombreFile();
		String commentpost = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostFile(textopost, title, ConfigElements.getFileNoImage());
		WaitTool.setImplicitWait(driver, 3);
		WaitTool.waitForJQueryProcessing(driver, 5);
		Comment comment = createComment(commentpost);
		
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(commentpost, comment.getTextComment());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertEquals(title, feeds.getFileName());
		assertEquals("Descargar "+title, feeds.getDescargarFile());
		
		assertEquals(commentpost, comment.getTextComment());
	}
	
	@Test
	public void test_Comment_post_de_file_imagen() {
		String textopost = DataGenerator.horaactual();
		String commentpost = DataGenerator.nombreFile();
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.open();
		login.LoginPlatformNoReg(ConfigElements.getUsername(), ConfigElements.getPassword());
		SocialWall social = PageFactory.initElements(driver, SocialWall.class);
		social.open();
		PostForm post = PageFactory.initElements(driver, PostForm.class);
		post.completePostFileImagen(textopost, ConfigElements.getFileImagen());
		WaitTool.setImplicitWait(driver, 3);
		WaitTool.waitForJQueryProcessing(driver, 5);
		Comment comment = createComment(commentpost);
		
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(commentpost, comment.getTextComment());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertTrue(ConfigElements.getFileImagen().contains(feeds.getFeedImage()));
		
		assertEquals(commentpost, comment.getTextComment());
	}
	
	@Test
	public void test_Comment_post_de_vinculo() {
		String textopost = DataGenerator.horaactual();
		String commentpost = DataGenerator.nombreFile();
		
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
		WaitTool.waitForJQueryProcessing(driver, 5);
		Comment comment = createComment(commentpost);
		
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertEquals(commentpost, comment.getTextComment());
		
		Profile profile = PageFactory.initElements(driver, Profile.class);
		profile.open();
		WallFeeds feeds = PageFactory.initElements(driver, WallFeeds.class);
		
		assertEquals(textopost, feeds.getFeedContent());
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, feeds.getPublicoEn());
		assertEquals(ConfigElements.getUrlTest(), feeds.getURLFeed());
		
		assertEquals(commentpost, comment.getTextComment());
	}

	private Comment createComment(String commentpost) {
		Comment comment = PageFactory.initElements(driver, Comment.class);
		comment.completeComment(commentpost);
		return comment;
	}
	
	@AfterMethod
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
