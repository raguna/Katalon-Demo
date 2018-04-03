package com.cct.util

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class InputFormat {

	@Keyword
	private void setInputDate(TestObject object, String inputDate){
		WebElement element = WebUiCommonHelper.findWebElement(object, 3)
		WebUI.sendKeys(object, Keys.chord(Keys.CONTROL, 'a'))
		element.sendKeys(inputDate)
		
	}
	
	@Keyword
	private void setInputTime(TestObject object, String inputTime){
		WebElement element = WebUiCommonHelper.findWebElement(object, 3)
		WebUI.sendKeys(object, Keys.chord(Keys.CONTROL, 'a'))
		element.sendKeys(inputTime)
			
	}
}
