package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;



public class test{
	public static WebDriver driver;
	static ExtentReports reports;
	static ExtentTest test;
	@BeforeTest
	public void startup()
	{

		 reports = new ExtentReports();
		 
		 test = reports.createTest("csvds");
	}
	
	@AfterTest
	public static void endTest()
	{
		
	reports.flush();
	test.log(Status.PASS, "cds");
	}
	
    @Test
    public static void switchtab() throws InterruptedException, IOException{

       // WebDriverManager.firefoxdriver().setup();
    	//setting firefox driver
        
        driver = new ChromeDriver();
        
        //navigate to web page
        driver.get("https://selectorshub.com");
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//li[@id='menu-item-4098']")).click();
      //  By youtubedata = By.xpath("//a[contains(text(),'Click to learn \"How does XPath works internally?\"')]");
        By youtubedata = By.xpath("//input[@id='userId']");
       eplicitlyWait(youtubedata);
    //    System.out.println(driver.findElement(youtubedata).getAttribute("href"));
        
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
        a.moveToElement(driver.findElement(editIcon)).
        click().build().perform();
        
        WebElement nameThroughAutomation = driver.findElement(By.xpath("//input[@class='nameFld']"));
        nameThroughAutomation.click();
        nameThroughAutomation.sendKeys("Dell acd");
        
        fullPageScreenshot();
        
       driver.quit();
    }
    
    public static void eplicitlyWait(By webelement)
    {
    	new WebDriverWait(driver, Duration.ofSeconds(20)).until(
    			ExpectedConditions.elementToBeClickable(webelement));   	  
    }
    
    public static void fullPageScreenshot() throws IOException {
        Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(s.getImage(),"PNG",new File("target/fullpagescreenshot-"+timeStamp()+".png"));

	}

	public static void pageScreenshot() throws IOException {
	     File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     FileHandler.copy(source, new File("pagescreenshot-"+timeStamp()+".png"));
	}
	
	public static String timeStamp()
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		return timeStamp;
	}
        
}