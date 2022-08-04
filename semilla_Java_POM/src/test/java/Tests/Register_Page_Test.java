package Tests;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Register_Page;

public class Register_Page_Test {
	private ChromeDriver driver;
    private Register_Page register;

    @Before
    public void SetupTest()
    {
    	System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://opencart.abstracta.us/index.php?route=account/register");
        register = new Register_Page(driver);
    }
    
    @Test
    public void TestMailDuplicado(){
        register.ingresaUserName("Brand");
        register.ingresaLastName("Dovarn");
        register.ingresaEmail("email@email.com");
        register.ingresaPhone("96857423");
        register.ingresaPass("pas123");
        register.confirmPass("pas123");
        register.checkAgree();
        register.clickBoton();
        register.confirmTextMailDuplicado();
        driver.close();
    }

    @Test
    public void TestWrongPassConfirm(){
        register.ingresaUserName("Brand");
        register.ingresaLastName("Dovarn");
        register.ingresaEmail("email@email.com");
        register.ingresaPhone("96857423");
        register.ingresaPass("pas123");
        register.confirmPass("pas1234");
        register.checkAgree();
        register.clickBoton();
        register.confirmTextWrongLogin();
        driver.close();
    }
}