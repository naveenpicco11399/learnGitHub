package com.vsMaven.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class schoolLoginOBJ {


    WebDriver driver;

	public schoolLoginOBJ(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(ldriver, this);

	}

	/*
	 * locator for login page
	 */

	@FindBy(xpath = "//input[@placeholder='School code']")
	@CacheLookup
	WebElement SchoolCode;

	@FindBy(xpath = "//button[text()='Submit']")
	@CacheLookup
	WebElement Submit;

	@FindBy(xpath = "//div[text()='Code verified successfully']")
	@CacheLookup
	WebElement schoolCodeVerify;

	@FindBy(xpath = "//input[@placeholder='User ID']")
	@CacheLookup
	WebElement UserID;

	@FindBy(xpath = "//input[@placeholder='Password']")
	@CacheLookup
	WebElement Password;

	@FindBy(xpath = "//button[text()='LOGIN']")
	@CacheLookup
	WebElement LOGIN;

	/*
	 * 
	 */

	public void SchoolCode(String code) {
		SchoolCode.sendKeys(code);
	}

	public void submit() {
		Submit.click();
	}
	
	public void VerifySchlCode() {
		
		String act=schoolCodeVerify.getTagName();
		Assert.assertEquals("Code verified successfully", act);
	}

	public void UserID(String id) {
		UserID.sendKeys(id);
	}

	public void Password(String pword) {
		Password.sendKeys(pword);
	}
	
	public void LOGIN() {
		LOGIN.click();
	}

    
}
