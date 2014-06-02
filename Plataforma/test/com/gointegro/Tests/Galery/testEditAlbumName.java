package com.gointegro.Tests.Galery;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gointegro.Pages.Galery.AdminAlbum;
import com.gointegro.Pages.Galery.AlbumDetail;
import com.gointegro.Pages.Galery.EditAlbum;
import com.gointegro.Pages.Galery.HomeGalery;
import com.gointegro.Pages.Galery.NewAlbumOverlay;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Tests.Base.TestBase;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.StringUtils;
import com.gointegro.Util.WaitTool;

public class testEditAlbumName extends TestBase{
	
private WebDriver driver; 
	
	@Before
	public void setUp() {
		driver = AllTestsGalery.getDriver();
	}
	
	@Test
	public void test_edit_album_admin_text() {
		String albumname = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminAlbum admin = home.selectAdminAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(albumname, admin.getAlbumName(albumname));
	}
	
	@Test
	public void test_edit_album_admin() {
		String albumname = DataGenerator.nombreFile();
		String albumnameedit = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminAlbum admin = home.selectAdminAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.editAlbum(albumname, true, albumnameedit);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertTrue(admin.isAlbumInList(albumnameedit));
		assertFalse(admin.isAlbumInList(albumname));
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(home.getAlbumNameMainContainer(albumnameedit));
		assertTrue(home.getAlbumNameSideBar(albumnameedit));
		
		assertFalse(home.getAlbumNameMainContainer(albumname));
		assertFalse(home.getAlbumNameSideBar(albumname));
	}
	
	@Test
	public void test_edit_album_admin_empty() {
		String albumname = DataGenerator.nombreFile();
		String albumnameedit = "";
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminAlbum admin = home.selectAdminAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.editAlbum(albumname, true, albumnameedit);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El título del álbum es requerido", admin.getFieldErrorMsj());
		assertEquals("Ocurrió un error al editar el álbum", admin.getErrorMsj());
	}
	
	@Test
	public void test_edit_album_admin_max_char() {
		String albumname = DataGenerator.nombreFile();
		String albumnameedit = "";
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminAlbum admin = home.selectAdminAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.editAlbum(albumname, true, albumnameedit);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El título supera el máximo de 80 caracteres", admin.getFieldErrorMsj());
		assertEquals("Ocurrió un error al editar el álbum", admin.getErrorMsj());
	}
	
	@Test
	public void test_edit_album_admin_exist() {
		String albumname = DataGenerator.nombreFile();
		String albumname2 = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAlbum(albumname2, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminAlbum admin = home.selectAdminAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.editAlbum(albumname, true, albumname2);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre del album ya existe", admin.getErrorMsj());
	}
	
	@Test
	public void test_edit_album_admin_cancel() {
		String albumname = DataGenerator.nombreFile();
		String albumnameedit = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminAlbum admin = home.selectAdminAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.editAlbum(albumname, false, albumnameedit);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertFalse(admin.isAlbumInList(albumnameedit));
		assertTrue(admin.isAlbumInList(albumname));
	}
	
	@Test
	public void test_edit_album_admin_special_char() {
		String albumname = DataGenerator.nombreFile();
		String albumnameedit = StringUtils.getCaracteresEspeciales();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AdminAlbum admin = home.selectAdminAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.editAlbum(albumname, true, albumnameedit);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		admin.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		assertTrue(admin.isAlbumInList(albumnameedit));
		assertFalse(admin.isAlbumInList(albumname));
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(home.getAlbumNameMainContainer(albumnameedit));
		assertTrue(home.getAlbumNameSideBar(albumnameedit));
		
		assertFalse(home.getAlbumNameMainContainer(albumname));
		assertFalse(home.getAlbumNameSideBar(albumname));
	}
	
	@Test
	public void test_edit_album_detail_text() {
		String albumname = DataGenerator.nombreFile();
				
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		EditAlbum edit = detail.selectEditAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(albumname, edit.getAlbumName());	
	}
	
	@Test
	public void test_edit_album_detail() {
		String albumname = DataGenerator.nombreFile();
		String albumnameedit = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		EditAlbum edit = detail.selectEditAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		detail = edit.editAlbum(albumnameedit, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(albumnameedit, detail.getAlbumTitle());
	}
	
	@Test
	public void test_edit_album_special_char() {
		String albumname = DataGenerator.nombreFile();
		String albumnameedit = StringUtils.getCaracteresEspeciales();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		EditAlbum edit = detail.selectEditAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		detail = edit.editAlbum(albumnameedit, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(albumnameedit, detail.getAlbumTitle());
	}
	
	@Test
	public void test_edit_album_detail_empty() {
		String albumname = DataGenerator.nombreFile();
		String albumnameedit = "";
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		EditAlbum edit = detail.selectEditAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		edit.editAlbum(albumnameedit, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El título del álbum es requerido", edit.getErrorMsjAlbum());
	}
	
	@Test
	public void test_edit_album_detail_existe() {
		String albumname = DataGenerator.nombreFile();
		String albumname2 = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAlbum(albumname2, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		EditAlbum edit = detail.selectEditAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		edit.editAlbum(albumname2, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El nombre del album ya existe", edit.getUploadErrorMsj());
	}
	
	@Test
	public void test_edit_album_max_char() {
		String albumname = DataGenerator.nombreFile();
		String albumnameedit = StringUtils.getTextoLargo();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		EditAlbum edit = detail.selectEditAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		edit.editAlbum(albumnameedit, true);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals("El título supera el máximo de 80 caracteres", edit.getErrorMsjAlbum());
	}
	
	@Test
	public void test_edit_album_cancel() {
		String albumname = DataGenerator.nombreFile();
		String albumnameedit = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		EditAlbum edit = detail.selectEditAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		detail = edit.editAlbum(albumnameedit, false);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		driver.switchTo().alert().accept();
		
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertTrue(home.getAlbumNameMainContainer(albumnameedit));
		assertTrue(home.getAlbumNameSideBar(albumnameedit));
		
		assertFalse(home.getAlbumNameMainContainer(albumname));
		assertFalse(home.getAlbumNameSideBar(albumname));
	}
	
	@Test
	public void test_edit_album_basic_user() {
		String albumname = DataGenerator.nombreFile();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		EditAlbum edit = detail.selectEditAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		String urledit = edit.getURL();
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		
		loginBasicUser(driver);
		
		driver.get(urledit);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertNotEquals(driver.getCurrentUrl(), urledit);
	}
	
	private void createAlbum(String albumname, HomeGalery home) {
		NewAlbumOverlay albumover = home.selectNewAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover.createAlbum(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
	}
	
	@After
	public void tearDown() {
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
	}

}
