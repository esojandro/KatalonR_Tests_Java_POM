package Pages;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Test_Excell_Page {

	WebDriver driver;
	
	// Selecctors

	By search_box = By.id("search_query_top");
	By search_btn = By.name("submit_search");
	By search_results = By.xpath("//span[contains(@class,'heading-counter')]");

	public Test_Excell_Page(WebDriver driver) {

		this.driver = driver;
	}

	// Write / Read .FIle methods
	// Buscar la forma de crear una propia clase para los metodos search y write clasificados en tipo fila

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

	// Permite escribir el excell fila por fila
	public void writePage(String filepath, String sheetName, String[] dataToWirte) throws IOException {

		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);		
		XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet = newWorkBook.getSheet(sheetName);
		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();		
		XSSFRow row = newSheet.getRow(0);
		XSSFRow newRow = newSheet.createRow(rowCount + 1);

		for(int i = 0; i < row.getLastCellNum(); i++) {			
			XSSFCell newCell = newRow.createCell(i);
			newCell.setCellValue(dataToWirte[i]);
		}
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		newWorkBook.write(outputStream);
		outputStream.close();
	}

	// Permite escribir el excell una celda
	public void writeCell(String filepath, String sheetName, int rowNumber, int cellNumber, String resultTest) throws IOException {

		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
		XSSFRow row = newSheet.getRow(rowNumber);
		XSSFCell firstCell = row.getCell(cellNumber - 1);
		System.out.println("first cell value is:" + firstCell.getStringCellValue());
		XSSFCell nextCell = row.createCell(cellNumber);
		nextCell.setCellValue(resultTest);
		System.out.println("nextcell value:" + nextCell.getStringCellValue());
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		newWorkbook.write(outputStream);
		outputStream.close();
	}

	// Test Mehod
	
	public void searchAnyElement(int readRow, int readCell, int writeRow, int writeCell) throws IOException {
		String filepath = "./src/test/resources/writefiles/test.xlsx";
		String searchText = readCell(filepath, "Hoja1", readRow, readCell);		
		driver.findElement(search_box).sendKeys(searchText);
		driver.findElement(search_btn).click();		
		String resultText = driver.findElement(search_results).getText();
		System.out.println("Page result text: " + searchText);		
		readPage(filepath, "Hoja1");		
		writeCell(filepath, "Hoja1", writeRow, writeCell, resultText);		
		readPage(filepath, "Hoja1");
	}
}
