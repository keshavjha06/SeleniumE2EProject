package academy.tests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import academy.testcomponents.BaseTest;
import academy.testcomponents.Retry;
import academy.pageobjects.CartPage;
import academy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

    @Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
    public void LoginErrorValidation() {


        landingPage.loginApplication("anshika@gmail.com", "Iamki000");
        Assert.assertEquals("Incorrect email  password.", landingPage.getErrorMessage());

    }


    @Test
    public void ProductErrorValidation() throws InterruptedException {

        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("rahulshetty@gmail.com", "Iamking@000");
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);


    }


}
