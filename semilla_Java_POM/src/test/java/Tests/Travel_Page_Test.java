package Tests;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Travel_Page;

public class Travel_Page_Test {

	private ChromeDriver driver;
    private Travel_Page travel;

    @Before
    public void SetupTest()
    {
    	System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/index.php");
        travel = new Travel_Page(driver);
    }
    
    @Test
    public void TryLogin() {
    	travel.ingresaMail("noemailcaracter");
    	travel.ingresaPass(" "); //space i blank
    	travel.submitBotton();
    	travel.assertTextWorgLogin();
    	driver.quit();
    }
}