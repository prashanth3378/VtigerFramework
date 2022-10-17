package com.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganization {
	//Initialization
	public CreatingNewOrganization(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	//Declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreatingNewOrganization;
	
	
	@FindBy(name="accountname")
	private WebElement organizationtextfield;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	//getters method 
	public WebElement getCreatingNewOrganization() {
		return CreatingNewOrganization;
	}

	public WebElement getOrganizationtextfield() {
		return organizationtextfield;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	//Business logic
	public void CreatingNewOrganization()
	{
		CreatingNewOrganization.click();
	}
	public void organizationtextfield(String data)
	{
		organizationtextfield.sendKeys(data);
	}
	public void savebutton()
	{
	savebutton.click();
	}
}