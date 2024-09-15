package com.comsatel.steps;

import static com.comsatel.RunnerTest.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;

public class US05TyCSteps {
	@Given("^ingresar credenciales validas$")
    public void ingresarCredenciales() throws Throwable {
    	ingresarCredenciales("Abdiel_rath71@hotmail.com","welcome1");
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
