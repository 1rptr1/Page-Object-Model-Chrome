package utility;

import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class Waits extends BasePage {

    static int timeUnits = 30;

    public static void implicitlyWait(WebDriver driver, int timeUnits) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeUnits));
    }

    public static void explicitlyWait(WebDriver driver, By element, int timeUnits) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeUnits));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static WebElement explicitlyWait(WebDriver driver, WebElement element, int timeUnits) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeUnits));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static void fluentWait(WebDriver driver, By element, int timeUnits, int polling) {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeUnits))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class)
                .pollingEvery(Duration.ofSeconds(polling))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void fluentWait(WebDriver driver, WebElement element, int timeUnits, int polling) {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeUnits))
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofSeconds(polling))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    @SneakyThrows
    public static void threadSleep(int sleepSeconds) {
        Thread.sleep(sleepSeconds * 1000L);
    }
}
