package testSearch;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NoResultsSearch {
	
	  private WebDriver driver;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://platform.p2-test.gointegro.net/";
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
	    driver.findElement(By.id("search-text")).sendKeys("textoNoExiste");
	    driver.findElement(By.id("search-button")).click();
	    
	    // Se captura el texto de la validación
	    String capturedText = new String(driver.findElement(By.xpath(".//*[@id='middle-section']/section[1]/section[2]/section")).getText());
	    
	    // Se setea el texto de validación esperado
	    String expectedText = "Sin resultados";
	    
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
