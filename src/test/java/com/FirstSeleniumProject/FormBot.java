package com.FirstSeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormBot {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./binaries/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://form-bot-anvsystems.pages.dev/");
		
		driver.findElement(By.name("firstname")).sendKeys("Subrat");
		driver.findElement(By.name("lastname")).sendKeys("Sahoo");
		driver.findElement(By.name("email")).sendKeys("subratsahoo@gmail.com");
		driver.findElement(By.name("gender")).click();
		driver.findElement(By.name("phone")).sendKeys("1234567890");
		Select s = new Select(driver.findElement(By.name("country")));
		s.selectByVisibleText("India");
		driver.findElement(By.name("programming")).click();
		driver.findElement(By.tagName("button")).click();
		
	}
}
