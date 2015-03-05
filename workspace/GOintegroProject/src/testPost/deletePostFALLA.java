package testPost;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class deletePostFALLA {
	
	  private WebDriver driver;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {

	    driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "/Users/soledadcoronel/Downloads/chromedriver");

		//ChromeDriver driver = new ChromeDriver();
	    baseUrl = "http://platform.p2-test.gointegro.net/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	  }

	  @Test
	  public void testDeletePost() throws Exception {

	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("_username")).clear();
	    driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
	    driver.findElement(By.id("_password")).clear();
	    driver.findElement(By.id("_password")).sendKeys("coquito25");
	    driver.findElement(By.name("_submit")).click();

	    //btn btn-primary confirm-delete
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(".//*[@id='feed-item-post-30853']/div/span/div[1]/div[1]/span[6]/a")).click();

	    Thread.sleep(5000);
	    driver.findElement(By.xpath("html/body/div[5]/div[3]/button[1]")).click();
	    
	    //String capturedText = new String (driver.findElement(By.cssSelector(".modal.hide.fade.delete-dialog.in")).getText());
	    //System.out.println(capturedText);
	    //driver.findElement(By.cssSelector(".close")).click();
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
}

//.//*[@id='feed-item-post-30853']/div/span/div[1]/div[1]/span[6]/a
