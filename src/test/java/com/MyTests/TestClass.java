/**
 * 
 */
package com.MyTests;

import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.mypages.ItemPage;
import com.mypages.LoginPage;
import com.mypages.YourAccountPage;

/**
 * @author thilina.karunarathna
 *
 */
public class TestClass extends BaseTest{
	private static String productName;
	private static LoginPage loginPage;
	private static ItemPage itemPage;
	private static YourAccountPage yourAccountPage;
	private static String productPrice;
	
	@Description("T001_Check an verify whether unregistered users can't login to the application")
	@Test(priority=1, enabled = true)
	public void validateUnregisteredEmailAddress() {
		loginPage = new LoginPage(driver);
		loginPage.loginWithUnRegisteredEmail("thili7@yahoo.com","pass123");
		Assert.assertEquals(loginPage.emailValidationMessage(), "We cannot find an account with that email address");
	}
	 
	@Description("T002_Check and verify whether correctly added quantity showing in Cart page")
	@Test(priority=2, enabled = true)
	public void validateCartQty() {
		itemPage = new ItemPage(driver);
		itemPage.selectItemInCategory();
		productName = itemPage.captureProductName();
		productPrice = itemPage.captureProductPrice();
		itemPage.addToCart("3");
		itemPage.browserRefresh();
		// Check and verify whether selected product QTY is matching with the cart product qty
		Assert.assertEquals(itemPage.verifyQtyCount(), "3");
	}
	
	@Description("T003_Check and verify whether selected product price matching with the cart product price")
	@Test(priority=3, enabled = true)
	public void validateCartItemPrice() {
		itemPage = new ItemPage(driver);
		itemPage.selectItemInCategory();
		productName = itemPage.captureProductName();
		productPrice = itemPage.captureProductPrice();
		itemPage.addToCart("3");
		itemPage.browserRefresh();
		// Check and verify whether selected product price matching with the cart product price
		Assert.assertEquals(itemPage.trimPrice(itemPage.verifyProductPrice(),"AED "), itemPage.trimPrice(productPrice,"AED"));
	}
	
	@Description("T004_Check and verify the Cart sub total is matching with the selected 3 items price")
	@Test(priority=4, enabled = true)
	public void validateCartSubTotal() {
		itemPage = new ItemPage(driver);
		itemPage.selectItemInCategory();
		productName = itemPage.captureProductName();
		productPrice = itemPage.captureProductPrice();
		itemPage.addToCart("3");
		itemPage.browserRefresh();
		// Check and verify the Cart sub total is matching with the selected 3 items price
		Assert.assertEquals(itemPage.trimAndReplaceComma(itemPage.getSubTotal().getText(),"AED "),itemPage.generateSubTotal(itemPage.verifyProductPrice(), "AED "));
	}
	
	@Description("T005_Check and verify whether selected product name matching with the cart product name")
	@Test(priority=5, enabled = true)
	public void validateCartProductName() {
		itemPage = new ItemPage(driver);
		itemPage.selectItemInCategory();
		productName = itemPage.captureProductName();
		productPrice = itemPage.captureProductPrice();
		itemPage.addToCart("3");
		itemPage.browserRefresh();
		// Check and verify whether selected product name matching with the cart product name
		Assert.assertEquals(itemPage.verifyProductName(), productName);		
	}
	
	@Description("T006_Check and verify whether user can't see Your orders after going to Your account page without sign-in")
	@Test(priority=6, enabled = true)
	public void validateYourOrders() {
		yourAccountPage = new YourAccountPage(driver);
		yourAccountPage.navigateToYourAccount();
		Assert.assertEquals(yourAccountPage.getLoginPageTitle(), "Amazon Sign In");
	}
	
	@Description("T007_Check and verify whether user can't see Your orders after going to Your Address page without sign-in")
	@Test(priority=7, enabled = true)
	public void validateYourAddress() {
		yourAccountPage = new YourAccountPage(driver);
		yourAccountPage.navigateToYourAddress();
		Assert.assertEquals(yourAccountPage.getLoginPageTitle(), "Amazon Sign In");
	}
	
	@Description("T008_Check and verify whether user navigate to Lists page when click on 'Your Lists'")
	@Test(priority=8, enabled = true)
	public void validateYourLists() {
		yourAccountPage = new YourAccountPage(driver);
		yourAccountPage.navigateToYourLists();
		//Check whether your went to correct page and page title is correct
		Assert.assertEquals(yourAccountPage.getLoginPageTitle(), "Your List");
		//Assert whether page topic is available
		Assert.assertEquals(yourAccountPage.getYourListPageTitle().getText(), "Lists");
	}
}
