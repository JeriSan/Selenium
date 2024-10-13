package com.comsatel.steps.sp01;

import io.cucumber.java.en.Given;

import static org.junit.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;

import static com.comsatel.RunnerTest.driver;

public class US02RegistroSteps {
	
	@Given("^verificar si boton siguiente de nueva cuenta es habilitado$")
    public void verificarSiBotonSiguienteEsHabilitado() throws Throwable {
        WebElement siguienteElement = driver.findElement(By.xpath("//button[@onclick=\"validarCambioPantalla('.registro-container')\"]"));
        if (!siguienteElement.isEnabled()) {
            throw new RuntimeException("El botón 'Next' no está habilitado.");
        }
        String cursorStyle = siguienteElement.getCssValue("cursor");
        if (!"pointer".equals(cursorStyle)) {
            throw new RuntimeException("El cursor sobre el botón 'Next' no permite Continuar.");
        }
    }
	
	@Given("^verificar si boton siguiente de nueva cuenta es deshabilitado$")
    public void verificarSiBotonSiguienteEsDeshabilitado() throws Throwable {
        WebElement siguienteElement = driver.findElement(By.xpath("//button[@onclick=\"validarCambioPantalla('.registro-container')\"]"));
        String cursorStyle = siguienteElement.getCssValue("cursor");
        if ("pointer".equals(cursorStyle)) {
            throw new RuntimeException("El cursor sobre el botón 'Next' permite Continuar.");
        }
    }
	
    @Given("^click boton siguiente de nueva cuenta$")
    public void clickAlBotonSiguienteDeNuevaCuenta() throws Throwable {
    	String strMensajeError = "Error al dar click al boton Next.";
    	try {
	    	WebElement siguienteElement = driver.findElement(By.xpath("//button[@onclick=\"validarCambioPantalla('.registro-container')\"]"));
	        siguienteElement.click();
    	}catch(Exception e) {
    		throw new RuntimeException(strMensajeError);
        }
//    	Thread.sleep(500);
//        WebElement nuevaClaveInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nuevaClave")));
//        if (nuevaClaveInput == null) {
//            throw new RuntimeException(strMensajeError);
//        }
    }
    
    @Given("^ingresar campos Nueva cuenta con espacios en blanco al inicio y al final$")
    public void ingresarNuevaCuentaConEspaciosAlInicioYFinal() throws Throwable {
    	ingresarNuevaCuenta(" Hans "," Llanos Quiroz "," 976543333 ","01/02/1994"," a@a.com ");
    }
    
    @Given("^verificar campos Nueva cuenta sin espacios en blanco al inicio y al final$")
    public void verificarNuevaCuentaSinEspaciosEnBlanco() {
    	String [] strArrayIdPoliticas = {"nombres","apellidos","telefono","correo"};
    	for (String strId : strArrayIdPoliticas) {
	        WebElement element = driver.findElement(By.id(strId));
	        String fieldValue = element.getAttribute("value");
	        if(fieldValue != null) {
	        	assertFalse("El campo " + strId + " tiene espacios en blanco al inicio o al final", 
	                     fieldValue.startsWith(" ") || fieldValue.endsWith(" "));
	        }else {
	        	System.out.println("revisar el elemento: " + strId + " tiene problemas para obtener valor");
	        }
    	}
    }
    		 
    @Given("^ingresar campos Nueva cuenta sin todos los campos obligatorios$")
    public void ingresarNuevaCuentaSinTodosCamposObligatorios() throws Throwable {
    	ingresarNuevaCuenta("","","","01/02/1994","");
    }

    @Given("^ingresar campos Nueva cuenta con correo nuevo$")
    public void ingresarNuevaCuentaConCorreoNuevo() throws Throwable {
    	ingresarNuevaCuenta("Hans","Llanos Quiroz","977462884","01/02/1994","hllanos0917@gmail.com");
    }
    
    @Given("^ingresar campos Nueva cuenta con correo existente$")
    public void ingresarNuevaCuentaConCorreoExistente() throws Throwable {
    	ingresarNuevaCuenta("Hans","Llanos Quiroz","977462884","01/02/1994","Abdiel_rath71@hotmail.com");
    }
    
    @Given("^ingresar campos Nueva cuenta con correo no cumple estructura$")
    public void ingresarNuevaCuentaConCorreoNoCumpleEstructura() throws Throwable {
    	ingresarNuevaCuenta("Hans","Llanos Quiroz","977462884","01/02/1994","aacom");
    }
    
    @Given("^ingresar campos Nueva cuenta con celular invalido$")
    public void ingresarNuevaCuentaConCelularInvalido() throws Throwable {
    	ingresarNuevaCuenta("Hans","Llanos Quiroz","1234abc","01/02/1994","adminqa@comsatel.com.pe");
    }

    @Given("^Registro con cuenta google con un correo no existente$")
    public void llenamosFormularioDeNuevaCuenta() throws Throwable {
        System.out.println("llenamosFormularioDeNuevaCuenta");
    }
    
    @Given("^ingresar nueva cuenta valida$")
    public void ingresarNuevaCuentaValida() throws Throwable {
    	//TODO automatizar el valor de 09171 para hans09171@a.com
    	ingresarNuevaCuenta("Hans","Llanos Llanos","111111111","01/01/2004","hans09174@a.com");
	}
    
    private void ingresarNuevaCuenta(String strNombre,String strApellidos,String strTelefono,String strFechaNacimiento,String strCorreo) throws Throwable{
    	 WebElement desNombreElement = driver.findElement(By.id("nombres"));
 	    desNombreElement.sendKeys(strNombre);
 	    Thread.sleep(500);
 	
 	    WebElement desApellidoElement = driver.findElement(By.id("apellidos"));
 	    desApellidoElement.sendKeys(strApellidos);
 	    Thread.sleep(500);
 	
 	    WebElement idIdiomaElement = driver.findElement(By.id("codIdioma"));
 	    idIdiomaElement.click();
 	    Thread.sleep(500);
 	
 	    WebElement primerIdioma = driver.findElement(By.xpath("//div[@class='contenedor-selector-idioma']/div[@data-valor='es']"));
 	    primerIdioma.click();
 	    //Select idIdiomaSelect = new Select(idIdiomaElement);
 	    //idIdiomaSelect.getOptions().get(1).click();
 	    Thread.sleep(500);
 	
 	    WebElement numTelefonoElement = driver.findElement(By.id("telefono"));
 	    numTelefonoElement.sendKeys(strTelefono);
 	    Thread.sleep(500);
 	
 	    WebElement fecNacimientoElement = driver.findElement(By.id("fechaNacimiento"));
 	    fecNacimientoElement.sendKeys(strFechaNacimiento);
 	    Thread.sleep(500);
 	
 	    WebElement desCorreoElement = driver.findElement(By.id("correo"));
 	    desCorreoElement.sendKeys(strCorreo);
 	    
 	    desNombreElement.click();
 	    Thread.sleep(2000);
    }
}
