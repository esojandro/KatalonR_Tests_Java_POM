package Pages;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import File.*;

public class Test_Excell_Page {

	WebDriver driver;	

	private Exell_Write_File writeFile;
	private Exell_Read_File readFile;

	By search_box = By.id("search_query_top");
	By search_btn = By.name("submit_search");
	By search_results = By.xpath("//span[contains(@class,'heading-counter')]");
	
	public Test_Excell_Page(WebDriver driver) {
		this.driver = driver;
	}	

	public void searchFristElement() throws IOException {
		String filepath = "./src/test/resources/writefiles/test.xlsx";
		String searchText = readFile.readCell(filepath, "Hoja1", 0, 0);		
		driver.findElement(search_box).sendKeys(searchText);
		driver.findElement(search_btn).click();		
		String resultText = driver.findElement(search_results).getText();
		System.out.println("Page result text: " + searchText);		
		readFile.readPage(filepath, "Hoja1");		
		writeFile.writeCell(filepath, "Hoja1", 0, 1, resultText);		
		readFile.readPage(filepath, "Hoja1");
	}
	
	public void searchSecondElement() throws IOException {
		String filepath = "./src/test/resources/writefiles/test.xlsx";
		String searchText = readFile.readCell(filepath, "Hoja1", 1, 0);		
		driver.findElement(search_box).sendKeys(searchText);
		driver.findElement(search_btn).click();		
		String resultText = driver.findElement(search_results).getText();
		System.out.println("Page result text: " + searchText);		
		readFile.readPage(filepath, "Hoja1");		
		writeFile.writeCell(filepath, "Hoja1", 1, 1, resultText);		
		readFile.readPage(filepath, "Hoja1");
	}
}
