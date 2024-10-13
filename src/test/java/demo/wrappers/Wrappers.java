package demo.wrappers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.mustache.StringChunk;

import net.bytebuddy.asm.Advice.Local;

import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    public static void enterText(WebElement element , String text){
        try {
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public static void radiobutton(ChromeDriver driver,String radioButtonText){
        try {
            WebElement element = driver.findElement(By.xpath("//span[contains(@class,'tyNBNd')]//span[contains(text(),'"+radioButtonText+"')]"));
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
    public static void checkbox(ChromeDriver driver,String checkboxText){
        try {
            WebElement element = driver.findElement(By.xpath("//div[contains(@class , \"Y6Myld\")]//span[contains(text(), '"+checkboxText+"')]"));
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
    public static void dropDown(ChromeDriver driver,String dropdownText){
        try {
            WebElement element = driver.findElement(By.xpath("//div[contains(@class, 'QXL7Te')]//span[text()='"+dropdownText+"']"));
            element.click();
            

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
    public static void clickonText(ChromeDriver driver,WebElement element){
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public static String getdateSevenDaysAgo(){
        LocalDate currentDate = LocalDate.now();
        LocalDate dateMiuns7Dyas = currentDate.minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = dateMiuns7Dyas.format(formatter);
        return formattedDate;
    }
    public static String getEpochTimeAsStirng(){
        long epochTime = System.currentTimeMillis()/1000;
        String epochTimeString = String.valueOf(epochTime);
        return epochTimeString;

    }
}
