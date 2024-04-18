package com.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import  org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleData {
	public HashMap<String,String> readMultipleData(String sheetName, int CellNo) throws EncryptedDocumentException, IOException
	{FileInputStream fi=new FileInputStream(IpathConstant.ExcelPath);
	Workbook wb = WorkbookFactory.create(fi);
Sheet sh = wb.getSheet(sheetName);
	int rowCount=sh.getLastRowNum();
	HashMap<String,String> map= new HashMap<String,String>();
	for(int i=0;i<=rowCount;i++)
	{
		String key=sh.getRow(i).getCell(CellNo).getStringCellValue();
		String value=sh.getRow(i).getCell(CellNo).getStringCellValue();
		map.put(key, value);
		
	}
		return map;
		
	}

}
