package Go5.Automation;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;


public class LoginTest extends CommonFunctions{


	 @BeforeTest // call function to open the browser and load url
	 public void setup (){
	   openSiteLogin();
	 }
	
	 @AfterTest // call function to close browser 
		
		public void teardown(){
			closeBrowser();
		}

	
	@Test
	public void login() throws Exception { 
	
 	     
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.id("signInIdentification")).sendKeys("marina.touceda@gointegro.com");
		driver.findElement(By.id("signInPassword")).sendKeys("Fake1234");
        driver.findElement(By.cssSelector(".primary")).click();
 
	}

	
}
