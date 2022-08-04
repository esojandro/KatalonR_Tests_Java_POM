package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Calculator_Page {
	WebDriver driver;
    By first_Number = By.xpath("//input[contains(@id,'number1Field')]");
    By second_Number = By.xpath("//input[contains(@id,'number2Field')]");        
    By opcion_box = By.xpath("//select[contains(@id,'selectOperationDropdown')]");
    By botom_calculate = By.xpath("//input[contains(@id,'calculateButton')]");
    By assert_answer = By.xpath("//label[contains(@id,'errorMsgField')]");
    By integers_option = By.xpath("//input[contains(@id,'integerSelect')]");
    By clear_option = By.xpath("//input[contains(@id,'clearButton')]");

    public Calculator_Page(WebDriver driver)
    {
        this.driver = driver;
    }

    public void typeFirstNumber(String firstNumber)
    {
        driver.findElement(first_Number).sendKeys(firstNumber);
    }

    public void typeSecondNumber(String secondNumber)
    {
        driver.findElement(second_Number).sendKeys(secondNumber);
    }

    public void selectOpction(String option)
    {
        driver.findElement(opcion_box).sendKeys(option);
    }

    public void selectCalculate()
    {
        driver.findElement(botom_calculate).click();
    }

    public void assertAnswer()
    {
        assert(driver.findElement(assert_answer).isDisplayed());
    }

    public void selectIntegers()
    {
        driver.findElement(integers_option).click();
    }

    public void selectClear()
    {
        driver.findElement(clear_option).click();
    }
}
