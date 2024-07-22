package com.comsatel.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.comsatel.RunnerTest.driver;

public class PasswordSteps {

    @Given("^ingresamos las claves$")
    public void ingresamosLasClaves() throws Throwable {
        WebElement nuevaClaveElement = driver.findElement(By.id("nuevaClave"));
        nuevaClaveElement.sendKeys("Comsa@123");
        Thread.sleep(500);
        
        WebElement repetirNuevaClaveElement = driver.findElement(By.id("repetirNuevaClave"));
        repetirNuevaClaveElement.sendKeys("Comsa@123");

        Thread.sleep(2000);
    }
}
