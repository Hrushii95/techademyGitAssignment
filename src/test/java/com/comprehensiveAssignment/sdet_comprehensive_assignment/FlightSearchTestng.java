package com.comprehensiveAssignment.sdet_comprehensive_assignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlightSearchTestng {
	WebDriver driver;

    @BeforeMethod
    public void setup() {
    	String driverPath = System.getProperty("user.dir");
        System.setProperty("webdriver.edge.driver", driverPath+"/Driver/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.makemytrip.com/");
    }
    
    @Test
    public void searchRoundTripFlights() throws InterruptedException {
    	try {
            WebElement closePopup = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
            closePopup.click();
        } catch (Exception e) {
        	e.printStackTrace();
        }

        driver.findElement(By.xpath("//span[text()='Flights']")).click();

        driver.findElement(By.xpath("//li[text()='Round Trip']")).click();

        WebElement fromInput = driver.findElement(By.id("fromCity"));
        fromInput.click();
        WebElement fromSearch = driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromSearch.sendKeys("HYD");
        driver.findElement(By.xpath("//span[contains(text(),'HYD')]")).click();

        WebElement toInput = driver.findElement(By.id("toCity"));
        toInput.click();
        WebElement toSearch = driver.findElement(By.xpath("//input[@placeholder='To']"));
        toSearch.sendKeys("MAA");
        driver.findElement(By.xpath("//span[contains(text(),'MAA')]")).click();

        driver.findElement(By.xpath("//span[contains(text(),'Departure')]")).click();
        WebElement departureDate = driver.findElement(By.xpath("//*[@id='top-banner']/div[2]/div/div/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[5]/div[1]/div/p[1]"));
        departureDate.click();

        driver.findElement(By.xpath("//span[contains(text(),'Return')]")).click();
        WebElement returnDate = driver.findElement(By.xpath("//*[@id='top-banner']/div[2]/div/div/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[1]/div[4]/div/p[2]"));
        returnDate.click();
        
        driver.findElement(By.xpath("//a[text()='Search']")).click();
        Thread.sleep(5000);

        assert driver.getCurrentUrl().contains("flight/search") : "Search page not displayed";
    }
    
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
