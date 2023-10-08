package com.actitime.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.actitime.genericlibrary.Baseclass;
import com.actitime.genericlibrary.Filelibrary;
import com.actitime.pom.Homepage;
import com.actitime.pom.TaskPage;

public class Createcustomer extends Baseclass{

	@Test
	public void create() throws EncryptedDocumentException, IOException {
		Homepage hp =new Homepage(driver);
		hp.getTasktab().click();
		TaskPage tp =new TaskPage(driver);
		tp.getAddnew().click();
		tp.getNewcustomer().click();
		Filelibrary f= new Filelibrary();
		String custname = f.readDatafromExcel("WantedList", 2, 1);
		tp.getCustname().sendKeys(custname);
		String custdesp = f.readDatafromExcel("WantedList", 2, 2);
		tp.getCustdesp().sendKeys(custdesp);
		tp.getCreatebtn().click();
		
	}
}
