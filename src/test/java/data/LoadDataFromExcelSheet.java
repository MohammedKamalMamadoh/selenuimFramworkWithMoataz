package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.opencv.objdetect.Objdetect;

public class LoadDataFromExcelSheet {
	
	public static Object[][] getDataFromExcel() throws IOException
	{
		File file= new File(System.getProperty("user.dir")+"\\src\\test\\java\\data\\userdata.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		Sheet sheet= workbook.getSheetAt(0) ;
		int Row=sheet.getLastRowNum()+1;
		int col= sheet.getRow(0).getLastCellNum();
		
		Object data [][]= new Object[Row][col];
		for (int i = 0; i <Row; i++) 
		{
		for (int c = 0; c < col; c++)
		{
		data[i][c]=sheet.getRow(i).getCell(c).toString();	
		}	
		}
		workbook.close();
		return data;
	}

}
