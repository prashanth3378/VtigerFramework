package com.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaign {
//Initialization
	public CreateNewCampaign(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
//Declaration
	@FindBy(xpath="//img[@src=\'themes/softed/images/btnL3Add.gif\']")
	private WebElement CreateCampaign  ;
	
	@FindBy(xpath="//input[@class=\'detailedViewTextBox\']")
	private WebElement CampaignNametextfield;
	
	@FindBy(xpath="//input[@title=\'Save [Alt+S]']")
	private WebElement savebutton;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement Productselect;
	
	@FindBy(id="search_txt")
	private WebElement SearchTextfield;
	
	@FindBy(xpath="//input[@class=\'crmbutton small create\']")
	private WebElement SearchNowButton;

	
//getters methods
	public WebElement getCreateCampaign() {
		return CreateCampaign;
	}

	public WebElement getCampaignNametextfield() {
		return CampaignNametextfield;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getProductselect() {
		return Productselect;
	}

	public WebElement getSearchTextfield() {
		return SearchTextfield;
	}

	public WebElement getSearchNowButton() {
		return SearchNowButton;
	}
	
	//business logic
	public void CreateCampaign()
	{
		CreateCampaign.click();
	}
	
	public void CampaignNametextfield(String data)
	{
		CampaignNametextfield.sendKeys(data);
	}
	public void savebutton()
	{
		savebutton.click();
	}
	public void Productselect()
	{
		Productselect.click();
	}
	public void SearchTextfield(String data)
	{
		SearchTextfield.sendKeys(data);
	}
	public void SearchNowButton()
	{
		SearchNowButton.click();
	}
	
	
	
}
