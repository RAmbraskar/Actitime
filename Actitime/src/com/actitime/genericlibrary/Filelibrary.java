package com.actitime.genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Filelibrary {
public String readDatafrompropertyfile(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./Testdata/commondata.property");
	Properties p= new Properties();
	p.load(fis);
	String data= p.getProperty(key);
	return data;	
}
public String readDatafromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./Testdata/Test Data.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	String data=wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	return data;
}

}
