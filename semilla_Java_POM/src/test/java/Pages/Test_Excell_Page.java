package Pages;
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
	
	public Test_Excell_Page(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
//	String filepath = "./src/test/resources/writefiles/test.xlsx";
//	String searchText = readFile.readCell(filepath, "sheet1", 0, 0);
//	
//	public void writeSeacrh(){
//		driver.findElement(search_box).sendKeys(searchText);
//	}
}
