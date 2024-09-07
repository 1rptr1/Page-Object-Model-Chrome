package tests;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static configurations.extentreports.ExtentTestManager.startTest;

public class LoginTests extends tests.BaseTest {
    @Test(priority = 0, description = "valid Scenario with username ,password  and company.")
    public void sendingDetailsToPage(Method method) {
        //ExtentReports Description
        startTest(method.getName(), "valid Scenario with username ,password  and company.");

        homePage
            .goToSelectorsHub()
            .goToPracticePage()
            .loginToSH("Saurav@gmail.com","tomtom@123","Dell");

    }

}