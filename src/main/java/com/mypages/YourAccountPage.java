package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class YourAccountPage extends BasePage{

	public YourAccountPage(WebDriver driver) {
		super(driver);
	}

	private By homePageSignInButton = By.cssSelector("#nav-link-accountList");
	private By yourAccountLink = By.cssSelector("#nav-al-your-account > a:nth-child(2)");
	private By yourAddressLink = By.cssSelector("#nav_prefetch_youraddresses");
	private By yourListsLink = By.cssSelector("#nav-al-your-account > a:nth-child(5)");
	private By yourOrdersButton = By.xpath("//h2[contains(text(),'Your Orders')]");
	private By yourListPageTitle = By.cssSelector("#wishlist-page > div.a-section.al-intro-tab-content > "
			+ "div.a-section.a-padding-base.al-intro-content.a-text-center > div > span.al-intro-banner-header");
	
	
	/**
	 * @return the homePageSignInButton
	 */
	public WebElement getHomePageSignInButton() {
		return getElement(homePageSignInButton);
	}
	/**
	 * @return the yourAccountLink
	 */
	public WebElement getYourAccountLink() {
		return getElement(yourAccountLink);
	}
	/**
	 * @return the yourAddress
	 */
	public WebElement getYourAddress() {
		return getElement(yourAddressLink);
	}
	/**
	 * @return the yourLists
	 */
	public WebElement getYourLists() {
		return getElement(yourListsLink);
	}
	
	/**
	 * @return the yourOrdersButton
	 */
	public WebElement getYourOrdersButton() {
		return getElement(yourOrdersButton);
	}
	
	/**
	 * @return the yourListPageTitle
	 */
	public WebElement getYourListPageTitle() {
		return getElement(yourListPageTitle);
	}
	
	public void navigateToYourAccount() {
		Actions action = new Actions(driver);
		action.moveToElement(getHomePageSignInButton()).perform();
		getYourAccountLink().click();
		getYourOrdersButton().click();
	}
	
	public void navigateToYourAddress() {
		Actions action = new Actions(driver);
		action.moveToElement(getHomePageSignInButton()).perform();
		getYourAddress().click();
	}
	
	public void navigateToYourLists() {
		Actions action = new Actions(driver);
		action.moveToElement(getHomePageSignInButton()).perform();
		getYourLists().click();
	}
	
	public String getLoginPageTitle() {
		return getPageTitle();
	}
}
