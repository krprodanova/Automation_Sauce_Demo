package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformCheckoutPage {
    protected WebDriver driver;

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueBtn;

    public InformCheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OverviewPage checkout(String firstName, String lastName, String postalCode){
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);

        lastNameInput.click();
        lastNameInput.sendKeys(lastName);

        postalCodeInput.click();
        postalCodeInput.sendKeys(postalCode);

        continueBtn.click();
        return new OverviewPage(driver);
    }

    //public void tryToCheckout(){
        //firstNameInput.click();
        //firstNameInput.sendKeys("Kr");

        //lastNameInput.click();
        //lastNameInput.sendKeys("Pr");

        //postalCodeInput.click();
        //postalCodeInput.sendKeys("4000");


        //continueBtn.click();

    //}
    public OverviewPage openOverviewPage(){
        WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueBtn.click();
        return new OverviewPage(driver);
    }

}
