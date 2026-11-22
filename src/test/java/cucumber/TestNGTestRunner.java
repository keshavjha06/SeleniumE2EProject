package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumber->  TestNG, junit

@CucumberOptions(features = "src/test/java/cucumber", glue = "academy.stepdefinitions",
        monochrome = true, tags = "@Regression", plugin = {"html:target/cucumber.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {


}
