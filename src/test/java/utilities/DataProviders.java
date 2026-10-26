package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//Dataprovider 1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\opencart_logindata.xlsx";  //taking xl file fom testdata
		
		ExcelUtility xlutil=new ExcelUtility(path); //cretae an object  for xlutility
		 int totalrows =xlutil.getRowCount("Sheet1");
		 int totalcells=xlutil.getCellCount("Sheet1", 1);
		 
		 String  logindata[][]=new String [totalrows][totalcells];//create for two dimention  array  which  can storedata
		 for (int i=1;i<=totalrows;i++) //read  the data from  xl storing  in two dimention  array
		 {
			 for(int j=0;j<totalcells;j++) 
			 {
				 logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			 }
		 }
		 return logindata; //returning two dimention array
		 
	}
	

}
