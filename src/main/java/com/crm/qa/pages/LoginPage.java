package com.crm.qa.pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseclass.TestBase;

public class LoginPage extends TestBase{

	//pagefactory or Object repository
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement log;
	
	//Initialization
	public LoginPage(){
		PageFactory.initElements(driver, this);
		
	}
    //Actions
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un,String pwd) {
	  email.sendKeys(un);
	  password.sendKeys(pwd);
	  log.click();
	  return new HomePage();
	  
	  
	}
	
}
