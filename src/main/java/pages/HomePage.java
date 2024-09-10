package pages;

import configurations.logs.Log;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    /**
     * Constructor
     *
     */
    public HomePage() {
       super();
    }

    /**
     * Variables
     */
    String baseURL = "https://selectorshub.com";

    /**
     * Web Elements
     */
    By products      =   By.xpath("//li[@id='menu-item-27']");
    By proPlans =   By.xpath("//li[@id='menu-item-33']");
    By courses       =   By.xpath("//li[@id='menu-item-1075']");
    By practicePage =   By.xpath("//li[@id='menu-item-4098']");
    By resources     =   By.xpath("//li[@id='menu-item-36']");
    By about         =   By.xpath("//li[@id='menu-item-48']");
    By search        =   By.xpath("//input[@type='search']");

    /**
     * Page Methods
     */
    //Go to Homepage
    public HomePage goToSelectorsHub() {
        Log.info("Opening the Website.");
        driver.get(baseURL);
        return this;
    }

    //Go to LoginPage
    public PracticePage goToPracticePage() {
        Log.info("Going to practice page");
        click(practicePage);
        return new PracticePage();
    }
}