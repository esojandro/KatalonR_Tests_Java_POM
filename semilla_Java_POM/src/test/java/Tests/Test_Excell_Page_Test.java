package Tests;
import java.io.IOException;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import File.*;

public class Test_Excell_Page_Test {
	
	private ChromeDriver driver;
    private Exell_Write_File writeFile;
    private Exell_Read_File readFile;
    
    By search_box = By.id("search_query_top");
	By search_btn = By.name("submit_search");
	By search_results = By.xpath("//span[contains(@class,'heading-counter')]");

    @Before
    public void SetupTest()
    {
    	System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
		writeFile = new Exell_Write_File();
		readFile = new Exell_Read_File();
        driver.get("http://automationpractice.com/index.php");
    }
    
	@Test
	public void test() throws IOException {
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

}
