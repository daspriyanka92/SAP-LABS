package com.comCast.genericlib;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * It provides libraries to get the data from .xlsx and .properties
 * @author Priyanka
 */
public class FileLib {
	/**
	 * Get the key =value from the commondata.properties file like url,username,password,user
	 * @param key
	 * @retun value of key
	 * @throws Throwable
	 */
		public String getPropertykeyvalue(String key)throws Throwable
		{
			FileInputStream fis= new FileInputStream("C:\\TestCase1\\src\\Data2\\Commondata.properties");
			Properties pobj=new Properties();
			pobj.load(fis);
					String Value=pobj.getProperty(key);
			return Value;
		}
		/**
		 * get the data from excel workbook,based on user arguements
		 * @param sheetName
		 * @param rowNum
		 * @param colNum
		 * @return
		 * throws Throwable
		 * @throws IOException 
		 * @throws EncryptedDocumentException 
		 */
		public String getExcelData(String sheetName, int rowNum,int colNum) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("C:\\TestCase1\\src\\Data2\\data.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sh= wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
	      Cell cel=row.getCell(colNum);
	    String data=cel.getStringCellValue();
	    wb.close();
		return data;
		}
	/**
	 * set data back to excel-workbook based on user argurement
	 * @param sheetName
	 * @param rownum
	 * @param colnum
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	 */
	   
	

}
