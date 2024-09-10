package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static utility.Utils.fullPageScreenshot;


public class TestInitiator {
    public static WebDriver driver;
    static ExtentReports reports;
    static ExtentTest test;

    @AfterTest
    public static void endTest() {

        reports.flush();
        test.log(Status.PASS, "cds");
    }

    @Test
    public static void switchTab() throws IOException {
        driver = new ChromeDriver();

        //navigate to web page
        driver.get("https://selectorshub.com");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//li[@id='menu-item-4098']")).click();

        By youtubeData = By.xpath("//input[@id='userId']");
        eplicitlyWait(youtubeData);

        WebElement username = driver.findElement(By.xpath("//input[@id='userId']"));
        username.click();
        username.sendKeys("dsadsa");

        WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
        password.click();
        password.clear();
        password.sendKeys("botbot@123");

        WebElement company = driver.findElement(By.xpath("//input[@name='company']"));
        company.click();
        company.sendKeys("JBL");

        //SVG element
        By editIcon = (By.xpath("//*[local-name()='svg' and @iconid='editon']/*[local-name()='path']"));
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(editIcon)).click().build().perform();

        WebElement nameThroughAutomation = driver.findElement(By.xpath("//input[@class='nameFld']"));
        nameThroughAutomation.click();
        nameThroughAutomation.sendKeys("Dell acd");

        fullPageScreenshot(driver);

        driver.quit();
    }

    public static void eplicitlyWait(By webelement) {
        new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(webelement));
    }

    @BeforeTest
    public void startup() {

        reports = new ExtentReports();
        test = reports.createTest("Test Start");
    }

}