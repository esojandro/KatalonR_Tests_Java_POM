package Tests;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.DDL_Example_Page;

public class DDl_Example_Page_Test {
	
	private ChromeDriver driver;
	private DDL_Example_Page reactTest;

	@Before
	public void SetupTest()
    {
    	System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://react-bootstrap.github.io/components/dropdowns/");
        reactTest = new DDL_Example_Page(driver);
    }
	
	@Test
	public void test() throws InterruptedException {
		reactTest.clickDDBoton();
		driver.quit();
	}

}
