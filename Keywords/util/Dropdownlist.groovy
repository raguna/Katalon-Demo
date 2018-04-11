package util

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class Dropdownlist {

	@Keyword
	public static void selectDropdownlistByIndex(TestObject button, TestObject box, String index){
		WebUI.waitForElementVisible(button, GlobalVariable.G_Timeout)
		WebUI.click(button)
		WebUI.waitForElementVisible(box, GlobalVariable.G_Timeout)

		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = driver.findElement(By.xpath(box.getSelectorCollection().get(box.getSelectorMethod())+"/li["+index+"]/div"))
		Actions action = new Actions(driver)
		action.moveToElement(element).perform()
		
		WebUI.delay(1)
		element.click()
	}
	
	@Keyword
	public static void selectDropdownlistByText(TestObject button, TestObject box, String text){
		WebUI.waitForElementVisible(button, GlobalVariable.G_Timeout)
		WebUI.click(button)
		WebUI.waitForElementVisible(box, GlobalVariable.G_Timeout)
		
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = driver.findElement(By.xpath(box.getSelectorCollection().get(box.getSelectorMethod())+"/li/div[text()=\""+text+"\"]"))
		Actions action = new Actions(driver)
		action.moveToElement(element).perform()
		
		WebUI.delay(1)
		element.click()
	}
}
