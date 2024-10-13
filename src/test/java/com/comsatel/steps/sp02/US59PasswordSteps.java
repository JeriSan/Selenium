package com.comsatel.steps.sp02;

import static com.comsatel.RunnerTest.driver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;

public class US59PasswordSteps {
    @Given("^click tab contrasena$")
    public void clickATabContrasena() throws Throwable {
    	String strMensajeError = "Error al dar click a Tab contrasena.";
    	String strId = "pn_id_32_header_action";
    	try {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strId)));
    		
    		//Actions actions = new Actions(driver);
	    	WebElement siguienteElement = driver.findElement(By.id(strId));
	    	wait.until(ExpectedConditions.elementToBeClickable(siguienteElement));
	    	siguienteElement.click();
	    	//actions.moveToElement(siguienteElement).click().perform();
	        Thread.sleep(500);
    	}catch(Exception e) {
    		throw new RuntimeException(strMensajeError,e);
        }
    }
    
    @Given("^ingresar claves sin mayuscula en perfil$")
    public void ingresarClavesSinMayuscula() throws Throwable {
    	ingresarClaves("comsa@12","comsa@12");
    }
    
    @Given("^ingresar claves sin numero en perfil$")
    public void ingresarClavesSinNumero() throws Throwable {
    	ingresarClaves("Comsa@tel","Comsa@tel");
    }
    
    @Given("^ingresar claves sin caracter especial en perfil$")
    public void ingresarClavesSinCaracterEspecial() throws Throwable {
    	ingresarClaves("Comsa123","Comsa123");
    }
    
    @Given("^ingresar claves 7 caracteres en perfil$")
    public void ingresarClaves7Caracteres() throws Throwable {
    	ingresarClaves("Comsa@1","Comsa@1");
    }
    
    @Given("^ingresar claves con espacio en perfil$")
    public void ingresarClavesConEspacio() throws Throwable {
    	ingresarClaves("Coms@ 123","Coms@ 123");
    }
    
    @Given("^ingresar claves con secuencias en perfil$")
    public void ingresarClavesConSecuencias() throws Throwable {
    	ingresarClaves("Cooom@12","Cooom@12");
    }
    
    @Given("^ingresar claves sin minuscula en perfil$")
    public void ingresarClavesSinMinuscula() throws Throwable {
    	ingresarClaves("COMSA@123","COMSA@123");
    }
    
    @Given("^ingresar claves diferentes en perfil$")
    public void ingresarClavesDiferentes() throws Throwable {
    	ingresarClaves("Comsa@123","Comsa@333");
    }
    
    @Given("^verificar claves sin mayuscula en perfil$")
    public void verificarClavesSinMayuscula() throws Throwable {
    	String strPolitica = "Debe contener al menos una letra mayúscula";
    	String strMensaje = strPolitica +" no cumple";
        isClassErrorEnPolitica(strPolitica,strMensaje);
        isNoClassErrorEnArrayPoliticaExceptoPorPolitica(strPolitica);
        Thread.sleep(500);
        limpiarClaves();
    }
    
    @Given("^verificar claves sin numero en perfil$")
    public void verificarClavesSinNumero() throws Throwable {
    	String strPolitica = "Debe contener al menos un número";
    	String strMensaje = strPolitica +" no cumple";
        isClassErrorEnPolitica(strPolitica,strMensaje);
        isNoClassErrorEnArrayPoliticaExceptoPorPolitica(strPolitica);
        Thread.sleep(500);
        limpiarClaves();
    }
    
    @Given("^verificar claves sin caracter especial en perfil$")
    public void verificarClavesSinCaracterEspecial() throws Throwable {
    	String strPolitica = "Debe contener al menos un carácter especial";
    	String strMensaje = strPolitica +" no cumple";
        isClassErrorEnPolitica(strPolitica,strMensaje);
        isNoClassErrorEnArrayPoliticaExceptoPorPolitica(strPolitica);
        Thread.sleep(500);
        limpiarClaves();
    }
    
    @Given("^verificar claves sin 8 caracteres en perfil$")
    public void verificarClavesSin8Caracteres() throws Throwable {
    	String strPolitica = "Debe tener al menos 8 caracteres";
    	String strMensaje = strPolitica +" no cumple";
        isClassErrorEnPolitica(strPolitica,strMensaje);
        isNoClassErrorEnArrayPoliticaExceptoPorPolitica(strPolitica);
        Thread.sleep(500);
        limpiarClaves();
    }
    
    @Given("^verificar claves sin espacio en blanco en perfil$")
    public void verificarClavesSinEspacioBlanco() throws Throwable {
    	String strPolitica = "No debe contener espacios";
    	String strMensaje = strPolitica +" no cumple";
        isClassErrorEnPolitica(strPolitica,strMensaje);
        isNoClassErrorEnArrayPoliticaExceptoPorPolitica(strPolitica);
        Thread.sleep(500);
        limpiarClaves();
    }
    
    @Given("^verificar claves sin secuencias en perfil$")
    public void verificarClavesSinSecuencia() throws Throwable {
    	String strPolitica = "No debe contener secuencias de tres o más caracteres repetidos";
    	String strMensaje = strPolitica +" no cumple";
        isClassErrorEnPolitica(strPolitica,strMensaje);
        isNoClassErrorEnArrayPoliticaExceptoPorPolitica(strPolitica);
        Thread.sleep(500);
        limpiarClaves();
    }
    
    @Given("^verificar claves sin minuscula en perfil$")
    public void verificarClavesSinMinuscula() throws Throwable {
    	String strPolitica = "Debe contener al menos una letra minúscula";
    	String strMensaje = strPolitica +" no cumple";
    	isClassErrorEnPolitica(strPolitica,strMensaje);
    	isNoClassErrorEnArrayPoliticaExceptoPorPolitica(strPolitica);
    	Thread.sleep(500);
    	limpiarClaves();
    }
    
    @Given("^verificar claves iguales en perfil$")
    public void verificarClavesIguales() throws Throwable {
    	//String strPolitica = "La politica por claves diferentes";
    	isNoClassErrorEnArrayPoliticaExceptoPorPolitica(null);
    }
    
    private void isClassErrorEnPolitica(String strParPolitica,String strParMensaje) {
    	WebElement weDiv = null;
        String classDeDiv = null;
        String strPath = "//div[contains(text(),'"+strParPolitica+"')]";
		weDiv = driver.findElement(By.xpath(strPath));
        classDeDiv = weDiv.getAttribute("class");
        if (!classDeDiv.contains("error")) {
        	throw new AssertionError(strParMensaje);
        }
    }
    
    private void isNoClassErrorEnArrayPoliticaExceptoPorPolitica(String strParPolitica) {
    	String strPolitica = null;
        String strClassDiv = null;
        
        WebElement weContenedor = driver.findElement(By.className("contenedor-requisitos"));
        List<WebElement> weListaRequisito = weContenedor.findElements(By.tagName("div"));
        
    	for (WebElement weRequisito : weListaRequisito) {
    		strPolitica = weRequisito.getText();
    		if(strParPolitica!=null && !strPolitica.contains(strParPolitica)) {
	            strClassDiv = weRequisito.getAttribute("class");
	            if (strClassDiv.contains("error")) {
	            	throw new AssertionError("Politicas: "+strPolitica+" muestra check inactivo.");
	            }
    		}
    	}
    }
    
    private void ingresarClaves(String strParClave, String strParRepetirClave)  throws Throwable{
    	WebElement weField = driver.findElement(By.id("usuario-contrasena1"))
    							   .findElement(By.tagName("input"));
    	weField.sendKeys(strParClave);
    	Thread.sleep(500);
    	
    	WebElement weField2 = driver.findElement(By.id("usuario-contrasena2"))
    							    .findElement(By.tagName("input"));
    	weField2.sendKeys(strParRepetirClave);
        Thread.sleep(500);
    }
    
    private void limpiarClaves() throws Throwable {
    	WebElement weField = driver.findElement(By.id("usuario-contrasena1"))
				   				   .findElement(By.tagName("input"));
    	weField.clear();
        
    	WebElement weField2 = driver.findElement(By.id("usuario-contrasena2"))
			    .findElement(By.tagName("input"));
    	weField2.clear();
    }
    
    @Given("^verificar si boton siguiente de password esta habilitado en perfil$")
    public void verificarSiBotonSiguienteDePasswordEsHabilitadoEnPerfil() throws Throwable {
    	WebElement weBoton = null;
    	weBoton = driver.findElement(By.id("usuario-contrasena-guardar"))
                		.findElement(By.tagName("button"));
        String cursorStyle = weBoton.getCssValue("cursor");
        if (!"pointer".equals(cursorStyle)) {
            throw new RuntimeException("El cursor sobre el botón 'Guardar' no permite Continuar.");
        }
    }
    
    @Given("^click boton guardar de password en perfil$")
    public void clickBotonGuardarDePasswordEnPerfil() throws Throwable {
    	String strMensajeError = "Error al dar click en boton Guardar.";
    	try {
	    	WebElement weBoton = driver.findElement(By.id("usuario-contrasena-guardar"))
            						   .findElement(By.tagName("button"));
	    	weBoton.click();
	        Thread.sleep(500);
    	}catch(Exception e) {
    		throw new RuntimeException(strMensajeError);
        }
    }
    
    @Given("^click boton cancelar de password en perfil$")
    public void clickBotonCancelarDePasswordEnPerfil() throws Throwable {
    	String strMensajeError = "Error al dar click en boton Guardar.";
    	try {
	    	WebElement weBoton = driver.findElement(By.id("usuario-contrasena-cancelar"))
            						   .findElement(By.tagName("button"));
	    	weBoton.click();
	        Thread.sleep(500);
    	}catch(Exception e) {
    		throw new RuntimeException(strMensajeError);
        }
    }
    
    @Given("^verificar si mensaje por politica es mostrado$")
    public void verificarSiMensajePorPoliticaEsMostrado() throws Throwable {
    	String strMensajeError = "Error al mostrar mensaje por politica.";
    	String strMensaje = null;
    	try {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("p-message-wrapper")));
            
	    	WebElement weDetail = driver.findElement(By.className("p-message-detail"));
	    	strMensaje = weDetail.getText();
	        if (strMensaje.equals("")) {
	            throw new RuntimeException("no se muestra mensaje de error por politica.");
	        }
	        Thread.sleep(1000);
	        WebElement weBoton = driver.findElement(By.xpath("//button[@aria-label='Cerrar']"));
	        weBoton.click();
    	}catch(RuntimeException e) {
    		throw e;
        }catch(Exception e) {
    		throw new RuntimeException(strMensajeError,e);
        }
    }
}
