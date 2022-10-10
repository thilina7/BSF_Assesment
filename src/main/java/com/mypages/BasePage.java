package com.mypages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BasePage extends Page{

	public BasePage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElement(locator);
			return element;
			
		}catch (Exception e) {
			System.out.println("Some error occured while creating element" +locator.toString());
			e.printStackTrace();
		}
		return element;
	}
	
	public List<WebElement> getElements(By locator) {
		List<WebElement> elements = null;
		try {
			waitForElementPresent(locator);
			elements = driver.findElements(locator);
			return elements;
			
		}catch (Exception e) {
			System.out.println("Some error occured while creating element" +locator.toString());
			e.printStackTrace();
		}
		return elements;
	}
	
	public void selectDropDownValue(By locator,String value) {
		try {
			Select drpQty = new Select(driver.findElement(locator));
			drpQty.selectByValue(value);
		}
		catch (Exception e) {
			System.out.println("Some error occured while creating element" +locator.toString());
			e.printStackTrace();
		}
	}
	
	@Override
	public Select getDropdownElement(By locator) {
		Select element = null;
		
		try {
			waitForElementPresent(locator);
			element = new Select(driver.findElement(locator));
			return element;
			
		}catch (Exception e) {
			System.out.println("Some error occured while creating element" +locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}catch (Exception e) {
			System.out.println("Some exception/error occured while waiting for the element" + locator.toString());
		}
	}
	
	@Override
	public void waitForElementtoBeClickable(By locator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}catch (Exception e) {
			System.out.println("Some exception/error occured while waiting for the element" + locator.toString());
		}
	}

	@Override
	public void waitforPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}catch (Exception e) {
			System.out.println("Some exception/error occured while waiting for the element" + title);
		}
	}
	
	public String getScreenshot() {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(src, destination);
		}
		catch(IOException e) {
			System.out.println("Capture Failed "+e.getMessage());
		}
		return path;
		
	}
}
