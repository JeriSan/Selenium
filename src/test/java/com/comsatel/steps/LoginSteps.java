package com.comsatel.steps;

import io.cucumber.java.en.Given;

import static com.comsatel.RunnerTest.driver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps {

	//public static final String LOGIN_URL = "http://192.168.1.52:9090/auth/realms/Apps-TEMP/account";
    //public static final String LOGIN_URL = "http://localhost:4200";
    public static final String LOGIN_URL = "https://cl2webportal.qa.comsatel.com.pe/";

    @Given("^ir a la pagina de login$")
    public void irPaginaLogin() throws Throwable {
    	String strMensajeError = "Error al cargar la pagina de login.";
        System.out.println("Cargando Url: "+ LOGIN_URL);
    	driver.get(LOGIN_URL);
    	try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("desUsuario")));
    	}catch(Exception e) {
    		throw new RuntimeException(strMensajeError);
        }	
    }

    @Given("^click al boton registrar$")
    public void clickAlBotonRegistrar() throws Throwable {
    	String strMensajeError = "Error al dar click al boton Registrar.";
    	try {
	    	WebElement weLinkRegistrar = driver.findElement(By.className("link-iniciar-sesion"));
	    	weLinkRegistrar.click();
    	}catch(Exception e) {
    		throw new RuntimeException(strMensajeError);
        }	
    }
    
    @Given("^click al boton ingresar$")
    public void clickAlBotonIngresar() throws Throwable {
    	String strMensajeError = "Error al dar click al boton Ingresar.";
    	try {
    		WebElement weBoton = driver.findElement(By.xpath("//button[text()='Ingresar']"));
    		weBoton.click();
    	}catch(Exception e) {
    		throw new RuntimeException(strMensajeError);
        }	
    }
    
	@Given("^ingresar credenciales validas abdiel$")
    public void ingresarCredencialesValidasAbdiel() throws Throwable {
    	ingresarCredenciales("Abdiel_rath71@hotmail.com","welcome1");
    }
	
	@Given("^ingresar credenciales validas hans$")
    public void ingresarCredencialesValidasHans() throws Throwable {
    	ingresarCredenciales("hans.llanos@gmail.com","Hans123x*");
    }
	
	 private void ingresarCredenciales(String strUsuario,String strClave) throws Throwable{
    	 WebElement weUsuario = driver.findElement(By.id("desUsuario"));
    	 weUsuario.sendKeys(strUsuario);
 	     Thread.sleep(500);
 	
 	     WebElement weClave = driver.findElement(By.id("desClave"));
 	     weClave.sendKeys(strClave);
 	     Thread.sleep(2000);
    }

}
