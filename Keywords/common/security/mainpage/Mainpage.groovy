package common.security.mainpage

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class Mainpage {

	@Keyword
	public static void gotoHome() {
		WebUI.click(findTestObject("security/mainpage/main/div_home"))
		
	}
	
	@Keyword
	public static void selectMenu(TestObject object) {
		WebUI.click(object)
		
	}
}
