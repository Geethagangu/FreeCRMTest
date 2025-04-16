package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.baseclass.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskLink;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactspage;
	DealsPage dealspage;
	TaskLink taskspage;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void initialize() {
		initialization();
		 loginpage=new LoginPage();
		 contactspage=new ContactsPage();
		 homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 testUtil=new TestUtil();
	}
	
	@Test
	public void verifyUserName() {
	testUtil.switchToFrame();
	Assert.assertTrue(homepage.visibilityOfUser());
	}
	
	@Test
	public void ClickOnContactLink() {
		testUtil.switchToFrame();
		contactspage=homepage.clickOnContactslink();
	}
	
	@Test
	public void ClickOnDealsLink() {
		testUtil.switchToFrame();
		 dealspage=homepage.clickOnDealslink();
	}
	
	@Test
	public void ClickOnTasksLink() {
		testUtil.switchToFrame();
		 taskspage=homepage.clickOnTaskslink();
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
