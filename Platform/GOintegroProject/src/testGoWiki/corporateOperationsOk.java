package testGoWiki;

import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CorporateOperationsOk {
	
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
	  public void corporateOperations() throws Exception {
		    // Inicia el test
		    // Se ingresan credenciales
		    driver.get(baseUrl + "/");
		    driver.findElement(By.id("_username")).clear();
		    driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
		    driver.findElement(By.id("_password")).clear();
		    driver.findElement(By.id("_password")).sendKeys("coquito25");
		    driver.findElement(By.name("_submit")).click();
	    driver.get(baseUrl + "/app/articles/5669");
	    driver.findElement(By.cssSelector("a[title=\"Corporate Operations\"] > span.app-name")).click();
	    String capturedText = new String(driver.findElement(By.cssSelector(".titleEditable>h3>p")).getText());

	    //Se setea el texto de validaci�n esperado
	    String expectedText = "Descripci�n general";
	    
	    // Se valida que el texto es el esperado
	    if(capturedText.equals(expectedText)) {
	    	System.out.println("corporateOperationsOk  [OK]");
	    }
	    else {
	    	System.out.println("corporateOperationsOk  [FAIL]");
	    }
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
