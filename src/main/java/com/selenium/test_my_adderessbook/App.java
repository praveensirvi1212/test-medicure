package com.selenium.test_my_adderessbook;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class App 
{

    public static void main( String[] args ) throws InterruptedException, IOException
    {
          
      //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
      
      System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        
        
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--remote-allow-origins=*");
        
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body > div.contact_section.layout_padding > div > div > div > div.col-md-6.padding_left_0 > div > div")));
       
        driver.get("http://65.0.131.222:30038/contact.html");
        Thread.sleep(5000);
       
        driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[1]/div[1]/div/input")).sendKeys("Praveen Sirvi");
        //driver.findElement(By.name("Name")).sendKeys("Praveen Sirvi");
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[1]/div[2]/div/input")).sendKeys("2354691247");
        //driver.findElement(By.name("Phone Number")).sendKeys("2354691247");
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/input")).sendKeys("sirvi@gmail.com");
        //driver.findElement(By.name("Email")).sendKeys("sirvi@gmail.com");
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[3]/input")).sendKeys("i want to join your medicare company ");
        //driver.findElement(By.name("Message")).sendKeys("i want to take a loan");
        Thread.sleep(2000);
       
        driver.findElement(By.className("btn_box")).click();
        //WebElement element = driver.findElement(By.className("send_bt"));
        //JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        //jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        //jsExecutor.executeScript("arguments[0].click();", element);
        
        String message = driver.findElement(By.id("message")).getText();
        if(message.equals("Email Sent")) {
        	System.out.println("Script executed Successfully");
        }
        else {
        	System.out.println("Script failed");
        }
        
        System.out.println("Taking Screenshot as proof");
        //take the screenshot of the testcase
        
		
		  TakesScreenshot scrShot = ((TakesScreenshot)driver);
		  
		  File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
		  
		  File destFile = new File("screenshot.png");
		  
		  FileUtils.copyFile(screenShot, destFile);
		 
		  System.out.println("reports stored at : " + destFile.getAbsolutePath().toString());
        
        Thread.sleep(3000);
    
    driver.quit();
    
    
    }
}
