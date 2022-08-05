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
    	travel.ingresaPass(" "); //space in blank
    	travel.submitBotton();
    	travel.assertTextWorgLogin();
    	driver.quit();
    }
    
    @Test
    public void ResgisterTest() {
    	travel.registerBotton();
    	travel.writeFisrtName("Jonh");
    	travel.writeLastName("Doe");
    	travel.writePhone("89786541");
    	travel.writeEmail("mail@mail");
    	travel.writeAddress("address");
    	travel.writeCity("Sao Pablo");
    	travel.writeState("JL");
    	travel.writeZip("11901");
    	travel.writeCountry("Costa Rica");
    	travel.writeUsername("jodo");
    	travel.writePass("pas123");
    	travel.confirmPass("pas123");
    	travel.sendBotton();
    	travel.asserSucessRegister();
    	driver.quit();
    }
    
    @Test
    public void SuccessLogin() {
    	travel.ingresaMail("jodo");
    	travel.ingresaPass("pas123");
    	travel.submitBotton();
    	travel.assertTextSuccessLogin();
    	driver.quit();
    }
    
    @Test
    public void LoginWrongPass() {
    	travel.ingresaMail("jodo");
    	travel.ingresaPass("pass123");
    	travel.submitBotton();
    	travel.assertTextWorgLogin();
    	driver.quit();
    }
    
    @Test
    public void FlightFinder() { // Presenta problemas porque hay anuncios en la test page	
    	travel.bottonFlights();
    	travel.DDLPassenger("4");
    	travel.DDLDeparting("London");
    	travel.DDLDepartingMonth("July");
    	travel.DDLDepartingDay("14");
    	travel.DDLArriving("Paris");
    	travel.DDLDepartingMonth("October");
    	travel.DDLDepartingDay("22");
    	travel.bottonContinue();
    	travel.assertTextFlight();
    	driver.close();
    }
}