package com.DataProviderExcel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.GenericUtility.IpathConstant;

public class DataProviderTest {
	@DataProvider(name="readDataFromExcel")
	public Object[][] orgdata() throws EncryptedDocumentException, IOException 
	{
		FileInputStream fi=new FileInputStream(IpathConstant.ExcelPath1);
				Workbook wb = WorkbookFactory.create(fi);
				Sheet sh = wb.getSheet("dataprovider");
				int rowcount = sh.getLastRowNum()+1;
				int cellcount = sh.getRow(0).getLastCellNum();
				
				Object[][] obj=new Object[rowcount][cellcount];
				for(int i=0; i<rowcount;i++)
				{
					for(int j=0;j<cellcount;j++)
					{
						obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
						
						
					}
				}
				
				
				
				return obj;
	}

}
