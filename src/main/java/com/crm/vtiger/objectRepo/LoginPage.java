package com.crm.vtiger.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(name = "user_name")
	private WebElement untbx;
	
	@FindBy(name="user_password")
	private WebElement pwtbx;
	
	@FindBy(id="submitButton")
	private WebElement lgBtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username, String password)
	{
		untbx.sendKeys(username);
		pwtbx.sendKeys(password);
		lgBtn.click();
	}

	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPwtbx() {
		return pwtbx;
	}

	public WebElement getLgBtn() {
		return lgBtn;
	}
}
