package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    static int timeUnits = 30;
    public static void implicitlyWait(WebDriver driver, int timeUnits){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeUnits));
    }
    public static void explicitlyWait(WebDriver driver, By element, int timeUnits)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeUnits));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void explicitlyWait(WebDriver driver, WebElement element, int timeUnits)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeUnits));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void fluentWait(WebDriver driver,By element, int timeUnits, int polling)
    {
         new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeUnits))
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofSeconds(polling))
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void fluentWait(WebDriver driver,WebElement element, int timeUnits, int polling)
    {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeUnits))
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofSeconds(polling))
                .until(ExpectedConditions.visibilityOf(element));
    }
    public static void threadSleep(int sleepSeconds)
    {
        try{
            Thread.sleep(sleepSeconds* 1000L);
        }
        catch (InterruptedException ignored)
        {

        }

    }
}
