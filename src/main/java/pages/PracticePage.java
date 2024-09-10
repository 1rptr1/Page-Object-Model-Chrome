package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import configurations.logs.Log;

import java.util.Set;

import static utility.Waits.*;

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
    By userEmailId = By.xpath("//input[contains(@id,'shub')]");
    By passwordId = By.xpath("//input[@id='pass']");
    By companyId = By.xpath("//input[@name='company']");
    By submit = By.xpath("//button[@value='Submit']");
    By errorMessageUsernameXpath = By.xpath("//*[@id=loginForm]/div[1]/div/div");
    By errorMessagePasswordXpath = By.xpath("//*[@id=loginForm]/div[2]/div/div ");

    /**
     * Page Methods
     */
    public void loginToSH(String username, String password, String company) {
        Log.info("Trying to login the Practice page");
        fluentWait(driver, userEmailId, 500,20);
        click(userEmailId);
        writeText(userEmailId, username);
        click(passwordId);
        writeText(passwordId, password);
        click(companyId);
        writeText(companyId, company);
        click(submit);
    }
}
