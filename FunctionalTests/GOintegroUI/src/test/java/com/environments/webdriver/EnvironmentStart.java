package com.environments.webdriver;

/**
 * Created by soledad on 12/08/15.
 */

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EnvironmentStart {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://goc.p2-stage.gointegro.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testEnvironmentInicio() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.id("_username")).clear();
        driver.findElement(By.id("_username")).sendKeys("soledad.coronel@gointegro.com");
        driver.findElement(By.id("_password")).clear();
        driver.findElement(By.id("_password")).sendKeys("coquito25");
        driver.findElement(By.name("_submit")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@id='environments']/li[1]/a")).click();
        Thread.sleep(1000);
        String capturedText = new String(driver.findElement(By.xpath(".//*[@id='environmentHome']/header/span")).getText());

        //Se setea el texto de validación esperado
        String expectedText = "Inicio";

        // Se valida que el texto es el esperado
        if(capturedText.equals(expectedText)) {
            System.out.println("testEnvironmentInicio  [OK]");
        }
        else {
            System.out.println("testEnvironmentInicio  [FAIL]");
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
