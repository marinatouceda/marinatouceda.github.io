package Go5.Automation;


import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class CreatePlatformTest extends SignUp{

	private String urlToken;

	 @BeforeTest // call function to open the browser and load url
	 
	  public void openPlatform() throws Exception{
		urlToken=this.signup();
	// urlToken = "http://signup.qa.go5.gointegro.net/es/createPlatform/token/59nc8ko1r1oo4k0404kwgcc8ko8s4wgog4sck4kgc08owcsc84";
	  driver.get(urlToken);
	 }
	 
	   
	
	 @AfterTest // call function to close browser 
		
/*		public void teardown(){
			closeBrowser();
		}

	*/
	@Test
	public void registration() throws Exception { 
		
			  
	 	   
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("CreateAccount_company")).sendKeys("Automation");
		driver.findElement(By.id("CreateAccount_subdomain")).sendKeys("Site1");
		driver.findElement(By.id("CreateAccount_qty_employees_label")).sendKeys("0-50");
		driver.findElement(By.id("CreateAccount_name_label")).sendKeys("FakeName");
		driver.findElement(By.id("CreateAccount_last_name_label")).sendKeys("FakeSurname");
		driver.findElement(By.id("CreateAccount_password_label")).sendKeys("Fake1234");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("CreateAccount_timezone_label")).sendKeys("(GMT-10:00)Hawaii");
		driver.findElement(By.id("CreateAccount_terms_and_conditions")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("submit_button")).click();
		
		
		
        
		
 
	}

	
}
