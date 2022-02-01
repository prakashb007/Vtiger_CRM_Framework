package com.crm.vtiger.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInfoPage 
{
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerTxt;
	
	public LeadsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderTxt() {
		return headerTxt;
	}
	
}
