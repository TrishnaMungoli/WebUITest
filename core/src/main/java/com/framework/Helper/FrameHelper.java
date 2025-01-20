package com.framework.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {
	
	/**
	 * this method will switchToFrame based on frame index
	 * @param frameIndex
	 * @return 
	 */
	public  static void switchToFrameByIndex(int frameIndex,WebDriver driver){
		driver.switchTo().frame(frameIndex);
	}
	
	/**
	 * this method will switchToFrame based on frame name
	 * @param frameName
	 */
	public static void switchToFrameByFrameName(String frameName,WebDriver driver){
		driver.switchTo().frame(frameName);
	}
	
	/**
	 * this method will switchToFrame based on frame WebElement
	 * @param element
	 */
	public static void switchToFrameByWebElement(WebElement element,WebDriver driver){
		driver.switchTo().frame(element);
	}
	
	public static void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
}


