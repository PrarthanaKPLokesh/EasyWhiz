package com.ProjectAssignment;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataDrivenAssignment {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fi = new FileInputStream("./src/test/resources/ClientDDT.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet1");
		int rowcount = sh.getLastRowNum();
		for (int i = 0; i <=rowcount; i++) 
		{
			String value = sh.getRow(i).getCell(0).toString();
			if(value.equalsIgnoreCase("client"))
			{
				//System.out.println(value);
				int cellcount = sh.getRow(i).getLastCellNum();
				for (int j = 0; j <cellcount; j++) //multiple data
				{
					String value1 = sh.getRow(i).getCell(j).toString();
					System.out.print(value1+"  ");
				}
			}
		}

	}
}


