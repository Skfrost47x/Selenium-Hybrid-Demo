package codenbox.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "testDemo")
	public String [] [] getData() {
		String path = ".//testData//testDemo.xlsx";
		//creating object of excel reader
		ExcelReader xlutil = new ExcelReader(path);
		int totalrows = xlutil.getRowCount("Sheet1"); //total num of rows
		int totalcols = xlutil.getColumnCount("Sheet1");//total num of columns
		
		String data[][] = new String[totalrows-1][totalcols];
		
		for(int rowNum=2; rowNum<=totalrows; rowNum++) {
			for (int colNum=0; colNum<totalcols; colNum++) {
				data[rowNum-2][colNum]=xlutil.getCellData("Sheet1", colNum, rowNum);
			}
		}
		
		return data;
		
	}

}
