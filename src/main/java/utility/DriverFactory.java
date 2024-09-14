package utility;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;

public class DriverFactory {

    private DriverFactory(){
        throw  new IllegalStateException("Driver Factory Class");
    }
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    // Method to create and get the driver instance for the current thread
    @SneakyThrows
    public static WebDriver getDriver() {
        if (threadLocalDriver.get() == null) {
            Properties propertiesReader = Properties.getInstance();
            String browserName = propertiesReader.getProperty("browser");
            String remoteURL = propertiesReader.getProperty("remoteUrl");

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
                case "REMOTE":
                    ChromeOptions options = new ChromeOptions();
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    driver = new RemoteWebDriver(new URL(remoteURL), capabilities);
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
