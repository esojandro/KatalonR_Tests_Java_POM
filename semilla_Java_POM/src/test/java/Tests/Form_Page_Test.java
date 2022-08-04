package Tests;
import java.io.IOException;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Form_Page;

public class Form_Page_Test {

	private ChromeDriver driver;
	private Form_Page form;

	@Before
	public void SetupTest()
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
		form = new Form_Page(driver);
	}

	@Test
	public void TestFormSubmit() throws IOException
	{
		form.ingresaUserName("Jose");
		form.ingresaPass("pass1234");
		form.ingresaMail("mail@mail.com");
		form.seleccionaCheckbox2();
		form.seleccionaRadiobox2();
		form.seleccionaItem2();
		form.seleccionaDropItem2();
		form.seleccionaSubmit();
		form.assertSubmitForm();
		form.takeScreenshotSucessRegister();
		driver.close();
	}

	@Test
	public void TestFormCancel()
	{
		form.ingresaUserName("Jose");
		form.ingresaPass("pass1234");
		form.ingresaMail("mail@mail.com");
		form.seleccionaCheckbox2();
		form.seleccionaRadiobox2();
		form.seleccionaItem2();
		form.seleccionaDropItem2();
		form.seleccionaCancel();
		driver.close();
	}
}
