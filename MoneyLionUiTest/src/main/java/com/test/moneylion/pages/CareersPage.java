package com.test.moneylion.pages;

import java.util.List;

import com.framework.Helper.JavaScriptHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.Helper.ActionHelper;
import com.framework.base.LocalBrowserInitialzation;

public class CareersPage {
	public CareersPage(WebDriver driver) {
		LocalBrowserInitialzation.driver = driver;
		PageFactory.initElements(LocalBrowserInitialzation.driver, this);
	}
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'where-we-work-cities')]//figcaption")
	List<WebElement>figureCaption;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'View open roles >')]")
	WebElement openRoles;

	public LandingPage scrollToOpenRoles() {
//		ActionHelper.moveToElement(LocalBrowserInitialzation.driver,openRoles);
		JavaScriptHelper.scrollIntoView(openRoles,LocalBrowserInitialzation.driver);
		return new LandingPage(LocalBrowserInitialzation.driver);
	}
   public String getTextOfFigureCaption(int num) {
	   return  figureCaption.get(num).getText();
   }
}