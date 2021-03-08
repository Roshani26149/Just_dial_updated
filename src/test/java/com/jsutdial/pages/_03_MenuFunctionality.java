package com.jsutdial.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class _03_MenuFunctionality {
	//initializes webdriver
	private WebDriver driver;
	

	//Parameterized constructor
	public _03_MenuFunctionality(WebDriver driver) {
		this.driver=driver;
	}

	//Locators
    private By minu_list =By.xpath("//a[contains(@id,'ContextualHotkey')]");

	//Actions
	public void Select_minu_List(String product) throws Exception {
		List<WebElement> list=driver.findElements(minu_list);
         System.out.println("The List in The Minu List is "+list.size());
          for(int i=0;i<list.size();i++) {
        	 // System.out.println(list.get(i).getText());
			try {
                if(list.get(i).getText().contains(product))
				{
                  list.get(i).click();
                  
				}
			}catch(StaleElementReferenceException e) 
			{
				list=driver.findElements(minu_list);
				if(list.get(i).getText().contains(product)) 
				{
					list.get(i).click();
					
				}
				
			}

		}
	}

}


