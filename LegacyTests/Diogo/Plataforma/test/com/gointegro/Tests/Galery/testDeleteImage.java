package com.gointegro.Tests.Galery;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gointegro.Helpers.ConfigElements;
import com.gointegro.Pages.Galery.AlbumDetail;
import com.gointegro.Pages.Galery.DeleteOverlay;
import com.gointegro.Pages.Galery.EditAlbum;
import com.gointegro.Pages.Galery.HomeGalery;
import com.gointegro.Pages.Galery.ImageDetail;
import com.gointegro.Pages.Galery.NewAlbumOverlay;
import com.gointegro.Pages.Galery.UploadContent;
import com.gointegro.Pages.Platform.Logout;
import com.gointegro.Util.DataGenerator;
import com.gointegro.Util.FileDownloader;
import com.gointegro.Util.WaitTool;

public class testDeleteImage extends AllTestsGalery {
	
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
	public void test_delete_img_detail() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, false);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ImageDetail img = detail.selectLastPictureInAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay delete = img.selectDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		delete.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(0, detail.albumsize());
	}
	
	@Test
	public void test_delete_img_detail_cancel() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, false);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ImageDetail img = detail.selectLastPictureInAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay delete = img.selectDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		delete.cancelDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(1, detail.albumsize());
	}
	
	@Test
	public void test_delete_img_detail_2_pictures() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, true);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		

		
		String urlalbum = detail.getURL();
		
		ImageDetail img = detail.selectLastPictureInAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay delete = img.selectDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		delete.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		driver.get(urlalbum);
		
		assertEquals(1, detail.albumsize());
	}
	
	@Test
	public void test_delete_img_access_url() {
		FileDownloader downloadTestFile = new FileDownloader(driver);
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		String downloadedFileAbsoluteLocation = null;
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, false);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ImageDetail img = detail.selectLastPictureInAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		try {
			downloadedFileAbsoluteLocation = img.getSrcImg();
		} catch (Exception e) {
			
		}
		
		DeleteOverlay delete = img.selectDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		delete.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		Logout logout = PageFactory.initElements(driver, Logout.class);
		logout.open();
		
		FirefoxBinary firefox = new FirefoxBinary();
		firefox.setEnvironmentProperty("DISPLAY", ":0");
		WebDriver _driver = new FirefoxDriver(firefox,null);
		
		login(_driver);

		_driver.get(downloadedFileAbsoluteLocation);
		
		assertNotEquals(200, downloadTestFile.getHTTPStatusOfLastDownloadAttempt());
		
		_driver.close();
	}
	
	@Test
	public void test_delete_img_edit_album() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, false);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditAlbum edit = detail.selectEditAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay del = edit.selectDeletePicture();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		del.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(0, detail.albumsize());
	}
	
	@Test
	public void test_delete_img_edit_album_cancel() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, false);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditAlbum edit = detail.selectEditAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay del = edit.selectDeletePicture();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		del.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		edit.selectCancel();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(1, detail.albumsize());
	}
	
	@Test
	public void test_delete_img_edit_album_cancel_overlay() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, false);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditAlbum edit = detail.selectEditAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay del = edit.selectDeletePicture();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		del.cancelDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(1, detail.albumsize());
	}
	
	@Test
	public void test_delete_img_edit_album_2_pictures() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileImagen();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, true);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		EditAlbum edit = detail.selectEditAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		DeleteOverlay del = edit.selectDeletePicture();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		del.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		edit.selectSave();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(1, detail.albumsize());
	}
	
	@Test
	public void test_delete_video_detail() {
		String albumname = DataGenerator.nombreFile();
		String testfile = ConfigElements.getFileMP4Video();
		
		login(driver);
		
		HomeGalery home = PageFactory.initElements(driver, HomeGalery.class);
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		createAddFile(testfile, albumname, home, false);
		
		home.open();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		AlbumDetail detail = home.selectAlbumSideBar(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		ImageDetail img = detail.selectLastPictureInAlbum();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		DeleteOverlay delete = img.selectDeleteVideo();
		WaitTool.waitForJQueryProcessing(driver, 10);
		
		delete.confirmDelete();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		assertEquals(0, detail.albumsize());
	}
	
	private void createAddFile(String testfile, String albumname, HomeGalery home, boolean otherfile) {
		createAlbum(albumname, home);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.uploadFile(testfile);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		UploadContent upload = PageFactory.initElements(driver, UploadContent.class);
		upload.selectAlbumInList(albumname);
		if (otherfile)
			upload.setOtherFile(testfile);
		upload.selectSave();
	}
	
	private void createAlbum(String albumname, HomeGalery home) {
		NewAlbumOverlay albumover = home.selectNewAlbum();
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		albumover.createAlbum(albumname);
		WaitTool.waitForJQueryProcessing(driver, 5);
		
		home.open();
	}
	
	private boolean isAlertPresent(){
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
		
		if(isAlertPresent()) {
			driver.switchTo().alert();
	        driver.switchTo().alert().accept();
	        driver.switchTo().defaultContent();
		}
	}

}
