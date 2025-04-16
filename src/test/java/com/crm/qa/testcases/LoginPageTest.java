package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.baseclass.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.HomePage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		 loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void pageTitleTest() {
		String title=loginpage.validatePageTitle();
		Assert.assertEquals(title, "Let's shop");
	}
	
	@Test(priority=2)
	public void loginTest() {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	

}

/*@Test
public void imagetest()
{
boolean flag=loginpage.image():
Assrt.asserTrue(flag)*/