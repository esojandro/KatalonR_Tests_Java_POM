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
	public void testReadSearchWriteFristElement() throws IOException {

		tep.searchFristElement();
	}
	
	@Test
	public void testReadSearchWriteSecondElement() throws IOException {

		tep.searchSecondElement();
	}

}
