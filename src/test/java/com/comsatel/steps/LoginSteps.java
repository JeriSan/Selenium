package com.comsatel.steps;

import io.cucumber.java.en.Given;

import static com.comsatel.RunnerTest.driver;

public class LoginSteps {

    public static final String LOGIN_URL = "http://localhost:9090/auth/realms/apps-tmp/account";

    @Given("^ir a la pagina de login$")
    public void irPaginaLogin() throws Throwable {
        driver.get(LOGIN_URL);
        Thread.sleep(3000);
    }
}
