package common.serviceschedule.addopenschedule

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After


import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable
import util.Dropdownlist
import util.InputFormat
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class AddOpenSchedule {
   
	@Keyword
	private void gotoPage(){
	/*	
		WebUI.click(findTestObject('security/mainpage/main/input_btnSubmit Manage Schedule and Individual Check-Ins'))
		WebUI.click(findTestObject('serviceschedule/openschedule/search/button_open new schedule'))
		WebUI.click(findTestObject('serviceschedule/openschedule/search/button_Open schedule manually'))*/
	
		WebUI.navigateToUrl("http://10.100.70.87:8080/cp_cambodia/jsp/serviceschedule/gotoAddOpenSchedule.action")
	}
	@Keyword
	private void  setValueToInput(String flightNumber,String depPort,String arrPort,
		String depDate,String arrDate,String depTime,String arrTime,String DirectionIndex){
		WebUI.setText(findTestObject('serviceschedule/openschedule/add/input_openScManual.serviceNumb'), flightNumber)
		Dropdownlist.selectDropdownlistByIndex(findTestObject('serviceschedule/openschedule/add/span_Arrival'), findTestObject('serviceschedule/openschedule/add/ul_ArrivalDeparture'), DirectionIndex)
		
		WebUI.setText(findTestObject('serviceschedule/openschedule/add/input_autocompleteDepturePortN'), depPort)
		WebUI.delay(1)
		WebUI.setText(findTestObject('serviceschedule/openschedule/add/input_autocompleteArrivalPortN'), arrPort)
		WebUI.delay(1)
		
		InputFormat.setInputDate(findTestObject('serviceschedule/openschedule/add/input_openScManual_depDate_dd_'), depDate)
		InputFormat.setInputDate(findTestObject('serviceschedule/openschedule/add/input_openScManual_arrDate_dd_'), arrDate)
		InputFormat.setInputTime(findTestObject('serviceschedule/openschedule/add/input_openScManual_arrTime_hh_'), arrTime)
		InputFormat.setInputTime(findTestObject('serviceschedule/openschedule/add/input_openScManual_depTime_hh_'), depTime)
		WebUI.delay(1)
		
	}
	
}
