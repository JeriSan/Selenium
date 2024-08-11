package com.comsatel.steps;

//import io.cucumber.java.en.Given;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import static com.comsatel.RunnerTest.driver;

public class CommonSteps {

//    @Given("^click al boton registrar$")
//    public void clickAlBotonRegistrar() throws Throwable {
//        WebElement registrarElement = driver.findElement(By.xpath("//a[contains(@class, 'btn') and contains(@class, 'registrate')]"));
//        registrarElement.click();
//    }

//    @Given("^click al boton registrar google")
//    public void clickAlBotonRegistrarGoogle() throws Throwable {
//        WebElement registrarGoogleElement = driver.findElement(By.xpath("//a[contains(@class, 'btn') and contains(@class, 'registrate-google')]"));
//        registrarGoogleElement.click();
//    }
//
//    @Given("^verificar si boton siguiente esta habilitado$")
//    public void verificarSiElBotonSiguienteEstaHabilitado() throws Throwable {
//        WebElement siguienteElement = driver.findElement(By.xpath("//button[contains(@class, 'btn') and contains(@class, 'btn-danger') and contains(text(),'Next')]"));
//        if (!siguienteElement.isEnabled()) {
//            throw new RuntimeException("El botón 'Next' no está habilitado.");
//        }
//        
//        // Verificar el estilo CSS para asegurarse de que el cursor sea 'pointer'
//        String cursorStyle = siguienteElement.getCssValue("cursor");
//        if (!"pointer".equals(cursorStyle)) {
//            throw new RuntimeException("El cursor sobre el botón 'Next' no permite Continuar.");
//        }
//    }
    
//    @Given("^click al boton siguiente$")
//    public void clickAlbotonSiguiente() throws Throwable {
//        WebElement siguienteElement = driver.findElement(By.xpath("//button[contains(@class, 'btn') and contains(@class, 'btn-danger') and contains(text(),'Next')]"));
//        siguienteElement.click();
//
//        Thread.sleep(2000);
//    }
    
//    @Given("^click boton siguiente de nueva cuenta$")
//    public void clickAlBotonSiguienteDeNuevaCuenta() throws Throwable {
//        WebElement siguienteElement = driver.findElement(By.xpath("//button[contains(@class, 'btn') and contains(@class, 'btn-danger') and contains(text(),'Next')]"));
//        siguienteElement.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        
//        WebElement nuevaClaveInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nuevaClave")));
//        if (nuevaClaveInput == null) {
//            throw new RuntimeException("El proceso no llevó a pagina de Password correctamente.");
//        }
//        if (weMsjError != null) {
//            String mensajeTexto = weMsjError.getText();
//            throw new RuntimeException(mensajeTexto);
//        }else {    
//        	try {
//        		System.out.println("aqui voy 3");
//        		weSpanNumero = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='03']")));
//        	}catch(Exception e) {
//        		System.out.println("aqui voy 4");
//        		weSpanNumero =null;
//            }	
//            if (weSpanNumero == null) {
//                throw new RuntimeException("El proceso no llevó a pagina de Verificacion correctamente.");
//            }
//            WebElement divPadre = weSpanNumero.findElement(By.xpath(".."));
//            String claseDivPadre = divPadre.getAttribute("class");
//            if (!claseDivPadre.contains("activo")) {
//                throw new RuntimeException("La pagina de Verificacion no se muestra correctamente.");
//            }
//        }
//    }
}
