package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException 
	{
		String path=".\\testData\\Opencart_LoginData.xlsx"; //taking xl file from testData
		
		ExcelUtility exutil=new ExcelUtility(path);
		
		int totalrows=exutil.getRowCount("Sheet1");
		int totalcols=exutil.getCellCount("Sheet1", 1); //creating an object for XLUtility
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= exutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
		return logindata;  //returning two dimension array
	}

}
