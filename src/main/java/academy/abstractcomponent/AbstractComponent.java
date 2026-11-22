package academy.abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import academy.pageobjects.CartPage;
import academy.pageobjects.OrderPage;

public class AbstractComponent {

    WebDriver driver;

    public AbstractComponent(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader;

    @FindBy(css = "[routerlink*='myorders']")
    WebElement orderHeader;


    public void waitForElementToAppear(By findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }

    public void waitForWebElementToAppear(WebElement findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));

    }

    /** Full-screen loading overlay; while present it swallows every click on the page. */
    private static final By SPINNER_OVERLAY = By.cssSelector(".ngx-spinner-overlay");

    /**
     * Waits until no element matching the locator is visible. The implicit wait is
     * switched off meanwhile, otherwise each check of an absent element blocks for 10s.
     */
    public void waitForElementToDisappear(By locator) {
        Duration implicitWait = driver.manage().timeouts().getImplicitWaitTimeout();
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        try {
            new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } finally {
            driver.manage().timeouts().implicitlyWait(implicitWait);
        }
    }

    public void waitForSpinnerToDisappear() {
        waitForElementToDisappear(SPINNER_OVERLAY);
    }

    /** Clicks a header link once the overlay is gone and waits for the route to change. */
    private void clickAndWaitForUrl(WebElement link, String urlFragment) {
        waitForSpinnerToDisappear();
        link.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(urlFragment));
    }

    public CartPage goToCartPage() {
        clickAndWaitForUrl(cartHeader, "/dashboard/cart");
        return new CartPage(driver);
    }

    public OrderPage goToOrdersPage() {
        clickAndWaitForUrl(orderHeader, "/dashboard/myorders");
        return new OrderPage(driver);
    }

}
