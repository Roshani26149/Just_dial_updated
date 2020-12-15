package com.justdial.StepDefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.jsutdial.pages._01_LoginPage;
import com.jsutdial.pages._02_SearchFunctionality;
import com.jsutdial.pages._03_MenuFunctionality;
import com.jsutdial.pages._04_CustomerCarePage;
import com.justdial.core.WebDriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination {

	private static final Logger logger = LogManager.getLogger(StepDefination.class);


	WebDriver driver;
	String base_url = "https://www.justdial.com/";
	int implicit_wait_timeout_in_sec = 20;
	Scenario scn;

	//declare pages
	_01_LoginPage loginpage;
	_02_SearchFunctionality SearchFunctionality;
	_03_MenuFunctionality MenuFunctionality;
	_04_CustomerCarePage CustomerCarePage;

	@Before
	public void setUp(Scenario scn) throws Exception {
		this.scn = scn; 

		String browserName = WebDriverFactory.getBrowserName();
		driver = WebDriverFactory.getWebDriverForBrowser(browserName);
		logger.info("Browser invoked.");

		//Initialize Page Object Model
		loginpage=new _01_LoginPage(driver);
		SearchFunctionality =new _02_SearchFunctionality(driver);
		MenuFunctionality =new _03_MenuFunctionality(driver);
		CustomerCarePage =new _04_CustomerCarePage(driver);
	}
	
	 @After(order=1)
	    public void cleanUp(){
	        WebDriverFactory.quitDriver();
	        scn.log("Browser Closed");
	    }
	 @After(order=2)
	    public void takeScreenShot(Scenario s) {
	        if (s.isFailed()) {
	            TakesScreenshot scrnShot = (TakesScreenshot)driver;
	            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
	            scn.attach(data, "image/png","Failed Step Name: " + s.getName());
	        }else{
	            scn.log("Test case is passed, no screen shot captured");
	        }
	    }
	
	//********************LoginPageSteps***************************************************
	 
	 @Given("User navigates to the application url")
	 public void user_navigates_to_the_application_url() {
		 WebDriverFactory.navigateToTheUrl(base_url);
	        scn.log("Browser navigated to URL: " + base_url);
         String expected = "Justdial - Local Search, Social, News, Videos, Shopping";
         String Actual =driver.getTitle();
         Assert.assertEquals("Title matched", expected, Actual);
	 }

	 @When("User clicks on Sign up link at the top right corner of the application")
	 public void user_clicks_on_sign_up_link_at_the_top_right_corner_of_the_application() throws Exception {
		 loginpage.Click_On_Sign_in();
		 
	 }

	 @When("User enters name as {string} and Phone number as {string} and clicks on Submit Button")
	 public void user_enters_name_as_and_phone_number_as_and_clicks_on_submit_button(String namefield, String mobfield) throws Exception {
		 loginpage.login_pop_up(namefield, mobfield);
	 }

	 @Then("User is displayed with the message as {string}")
	 public void user_is_displayed_with_the_message_as(String msg) {
		 loginpage.msg_display(msg);
		 logger.info("The Massage displayed - "+msg);
	 }

	 @When("User clicks on Login-in link at the top right corner of the application")
	 public void user_clicks_on_login_in_link_at_the_top_right_corner_of_the_application() throws Exception {
		 loginpage.Click_On_Login();
	 }

	 @When("User enters name as {string} and Phone number {string} and clicks on Submit Button")
	 public void user_enters_name_as_and_phone_number_and_clicks_on_submit_button(String name1, String mob1) throws Exception {
		 loginpage.Enter_name(name1, mob1);
	     
	 }
     @Then("User gets error message")
	 public void user_gets_error_message() {
    	 loginpage.Error_msg();
     }
	 @Then("User is able to enter only {string} digits in the Mobile text field")
	 public void user_is_able_to_enter_only_digits_in_the_mobile_text_field(String num) {
		 loginpage.cheke_mob_field(num);
	 }
   
	 //********************Search Related Steps*********************************************
	 
	 @When("User enters {string} in search text box")
	 public void user_enters_in_search_text_box(String searchname) throws Exception {
		 SearchFunctionality.search_text(searchname);
	     
	 }

	 @When("User clicks search button")
	 public void user_clicks_search_button() throws Exception {
		 SearchFunctionality.Click_search();
	 }

	 @Then("User is able to see search result related to {string}")
	 public void user_is_able_to_see_search_result_related_to(String string) {
	    
	 }

	 @When("User enters a {string} in search text box")
	 public void user_enters_a_in_search_text_box(String resta) throws Exception {
		 SearchFunctionality.Partial_search(resta);
		 Thread.sleep(2000);
	 }

	 @Then("User is able to see the drop down under search text box with all the items with text {string}")
	 public void user_is_able_to_see_the_drop_down_under_search_text_box_with_all_the_items_with_text(String string) {
		 SearchFunctionality.Select_All_link();
	 }
   
	 //*******************Menu Related steps**********************************************************
	 
	 @When("User clicks on {string}")
	 public void user_clicks_on(String product) throws Exception {
		 MenuFunctionality.Select_minu_List(product);
	 }

	 @Then("User is navigates to the corresponding link realted to {string}")
	 public void user_is_navigates_to_the_corresponding_link_realted_to(String string) {
	     
	 }
	 
	 //*************************Customer Care Steps*************************************************

	 @Given("User navigates to Customer care page by clicking on Customer Care tab at the right-mid of the page")
	 public void user_navigates_to_customer_care_page_by_clicking_on_customer_care_tab_at_the_right_mid_of_the_page() {
	    
	 }

	 @When("User enter {string} in the Text box")
	 public void user_enter_in_the_text_box(String test) throws Exception {
		 CustomerCarePage.click_on_customer_link();
		 CustomerCarePage.input_field(test);
		 Thread.sleep(2000);
		 
	 }

	 @Then("User is able to see the drop down and all the items in the list must have text as {string}")
	 public void user_is_able_to_see_the_drop_down_and_all_the_items_in_the_list_must_have_text_as(String string) {
		 CustomerCarePage.Select_All_link();
	 }
	
}
