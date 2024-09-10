package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import configurations.logs.Log;
import pages.HomePage;
import utility.DriverFactory;

public class BaseTest {
    @Getter
    public WebDriver driver;
    public HomePage homePage;

    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    protected static ExtentTest extentTest= new ThreadLocal<ExtentTest>().get();

    @BeforeClass
    public void classSetup() {
        Log.info("Tests starting!");
    }

    @BeforeTest
    public void startReporter()
    {
        extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir") + "/target/Reports/extentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);


        //configuration items to change the look and feel
        //add content, manage tests etc
        extentSparkReporter.config().setDocumentTitle("Automation Report");
        extentSparkReporter.config().setReportName("Test Report");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }



    @BeforeMethod
    public void Setup() {
        homePage = new HomePage();
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL,result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, result.getTestName());
        }
        else {
            extentTest.log(Status.SKIP, result.getTestName());
        }
    }
    @AfterTest
    public void tearDown() {
        //to write or update test information to the reporter
        extentReports.flush();
        Log.info("Tests ended");
        DriverFactory.quitDriver();
    }

}