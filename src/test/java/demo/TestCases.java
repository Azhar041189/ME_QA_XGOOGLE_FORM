package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beust.jcommander.WrappedParameter;

import java.time.Duration;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;
    WebDriverWait wait;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
    
     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
     @Test   
     public void testCase01() throws InterruptedException{
        // Navigate to the form URL
        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");
        
        // Enter name
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type=\"text\"])[1]")));
        Wrappers.enterText(Name, "Crio Learner");
        System.out.println("wait 1");
               
        // Enter answer
        WebElement ansFieldArea = driver.findElement(By.xpath("//textarea[@aria-label=\"Your answer\"]"));
        String ansFeild = "I want to be the best QA Engineer!";
        String epochTimeString = Wrappers.getEpochTimeAsStirng();
        
        System.out.println("wait 2");
        Wrappers.enterText(ansFieldArea, ansFeild +" "+ epochTimeString);

        System.out.println("wait 3");
        // Select radio button
        Wrappers.radiobutton(driver, "3 - 5");

        System.out.println("wait 4");
         // Select checkboxes
        Wrappers.checkbox(driver, "Java");
        Wrappers.checkbox(driver, "Selenium");
        Wrappers.checkbox(driver, "TestNG");

        System.out.println("wait 5");
        // Select dropdown option
        WebElement dropdoWebElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, \"DEh1R\")]")));
        Wrappers.clickonText(driver, dropdoWebElement);
        Thread.sleep(5000);
        Wrappers.dropDown(driver, "Mr");
        System.out.println("wait 5");

       

       // Enter date
       WebElement dateInputBox = driver.findElement(By.xpath("//input[@type = \"date\"]"));
        System.out.println("wait 6");
        String sevenDaysAgodate = Wrappers.getdateSevenDaysAgo();
        Wrappers.enterText(dateInputBox, sevenDaysAgodate);

       // Enter time
        WebElement hrElement = driver.findElement(By.xpath("(//input[@type = \"text\"])[2]"));
        Wrappers.enterText(hrElement, "07");
        WebElement minElement = driver.findElement(By.xpath("(//input[@type = \"text\"])[3]"));
        Wrappers.enterText(minElement, "30");

        // Submit form
        WebElement submitBtn = driver.findElement(By.xpath("//span[contains(text(), \"Submit\")]"));
        Wrappers.clickonText(driver, submitBtn);
        
        // Verify success message
        System.out.println("wait 7");
        WebElement successMsg = driver.findElement(By.xpath("//div[contains(text(), \"Thanks for your response, Automation Wizard!\")]"));
        String ExpectedMsg = "Thanks for your response, Automation Wizard!";
        Assert.assertEquals(successMsg.getText().trim(), ExpectedMsg);

    }

    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}