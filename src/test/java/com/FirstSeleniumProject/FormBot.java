package com.FirstSeleniumProject;

import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormBot {
	static Random rand = new Random();
	
	public static String generateRandomNumber(int length) {
		StringBuilder mobilenumber = new StringBuilder(String.valueOf(length-1));
		for(int i =0 ; i<length; i++) {
			int number = rand.nextInt(10);
			mobilenumber.append(number);
		}
		return mobilenumber.toString();
	}
	
	public static String  getRandomValue(String value) {
		String returnval="";
		int num= rand.nextInt(5);
		if(value=="gender") {
			if(num == 0) {
				returnval="//input[@value='male']";
			}else if(num== 1) {
				returnval="//input[@value='female']";
			}else {
				returnval="//input[@value='male']";
			}
		}else if(value=="country") {
			if(num==0) {
				returnval="India";
			}
			else if(num==1) {
				returnval="USA";
			}else if(num==2) {
				returnval="Canada";
			}else if(num==3) {
				returnval="UK";
			}else{
				returnval="Australia";
			}
			
		}else if(value=="programming") {
			if(num== 0) {
				returnval="//input[@value='JavaScript']";
			}else if(num== 1) {
				returnval="//input[@value='Java']";
			}else {
				returnval="//input[@value='Python']";
			}
		}else {
			returnval="No Value";
		}
		return returnval;
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./binaries/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://form-bot-anvsystems.pages.dev/");
		for(int i=0; i<10; i++) {
			driver.findElement(By.name("firstname")).sendKeys(UUID.randomUUID().toString().substring(0, 8));
			driver.findElement(By.name("lastname")).sendKeys(UUID.randomUUID().toString().substring(0, 5));
			driver.findElement(By.name("email")).sendKeys(UUID.randomUUID().toString().subSequence(0, 7)+"@gmail.com");
			driver.findElement(By.xpath(getRandomValue("gender"))).click();
			driver.findElement(By.name("phone")).sendKeys("+91 "+generateRandomNumber(10));
			Select s = new Select(driver.findElement(By.name("country")));
			s.selectByVisibleText(getRandomValue("country"));
			driver.findElement(By.xpath(getRandomValue("programming"))).click();
			driver.findElement(By.tagName("button")).click();
		}
		Thread.sleep(8000);
		driver.quit();
	}
	
	
}
