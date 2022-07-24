package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {


    public WebDriver driver;

    private final By EMAIL = By.cssSelector("[id='user_email']");
    private final By SEND_ME_INSTRUCTIONS = By.cssSelector("[type='submit']");


    public ForgotPassword(WebDriver driver) {

        this.driver = driver;

    }


    public WebElement getEmail() {
        return driver.findElement(EMAIL);
    }

    public WebElement sendMeInstructions() {
        return driver.findElement(SEND_ME_INSTRUCTIONS);
    }


}
