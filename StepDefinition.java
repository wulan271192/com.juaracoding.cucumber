package com.juaracoding.cucumber.definition;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static org.junit.matchers.JUnitMatchers.containsString;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
	WebDriver driver;
	
	@Given("User home page")
	public void userOnHomePage() {
		System.setProperty("webdriver.chrome.driver", "D:/driverchrome/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@When("User input username as {string}")
	public void inputUsername(String userName) throws InterruptedException {
		System.out.println("Username input");
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		
		
	}
	
	@When("User input password as {string}")
	public void inputPassword(String userPassword) throws InterruptedException {
		System.out.println("Password input");
		driver.findElement(By.id("txtPassword")).sendKeys(userPassword);
		
		driver.findElement(By.id("btnLogin")).submit();
	}
	
	@Then("User berhasil login")
	public void successfullLogin() throws InterruptedException {
		String newPageText = driver.findElement(By.id("welcome")).getText();
		System.out.println("Welcome : "+newPageText);
		assertThat(newPageText, containsString("Welcome"));
		
	}

	@Then("User gagal login dengan pesan: {string}")
	public void unsuccessfullLogin(String errorMessage) throws InterruptedException{
		
		String actualErrorMessage = driver.findElement(By.id("spanMessage")).getText();
		System.out.println("actula Error message :" + actualErrorMessage);
		

		assertTrue(actualErrorMessage.equalsIgnoreCase(errorMessage));
	}
}