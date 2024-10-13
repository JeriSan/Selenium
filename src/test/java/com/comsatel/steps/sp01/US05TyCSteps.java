package com.comsatel.steps.sp01;

import static com.comsatel.RunnerTest.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;

public class US05TyCSteps {
	@Given("^ingresar credenciales validas$")
    public void ingresarCredencialesValidas() throws Throwable {
    	ingresarCredenciales("demodemo@gmail.com","cp%vPiKB#2l$");
    }
	
	 private void ingresarCredenciales(String strUsuario,String strClave) throws Throwable{
    	 WebElement weUsuario = driver.findElement(By.id("desUsuario"));
    	 weUsuario.sendKeys(strUsuario);
 	     Thread.sleep(500);
 	
 	     WebElement weClave = driver.findElement(By.id("desClave"));
 	     weClave.sendKeys(strClave);
 	     Thread.sleep(2000);
    }
	 
	@Given("^verificar panel tyc$")
    public void verificarTyC() throws Throwable {
        String strMensajeError = null;
        String strTitulo = null;
    	try {
    		strMensajeError = "El proceso no llevó a pagina de TYC correctamente.";
    		strTitulo = "Términos y condiciones";
            WebElement weTitulo = driver.findElement(By.className("contenedor-titulo"));
            if(!strTitulo.equals(weTitulo.getText())) {
            	throw new RuntimeException(strMensajeError);
            }
    	}catch(Exception e) {
    		throw new RuntimeException(strMensajeError);
        }	
    }
	 
    @Given("^verificar si boton Aceptar de tyc esta habilitado$")
    public void verificarSiBotonAceptarEstaHabilitado() throws Throwable {
        WebElement weAceptar = driver.findElement(By.id("btn-aceptar-tyc")).findElement(By.tagName("button"));
        if (!weAceptar.isEnabled()) {
            throw new RuntimeException("El botón 'Aceptar' no está habilitado.");
        }
        String cursorStyle = weAceptar.getCssValue("cursor");
        if (!"pointer".equals(cursorStyle)) {
            throw new RuntimeException("El cursor sobre el botón 'Aceptar' no permite Continuar.");
        }
    }
}
