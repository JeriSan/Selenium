package com.comsatel.steps.sp02;

import static com.comsatel.RunnerTest.driver;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;

public class US10IndicadorSteps {
	
	private String strIdiomaInicial = null;
	private Map<String, String> mapIdTexto = new HashMap<>();
	
	@Given("^verificar si configuracion usuario es habilitado$")
    public void verificarSiConfiguracionUsuarioEsHabilitado() throws Throwable {
		String strMensajeError = "Error al dar click a configuracion usuario.";
		String strId = "btn-detalle-usuario";
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("map")));
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".yNHHyP-marker-view")));
            Thread.sleep(7000);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strId)));
	        
	        WebElement weConfiguracion = driver.findElement(By.id(strId));
	        if (!weConfiguracion.isEnabled()) {
	            throw new RuntimeException("'Configuracion usuario' no está habilitado.");
	        }
	        String cursorStyle = weConfiguracion.getCssValue("cursor");
	        if (!"pointer".equals(cursorStyle)) {
	            throw new RuntimeException("El cursor sobre 'Configuracion usuario' no permite Continuar.");
	        }
	        
		}catch(RuntimeException e) {
    		throw e;
        }catch(Exception e) {
    		throw new RuntimeException(strMensajeError,e);
        }   
    }
	
    @Given("^click configuracion usuario$")
    public void clickAConfiguracionUsuario() throws Throwable {
    	String strMensajeError = "Error al dar click a configuracion usuario.";
    	String strId = "btn-detalle-usuario"; 
    	try {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strId)));
	        
	    	WebElement siguienteElement = driver.findElement(By.id(strId));
	        siguienteElement.click();
    	}catch(Exception e) {
    		throw new RuntimeException(strMensajeError);
        }
    }
    
    @Given("^click datos de cliente de configuracion$")
    public void clickADatosDeCliente() throws Throwable {
    	String strMensajeError = "Error al dar click a datos de cliente.";
    	String strId = "btn-abrir-datos-cliente";
    	try {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strId)));
    		
            Actions actions = new Actions(driver);
	    	WebElement siguienteElement = driver.findElement(By.id(strId));
	    	actions.moveToElement(siguienteElement).click().perform();
    	}catch(Exception e) {
    		throw new RuntimeException(strMensajeError);
        }
    }
    
    @Given("^click cerrar sesion de configuracion$")
    public void clickACerrarSesionDeConfiguracion() throws Throwable {
    	String strMensajeError = "Error al dar click a cerrar sesion.";
    	String strId = "btn-cerrar-sesion";
    	try {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(strId)));
    		
            Actions actions = new Actions(driver);
	    	WebElement siguienteElement = driver.findElement(By.id(strId));
	    	actions.moveToElement(siguienteElement).click().perform();
	    	Thread.sleep(500);
    	}catch(Exception e) {
    		throw new RuntimeException(strMensajeError,e);
        }
    }

    private void guardarIndicadoresEnMapa() {
    	WebElement weBoton = null;
		WebElement weTexto = null;
		WebElement weDivDos = null;
		String strIdIndicador = null;
		String strTextoIndicador = null;
		
        WebElement weContenedorBtn = driver.findElement(By.cssSelector("app-indicadores .contenedor-botones"));
        List<WebElement> listaWEBoton = weContenedorBtn.findElements(By.tagName("button"));
        for (WebElement we : listaWEBoton) {
        	strIdIndicador = we.getAttribute("id");
        	weBoton = driver.findElement(By.id(strIdIndicador));
        	weTexto = weBoton.findElement(By.className("texto"));
        	weDivDos = weTexto.findElement(By.xpath("./div[2]"));
        	strTextoIndicador = weDivDos.getText();
        	mapIdTexto.put(strIdIndicador,strTextoIndicador);
        }
    }
    
    @Given("^seleccionar idioma diferente al actual$")
    public void seleccionarIdiomaDiferenteAlActual() throws Throwable {
    	String strMensajeError = "Error al dar click a datos de cliente.";
    	String strIdiomaSeleccionado = null;
    	try {
    		guardarIndicadoresEnMapa();
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement dropdown = driver.findElement(By.id("usuario-codIdioma"));
            strIdiomaInicial = dropdown.findElement(By.className("p-dropdown-label")).getText();
            
            WebElement dropdownTrigger = driver.findElement(By.cssSelector("#usuario-codIdioma .p-dropdown-trigger"));
            dropdownTrigger.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".p-dropdown-item")));
            
            List<WebElement> options = driver.findElements(By.cssSelector(".p-dropdown-item"));
            
            if (options.size() > 1) {
                Actions actions = new Actions(driver);
                for (WebElement option : options) {
		            String optionText = option.getText();
		            if (!optionText.equals(strIdiomaInicial)) {
		                actions.moveToElement(option).click().perform();
		                wait.until(ExpectedConditions.textToBePresentInElementLocated(
			                By.cssSelector("#usuario-codIdioma .p-dropdown-label"), 
			                optionText
			            ));
		                break;
		            }
		        }
                Thread.sleep(1000);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#usuario-codIdioma .p-dropdown-label")));
                
                dropdown = driver.findElement(By.id("usuario-codIdioma"));
                strIdiomaSeleccionado = dropdown.findElement(By.className("p-dropdown-label")).getText();
                if (strIdiomaInicial.equals(strIdiomaSeleccionado)){
                	throw new RuntimeException("se selecciono idioma "+strIdiomaSeleccionado+" diferente a: "+strIdiomaInicial);
                }
            } else {
            	throw new RuntimeException("No hay suficientes opciones de idioma.");
            }
    	}catch(RuntimeException e) {
    		throw e;
        }catch(Exception e) {
    		throw new RuntimeException(strMensajeError);
        }
    }
    
    @Given("^click boton guardar de editar perfil$")
    public void clickABotonGuardarDeEditarPerfil() throws Throwable {
    	String strMensajeError = "Error al dar click a boton guardar.";
    	try {
	    	WebElement weDiv = driver.findElement(By.id("usuario-datos-guardar"));
	        WebElement weBoton = weDiv.findElement(By.tagName("button"));
	    	weBoton.click();
    	}catch(Exception e) {
    		throw new RuntimeException(strMensajeError,e);
        }
    }
    
    @Given("^click boton guardar de confirmacion editar perfil$")
    public void clickABotonguardarDeConfirmacionEditarPerfil() throws Throwable {
    	String strMensajeError = "Error al dar click a boton guardar de confirmacion.";
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	String strPath = null;
    	WebElement weBoton = null;
    	try {
    		strPath = "//div[contains(@class, 'confirmacion-actualizacion') and not(contains(@class, 'd-none'))]";
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strPath)));
    	
	    	weBoton = driver.findElement(By.xpath("//p-button[@id='usuario-actualizar-guardar']//button"));
        	weBoton.click();
        }catch(Exception e) {
    		throw new RuntimeException(strMensajeError,e);
        }
        try {
        	strMensajeError = "Error al dar click a boton guardar de confirmacion 2.";
        	strPath = "//div[contains(@class, 'final-registro') and not(contains(@class, 'd-none'))]";
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strPath)));
        	
        	weBoton = driver.findElement(By.xpath("//p-button[@id='usuario-registro-completado']//button"));
        	weBoton.click();
        	
    	}catch(Exception e) {
    		throw new RuntimeException(strMensajeError,e);
        }
    }
    
    @Given("^verificar cambio de idioma de indicadores$")
    public void verificarCambioDeIdiomaDeIndicadores() throws Throwable {
    	String strIdIndicador = null;
    	String strTextoIndicador = null;
    	String strTextoIndicadorOld = null;
    	WebElement weBoton = null;
    	WebElement weTexto = null;
    	WebElement weDivDos = null;
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("map")));
        Thread.sleep(7000);
	    
	    WebElement weContenedorBtn = driver.findElement(By.cssSelector("app-indicadores .contenedor-botones"));
        List<WebElement> listaWEBoton = weContenedorBtn.findElements(By.tagName("button"));
        for (WebElement we : listaWEBoton) {
        	strIdIndicador = we.getAttribute("id");
        	weBoton = driver.findElement(By.id(strIdIndicador));
        	weTexto = weBoton.findElement(By.className("texto"));
        	weDivDos = weTexto.findElement(By.xpath("./div[2]"));
        	strTextoIndicador = weDivDos.getText();
        	strTextoIndicadorOld = mapIdTexto.get(strIdIndicador);
        	if(strTextoIndicadorOld.equals(strTextoIndicador)){
        		throw new RuntimeException("El indicador " + strIdIndicador+ " no cambio de idioma");
        	}
        }
    }
}
