package com.stepDefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.*;
import java.time.Duration;

public class FlightSearchSteps {
    WebDriver driver;

    @Given("the user launches Chrome browser and opens MakeMyTrip website")
    public void launchBrowser() {
    	String driverPath = System.getProperty("user.dir");
        System.setProperty("webdriver.edge.driver", driverPath+"/Driver/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.makemytrip.com/");
    }

    @Given("the user clicks on Flights tab")
    public void clickFlightsTab() {
    	try {
            WebElement closePopup = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
            closePopup.click();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        driver.findElement(By.xpath("//span[text()='Flights']")).click();
    }

    @Given("the user selects Round Trip option")
    public void selectRoundTrip() {
        driver.findElement(By.xpath("//li[text()='Round Trip']")).click();
    }

    @Given("the user enters {string} as the From location")
    public void enterFromLocation(String from) throws InterruptedException {
        driver.findElement(By.id("fromCity")).click();
        WebElement fromInput = driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromInput.sendKeys(from);
        Thread.sleep(1000);
        fromInput.sendKeys(Keys.ENTER);
    }

    @Given("the user enters {string} as the To location")
    public void enterToLocation(String to) throws InterruptedException {
        driver.findElement(By.id("toCity")).click();
        WebElement toInput = driver.findElement(By.xpath("//input[@placeholder='To']"));
        toInput.sendKeys(to);
        Thread.sleep(1000);
        toInput.sendKeys(Keys.ENTER);
    }

    @Given("the user selects departure and return dates")
    public void selectDates() {
        driver.findElement(By.xpath("//label[@for='departure']")).click();
        WebElement departureDate = driver.findElement(By.xpath("//*[@id='top-banner']/div[2]/div/div/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[5]/div[1]/div/p[1]"));
        departureDate.click();
        driver.findElement(By.xpath("//label[@for='return']")).click();
        WebElement returnDate = driver.findElement(By.xpath("//*[@id='top-banner']/div[2]/div/div/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[1]/div[4]/div/p[2]"));
        returnDate.click();
    }

    @When("the user clicks on the Search button")
    public void clickSearchButton() {
        driver.findElement(By.xpath("//a[text()='Search']")).click();
    }

    @Then("the flight search results page should be displayed")
    public void verifySearchPage() throws InterruptedException {
        Thread.sleep(5000);
        if (driver.getCurrentUrl().contains("flight/search")) {
            System.out.println("Search results page displayed.");
        } else {
            System.out.println("Search results page not displayed.");
        }
        driver.quit();
    }
}

