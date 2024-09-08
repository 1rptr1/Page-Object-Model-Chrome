package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import configurations.logs.Log;

public class PracticePage extends BasePage {
    /**
     * Constructor
     */
    public PracticePage() {
        super();
    }

    /**
     * Web Elements
     */
    By userEmailId               = By.xpath("//input[@id='userId']");
    By passwordId                = By.xpath("//input[@id='pass']");
    By companyId                 = By.xpath("//input[@name='company']");
    By submit                    = By.xpath("//input[@type='submit']");
    By errorMessageUsernameXpath = By.xpath("//*[@id=loginForm]/div[1]/div/div");
    By errorMessagePasswordXpath = By.xpath("//*[@id=loginForm]/div[2]/div/div ");

    /**
     * Page Methods
     */
    public PracticePage loginToSH(String username, String password, String company) {
        Log.info("Trying to login the Practice page");
        implicitWait(10);
        click(userEmailId);
        writeText(userEmailId, username);
        click(passwordId);
        writeText(passwordId, password);
        click(companyId);
        writeText(companyId, company);
        click(submit);
        return this;
    }

    //Verify Username Condition
   /* public practicePage verifyLoginUserName(String expectedText) {
        Log.info("Verifying login username.");
        waitVisibility(errorMessageUsernameXpath);
        assertEquals(readText(errorMessageUsernameXpath), expectedText);
        return this;
    }

    //Verify Password Condition
    public practicePage verifyLogError() {
        Log.info("Verifying javascript login errors.");
        assertTrue(JSErrorLogs.isLoginErrorLog(driver));
        return this;
    }*/

}
