package com.gointegro.Tests.Social;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Platform.Login;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Pages.Social.Comment;
import com.gointegro.Pages.Social.PostForm;
import com.gointegro.Pages.Social.SocialWall;
import com.gointegro.Pages.Social.TagFeed;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.WaitTool;

public class testHashtagComment extends AllTests {
	
	private WebDriver driver;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		@Override
		protected void starting(final Description description) {
			logger.info(description.getMethodName());
		}
	};
	
	@Before
	public void setUp() {
		driver = getDriver();
	}

	@Test  //no funciona 30/04 https://gointegro.atlassian.net/browse/PLATAFORMAII-2889
	public void test_hashtag_comment() {
		String textopost = DataGenerator.horaactual();
		String commentpost = "#hashtag2 "+DataGenerator.nombreFile();
		
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
		
		TagFeed tagfeeds = comment.selectHashtag("#hashtag2");
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(textopost, tagfeeds.getFeedContent());
		assertEquals(ConfigElements.getNombrePlataforma()+" > "+ConfigElements.getNombreUsuario()+" publicó\n"+textopost, tagfeeds.getFeedFullContent());
		assertEquals("Contenidos etiquetados con #hashtag2", tagfeeds.getModalTitle());
		
		assertEquals(ConfigElements.getUrlTest(), tagfeeds.getURLFeed());
	}
	
	private Comment createComment(String commentpost) {
		Comment comment = PageFactory.initElements(driver, Comment.class);
		comment.completeComment(commentpost);
		return comment;
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
