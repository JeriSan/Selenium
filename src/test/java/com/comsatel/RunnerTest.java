package com.comsatel;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.comsatel.steps"},
        plugin = {
                "pretty",
                "html:target/cucumber-report/cucumber.html",
                "json:target/cucumber-report/cucumber.json"
        })
public class RunnerTest {
        public static final WebDriver driver ;
        
        public static final ChromeOptions options = new ChromeOptions();
         
        static {
	        	options.setExperimentalOption("useAutomationExtension", false);
	            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	        	options.addArguments("--disable-web-security");
	        	options.addArguments("--allow-insecure-localhost");
	        	options.addArguments("--no-sandbox");
                driver = new ChromeDriver(options);
                //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
        }
        
        @AfterClass
        public static void tearDown() {
//            if (driver != null) {
//                driver.quit();
//            }
        }
}