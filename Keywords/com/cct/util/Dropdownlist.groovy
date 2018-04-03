package com.cct.util

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class Dropdownlist {

	@Keyword
	public void selectDropdownlist(TestObject button, TestObject box, int index){
		WebUI.delay(1)
		WebUI.click(button)
		WebUI.delay(1)

		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = driver.findElement(By.xpath(box.getSelectorCollection().get(box.getSelectorMethod())+"/li["+index+"]/div"))
		Actions action = new Actions(driver)
		action.moveToElement(element).perform()
		
		WebUI.delay(1)
		element.click()
	}
}
