package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    private DriverFactory(){
        throw  new IllegalStateException("Driver Factory Class");
    }
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    // Method to create and get the driver instance for the current thread
    public static WebDriver getDriver() {
        if (threadLocalDriver.get() == null) {
            Properties propertiesReader = Properties.getInstance();
            String browserName = propertiesReader.getProperty("browser");

            WebDriver driver;
            switch (browserName.toUpperCase()) {
                case "CHROME":
                    driver = new ChromeDriver();
                    break;
                case "FIREFOX":
                    driver = new FirefoxDriver();
                    break;
                case "SAFARI":
                    driver = new SafariDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser type: " + browserName);
            }

            driver.manage().window().maximize();
            threadLocalDriver.set(driver);
        }
        return threadLocalDriver.get();
    }

    // Method to quit the WebDriver and remove it from the ThreadLocal
    public static void quitDriver() {
        WebDriver driver = threadLocalDriver.get();
        if (driver != null) {
            driver.quit();
            threadLocalDriver.remove();  // Prevent memory leaks
        }
    }

}
