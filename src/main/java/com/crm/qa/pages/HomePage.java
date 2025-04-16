package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseclass.TestBase;

public class HomePage  extends TestBase{
	
	//page factory
	@FindBy(xpath="//td[contains(text(),'User: Naveen')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasklink;
	
	@FindBy(xpath="//a[contains(text(),'New contact')]")
	WebElement newContactLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
		
	}

	//Actions
	public boolean visibilityOfUser()
{
		return userNameLabel.isDisplayed();
		
		}
	
	public ContactsPage clickOnContactslink()
	{
		contactslink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealslink()
	{
		dealslink.click();
		return new DealsPage();
	}
	public TaskLink clickOnTaskslink()
	{
		tasklink.click();
		return new TaskLink();
	}
	
	public void clickOnNewContactLink() {
		Actions action=new Actions(driver);
		action.moveToElement(contactslink).build().perform();
		newContactLink.click();		
	}
	
	
}
