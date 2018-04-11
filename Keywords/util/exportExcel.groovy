package util

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.context.TestCaseContext
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

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI



import org.apache.poi.*
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.Font
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.VerticalAlignment
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFColor;
import java.awt.Color
import java.text.SimpleDateFormat

public class exportExcel {
	private static String oldID=""
	private static Sheet sheet
	private static String path=""
	private static String timeStamp=""
	public static createHeader (XSSFWorkbook wb, int curRow,String Name){
		int colIndex =0
		sheet = wb.createSheet(Name)
		Row row = sheet.createRow(curRow)
		for(int i=0;i<8;i++){
			if(i==0 || i==1 || i==3|| i==2 ){
				sheet.setColumnWidth(i, 30*255);
			}else if(i==4 ||i==5) {
				sheet.setColumnWidth(i, 25*255);
			}else if (i==7){
				sheet.setColumnWidth(i, 14*255);
			}
		}
	
		Font font = wb.createFont();
		font.setFontHeightInPoints((short)14);
		font.setFontName("Cordia New");
		//font.setBoldweight(0)(true);
		CellStyle style = wb.createCellStyle();
		style.setFont(font)
		style.setAlignment(CellStyle.ALIGN_CENTER)
		style = setborder(style)
		Cell cell = row.createCell(colIndex)
		cell.setCellStyle(style);
		//sheet.addMergedRegion(new CellRangeAddress(curRow, curRow+1, colIndex, colIndex));
		cell.setCellValue("Test Case No.")
		colIndex++
	
		cell = row.createCell(colIndex)
		cell.setCellStyle(style);
		//sheet.addMergedRegion(new CellRangeAddress(curRow, curRow+1, colIndex, colIndex));
		cell.setCellValue("Test Event")
		colIndex++
		
		cell = row.createCell(colIndex)
		cell.setCellStyle(style);
		//sheet.addMergedRegion(new CellRangeAddress(curRow, curRow+1, colIndex, colIndex));
		cell.setCellValue("Expected Result")
		colIndex++
		
		cell = row.createCell(colIndex)
		cell.setCellStyle(style);
		//sheet.addMergedRegion(new CellRangeAddress(curRow, curRow+1, colIndex, colIndex));
		cell.setCellValue("Katalon Test Case Name")
		colIndex++
		
		cell = row.createCell(colIndex)
		cell.setCellStyle(style);
		//sheet.addMergedRegion(new CellRangeAddress(curRow, curRow+1, colIndex, colIndex));
		cell.setCellValue("Test Data")
		colIndex++
		
			
		cell = row.createCell(colIndex)
		cell.setCellStyle(style);
		//sheet.addMergedRegion(new CellRangeAddress(curRow, curRow+1, colIndex, colIndex));
		cell.setCellValue("Expected Data")
		colIndex++
		
		cell = row.createCell(colIndex)
		cell.setCellStyle(style);
		//sheet.addMergedRegion(new CellRangeAddress(curRow, curRow+1, colIndex, colIndex));
		cell.setCellValue("Result")
		colIndex++
		
		cell = row.createCell(colIndex)
		cell.setCellStyle(style);
		//sheet.addMergedRegion(new CellRangeAddress(curRow, curRow+1, colIndex, colIndex));
		cell.setCellValue("Excute Date")
		colIndex++
		
		++curRow
		return curRow
	}
	
	
	
	private static  CellStyle setborder (CellStyle style){
		style.setBorderTop((short) 1);
		style.setBorderBottom((short) 1);
		style.setBorderLeft((short) 1);
		style.setBorderRight((short) 1);
		
		return style
		
		
	}
	
	public static void craeteFolder (String name){

		File file = new File(GlobalVariable.G_ReportPath);
		String[] names  = name.split("/")
		timeStamp = genDate("ddMMyyyyHHmmss")
		path =GlobalVariable.G_ReportPath+"/"+names[names.length-1]+"/"+names[names.length-1]+"_"+timeStamp
		//new File("D:/testreport/"+names[names.length-1]).mkdir()
		if(!file.exists()){
			file.mkdir()

		}
		file = new File(GlobalVariable.G_ReportPath+"/"+names[names.length-1])
		if(!file.exists()){
			file.mkdir()
		}
		file = new File(path)
		file.mkdir()
	}
	public static createRerportdetail(XSSFWorkbook wb  , int curRow,TestCaseContext testcase){
		int curCol=0;
		
		Row row = sheet.createRow(curRow)
		Cell cell = row.createCell(curCol)
		CellStyle cs =wb.createCellStyle()
		cs.setVerticalAlignment(VerticalAlignment.TOP)
		cs.setWrapText(true)
		cs = setborder(cs)
		Font font = wb.createFont();
		font.setFontHeightInPoints((short)14);
		font.setFontName("Cordia New");
		cs.setFont(font)
	
		cell.setCellStyle(cs)
		cell.setCellValue(testcase.getTestCaseVariables().get("testCaseNo"))
		++curCol
		
		cell = row.createCell(curCol)
		cell.setCellStyle(cs)
		cell.setCellValue(testcase.getTestCaseVariables().get("testEvent"))
		++curCol
		
		cell = row.createCell(curCol)
		cell.setCellStyle(cs)
		cell.setCellValue(testcase.getTestCaseVariables().get("expectedResult"))
		++curCol
		
		cell = row.createCell(curCol)
		String[] testCaseName = testcase.getTestCaseId().split("/")
		cell.setCellStyle(cs)
		cell.setCellValue(testCaseName[testCaseName.length-1])
		++curCol
		


		 cell = row.createCell(curCol)
		Map<String,Object> map = testcase.getTestCaseVariables()
		String value ="";
		for(String key : map.keySet()){
			if(key !="testCaseNo" && key != "testEvent"&&key !="expectedResult" && key !="expectedData"){
				value += key+" : "+map.get(key)+"\n"
				
			}
			
		}
		
		if(value!=""){
			cell.setCellValue(value.substring(0, value.length()-1))
			//cell.setCellValue(value)
			cell.setCellStyle(cs)
			
		}
		++curCol
		cell=row.createCell(curCol)
		cell.setCellValue(testcase.getTestCaseVariables().get("expectedData"))
		cell.setCellStyle(cs)
		++curCol
		
		CellStyle statusStyle = wb.createCellStyle();
		 cell = row.createCell(curCol)
		statusStyle.setVerticalAlignment(VerticalAlignment.TOP)
		statusStyle.setWrapText(true)
		
		WebUI.comment( testcase.getTestCaseStatus())
		 if(testcase.getTestCaseStatus()=="PASSED"){
			 
			 statusStyle.setFillForegroundColor(new XSSFColor(new Color(0,128,0)))
			 statusStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			 statusStyle = setborder(statusStyle)
			  cell.setCellStyle(statusStyle)
		 }else if(testcase.getTestCaseStatus()=="ERROR"){
		 
			 statusStyle.setFillForegroundColor(new XSSFColor(new Color(255,0,0)))
			 statusStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			 statusStyle = setborder(statusStyle)
			 cell.setCellStyle(statusStyle)
			 WebUI.delay(1)
			 WebUI.takeScreenshot(path+"/"+testcase.getTestCaseVariables().get("testCaseNo")+".png")
			 
		 }
		
		cell.setCellValue(testcase.getTestCaseStatus())
		++curCol
		
		cell = row.createCell(curCol)
		cell.setCellStyle(cs)
		cell.setCellValue(genDate("dd/MM/yyyy"))
		++curCol
		


		
		++curRow
		return curRow
	}
	private static String genDate(String format) {
		
			//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HHmmss", Locale.ENGLISH);
				SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				String date = sdf.format(cal.getTime());
			
				
			
				return date;
	}
	
	public static export(XSSFWorkbook wb,String name){
		//String filename = genReportName();
		String[] names = name.split("/")
		
		FileOutputStream file = new FileOutputStream(path+"/"+names[names.length-1]+"_"+timeStamp+".xlsx")
		wb.write(file);
		file.close();
	
	}
}
