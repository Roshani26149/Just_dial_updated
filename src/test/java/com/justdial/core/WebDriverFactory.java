package com.justdial.core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;



public class WebDriverFactory {
	
	 
	    private static WebDriver driver=null;
	    public static WebDriver getWebDriverForBrowser(String browser) throws Exception {
	        switch(browser.toLowerCase()){
	            case "chrome":
	                driver = new ChromeDriver();
	                break;
	            case "firefox":
	                driver = new FirefoxDriver();
	                break;
	            case "headless":
	                ChromeOptions options = new ChromeOptions();
	                options.addArguments("headless");
	                options.addArguments("window-size=1200x600");
	                driver = new ChromeDriver(options);
	                break;
	            default:
	                throw new Exception("No such browser is implemented.Browser name sent: " + browser);
	        }

	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        return driver;
	    }

	    public static void navigateToTheUrl(String url){
	        driver.get(url);
	       
	    }

	    public static void quitDriver(){
	        driver.quit();
	        
	    }
	    
	    public static String getBrowserName(){
	        String browserDefault = "chrome"; //Set by default
	        String browserSentFromCmd = System.getProperty("browser");

	        if (browserSentFromCmd==null){
	            return browserDefault;
	        }else{
	            return browserSentFromCmd;
	        }
	    }


}
