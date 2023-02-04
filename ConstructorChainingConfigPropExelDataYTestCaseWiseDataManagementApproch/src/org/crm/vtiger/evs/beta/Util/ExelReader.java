package org.crm.vtiger.evs.beta.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelReader {

	public static Map<String,String>DataMap;

	public Workbook getExelFile(String filePath) {
		File fl=new File(filePath);
		InputStream is=null;
		Workbook wbook=null;
		try {
			is=new FileInputStream(fl);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String arr[]=filePath.split("\\.");
		String str=arr[arr.length-1];
		if(str.equalsIgnoreCase("xlsx")) {
			try {
				wbook=new XSSFWorkbook(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				wbook=new HSSFWorkbook(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return wbook;
	}

	
	
	
	
	public int getColumnNoByColumnName(Sheet sObj,String columnName) {
		Row firstRow=sObj.getRow(0);
		int cellNo=0;
		for(int i=0;i<firstRow.getLastCellNum();i++) {
			String cellvalue=firstRow.getCell(i).getStringCellValue();
			if(cellvalue.equalsIgnoreCase(columnName)) {
				cellNo=i;
				break;
			}
		}
		return cellNo;
		
	}
	public int getRowNo(Sheet sObj,String columnName,String tsName) {
		
		int cellNo=getColumnNoByColumnName(sObj, columnName);
		int rowNo=0;
		int totalRow=sObj.getLastRowNum();
		for(int i=0;i<totalRow;i++) {
			Row rObj=sObj.getRow(i);
			String cellValue=rObj.getCell(cellNo).getStringCellValue();
			if(cellValue.equalsIgnoreCase(tsName)) {
				rowNo=i;
				break;
			}
		}
		return rowNo;
		
	}
	
	public Cell getCell(Row rObj,int cellNo) {
		
		Cell cObj=rObj.getCell(cellNo, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		return cObj;
	}
	

	public void inputDataByExel(String filePath,String tsName,String sheetName) {

		Workbook wbook=getExelFile(filePath);
		Sheet shObj=wbook.getSheet(sheetName);
		int rowNum=getRowNo(shObj,"TestCaseName",tsName);
		int dataStartCellNo=getColumnNoByColumnName(shObj, "DataName1");
		Row rrObj=shObj.getRow(rowNum);
		
		Map<String,String> mapObj=new HashMap<String,String>();
		int lastCell=rrObj.getLastCellNum();
		for(int i=dataStartCellNo;i<lastCell; i=i+2) {
			Cell cObj= rrObj.getCell(i);
			Cell cObj1=rrObj.getCell(i+1);
			String celldata=getCell(rrObj, i).getStringCellValue();
			String cellValue= getCell(rrObj, i+1).getStringCellValue();
			mapObj.put(celldata, cellValue);

		}
		DataMap=mapObj;
	}

	//public void ExelData(String testCaseName) {
	//
	//String filePath="invoice.xlsx";
	//File fl=new File(filePath);
	//InputStream is=null;
	//Workbook wbook=null;
	//try {
	//	 is=new FileInputStream(fl);
	//} catch (FileNotFoundException e) {
	//	e.printStackTrace();
	//}
	//String arr[]=filePath.split("\\.");
	//String str=arr[arr.length-1];
	//if(str.equalsIgnoreCase("xlsx")) {
	//	try {
	//		wbook=new XSSFWorkbook(is);
	//	} catch (IOException e) {
	//		e.printStackTrace();
	//	}
	//}else {
	//	try {
	//		wbook=new HSSFWorkbook(is);
	//	} catch (IOException e) {
	//		e.printStackTrace();
	//	}
	//}
	//Sheet shObj=wbook.getSheet("invoiceCreation");
	//
	//int lastRow=shObj.getLastRowNum();
	//Row rObj=null;
	////int rowNum=0;
	//for(int i=0;i<lastRow;i++) {
	// rObj=shObj.getRow(i);
	// Cell cObj=rObj.getCell(1);
	//String cellValue=cObj.getStringCellValue();
	//if(cellValue.equalsIgnoreCase(testCaseName)) {
	//	//rowNum=i;
	//	break;
	//}
	//
	//}
	////Row rrObj=shObj.getRow(rowNum);
	//int lastCell=rObj.getLastCellNum();
	//for(int i=2;i<lastCell; i=i+2) {
	//	Cell cObj= rObj.getCell(i);
	//	Cell cObj1=rObj.getCell(i+1);
	//	String celldata=cObj.getStringCellValue();
	//	String cellValue= cObj1.getStringCellValue();
	//	System.out.println(celldata+"  "+cellValue);
	//}
	//}

}
