package com.orangeHRM.utils;

import java.io.File;
import java.io.FileInputStream;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class InputData {
	
	public static final String USER_DIR = System.getProperty("user.dir");
	public static final String TEST_DATA_FILE_PATH = USER_DIR + "/testdata/EmpSearch_Testdata.xlsx";
	public static FileInputStream fis;
	
	
	
	public static ArrayList<Object[]> ReadExcel() throws Exception
	{
		ArrayList<Object[]> mydata= new ArrayList<> ();
		
		try {
			File inputData = new File(TEST_DATA_FILE_PATH);
			fis = new FileInputStream(inputData);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		XSSFWorkbook xss = new XSSFWorkbook(fis);
		XSSFSheet Sheet = xss.getSheetAt(0);
		int rowCount = Sheet.getLastRowNum();
		System.out.println("Total Number of Row in the Excel: "+rowCount);
		
		
		  for(int i=1;i<=rowCount;i++) 
		  { 
			  String Name =Sheet.getRow(i).getCell(0).getStringCellValue();
			  String ID =Sheet.getRow(i).getCell(1).getStringCellValue(); 
			  String EMPLOYMENT_STATUS =Sheet.getRow(i).getCell(2).getStringCellValue();
		  
			  Object ob[] = {Name,ID,EMPLOYMENT_STATUS};
			  
			  mydata.add(ob);
		  }
		 
		xss.close();
		return mydata;
		
	}
	
	

}
