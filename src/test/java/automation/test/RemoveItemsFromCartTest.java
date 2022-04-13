package automation.test;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProductsPage;

public class RemoveItemsFromCartTest extends TestUtil {
    @Test
    public void RemoveItemsFromTheCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addItemToTheCart("backpack");

        productsPage.addItemToTheCart("onesie");

        Assert.assertEquals(productsPage.getItemsInTheCart(), 2, "We have two items to now");

        productsPage.removeItemFromTheCart("backpack");

        productsPage.removeItemFromTheCart("onesie");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productsPage.getItemsInTheCart(), 0, "We have not items so far");
        System.out.println("I will be executed");




    }

}
