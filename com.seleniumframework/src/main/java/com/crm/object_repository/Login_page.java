package com.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
//Initialization
	public Login_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//Declaration
	@FindBy(name="user_name")
	private WebElement UserNameTextfield;
	
	@FindBy(name="user_password")
	private WebElement passwordTextfield;
	
	@FindBy(id="submitButton")
	private WebElement submitbutton;

	//getter methods 
	public WebElement getUserNameTextfield() {
		return UserNameTextfield;
	}

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public WebElement getSubmitbutton() {
		return submitbutton;
	}
	//business logic 
	/**
	 * this method used to login the application
	 * @param username
	 * @param password
	 * @prashanth
	 */
public void login(String username ,String password )
{
	UserNameTextfield.sendKeys(username);
	passwordTextfield.sendKeys(password );
	submitbutton.click();
}

	
}
