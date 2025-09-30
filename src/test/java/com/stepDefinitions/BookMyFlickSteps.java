package com.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookMyFlickSteps {
	WebDriver driver;
	
	@Given("user is on the movie search page")
	public void openSearchPage() {
		driver.get("https://in.bookmyshow.com/");
	}

	@When("user searches for {string}")
	public void searchMovie(String movie) {
		driver.findElement(By.cssSelector(".sc-1jg5yz-1.dIWPfO")).click();
		driver.findElement(By.id("//span[contains(text(),'Search for Movies')]")).sendKeys(movie);
		driver.findElement(By.xpath("//span[contains(text(),'Homebound')]")).click();
	}

	@Then("booking should be confirmed")
	public void confirmBooking() {
		Assert.assertTrue(driver.findElement(By.id("confirmation")).isDisplayed());
	}

}
