package com.comsatel.steps;

import io.cucumber.java.en.Given;

import static com.comsatel.RunnerTest.driver;

public class LoginSteps {

    public static final String LOGIN_URL = "http://192.168.1.52:9090/auth/realms/Apps-TEMP/account";

    @Given("^ir a la pagina de login$")
    public void irPaginaLogin() throws Throwable {
        driver.get(LOGIN_URL);
        Thread.sleep(3000);
    }
}
