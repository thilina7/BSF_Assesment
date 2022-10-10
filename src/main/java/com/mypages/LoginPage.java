/**
 * 
 */
package com.mypages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.configProperties;

/**
 * @author thilina.karunarathna
 *
 */
public class LoginPage extends BasePage {

	// Page locators:

	private By homePageSignInButton = By.cssSelector("#nav-link-accountList");
	private By emailIdText = By.cssSelector("#ap_email");
	private By continueButton = By.cssSelector("#continue");
	private By emailValidation = By.cssSelector(".a-list-item");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// public getters	
	/**
	 * @return the homePageSignInButton
	 */
	public WebElement getHomePageSignInButton() {
		return getElement(homePageSignInButton);
	}

	/**
	 * @return the emailIdText
	 */
	public WebElement getEmailIdText() {
		return getElement(emailIdText);
	}

	/**
	 * @return the continueButton
	 */
	public WebElement getContinueButton() {
		return getElement(continueButton);
	}
	

	/**
	 * @return the emailValidation
	 */
	public WebElement getEmailValidation() {
		return getElement(emailValidation);
	}
	
	public void loginWithUnRegisteredEmail(String email,String password) {
		getHomePageSignInButton().click();
		getEmailIdText().sendKeys(email);
		getContinueButton().click();
	}
	
	public String emailValidationMessage() {
		return getEmailValidation().getText();
	}

	public void searchAndScroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", getHomePageSignInButton());
	}

	public void clickOnSearchResult() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getHomePageSignInButton());
	}

	public void switchedToNewWindow() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public String validateUrl() {
		String url = driver.getCurrentUrl();
		String[] parts = url.split("\\?");
		String part1 = parts[0];
		System.out.println(part1);
		return part1;
	}
}
