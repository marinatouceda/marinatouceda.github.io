package testSearch;


import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class basicSearch {

	  private WebDriver driver;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "https://goc.gointegro.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testBasicSearch() throws Exception {
	    driver.get(baseUrl + "/");		
	    driver.findElement(By.id("_username")).clear();
	    driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
	    driver.findElement(By.id("_password")).clear();
	    driver.findElement(By.id("_password")).sendKeys("coquito25");
	    driver.findElement(By.name("_submit")).click();
	    driver.findElement(By.id("search-text")).clear();
	    driver.findElement(By.id("search-text")).sendKeys("gointegro");
	    driver.findElement(By.id("search-button")).click();
	    
	    // Se captura el texto de la validaci�n
	    String capturedText = new String(driver.findElement(By.xpath(".//*[@id='searchable-data']/span[1]")).getText());
	    // Se setea el texto de validaci�n esperado
	    String expectedText = "Resultado de b�squeda";
	    
	    // Se valida que el texto es el esperado
	    if(capturedText.equals(expectedText)) {
	    	System.out.println("basicSearch  [OK]");
	    }
	    else 
	    	System.out.println("basicSearch  [FAIL]");
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


