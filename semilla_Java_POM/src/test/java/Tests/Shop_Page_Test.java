package Tests;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Shop_Page;

public class Shop_Page_Test {

	private ChromeDriver driver;
	private Shop_Page shop;

	@Before
	public void SetupTest()
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cms.demo.katalon.com/");
		shop = new Shop_Page(driver);
	}


	@Test

	public void TestOrderProduct()
	{
		shop.assertPageTitle();
		shop.selectProduct();
		shop.writeCuantity("6");
		shop.addProduct();
		shop.viewCart();
		shop.clickCheckout();
		driver.quit();
	}

	@Test

	public void TestOrderChangeAddress()
	{
		shop.assertPageTitle();
		shop.selectProduct();
		shop.writeCuantity("6");
		shop.addProduct();
		shop.viewCart();
		shop.clickCheckout();
		shop.writeFisrtName("Jose");
		shop.writeLastName("Romero");
		shop.writeStreet("Calle Principal");
		shop.changeTown("Pérez Zeledón");
		shop.changeState("San José");
		shop.addZip("11901");
		shop.writePhone("98765432");
		shop.writeMail("mail@mail.com");
		//shop.orderProduct();
		//shop.assertOrder();
		driver.quit();
	}

}
