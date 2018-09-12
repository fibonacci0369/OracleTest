package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	
		public ReadExcel (String file) throws IOException {
			File rutaArchivo = new File(file);
			FileInputStream src = new FileInputStream(rutaArchivo);
			wb = new XSSFWorkbook(file);

		}
		
		public String  getData(String sheetname,int row, int column) {
			
			sheet = wb.getSheet(sheetname);
			String data=sheet.getRow(row).getCell(column).getStringCellValue();
			return data;
			

		}
}