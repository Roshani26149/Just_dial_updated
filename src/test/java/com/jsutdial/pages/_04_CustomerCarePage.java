package com.jsutdial.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class _04_CustomerCarePage {
	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger(_04_CustomerCarePage.class);


	public _04_CustomerCarePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	//Locators
	private By customer_care =By.xpath("//a[@class='cscare ']");
	private By input_field =By.id("what");
	
	//Actions
	
	public void click_on_customer_link() throws Exception {
		driver.findElement(customer_care).click();
		Thread.sleep(4000);
		String actual=driver.getTitle();
		String expected ="Justdial Customer Support - Customer Care for Clients";
		Assert.assertEquals("Customer is on customer page", expected, actual);
		
	}
	public void input_field(String test) {
		driver.findElement(input_field).sendKeys(test);
	}

	public void Select_All_link() {
		List<WebElement> dropList =driver.findElements(input_field);
		
		for(WebElement a :dropList) {
			System.out.println("list of all online option is "+a.getText());
		}
		
	}
	
}
