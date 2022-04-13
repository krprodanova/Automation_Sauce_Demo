package automation.test;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class UnsuccessfulLoginTest extends TestUtil {
    @DataProvider(name = "wrongUsersList")
    public Object[][] getWrongUsers() {
        return new Object[][]{
                {"standardUser111", "secret_sauce"},
                {"standard_user", "wrong password"},
                {"aaaa", "bbbb"},
        };
    }

    @Test(dataProvider = "wrongUsersList")
    public void UnsuccessfulLogin(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.tryToLogin("wrong", "wrong");

        WebElement errorLoginLabel = driver.findElement(By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']"));

        Assert.assertTrue(errorLoginLabel.isDisplayed());
    }



}
