package com.comsatel.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.comsatel.RunnerTest.driver;

public class PasswordSteps {
	private String [] strArrayIdPoliticas = {"patron1","patron5","patron8","patron9","patron13","patron17","patron21","patron25"};

    @Given("^limpiar claves$")
    public void limpiarClaves() throws Throwable {
        WebElement weNuevaClave = driver.findElement(By.id("nuevaClave"));
        weNuevaClave.clear();
        
        WebElement weRepetirNuevaClave = driver.findElement(By.id("repetirNuevaClave"));
        weRepetirNuevaClave.clear();
        Thread.sleep(1000);
    }
    
    @Given("^ingresar claves validas$")
    public void ingresarClavesValidas() throws Throwable {
    	ingresarClaves("Comsa@123","Comsa@123");
    }
    
    @Given("^ingresar claves sin mayuscula$")
    public void ingresarClavesSinMayuscula() throws Throwable {
    	ingresarClaves("comsa@12","comsa@12");
    }
    
    @Given("^ingresar claves sin numero$")
    public void ingresarClavesSinNumero() throws Throwable {
    	ingresarClaves("Comsa@tel","Comsa@tel");
    }
    
    @Given("^ingresar claves sin caracter especial$")
    public void ingresarClavesSinCaracterEspecial() throws Throwable {
    	ingresarClaves("Comsa123","Comsa123");
    }
    
    @Given("^ingresar claves 7 caracteres$")
    public void ingresarClaves7Caracteres() throws Throwable {
    	ingresarClaves("Comsa@1","Comsa@1");
    }
    
    @Given("^ingresar claves con espacio$")
    public void ingresarClavesConEspacio() throws Throwable {
    	ingresarClaves("Coms@ 123","Coms@ 123");
    }
    
    @Given("^ingresar claves con secuencias$")
    public void ingresarClavesConSecuencias() throws Throwable {
    	ingresarClaves("Cooom@12","Cooom@12");
    }
    
    @Given("^ingresar claves sin minuscula$")
    public void ingresarClavesSinMinuscula() throws Throwable {
    	ingresarClaves("COMSA@123","COMSA@123");
    }
    
    @Given("^ingresar claves diferentes$")
    public void ingresarClavesDiferentes() throws Throwable {
    	ingresarClaves("Comsa@123","Comsa@333");
    }
    
    @Given("^verificar politica claves con mayuscula$")
    public void verificarPoliticaClavesConMayuscula() throws Throwable {
    	String strId = "patron1";
    	String strPolitica = "La politica claves con mayuscula";
    	String strMensaje = strPolitica +" no cumple";
        isNoClassCheckEnId(strId,strMensaje);
        isClassCheckEnArrayPoliticaExceptoPorId(strId,strPolitica);
    }
    
    @Given("^verificar politica claves con numero$")
    public void verificarPoliticaClavesConNumero() throws Throwable {
    	String strId = "patron5";
    	String strPolitica = "La politica claves con numero";
    	String strMensaje = strPolitica +" no cumple";
        isNoClassCheckEnId(strId,strMensaje);
        isClassCheckEnArrayPoliticaExceptoPorId(strId,strPolitica);
    }
    
    @Given("^verificar politica claves con caracer especial$")
    public void verificarPoliticaClavesConCaracterEspecial() throws Throwable {
    	String strId = "patron9";
    	String strPolitica = "La politica claves con caracter especial";
    	String strMensaje = strPolitica +" no cumple";
        isNoClassCheckEnId(strId,strMensaje);
        isClassCheckEnArrayPoliticaExceptoPorId(strId,strPolitica);
    }
    
    @Given("^verificar politica claves con 8 caracteres$")
    public void verificarPoliticaClavesCon8Caracteres() throws Throwable {
    	String strId = "patron13";
    	String strPolitica = "La politica claves con 8 caracteres";
    	String strMensaje = strPolitica +" no cumple";
        isNoClassCheckEnId(strId,strMensaje);
        isClassCheckEnArrayPoliticaExceptoPorId(strId,strPolitica);
    }
    
    @Given("^verificar politica claves sin espacio en blanco$")
    public void verificarPoliticaClavesSinEspacioBlanco() throws Throwable {
    	String strId = "patron17";
    	String strPolitica = "La politica claves sin espacio en blanco";
    	String strMensaje = strPolitica +" no cumple";
        isNoClassCheckEnId(strId,strMensaje);
        isClassCheckEnArrayPoliticaExceptoPorId(strId,strPolitica);
    }
    
    @Given("^verificar politica claves sin secuencias$")
    public void verificarPoliticaClavesSinSecuencia() throws Throwable {
    	String strId = "patron21";
    	String strPolitica = "La politica claves sin secuencias";
    	String strMensaje = strPolitica +" no cumple";
        isNoClassCheckEnId(strId,strMensaje);
        isClassCheckEnArrayPoliticaExceptoPorId(strId,strPolitica);
    }
    
    @Given("^verificar politica claves con minuscula$")
    public void verificarPoliticaClavesConMinuscula() throws Throwable {
    	String strId = "patron25";
    	String strPolitica = "La politica claves con minuscula";
    	String strMensaje = strPolitica +" no cumple";
    	isNoClassCheckEnId(strId,strMensaje);
        isClassCheckEnArrayPoliticaExceptoPorId(strId,strPolitica);
    }
    
    @Given("^verificar politica claves iguales$")
    public void verificarPoliticaClavesIguales() throws Throwable {
    	String strId = "patron8";
    	String strPolitica = "La politica por claves diferentes";
    	String strMensaje = strPolitica +" no cumple";
    	isNoClassCheckEnId(strId,strMensaje);
        isClassCheckEnArrayPoliticaExceptoPorId(strId,strPolitica);
    }
    
    @Given("^verificar mensaje error por politica claves iguales$")
    public void verificarMensajeErrorPorClavesDiferentes() throws Throwable {
    	String strPolitica = "La politica por claves diferentes";
    	String strMensajeError = "El mensaje de error para "+strPolitica;
    	String strMensaje = "Las contraseñas no coinciden";
        WebElement alertDiv = driver.findElement(By.cssSelector("div.alert.alert-danger.d-none"));
        String alertText = alertDiv.getText();
        if (alertText.isEmpty()) {
            throw new AssertionError(strMensajeError+" no cumple.");
        } 
    	if(alertText != strMensaje) {
    		throw new AssertionError(strMensajeError+" debe decir: " + strMensaje);
    	}
    }
    
    private void isNoClassCheckEnId(String strParId,String strParMensaje) {
    	WebElement weDiv = null;
        String classDeDiv = null;
		weDiv = driver.findElement(By.id(strParId));
        classDeDiv = weDiv.getAttribute("class");
        if (classDeDiv.contains("check")) {
        	throw new AssertionError(strParMensaje);
        }
    }
    
    private void isClassCheckEnArrayPoliticaExceptoPorId(String parStrId,String strParPolitica) {
    	WebElement weDiv = null;
        String classDeDiv = null;
    	for (String strId : strArrayIdPoliticas) {
    		if(strId != parStrId) {
	    		weDiv = driver.findElement(By.id(strId));
	            classDeDiv = weDiv.getAttribute("class");
	            if (!classDeDiv.contains("check")) {
	            	throw new AssertionError("Politicas diferentes a "+strParPolitica+" muestra check inactivo.");
	            }
    		}
    	}
    }
    
    private void ingresarClaves(String strParClave, String strParRepetirClave)  throws Throwable{
    	WebElement nuevaClaveElement = driver.findElement(By.id("nuevaClave"));
        nuevaClaveElement.sendKeys(strParClave);
        Thread.sleep(500);
        
        WebElement repetirNuevaClaveElement = driver.findElement(By.id("repetirNuevaClave"));
        repetirNuevaClaveElement.sendKeys(strParRepetirClave);
        Thread.sleep(1000);
    }
    
    @Given("^verificar check activo por cada politica$")
    public void verificarCheckActivoEnPoliticas() {
    	WebElement weDiv = null;
    	WebElement weDivMensaje = null;
        String classDeDiv = null;
        String strMensaje = null;
    	for (String strId : strArrayIdPoliticas) {
    		weDiv = driver.findElement(By.id(strId));
            classDeDiv = weDiv.getAttribute("class");
            if (!classDeDiv.contains("check")) {
            	weDivMensaje = weDiv.findElement(By.className("col-10"));
            	strMensaje = weDivMensaje.getText(); 
            	throw new AssertionError("Politica "+strMensaje+" muestra check inactivo.");
            }
    	}
    }
    
    @Given("^verificar si boton siguiente de password esta habilitado$")
    public void verificarSiElBotonSiguienteEstaHabilitado() throws Throwable {
        WebElement siguienteElement = driver.findElement(By.xpath("//button[@onclick='registrarUsuario()']"));
        if (!siguienteElement.isEnabled()) {
            throw new RuntimeException("El botón 'Next' no está habilitado.");
        }
        String cursorStyle = siguienteElement.getCssValue("cursor");
        if (!"pointer".equals(cursorStyle)) {
            throw new RuntimeException("El cursor sobre el botón 'Next' no permite Continuar.");
        }
    }
    
    @Given("^verificar si boton siguiente de password esta deshabilitado$")
    public void verificarSiBotonSiguienteDePasswordEsDeshabilitado() throws Throwable {
    	WebElement weBtnSiguiente = null;
    	weBtnSiguiente = driver.findElement(By.xpath("//button[@onclick='registrarUsuario()']"));
        String cursorStyle = weBtnSiguiente.getCssValue("cursor");
        if ("pointer".equals(cursorStyle)) {
            throw new RuntimeException("El cursor sobre el botón 'Next' permite Continuar.");
        }
    }
    
    @Given("^click boton siguiente de password$")
    public void clickAlBotonSiguienteDePassword() throws Throwable {
    	WebElement weBtnSiguiente = null;
    	WebElement wePadre = null;
    	WebElement weMensaje = null;
        String strMensajeError = null;
        String strTitulo = null;
        String strXpathExpression = null;
    	weBtnSiguiente = driver.findElement(By.xpath("//button[@onclick='registrarUsuario()']"));
        weBtnSiguiente.click();
        Thread.sleep(2500);
        try {
        	wePadre = driver.findElement(By.cssSelector("ul.mb-0"));
        	weMensaje = wePadre.findElement(By.tagName("li"));
        }catch(Exception e) {
        	weMensaje =null;
        }
        if (weMensaje != null) {
        	strMensajeError = weMensaje.getText();
        }
        if (strMensajeError != null) {
            if(strMensajeError != null && strMensajeError.length()>0) {
            	throw new RuntimeException(strMensajeError);
            }
        }else {
        	try {
        		strMensajeError = "El proceso no llevó a pagina de Verificacion correctamente.";
        		strTitulo = "Verify that this account belongs to you";
        	    strXpathExpression = String.format("//div[contains(@class, 'contenedor-texto')]//div[contains(text(), '%s')]", strTitulo);
                WebElement weTitulo = driver.findElement(By.xpath(strXpathExpression));
                if(!strTitulo.equals(weTitulo.getText())) {
                	throw new RuntimeException(strMensajeError);
                }
        	}catch(Exception e) {
        		throw new RuntimeException(strMensajeError);
            }	
        }
    }
}
