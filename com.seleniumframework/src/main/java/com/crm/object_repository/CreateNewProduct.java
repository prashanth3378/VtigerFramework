package com.crm.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProduct {
	//Initialization
		public CreateNewProduct(WebDriver driver)
		{
		PageFactory.initElements(driver, this);
		}
	//Declaration
		@FindBy(xpath="//img[@ src=\'themes/softed/images/btnL3Add.gif\']")
		private WebElement CreateProduct  ;
		
		@FindBy(xpath="//input[@name='productname']")
		private WebElement ProductNametextfield;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement savebutton;
		
		@FindBy(xpath="//input[@title=\'Delete [Alt+D]\']")
		private WebElement Deletebutton;
	
		
		
//getters method

		public WebElement getCreateProduct() {
			return CreateProduct;
		}

		public WebElement getProductNametextfield() {
			return ProductNametextfield;
		}

		public WebElement getSavebutton() {
			return savebutton;
		}
		
		public WebElement getDeletebutton() {
			return Deletebutton;
		}

	//business logic for click on create product
		public void CreateProduct()
		{
			CreateProduct.click();
		}
		//business logic to send data into product name textfield
		public void  ProductNametextfield(String data)
		{
			 ProductNametextfield.sendKeys(data);
		}
		//busines logic to click on save button
		public void savebutton()
		{
			savebutton.click();
		}
		//business logic to click on delete button
		public void Deletebutton()
		{
			Deletebutton.click();
		}
}

