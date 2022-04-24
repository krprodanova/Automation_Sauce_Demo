package automation.test;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.CsvHelper;

import java.io.IOException;

public class CheckoutItemsTest extends TestUtil {
    @DataProvider(name = "csvInform")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/inform.csv");
    }




        @Test(dataProvider = "csvInform")
        public void checkoutItems (String firstName, String lastName, String postalCode) throws InterruptedException {
            LoginPage loginPage = new LoginPage(driver);
            ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

            productsPage.addItemToTheCart("backpack");

            productsPage.addItemToTheCart("onesie");

            WebElement shoppingCartLink = driver.findElement(By.className("shopping_cart_link"));
            shoppingCartLink.click();



            WebElement btnBtnActionBtnMediumCheckoutButton = driver.findElement(By.id("checkout"));
            btnBtnActionBtnMediumCheckoutButton.click();

            WebElement informationText = driver.findElement(By.className("title"));
            Assert.assertTrue(informationText.isDisplayed(), "This shall be display after successful checkout");

            InformCheckoutPage informCheckoutPage = new InformCheckoutPage(driver);
            OverviewPage overviewPage = informCheckoutPage.checkout(firstName, lastName, postalCode);


            CompletePage completePage = overviewPage.tryToCompletePage();



            WebElement userBackHomeButton = driver.findElement(By.id("back-to-products"));
            Assert.assertTrue(userBackHomeButton.isDisplayed(),"This shall be display after successful finish");



        }
    }