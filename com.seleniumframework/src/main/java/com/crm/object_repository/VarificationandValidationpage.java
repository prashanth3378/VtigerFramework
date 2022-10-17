package com.crm.object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VarificationandValidationpage {

	//Initialization
		public VarificationandValidationpage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//Declaration
				@FindBy(className="dvHeaderText")
				private WebElement ActualOrganisationdata;
				
				public WebElement getActualOrganisationdata() {
					return ActualOrganisationdata;
				}
//				business logic
				public void organisationValidation(WebDriver driver,String orgname)
				{
					String act_msg =ActualOrganisationdata .getText();
					if(act_msg.contains(orgname))
					{
						System.out.println("created pass");
					}
					else
					{
						System.out.println("not created fail");
					}
				}
				
				
				@FindBy(className="lvtHeaderText")
				private WebElement ActualCreateProductdata;
				
				
				public WebElement getActualCreateProductdata() {
					return ActualCreateProductdata;
				}

				
			//	business logic
				public void createProductValidation(WebDriver driver,String productame)
				{
					String act_msg = ActualCreateProductdata.getText();
					if(act_msg.contains(productame))
					{
						System.out.println("created pass");
					}
					else
					{
						System.out.println("not created fail");
					}
				}
				
				
				
				
				
				@FindBy(xpath="//span[@class=\'dvHeaderText\']")
				private WebElement ActualCreateCampaigntdata;
				
				
				public WebElement getActualCreateCampaigntdata() {
					return ActualCreateCampaigntdata;
				}
				
				
				//	business logic
					public void createcampaignValidation(WebDriver driver,String campaigname)
					{
						String act_msg = ActualCreateCampaigntdata.getText();
						if(act_msg.contains(campaigname))
						{
							System.out.println("created pass");
						}
						else
						{
							System.out.println("not created fail");
						}
					}
					
					
					
					
				
				
				
				
				
				@FindBy(css="span.dvHeaderText")
				private WebElement ActualCreateCampaign_producttdata;

				public WebElement getActualCreateCampaign_producttdata() {
					return ActualCreateCampaign_producttdata;
				}
			

				//	business logic
					public void CreateCampaign_productValidation(WebDriver driver,String campaign_productame)
					{
						String act_msg =  ActualCreateCampaign_producttdata.getText();
						if(act_msg.contains( campaign_productame))
						{
							System.out.println("created pass");
						}
						else
						{
							System.out.println("not created fail");
						}
					}
					
					
					
					
				
				
				
				
				
		
				
				
}
