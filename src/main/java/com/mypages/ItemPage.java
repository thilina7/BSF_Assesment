package com.mypages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage extends BasePage{

	public ItemPage(WebDriver driver) {
		super(driver);
	}
	
	//Page Locators
	private By todayDealsTab = By.cssSelector("#nav-xshop > a:nth-child(6)");
	private By categoryButton = By.cssSelector("#anonCarousel1 > ol > li:nth-child(2)");
	private By firstItem = By.cssSelector("#grid-main-container > "
			+ "div.a-row.Grid-module__gridSection_1SEJTeTsU88s6aVeuuekAp > div > div:nth-child(1)");
	private By subItem = By.cssSelector("#octopus-dlp-asin-stream > ul > li:nth-child(2)");
	private By qty = By.cssSelector("#quantity");
	private By productTitle = By.cssSelector("#productTitle");
	private By productPrice = By.cssSelector("#apex_offerDisplay_desktop");
	private By addToCart = By.cssSelector("#add-to-cart-button");
	private By cartCount = By.cssSelector("#nav-cart-count");
	private By deleteCart = By.name("submit.delete.C32578787-86fe-4d57-b71b-b9a21dfc19de");
	private By verifyProductTitle = By.xpath("//div[4]/div/div[1]/div/div/div[2]/ul/li[1]/span/a/span[1]/span");
	private By verifyProductPrice = By.cssSelector("p > span");
	private By subTotal = By.cssSelector("#sc-subtotal-amount-buybox > span");
	
	
	/**
	 * @return the todayDealsTab
	 */
	public WebElement getTodayDealsTab() {
		waitForElementPresent(todayDealsTab);
		return getElement(todayDealsTab);
	}
	/**
	 * @return the categoryButton
	 */
	public WebElement getCategoryButton() {
		waitForElementPresent(categoryButton);
		return getElement(categoryButton);
	}
	/**
	 * @return the firstItem
	 */
	public WebElement getFirstItem() {
		waitForElementPresent(firstItem);
		return getElement(firstItem);
	}
	/**
	 * @return the subItem
	 */
	public WebElement getSubItem() {
		waitForElementPresent(subItem);
		return getElement(subItem);
	}
	/**
	 * @return the qty
	 */
	public WebElement getQty() {
		waitForElementPresent(qty);
		return getElement(qty);
	}
	/**
	 * @return the productTitle
	 */
	public WebElement getProductTitle() {
		waitForElementPresent(productTitle);
		return getElement(productTitle);
	}
	/**
	 * @return the productPrice
	 */
	public WebElement getProductPrice() {
		waitForElementPresent(productPrice);
		return getElement(productPrice);
	}
	/**
	 * @return the addToCart
	 */
	public WebElement getAddToCart() {
		waitForElementPresent(addToCart);
		return getElement(addToCart);
	}
	/**
	 * @return the cartCount
	 */
	public WebElement getCartCount() {
		waitForElementPresent(cartCount);
		return getElement(cartCount);
	}
	
	/**
	 * @return the deleteCart
	 */
	public WebElement getDeleteCart() {
		waitForElementPresent(deleteCart);
		return getElement(deleteCart);
	}
	
	/**
	 * @return the verifyProductTitle
	 * @throws InterruptedException 
	 */
	public WebElement getVerifyProductTitle() {
		return getElement(verifyProductTitle);
	}
	/**
	 * @return the verifyProductPrice
	 */
	public WebElement getVerifyProductPrice() {
		return getElement(verifyProductPrice);
	}
	
	/**
	 * @return the subTotal
	 */
	public WebElement getSubTotal() {
		return getElement(subTotal);
	}
	
	public void selectItemInCategory() {
		getTodayDealsTab().click();
		getCategoryButton().click();
		getFirstItem().click();
		getSubItem().click();
	}
	
	public String captureProductName() {
		return getProductTitle().getText();
	}
	
	public String captureProductPrice() {
		return getProductPrice().getText();
	}
	
	public void addToCart(String value) {
		getAddToCart().click();
		getCartCount().click();
		selectDropDownValue(qty,value);
	}
	
	public String verifyQtyCount() {
		waitForElementPresent(cartCount);
		return getCartCount().getText();
	}
	
	public String verifyProductName() {
		return getVerifyProductTitle().getText();
	}
	
	public String verifyProductPrice() {
		return getVerifyProductPrice().getText();
	}
	
	public void browserRefresh() {
		driver.navigate().refresh();
	}
	
	public String trimPrice(String price, String trimAfter) {
		String[] parts = price.split(trimAfter);
		String part1 = parts[1];
		System.out.println(part1);
		return part1;
	}
	
	public Double generateSubTotal(String price, String trimAfter) {
		String totalPrice = trimPrice(price, trimAfter);
		Double number = Double.valueOf(totalPrice);
		return number*3;
	}
	
	public Double trimAndReplaceComma(String price, String trimAfter) {
		String totalPrice = trimPrice(getSubTotal().getText(),"AED ").replace(",","");
		Double number = Double.valueOf(totalPrice);
		return number;
	}
}
