package com.jsutdial.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _02_SearchFunctionality {
	
	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger(_02_SearchFunctionality.class);
	 
	//Parameterized constructor
	public _02_SearchFunctionality(WebDriver driver) {
		this.driver=driver;
	}
	
	//Locators
	private By Search_text =By.id("srchbx");
	private By Search_btn =By.id("srIconwpr");
	
	//Actions
	public void search_text(String searchname) throws Exception {
		driver.findElement(Search_text).sendKeys(searchname);
		Thread.sleep(5000);
	
	}
	
	public void Click_search() throws Exception {
		Thread.sleep(2000);
		driver.findElement(Search_btn).click();
		Thread.sleep(3000);
		logger.info("The Result of Restaurant searched ");
	}
	
	public void Partial_search(String resta) {
		driver.findElement(Search_text).sendKeys(resta);
	}
	public void Select_All_link() {
		
		WebElement mySelectElement = driver.findElement(By.xpath("//a[contains(@id,'-')]"));
		System.out.println("The restorents are "+mySelectElement.getText());
	    List<WebElement> options = driver.findElements(By.xpath("//a[contains(@id,'-')]"));
		for (WebElement option : options) {
		System.out.println("The Restarents are " +option.getText());
		logger.info("The Restarents are " +option.getText());
		}
	}

}
