package Academy;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base {
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(base.class.getName());
    LandingPage l;

    @BeforeTest
    public void initialize() throws IOException {

        driver = initializeDriver();
        log.info("Driver is initialized");

        driver.get(prop.getProperty("url"));
        log.info("Navigated to Home page");
    }

    @Test
    public void validateAppTitle() {

        //one is inheritance
        // creating object to that class and invoke methods of it
        l = new LandingPage(driver);
        //compare the text from the browser with actual text.- Error..
        Assert.assertEquals(l.getTitle().getText(), "FEATURED CO123URSES");
        log.info("Successfully validated Text message");
        System.out.println("Test completed");

    }

    @Test
    public void validateHeader() {
        Assert.assertEquals(l.getHeader().getText(), "An Academy to learn Everything about Testing");
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }
}

