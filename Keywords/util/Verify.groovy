package util

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class Verify {

	@Keyword
	public static void verifyAlertText(String expectedText){
		String actualText = WebUI.getAlertText()
		WebUI.verifyMatch(actualText, expectedText, false)
		
	}
	
	@Keyword
	public static boolean verifyValueLenght(TestObject object, String expectedNumber){
		String expectedData = WebUI.getAttribute(object, "value")
		WebUI.verifyLessThanOrEqual(expectedData.length(),Long.valueOf(expectedNumber))
		
	}
	
	@Keyword
	public boolean isConTrainsText(TestObject object, String expectedText){
		WebUI.waitForElementVisible(object, GlobalVariable.G_Timeout)
		WebUI.comment(expectedText)
		String text = WebUI.getText(object)
		WebUI.comment(text)
		if (text.indexOf(expectedText) > -1) {
			KeywordUtil.markPassed("Pass, Object is Contains Text.")
			
		} else {
			KeywordUtil.markFailed("Fail, Object is not Contains Text.")
			
		}
	}
	
	@Keyword
	public boolean notConTrainsText(TestObject object, String expectedText){
		WebUI.waitForElementVisible(object, GlobalVariable.G_Timeout)
			WebUI.comment(expectedText)
		String text = WebUI.getText(object)
		
		if (text.indexOf(expectedText) > -1) {
			KeywordUtil.markFailed("Fail, Object is Contains Text.")
			
		} else {
			KeywordUtil.markPassed("Pass, Object is not Contains Text.")
					
		}
	}
	
	@Keyword
	private void acceptAlert() {
		if (WebUI.verifyAlertPresent(1, FailureHandling.OPTIONAL)) {
			WebUI.acceptAlert()
		}
		
	}
}
