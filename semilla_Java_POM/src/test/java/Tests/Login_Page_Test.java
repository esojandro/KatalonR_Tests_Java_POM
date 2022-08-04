package Tests;
import java.io.IOException;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Login_Page;

public class Login_Page_Test {

	private ChromeDriver driver;
    private Login_Page login;

    @Before
    public void SetupTest()
    {
    	System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        login = new Login_Page(driver);
    }

    @Test
    public void SuccessLogin() throws IOException{
        login.ingresaEmail("mail@email.com");
        login.ingresaPass("pas123");
        login.clickBoton();
        login.confirmTextSuccessLogin();
        login.takeScreenshotSucessLogin();
        driver.quit();
    }

    @Test
    public void passWrongToLogin() throws IOException{
        login.ingresaEmail("mail@email.com");
        login.ingresaPass("pas123556+");
        login.clickBoton();
        login.confirmTextWrongLogin();
        login.takeScreenshotSucessLogin();
        driver.quit();
    }

    @Test
    public void mailWrongToLogin() throws IOException{
        login.ingresaEmail("mailmaikl");
        login.ingresaPass("pas123");
        login.clickBoton();
        login.confirmTextWrongLogin();
        login.takeScreenshotSucessLogin();
        driver.quit();
    }

    @Test
    public void passInMailBox() throws IOException{
        login.ingresaEmail("pas123");
        login.ingresaPass("pas123");
        login.clickBoton();
        login.confirmTextWrongLogin();
        login.takeScreenshotSucessLogin();
        driver.quit();
    }
}