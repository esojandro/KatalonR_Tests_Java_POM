package Tests;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Ecommerce_Page;

public class Ecommerce_Page_Test {
	
	private ChromeDriver driver;
	private Ecommerce_Page commerce;

	@Before
	public void SetupTest()
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://opencart.abstracta.us/index.php?route=common/home");
		commerce = new Ecommerce_Page(driver);
	}

	@Test
	public void TestSearhElement()
	{
		commerce.assertTitle();
		commerce.typeElement("phone");
		commerce.selectSearchBoton();
		driver.close(); 
	}

	@Test
	public void TestAddSixElements()
	{
		//TestSearhElement(); // Llamo al test anterior para partir de busqueda // no funciona porque los test se abren en ventanas diferentes
		commerce.assertTitle();
		commerce.typeElement("phone");
		commerce.selectSearchBoton();
		commerce.clickOnElement();
		commerce.typeNumberElements("6"); // Tiene un .clear en el metodo que limpia valores por defecto
		commerce.addToCart();
		driver.close();
	}

	@Test
	public void TestSearhTwoElements()
	{
		commerce.assertTitle();
		commerce.typeElement("display");
		commerce.selectSearchBoton();
		commerce.clearSearhBox(); // Limpia la cada de texto para hacer una nueva busqueda ver test anterior donde el .Clear se usa dentro de un método
		commerce.typeElement("phone");
		commerce.selectSearchBoton();
		driver.close();
	}
}