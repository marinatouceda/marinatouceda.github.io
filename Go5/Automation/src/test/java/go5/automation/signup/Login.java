package go5.automation.signup;


import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Login {

	private WebDriver driver;
	Logger log = Logger.getLogger("automation");

	@BeforeClass
	 @org.testng.annotations.Parameters(value={"browser","version","platform"})
	  public void setUp(String browser, String version, String platform) throws Exception {
	    DesiredCapabilities capability = new DesiredCapabilities();
	    capability.setCapability("platform",platform);
	    capability.setCapability("browserName", browser);
	    capability.setCapability("browserVersion", version);
	    capability.setCapability("project", "GOIntegro");
	    capability.setCapability("build", "1.0");
	    capability.setCapability("debug", false);
	    driver = new RemoteWebDriver(
	    		 new URL("http://rdgointegro1:8EKsJe3iYdeXFrKc2Byt@hub.browserstack.com/wd/hub"),
	    	      capability);
	 
	  }  
	
	
	
		private void login1(String sUsername,String sPassword) throws Exception { 
		 	
	 		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 		driver.findElement(By.id("signInIdentification")).clear();
	 		driver.findElement(By.id("signInIdentification")).sendKeys(sUsername);
	 		driver.findElement(By.id("signInPassword")).clear();
	 		driver.findElement(By.id("signInPassword")).sendKeys(sPassword);
	 		 driver.findElement(By.cssSelector(".primary")).click();
	         driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  	}
	 
	 
	 @AfterClass // call function to close browser 
		
		public void teardown(){
			driver.quit();
		}

	 @Test
		public void testLoginWithBlankUser() throws Exception { 
		
		   driver.get("http://automation1.pla.qa.go5.gointegro.net/authentication/login");
			 org.apache.log4j.BasicConfigurator.configure();
	 	  	log.info("Try a login with blank user ");
			this.login1("  ","Auto1234");
			// Verify if the button is disabled 
						
			Boolean goButtonEnabled = new Boolean(driver.findElement(By.cssSelector(".primary")).isEnabled());
			if (goButtonEnabled == true){
				log.info("The login button is enabled");
			}
			else
					log.info("The login button is disbled");
		
			log.info("Login fails due to user blank");
		}
		
	 @Test
		public void testLoginWithBlankPassword() throws Exception { 
		
			
	 	  	log.info("Try a login with blank password");
	 	  	driver.get("http://automation1.pla.qa.go5.gointegro.net/authentication/login");
			this.login1("marina.touceda@gointegro.com"," ");
			// Verify if the button is disabled 
			
			Boolean goButtonEnabled = new Boolean(driver.findElement(By.cssSelector(".primary")).isEnabled());
			if (goButtonEnabled == true){
				log.info("The login button is enabled");
			}
			else
					log.info("The login button is disbled");
		
			log.info("Login fails due to user blank");
		}
	 
	 
	
	@Test
	public void testProperLogin() throws Exception { 
	
 	  	log.info("Try a login");
 	 	driver.get("http://automation1.pla.qa.go5.gointegro.net/authentication/login");
		this.login1("marina.touceda@gointegro.com","Auto1234");
		log.info("Login successfull");
 
	}
	
	
	
}

