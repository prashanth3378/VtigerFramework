package com.crm.object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page {
//Initialization
		public Home_page(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
//Declaration
		@FindBy(linkText="Organizations")
		private WebElement organizationlinktext;
		
		@FindBy(xpath="//a[@href=\'javascript:;\']")
		private WebElement morelink;
		
		@FindBy(linkText="Campaigns")
		private WebElement Campaignslink ;
		
		@FindBy(linkText="Products")
		private WebElement Productslinktext;
		
		@FindBy(xpath="//img[@src=\'themes/softed/images/user.PNG\']")
		private WebElement signoutImg;
		
		@FindBy(xpath="//a[.='Sign Out']")
		private WebElement signoutlinkText;
	// getters method 

		public WebElement getOrganizationlinktext() {
			return organizationlinktext;
		}

		public WebElement getMorelink() {
			return morelink;
		}

		public WebElement getCampaignslinktext() {
			return Campaignslink;
		}

		public WebElement getProductslinktext() {
			return Productslinktext;
		}

		public WebElement getMouseoveronsignout() {
			return signoutImg;
		}

		public WebElement getSignoutbutton() {
			return signoutlinkText;
		}
		
		//business logic for organizationlink 
		public void organisazationlink()
		{
		organizationlinktext.click();
		}
		
		//business logic for morelink
		public void morelink()
		{
			 morelink.click();
		}
		//business logic campigns
		public void campignslink()
		{
			 Campaignslink.click();
		}
		//business logic for Productslinktext
		public void Productslinktext()
		{
			Productslinktext.click();
		}
		//business logic for signoutlinktext
		public void signoutlink()
		{
			signoutlinkText.click();
		}
		//business logic for signoutImg
		public void   signoutImg()
		{
			signoutImg.click();
				
		}
		
		
		
		
		
		
		
		
		
}
