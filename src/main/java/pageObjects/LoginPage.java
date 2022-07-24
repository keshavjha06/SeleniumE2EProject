package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {


    public WebDriver driver;

    private final By EMAIL = By.cssSelector("[id='user_email']");
    private final By PASSWORD = By.cssSelector("[type='password']");
    private final By LOGIN = By.cssSelector("[value='Log In']");
    private final By FORGOT_PASSWORD = By.cssSelector("[href*='password/new']");


    public LoginPage(WebDriver driver) {

        this.driver = driver;

    }


    public ForgotPassword forgotPassword() {
        driver.findElement(FORGOT_PASSWORD).click();
        return new ForgotPassword(driver);

    }

    public WebElement getEmail() {
        return driver.findElement(EMAIL);
    }


    public WebElement getPassword() {
        return driver.findElement(PASSWORD);
    }

    public WebElement getLogin() {
        return driver.findElement(LOGIN);
    }


}
