package com.comsatel.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.comsatel.RunnerTest.driver;

public class RegistroSteps {

    @Given("^Llenar formulario con espacios en blanco al inicio y al final de cada campo$")
    public void llenarFormularioConEspaciosAlInicioYFinal() throws Throwable {
        WebElement desNombreElement = driver.findElement(By.id("nombres"));
        desNombreElement.sendKeys(" Hans ");

        WebElement desApellidoElement = driver.findElement(By.id("apellidos"));
        desApellidoElement.sendKeys(" Llanos ");

        WebElement idIdiomaElement = driver.findElement(By.id("codIdioma"));
        idIdiomaElement.click();

        Select idIdiomaSelect = new Select(idIdiomaElement);
        idIdiomaSelect.getOptions().get(1).click();

        WebElement numTelefonoElement = driver.findElement(By.id("telefono"));
        numTelefonoElement.sendKeys(" 111111111 ");

        WebElement fecNacimientoElement = driver.findElement(By.id("fechaNacimiento"));
        fecNacimientoElement.sendKeys("01/01/2024");

        WebElement desCorreoElement = driver.findElement(By.id("correo"));
        desCorreoElement.sendKeys(" a@a.com ");

        Thread.sleep(3000);
    }

    @Given("^llenamos formulario de nueva cuenta$")
    public void llenamosFormularioDeNuevaCuenta() throws Throwable {
        WebElement desNombreElement = driver.findElement(By.id("nombres"));
        desNombreElement.sendKeys("Hans");
        Thread.sleep(500);
        
        WebElement desApellidoElement = driver.findElement(By.id("apellidos"));
        desApellidoElement.sendKeys("Llanos Llanos");
        Thread.sleep(500);
        
        WebElement idIdiomaElement = driver.findElement(By.id("codIdioma"));
        idIdiomaElement.click();
        Thread.sleep(500);
        
        Select idIdiomaSelect = new Select(idIdiomaElement);
        idIdiomaSelect.getOptions().get(1).click();
        Thread.sleep(500);
        /*
        WebElement idIdiomaElement = driver.findElement(By.id("idIdioma"));
        idIdiomaElement.click();
        Thread.sleep(3000);
        Select idIdiomaSelect = new Select(idIdiomaElement);
        idIdiomaSelect.selectByVisibleText("Español");
        */

        WebElement numTelefonoElement = driver.findElement(By.id("telefono"));
        numTelefonoElement.sendKeys("111111111");
        Thread.sleep(500);
        
        WebElement fecNacimientoElement = driver.findElement(By.id("fechaNacimiento"));
        fecNacimientoElement.sendKeys("01/01/2024");
        Thread.sleep(500);
        
        WebElement desCorreoElement = driver.findElement(By.id("correo"));
        desCorreoElement.sendKeys("a@a.com");
        Thread.sleep(2000);
    }
    
    @Given("^Llenar formulario ingresando un correo que no cumple con la estructura$")
    public void llenarFormularioConCorreoMalaEstructura() throws Throwable {
        WebElement desNombreElement = driver.findElement(By.id("nombres"));
        desNombreElement.sendKeys("Hans");

        WebElement desApellidoElement = driver.findElement(By.id("apellidos"));
        desApellidoElement.sendKeys("Llanos");

        WebElement idIdiomaElement = driver.findElement(By.id("codIdioma"));
        idIdiomaElement.click();

        Select idIdiomaSelect = new Select(idIdiomaElement);
        idIdiomaSelect.getOptions().get(1).click();

        WebElement numTelefonoElement = driver.findElement(By.id("telefono"));
        numTelefonoElement.sendKeys("111111111");

        WebElement fecNacimientoElement = driver.findElement(By.id("fechaNacimiento"));
        fecNacimientoElement.sendKeys("01/01/2024");

        WebElement desCorreoElement = driver.findElement(By.id("correo"));
        desCorreoElement.sendKeys("aacom");

        Thread.sleep(3000);
    }
    
    @Given("^ingresar nueva cuenta valida$")
    public void ingresarNuevaCuentaValida() throws Throwable {
        WebElement desNombreElement = driver.findElement(By.id("nombres"));
        desNombreElement.sendKeys("Hans");
        Thread.sleep(500);
        
        WebElement desApellidoElement = driver.findElement(By.id("apellidos"));
        desApellidoElement.sendKeys("Llanos Llanos");
        Thread.sleep(500);
        
        WebElement idIdiomaElement = driver.findElement(By.id("codIdioma"));
        idIdiomaElement.click();
        Thread.sleep(500);
        
        Select idIdiomaSelect = new Select(idIdiomaElement);
        idIdiomaSelect.getOptions().get(1).click();
        Thread.sleep(500);
        /*
        WebElement idIdiomaElement = driver.findElement(By.id("idIdioma"));
        idIdiomaElement.click();
        Thread.sleep(3000);
        Select idIdiomaSelect = new Select(idIdiomaElement);
        idIdiomaSelect.selectByVisibleText("Español");
        */

        WebElement numTelefonoElement = driver.findElement(By.id("telefono"));
        numTelefonoElement.sendKeys("111111111");
        Thread.sleep(500);
        
        WebElement fecNacimientoElement = driver.findElement(By.id("fechaNacimiento"));
        fecNacimientoElement.sendKeys("01/01/2024");
        Thread.sleep(500);
        
        WebElement desCorreoElement = driver.findElement(By.id("correo"));
        desCorreoElement.sendKeys("a07@a.com");
        Thread.sleep(2000);
    }
}
