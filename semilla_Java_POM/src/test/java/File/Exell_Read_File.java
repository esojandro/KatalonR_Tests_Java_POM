package File;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.*;

public class Exell_Read_File {

	// Permite leer el excell fila por fila
	public void readPage(String filepath, String sheetName) throws IOException {

		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);		
		XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet = newWorkBook.getSheet(sheetName);

		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();

		for(int i = 0; i < rowCount; i++) {
			XSSFRow row = newSheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.println(row.getCell(j).getStringCellValue() + "//End\\");
			}
		}
	}

	// Permite leer el excell una celda
	public String readCell(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException {

		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);		
		XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet = newWorkBook.getSheet(sheetName);
		XSSFRow row = newSheet.getRow(rowNumber);
		XSSFCell cell = row.getCell(cellNumber);
		return cell.getStringCellValue();
	}
}
