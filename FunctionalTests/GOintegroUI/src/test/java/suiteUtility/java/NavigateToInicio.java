package suiteUtility.java;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NavigateToInicio extends suiteUtility.java.LoginAutomation1{
    
    
    @Test 
    
    public void goToCatalogoPage() throws Exception { 
                  
       
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
         
         driver.findElement(By.cssSelector("#environments li:nth-child(1) a[data-bindattr-972='972']")).click();
                
         
         WebDriverWait wait = new WebDriverWait(driver, 10);
         WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".app-title")));
         driver.findElement(By.cssSelector(".app-title"));
         
    }    
  	  
}


