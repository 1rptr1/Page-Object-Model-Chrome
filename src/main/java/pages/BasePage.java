package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.DriverFactory;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage() {
        this.driver = DriverFactory.getDriver();
    }

    //Click Method
    public void click(By by) {
        waitVisibility(by).click();
    }

    //Write Text
    public void writeText(By by, String text) {
        waitVisibility(by).sendKeys(text);
    }

    //Read Text
    public String readText(By by) {
        return waitVisibility(by).getText();
    }

    //Clear Text
    public String clearText(By by) {
        return waitVisibility(by).getText();
    }

    //Get Attribute
    public String getAttribute(By by,String attribute) {
        return waitVisibility(by).getAttribute(attribute);
    }

    //Explicit Wait
    public WebElement waitVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //Implicit Wait
    public void implicitWait(int duration){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
    }

}