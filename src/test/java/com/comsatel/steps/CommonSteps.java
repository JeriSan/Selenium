package com.comsatel.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.comsatel.RunnerTest.driver;

public class CommonSteps {

    @Given("^click al boton registrar$")
    public void clickAlBotonRegistrar() throws Throwable {
        WebElement registrarElement = driver.findElement(By.xpath("//a[contains(@class, 'btn') and contains(@class, 'registrate')]"));
        registrarElement.click();
    }

    @Given("^click al boton siguiente$")
    public void clickAlbotonSiguiente() throws Throwable {
        WebElement siguienteElement = driver.findElement(By.xpath("//button[contains(@class, 'btn') and contains(@class, 'btn-danger') and contains(text(),'Next')]"));
        siguienteElement.click();

        Thread.sleep(3000);
    }
}
