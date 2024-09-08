package tests;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import configurations.logs.Log;
import pages.HomePage;

public class BaseTest {
    @Getter
    public WebDriver driver;
    public HomePage homePage;

    @BeforeClass
    public void classSetup() {
        Log.info("Tests starting!");
    }

    @BeforeMethod
    public void Setup() {
        homePage = new HomePage();
    }

    @AfterClass
    public void teardown() {
        Log.info("Tests ended");
        driver.quit();
    }
}