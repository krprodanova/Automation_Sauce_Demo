package pages;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage{
public WebDriver driver;

//private static final String CART_LINK = "//button[@id = 'shopping_cart_container']";
//private static final String CHECKOUT_LOCATOR = "//button[@id = 'checkout']";


@FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;

@FindBy(className = "btn btn_action btn_medium checkout_button")
    private WebElement btnBtnActionBtnMediumCheckoutButton;

public CheckoutPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
}
//public void shoppingCartLink(){
    //driver.findElement(By.className("shopping_cart_link")).click();
    //}
    public void btnBtnActionBtnMediumCheckoutButton(){
    driver.findElement(By.className("btn btn_action btn_medium checkout_button")).click();

    }

}
