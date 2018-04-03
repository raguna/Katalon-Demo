package com.cct.common.security.login

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.cct.util.Browser
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class Login {
	
	@Keyword
	public static void loginDefault() {
		Browser.openBrowser()
		
		WebUI.setText(findTestObject('com/cct/security/login/input_carrierCode'), GlobalVariable.G_CarrierCode)
		WebUI.setText(findTestObject('com/cct/security/login/input_username'), GlobalVariable.G_Username)
		WebUI.setText(findTestObject('com/cct/security/login/input_password'), GlobalVariable.G_Password)
		WebUI.click(findTestObject('com/cct/security/login/button_Log-in'))
		WebUI.delay(1)
		
	}
	
	@Keyword
	public static void login(String carrierCode, String username, String password) {
		Browser.openBrowser()
		
		WebUI.setText(findTestObject('com/cct/security/login/input_carrierCode'), carrierCode)
		WebUI.setText(findTestObject('com/cct/security/login/input_username'), username)
		WebUI.setText(findTestObject('com/cct/security/login/input_password'), password)
		WebUI.click(findTestObject('com/cct/security/login/button_Log-in'))
		WebUI.delay(1)
		
	}
	
	@Keyword
	public static void logout() {
		WebUI.click(findTestObject("com/cct/security/main/input_btnSubmit Logout"))
		
	}

}
