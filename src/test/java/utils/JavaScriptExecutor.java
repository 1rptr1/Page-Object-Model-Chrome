package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutor {

    // Method 1: Clicking an element using JavaScript
    public static WebDriver clickElementByJS(WebDriver driver, String elementId) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement elementToClick = driver.findElement(By.id(elementId));
        js.executeScript("arguments[0].click();", elementToClick);
        return driver;
    }

    // Method 2: Scrolling to a specific element using JavaScript
    public static WebDriver scrollToElementByJS(WebDriver driver, String elementId) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement elementToScrollTo = driver.findElement(By.id(elementId));
        js.executeScript("arguments[0].scrollIntoView(true);", elementToScrollTo);
        return driver;
    }

    // Method 3: Scrolling the page by a certain number of pixels
    public static WebDriver scrollByPixels(WebDriver driver, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
        return driver;
    }

    // Method 4: Scrolling to the bottom of the page
    public static WebDriver scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        return driver;
    }

    // Method 5: Getting the page title using JavaScript
    public static String getPageTitleByJS(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return document.title;");
    }

    // Method 6: Getting the inner text of an element using JavaScript
    public static String getElementInnerTextByJS(WebDriver driver, String elementId) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.id(elementId));
        return (String) js.executeScript("return arguments[0].innerText;", element);
    }
}
