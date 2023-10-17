package com.FirstSeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleBot {
	
	public static void main(String[] args) throws InterruptedException {
//		System.out.println(System.getProperty("os.name"));
		System.setProperty("webdriver.chrome.driver", "D:\\CODE\\JAVA\\SeleniumBasics\\binaries\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.findElement(By.name("field-keywords")).sendKeys("Oneplus 11r");
		driver.findElement(By.name("field-keywords")).sendKeys(Keys.ENTER);
//		driver.findElement(By.id("v3vtwxgppca0z12v18v51zrqona")).click();
		Thread.sleep(5000);
		driver.quit();
	}
}
