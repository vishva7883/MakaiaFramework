package data.reader;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public Object[][] readdata(String dataSheetName) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("./DataSource/"+dataSheetName+".xlsx");
		//XSSFSheet sheetName = wb.getSheet("Sheet1");
		XSSFSheet sheetAt = wb.getSheetAt(0);
		
		int rc = sheetAt.getLastRowNum();
		System.out.println("Total Rows in the Sheet : "+rc);
		
		XSSFRow headrow = sheetAt.getRow(0);
		int cc = headrow.getLastCellNum();
		System.out.println("Total Columns in the Sheet : "+cc);
		
		Object[][] data = new Object[rc][cc];
		
		for (int i = 1; i<=rc; i++)
		{
			XSSFRow rowdata = sheetAt.getRow(i);
			
			for (int j=0; j<cc; j++)
			{
				XSSFCell columndata = rowdata.getCell(j);
				String xlvalue = columndata.getStringCellValue();
				
				System.out.println(xlvalue);
				data[i-1][j] = xlvalue;
						
			}
			
		}
		
		return data;
		
	}

}
