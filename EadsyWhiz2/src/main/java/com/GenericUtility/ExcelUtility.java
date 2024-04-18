package com.GenericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	/**
	 * This method is used to read the data from Excel
	 * @author Prarthana
	 * @param SheetName
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readdatafromExcel(String SheetName,int rowno,int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		String value = sh.getRow(rowno).getCell(cellno).getStringCellValue();
		wb.close();
		return value;
	}
	
	
	/**
	 * This is the method used to get the total row count
	 * @author Rajeshwari
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int getTotalRowcount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rcount = sh.getLastRowNum();
		
		return rcount;
	}
	
	
	
	/**
	 * This is the method used to write the data into the Excel
	 * @author Rajeshwari
	 * @param SheetName
	 * @param rowno
	 * @param cellno
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public void writedataintoExcel(String SheetName,int rowno,int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstant.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		sh.createRow(rowno).createCell(cellno).setCellValue("data");
		FileOutputStream fout = new FileOutputStream(IpathConstant.ExcelPath);
		wb.write(fout);
		wb.close();
		

		}
	}
	
	


