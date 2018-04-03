package com.cct.util

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class Browser {

	@Keyword
	public static void openBrowser() {
		WebUI.openBrowser(GlobalVariable.G_SiteURL)
		WebUI.waitForPageLoad(GlobalVariable.G_Timeout)
		WebUI.maximizeWindow()
		
	}
	
	@Keyword
	public static void openBrowserUrl(String url) {
		WebUI.openBrowser(url)
		WebUI.waitForPageLoad(GlobalVariable.G_Timeout)
		WebUI.maximizeWindow()
		
	}
	
	public static void closeBrowser() {
		WebUI.switchToDefaultContent()
		WebUI.switchToWindowIndex(0)
		WebUI.closeBrowser()
		
	}
}
