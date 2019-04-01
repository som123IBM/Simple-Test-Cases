package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.bean.RealEstateBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "db-inputs1")
	public Object [][] getDBData1() {

		List<RealEstateBean> list = new ELearningDAO().getRealEstateFeatures(); 

		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(RealEstateBean temp : list){
			Object[]  obj = new Object[4]; 
			obj[0] = temp.getNameTextBox();
			obj[1]=temp.getSlugTextBox();
			obj[2]=temp.getParentFeatureListBox();
			obj[3]=temp.getDescriptionTextBox();
	

			result[count ++] = obj; 
		}


		return result;
	}
	
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\Course\\Assignments\\Test Data\\TestData.xlsx";
		String sheetName = "082";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\Course\\Assignments\\Test Data\\TestData.xlsx";
		String sheetName = "083";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "excel-inputs3")
	public Object[][] getExcelData3(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\Selenium\\Course\\Assignments\\Test Data\\TestData.xlsx";
		String sheetName = "084";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
