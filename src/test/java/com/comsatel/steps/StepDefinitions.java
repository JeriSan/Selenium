package com.comsatel.steps;

import io.cucumber.java.en.Given;
import org.junit.Assert;

public class StepDefinitions {
    @Given("^a successful step$")
    public void aSuccessfulStep() throws Throwable {
        System.out.println("a successful step");
    }

    @Given("^a not successful step$")
    public void aNotSuccessfulStep() throws Throwable {
        System.out.println("a not successful step");
        Assert.fail();
    }
}