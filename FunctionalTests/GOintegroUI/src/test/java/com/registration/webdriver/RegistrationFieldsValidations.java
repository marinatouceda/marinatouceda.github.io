package com.registration.webdriver;

/**
 * Created by soledad on 13/08/15.
 */

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationFieldsValidations {

    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod
	public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://goc.p2-stage.gointegro.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testRegistrationCancel() throws Exception {
        // Iniciando el test
        driver.get(baseUrl + "/auth/signin");

        // Se setea idioma español
        driver.findElement(By.xpath("//form[@id='login-form']/div[3]/div/button")).click();
        driver.findElement(By.linkText("Español")).click();

        driver.findElement(By.id("signupButton")).click();

        // Se ingresan los datos del usuario
        driver.findElement(By.id("name")).sendKeys("firstNameUser");
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys("surnameUser");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("mailUser@gointegro.com");
        //driver.findElement(By.id("document")).clear();
        //driver.findElement(By.id("document")).sendKeys("25123456");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("integro1234");
        driver.findElement(By.id("repeatPassword")).clear();
        driver.findElement(By.id("repeatPassword")).sendKeys("integro1234");
        new Select(driver.findElement(By.id("birthdate-day"))).selectByVisibleText("1");
        new Select(driver.findElement(By.id("birthdate-month"))).selectByVisibleText("Enero");
        new Select(driver.findElement(By.id("birthdate-year"))).selectByVisibleText("1940");
        driver.findElement(By.id("gender-1")).click();
        driver.findElement(By.id("termsAndConditions")).click();
        driver.findElement(By.id("cancelRegistration")).click();


        Thread.sleep(1000);
        String capturedText = new String(driver.findElement(By.id("signupButton")).getText());


        //Se setea el texto de validación esperado
        String expectedText = "Registrarme";

        // Se valida que el texto es el esperado
        if (capturedText.equals(expectedText)) {
            System.out.println("testRegistrationCancel  [OK]");
        } else {
            System.out.println("testRegistrationCancel  [FAIL]");
        }
    }

    @Test
    public void testRegistrationEmptyEmail() throws Exception {
        // Iniciando el test
        driver.get(baseUrl + "/auth/signin");

        // Se setea idioma español
        driver.findElement(By.xpath("//form[@id='login-form']/div[3]/div/button")).click();
        driver.findElement(By.linkText("Español")).click();

        driver.findElement(By.id("signupButton")).click();

        // Se ingresan los datos del usuario
        driver.findElement(By.id("name")).sendKeys("firstNameUser");
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys("surnameUser");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("");
        //driver.findElement(By.id("document")).clear();
        //driver.findElement(By.id("document")).sendKeys("25123456");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("integro1234");
        driver.findElement(By.id("repeatPassword")).clear();
        driver.findElement(By.id("repeatPassword")).sendKeys("integro1234");
        new Select(driver.findElement(By.id("birthdate-day"))).selectByVisibleText("1");
        new Select(driver.findElement(By.id("birthdate-month"))).selectByVisibleText("Enero");
        new Select(driver.findElement(By.id("birthdate-year"))).selectByVisibleText("1940");
        driver.findElement(By.id("gender-1")).click();
        driver.findElement(By.id("termsAndConditions")).click();
        driver.findElement(By.id("submitRegistration")).click();


        Thread.sleep(1000);
        String capturedText = new String(driver.findElement(By.id("emailError")).getText());

        //Se setea el texto de validación esperado
        String expectedText = "El correo electrónico no puede estar vacío.";

        // Se valida que el texto es el esperado
        if (capturedText.equals(expectedText)) {
            System.out.println("testRegistrationEmptyEmail  [OK]");
        } else {
            System.out.println("testRegistrationEmptyEmail  [FAIL]");
        }

    }

    @Test
    public void testRegistrationEmptyName() throws Exception {
        // Iniciando el test
        driver.get(baseUrl + "/auth/signin");

        // Se setea idioma español
        driver.findElement(By.xpath("//form[@id='login-form']/div[3]/div/button")).click();
        driver.findElement(By.linkText("Español")).click();

        driver.findElement(By.id("signupButton")).click();

        // Se ingresan los datos del usuario
        driver.findElement(By.id("name")).sendKeys("");
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys("surnameUser");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("mailUser@gointegro.com");
        //driver.findElement(By.id("document")).clear();
        //driver.findElement(By.id("document")).sendKeys("25123456");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("integro1234");
        driver.findElement(By.id("repeatPassword")).clear();
        driver.findElement(By.id("repeatPassword")).sendKeys("integro1234");
        new Select(driver.findElement(By.id("birthdate-day"))).selectByVisibleText("1");
        new Select(driver.findElement(By.id("birthdate-month"))).selectByVisibleText("Enero");
        new Select(driver.findElement(By.id("birthdate-year"))).selectByVisibleText("1940");
        driver.findElement(By.id("gender-1")).click();
        driver.findElement(By.id("termsAndConditions")).click();
        driver.findElement(By.id("submitRegistration")).click();

        Thread.sleep(1000);
        String capturedText = new String(driver.findElement(By.id("nameError")).getText());

        //Se setea el texto de validación esperado
        String expectedText = "El nombre no puede estar vacío.";

        // Se valida que el texto es el esperado
        if(capturedText.equals(expectedText)) {
            System.out.println("testRegistrationEmptyName  [OK]");
        }
        else {
            System.out.println("testRegistrationEmptyName  [FAIL]");
        }
    }

    @Test
    public void testRegistrationEmptySurname() throws Exception {
        // Iniciando el test
        driver.get(baseUrl + "/auth/signin");

        // Se setea idioma español
        driver.findElement(By.xpath("//form[@id='login-form']/div[3]/div/button")).click();
        driver.findElement(By.id("signupButton")).click();

        driver.findElement(By.id("signupButton")).click();

        // Se ingresan los datos del usuario
        driver.findElement(By.id("name")).sendKeys("firstNameUser");
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys("");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("mailUser@gointegro.com");
        //driver.findElement(By.id("document")).clear();
        //driver.findElement(By.id("document")).sendKeys("25123456");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("integro1234");
        driver.findElement(By.id("repeatPassword")).clear();
        driver.findElement(By.id("repeatPassword")).sendKeys("integro1234");
        new Select(driver.findElement(By.id("birthdate-day"))).selectByVisibleText("1");
        new Select(driver.findElement(By.id("birthdate-month"))).selectByVisibleText("Enero");
        new Select(driver.findElement(By.id("birthdate-year"))).selectByVisibleText("1940");
        driver.findElement(By.id("gender-1")).click();
        driver.findElement(By.id("termsAndConditions")).click();
        driver.findElement(By.id("submitRegistration")).click();


        Thread.sleep(1000);
        String capturedText = new String(driver.findElement(By.id("surnameError")).getText());

        //Se setea el texto de validación esperado
        String expectedText = "El apellido no puede estar vacío.";

        // Se valida que el texto es el esperado
        if(capturedText.equals(expectedText)) {
            System.out.println("testRegistrationEmptySurname  [OK]");
        }
        else {
            System.out.println("testRegistrationEmptySurname  [FAIL]");
        }
    }

    @Test
    public void testRegistrationEmptyTyC() throws Exception {
        // Iniciando el test
        driver.get(baseUrl + "/auth/signin");

        // Se setea idioma español
        driver.findElement(By.xpath("//form[@id='login-form']/div[3]/div/button")).click();
        driver.findElement(By.linkText("Español")).click();

        driver.findElement(By.id("signupButton")).click();

        // Se ingresan los datos del usuario
        driver.findElement(By.id("name")).sendKeys("firstNameUser");
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys("surnameUser");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("mailUser@gointegro.com");
        //driver.findElement(By.id("document")).clear();
        //driver.findElement(By.id("document")).sendKeys("25123456");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("integro1234");
        driver.findElement(By.id("repeatPassword")).clear();
        driver.findElement(By.id("repeatPassword")).sendKeys("integro1234");
        new Select(driver.findElement(By.id("birthdate-day"))).selectByVisibleText("1");
        new Select(driver.findElement(By.id("birthdate-month"))).selectByVisibleText("Enero");
        new Select(driver.findElement(By.id("birthdate-year"))).selectByVisibleText("1940");
        driver.findElement(By.id("gender-1")).click();
        driver.findElement(By.id("termsAndConditions")).click();
        driver.findElement(By.id("submitRegistration")).click();


        Thread.sleep(1000);
        String capturedText = new String(driver.findElement(By.id("termsAndConditionsError")).getText());

        //Se setea el texto de validación esperado
        String expectedText = "Debe aceptar los términos y condiciones para poder registrarse.";

        // Se valida que el texto es el esperado
        if(capturedText.equals(expectedText)) {
            System.out.println("testRegistrationEmptyTyC  [OK]");
        }
        else {
            System.out.println("testRegistrationEmptyTyC  [FAIL]");
        }
    }

    @Test
    public void testRegistrationExistingEmail() throws Exception {
        // Iniciando el test
        driver.get(baseUrl + "/auth/signin");

        // Se setea idioma español
        driver.findElement(By.xpath("//form[@id='login-form']/div[3]/div/button")).click();
        driver.findElement(By.linkText("Español")).click();

        driver.findElement(By.id("signupButton")).click();

        // Se ingresan los datos del usuario
        driver.findElement(By.id("name")).sendKeys("firstNameUser");
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys("lastNameUser");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("mailUser@gointegro.com");
        //driver.findElement(By.id("document")).clear();
        //driver.findElement(By.id("document")).sendKeys("25123123");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("integro1234");
        driver.findElement(By.id("repeatPassword")).clear();
        driver.findElement(By.id("repeatPassword")).sendKeys("integro1234");
        new Select(driver.findElement(By.id("birthdate-day"))).selectByVisibleText("1");
        new Select(driver.findElement(By.id("birthdate-month"))).selectByVisibleText("Enero");
        new Select(driver.findElement(By.id("birthdate-year"))).selectByVisibleText("1940");
        driver.findElement(By.id("gender-1")).click();
        driver.findElement(By.id("termsAndConditions")).click();
        driver.findElement(By.id("submitRegistration")).click();


        Thread.sleep(1000);
        String capturedText = new String(driver.findElement(By.cssSelector(".alert.alert-error.alert-danger")).getText());

        // Se setea el texto de validación esperado
        String expectedText = "Los datos ingresados pertenecen a un usuario ya existente.";

        // Se valida que el texto es el esperado
        if(capturedText.equals(expectedText)) {
            System.out.println("testRegistrationExistingEmail  [OK]");
        }
        else {
            System.out.println("testRegistrationExistingEmail  [FAIL]");
        }
    }

    @Test
    public void testRegistrationPwdConfirm() throws Exception {
        // Iniciando el test
        driver.get(baseUrl + "/auth/signin");

        // Se setea idioma español
        driver.findElement(By.xpath("//form[@id='login-form']/div[3]/div/button")).click();
        driver.findElement(By.linkText("Español")).click();

        driver.findElement(By.id("signupButton")).click();

        // Se ingresan los datos del usuario
        driver.findElement(By.id("name")).sendKeys("firstNameUser");
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys("surnameUser");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("mailUser@gointegro.com");
        //driver.findElement(By.id("document")).clear();
        //driver.findElement(By.id("document")).sendKeys("25123123");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("integro1234");
        driver.findElement(By.id("repeatPassword")).clear();
        driver.findElement(By.id("repeatPassword")).sendKeys("integro123*");
        new Select(driver.findElement(By.id("birthdate-day"))).selectByVisibleText("1");
        new Select(driver.findElement(By.id("birthdate-month"))).selectByVisibleText("Enero");
        new Select(driver.findElement(By.id("birthdate-year"))).selectByVisibleText("1940");
        driver.findElement(By.id("gender-1")).click();
        driver.findElement(By.id("termsAndConditions")).click();
        driver.findElement(By.id("submitRegistration")).click();


        Thread.sleep(1000);
        String capturedText = new String(driver.findElement(By.id("repeatPasswordError")).getText());

        //Se setea el texto de validación esperado
        String expectedText = "Las contraseñas ingresadas no coinciden.";

        // Se valida que el texto es el esperado
        if(capturedText.equals(expectedText)) {
            System.out.println("testRegistrationPwdConfirm  [OK]");
        }
        else {
            System.out.println("testRegistrationPwdConfirm  [FAIL]");
        }
    }


    @AfterMethod
	public void tearDown ()throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            Assert.fail(verificationErrorString);
        }
    }
}

