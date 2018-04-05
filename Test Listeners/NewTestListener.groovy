import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.cct.util.exportExcel
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext


class NewTestListener {
	
	
    private	XSSFWorkbook wb 
	private Sheet sheet
	private int rowIndex =0
	
	
	
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
			wb= new XSSFWorkbook()
		 String sheetName = testSuiteContext.getTestSuiteId().split("/")[1]
		 exportExcel.craeteFolder(testSuiteContext.getTestSuiteId())
		 rowIndex =	exportExcel.createHeader(wb,rowIndex,sheetName)
		 
			
	}
	
	
	
	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
	
	}

	
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		WebUI.comment(String.valueOf(wb))
		WebUI.comment(String.valueOf(sheet))
		WebUI.comment(String.valueOf(rowIndex))
		WebUI.comment(String.valueOf(testCaseContext))
			rowIndex = exportExcel.createRerportdetail(wb,  rowIndex, testCaseContext)
	}

	
	
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		//String sheetName = testSuiteContext.getTestSuiteId().split("/")[1]
		exportExcel.export(wb,testSuiteContext.getTestSuiteId() )
	}
}