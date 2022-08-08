package Tests;
import java.io.IOException;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Test_Excell_Page;

public class Test_Excell_Page_Test {

	private ChromeDriver driver;
	private Test_Excell_Page tep;

	@Before
	public void SetupTest()
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		tep = new Test_Excell_Page(driver);
	}

	@Test
	public void testProcessFristElement() throws IOException{
		tep.searchAnyElement(0, 0, 0, 1); // readcell, readRow, writeCell, writeRow
		driver.close();
	}
	
	@Test
	public void testProcessSecodElement() throws IOException{
		tep.searchAnyElement( 1, 0, 1, 1); // readcell, readRow, writeCell, writeRow
		driver.close();
	}
	
	@Test
	public void testProcessTreeElement() throws IOException{
		tep.searchAnyElement( 2, 0, 2, 1); // readcell, readRow, writeCell, writeRow
		driver.close();
	}
}
