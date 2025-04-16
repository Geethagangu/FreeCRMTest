package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.baseclass.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactspage;
	String sheetName;
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void initialize() {
		initialization();
		 loginpage=new LoginPage();
		 homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		 testUtil.switchToFrame();
		contactspage= homepage.clickOnContactslink();
		 contactspage=new ContactsPage();
		 testUtil=new TestUtil();
		 testUtil.switchToFrame();
	}
	
	@Test(priority=1)
	public void validateContactsLabel(){
		Assert.assertTrue(contactspage.verifyContactsLabel(),"contacts label is missing" );
		
	}
	
	@Test
	public void SelectContactsTest() {
		contactspage.selectContactsByName("test2 test2");
		
	}
	
	@Test
	public void SelectMultipleContactsTest() {
		contactspage.selectContactsByName("test2 test2");
		contactspage.selectContactsByName("ui uii");
		
	}
	//Data provider
	@DataProvider
	public Object[][] getCRMTestData()
	
	{
	Object data[][]=TestUtil.getTestData(sheetName)	;
	return data;
		
	}
	
	
	@Test(priority=4 ,dataProvider="getCRMTestData")
	public void createContact(String text ,String fN, String LN,String CN) {
		homepage.clickOnNewContactLink();
		contactspage.createNewContact(text, fN, LN, CN);//We have to provide data from excel
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
