package cts.miniproject.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet1;

	//Condtructor 
	public  ExcelDataConfig(String excelpath) {

		try {
			// This takes input of excel sheet path
			File src = new File(excelpath);
			FileInputStream fis  = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);
			//Getting data of sheet1 at index 0
			sheet1 = wb.getSheetAt(0);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	public String getData(int sheetNumber,int row, int coloumn) {
		sheet1 = wb.getSheetAt(sheetNumber);
		String data =  sheet1.getRow(row).getCell(coloumn).getStringCellValue();
		return data;
	}
	
	//METHOD TO RETURN NUMBER OF ROWS IN EXCEL SHEET
	
	public int getRowCont(int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		//Index starts from 0 so to get actual row number we add 1
		row = row+1;
		return row;
		
}
}