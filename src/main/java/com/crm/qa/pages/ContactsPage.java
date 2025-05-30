package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.baseclass.TestBase;

public class ContactsPage  extends TestBase {

	
	@FindBy(xpath="//td[contains(text(),'Contacts")
	WebElement contactslabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="last_name")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement companyName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
	return contactslabel.isDisplayed();	
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id]')).click()"));
	}
	
public void createNewContact(String text,String fN,String LN,String CN) {
	Select select=new Select(driver.findElement(By.name("title")));
	select.selectByVisibleText(text);
	firstName.sendKeys(fN);
	lastName.sendKeys(LN);
	companyName.sendKeys(CN);
	saveBtn.click();
	
		
	}
	
	}

      
