package com.test.moneylion.pages;

import java.util.List;

import com.framework.Helper.JavaScriptHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.framework.Helper.ActionHelper;
import com.framework.Helper.WaitHelper;
import com.framework.base.LocalBrowserInitialzation;

public class LandingPage {
	public LandingPage(WebDriver driver) {
		LocalBrowserInitialzation.driver = driver;
		PageFactory.initElements(LocalBrowserInitialzation.driver, this);
	}
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'About us')]")
	WebElement aboutUs;
	@FindBy(how = How.LINK_TEXT, using = "Careers")
	WebElement careers;
	public Boolean verifyAboutUs() throws InterruptedException {
		Thread.sleep(3000);
		ActionHelper.moveToElement(LocalBrowserInitialzation.driver,aboutUs);
		WaitHelper.isVisible(aboutUs,LocalBrowserInitialzation.driver);
		return aboutUs.isDisplayed();
	}
	public LandingPage clickOnCareer() {
		WaitHelper.isClickable(careers,LocalBrowserInitialzation.driver);
		JavaScriptHelper.clickElement(careers,LocalBrowserInitialzation.driver);
		return new LandingPage(LocalBrowserInitialzation.driver);
	}
}
