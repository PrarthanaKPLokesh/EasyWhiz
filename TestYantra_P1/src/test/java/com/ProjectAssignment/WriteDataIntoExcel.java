package com.ProjectAssignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\eclipse.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.createSheet("Spring");
		//Sheet sh = wb.getSheet("sheet5");
		sh.createRow(0).createCell(0).setCellValue("Chinni");
		sh.getRow(0).getCell(0).setCellValue("Hello");
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\eclipse.xlsx");
		wb.write(fout);
		wb.close();
		
		
	}

}
