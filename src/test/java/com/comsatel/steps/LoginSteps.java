package com.comsatel.steps;

import io.cucumber.java.en.Given;

import static com.comsatel.RunnerTest.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginSteps {

//    public static final String LOGIN_URL = "http://192.168.1.52:9090/auth/realms/Apps-TEMP/account";
    public static final String LOGIN_URL = "http://localhost:4200";
    
    @Given("^ir a la pagina de login$")
    public void irPaginaLogin() throws Throwable {
        driver.get(LOGIN_URL);
        Thread.sleep(2000);
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
}
