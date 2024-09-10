package pages;

import lombok.Getter;
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

import static utility.Waits.explicitlyWait;

@Getter
public class BasePage {
    protected WebDriver driver;

    //Constructor
    public BasePage() {
        this.driver = DriverFactory.getDriver();
    }

    //Click Method
    public void click(By by) {
        explicitlyWait(driver, by, 10);
        driver.findElement(by).click();
    }

    public Boolean isClickable(By by) {
        return driver.findElement(by).isEnabled();
    }

    //Write Text
    public void writeText(By by, String text) {
        explicitlyWait(driver, by, 10);
        driver.findElement(by).sendKeys(text);
    }

    //Read Text
    public String readText(By by) {
        explicitlyWait(driver, by, 10);
        return driver.findElement(by).getText();
    }

    //Clear Text
    public String clearText(By by) {
        explicitlyWait(driver, by, 10);
        return driver.findElement(by).getText();
    }

    //Get Attribute
    public String getAttribute(By by, String attribute) {
        explicitlyWait(driver, by, 10);
        return driver.findElement(by).getAttribute(attribute);
    }

}