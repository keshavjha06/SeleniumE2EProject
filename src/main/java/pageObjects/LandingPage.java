package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.print.attribute.standard.MediaSize;

public class LandingPage {


    public WebDriver driver;

    private final By SIGN_IN = By.cssSelector("a[href*='sign_in']");
    private final By TITLE = By.cssSelector(".text-center>h2");
    private final By NAVBAR = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
    private final By HEADER = By.cssSelector("div[class*='video-banner'] h3");


    public LandingPage(WebDriver driver) {

        this.driver = driver;

    }


    public LoginPage getLogin() {
        driver.findElement(SIGN_IN).click();
        LoginPage lp = new LoginPage(driver);
        return lp;


    }

    public WebElement getNavigationBar() {
        return driver.findElement(NAVBAR);
    }

    public WebElement getTitle() {
        return driver.findElement(TITLE);
    }

    public WebElement getHeader() {
        return driver.findElement(HEADER);
    }


}
