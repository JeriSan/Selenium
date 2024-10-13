package com.comsatel.steps.sp03;

import static com.comsatel.RunnerTest.driver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;

public class US25DetalleUnidadSteps {
	
    @Given("^click panel Izquierdo$")
    public void clickAConfiguracionUsuario() throws Throwable {
    	String strMensajeError = "Error al dar click a panel izquierdo.";
    	String strId = "panel-mostrar-menu-panel-izquierda";
    	try {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strId)));
    		
	    	WebElement siguienteElement = driver.findElement(By.id(strId));
	        siguienteElement.click();
    	}catch(Exception e) {
    		throw new RuntimeException(strMensajeError,e);
        }
    }
    
    @Given("^click detalle de Unidad$")
    public void clickADetalleUnidad() throws Throwable {
    	String strMensajeError = "Error al dar click a detalle de Unidad.";
    	try {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("unidad-abrir-filtro")));
    		
	    	WebElement siguienteElement = driver.findElement(By.xpath("(//button[@class='btn editar'])[1]"));
	        siguienteElement.click();
    	}catch(Exception e) {
    		throw new RuntimeException(strMensajeError,e);
        }
    }
    
    @Given("^verificar unidades disponibles en panel$")
    public void verificarUnidadesEnPanel() {
    	String strMensajeError = "No hay unidades en el panel izquierdo.";
    	String strClass = "p-accordion-tab";
    	List<WebElement> weLista = driver.findElements(By.className(strClass));
        if(weLista.size() ==0) {
        	throw new RuntimeException(strMensajeError);
        }else {
        	System.out.println("si hay unidades, No: "+weLista.size());
        }
    }
    
    @Given("^ingresar Nuevo odometro menor al anterior$")
    public void ingresarNuevoOdometroMenorAlAnterior() throws Throwable {
    	WebElement weTexto = driver.findElement(By.id("txt-unidad-editar-recorrido"));
    	String strValorActual = weTexto.getAttribute("value");
        Thread.sleep(1000);
        int intNuevoValor = Integer.parseInt(strValorActual) - 1;
        weTexto.clear();
    	weTexto.sendKeys(String.valueOf(intNuevoValor));
	    Thread.sleep(500);
    }
    
    @Given("^verificar si actualizar cambios es habilitado$")
    public void verificarSiActualizrCambiosEsHabilitado() throws Throwable {
		Thread.sleep(5000);
        WebElement weBoton = driver.findElement(By.id("btn-unidad-editar-guardar"));
        if (!weBoton.isEnabled()) {
            throw new RuntimeException("boton 'Actualizar cambios' de detalle unidad.");
        }
        String cursorStyle = weBoton.getCssValue("cursor");
        if (!"pointer".equals(cursorStyle)) {
            throw new RuntimeException("El cursor sobre 'Actualizar cambios' de detalle unidad no permite Continuar.");
        }
    }
    
    @Given("^click actualizar cambios$")
    public void clickActualizarCambios() throws Throwable {
    	String strMensajeError = "Error al dar click a Actualizar cambios.";
    	String strId = "btn-unidad-editar-guardar";
    	try {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strId)));
    		
	    	WebElement siguienteElement = driver.findElement(By.id(strId));
	        siguienteElement.click();
    	}catch(Exception e) {
    		throw new RuntimeException(strMensajeError,e);
        }
    }
    
    @Given("^verificar si mensaje por odometro es mostrado$")
    public void verificarSiMensajePorOdometroEsMostrado() throws Throwable {
    	String strMensajeError = "Error al mostrar mensaje de error por odometro.";
    	String strMensaje = null;
    	try {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("p-toast-message-content")));
            
	    	WebElement weDetail = driver.findElement(By.className("p-toast-detail"));
	    	strMensaje = weDetail.getText();
	        if (strMensaje.equals("")) {
	            throw new RuntimeException("no se muestra mensaje de error por odometro.");
	        }
    	}catch(RuntimeException e) {
    		throw e;
        }catch(Exception e) {
    		throw new RuntimeException(strMensajeError,e);
        }
    }
}