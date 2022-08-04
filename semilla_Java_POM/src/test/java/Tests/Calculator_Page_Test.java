package Tests;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Calculator_Page;

public class Calculator_Page_Test {

	private ChromeDriver driver;
    private Calculator_Page calculate;

    @Before
    public void SetupTest()
    {
    	System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
		driver.manage().window().maximize();
        calculate = new Calculator_Page(driver);
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
    }

    @Test
    public void TestAddCalculate()
    {
        calculate.typeFirstNumber("1");
        calculate.typeSecondNumber("1");
        calculate.selectOpction("Add");
        calculate.selectCalculate();
        driver.close();
    }

    @Test
    public void TestDivideCalculate()
    {
        calculate.typeFirstNumber("3");
        calculate.typeSecondNumber("895");
        calculate.selectOpction("Divide");
        calculate.selectIntegers(); // redondea a un valor
        calculate.selectCalculate();
        driver.close();
    }

    @Test
    public void TestTryDivideLetter()
    {
        calculate.typeFirstNumber("3");
        calculate.typeSecondNumber("JJJ");
        calculate.selectOpction("Divide");
        calculate.selectCalculate();
        calculate.assertAnswer();
        driver.close();
    }

    @Test
    public void TestConcatenatePhrase()
    {
        calculate.typeFirstNumber("Hola");
        calculate.typeSecondNumber(" Mundo");
        calculate.selectOpction("Concatenate");
        calculate.selectCalculate();
        driver.close();
    }

}
