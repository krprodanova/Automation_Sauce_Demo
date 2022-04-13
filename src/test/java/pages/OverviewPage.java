package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
    protected WebDriver driver;

    @FindBy(id="finish")
    private WebElement finishBtn;
    private static final String FINISH_LOCATOR = "//button[@id = 'finish']";

    public OverviewPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CompletePage tryToCompletePage(){
        WebElement finishBtn = driver.findElement(By.id("finish"));
        finishBtn.click();
        return new CompletePage(driver);

    }



}
