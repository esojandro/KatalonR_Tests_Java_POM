package Pages;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Form_Page {
	
	WebDriver driver;
    // Selectors
    By name = By.xpath("//input[contains(@name,'username')]");
    By password = By.xpath("//input[contains(@type,'password')]");
    By email = By.xpath("//textarea[@cols='40'][contains(.,'Comments...')]");
    By checkbox_position_2 = By.xpath("//input[contains(@value,'cb2')]");
    By radio_item_2 = By.xpath("//input[contains(@value,'rd2')]");
    By selection_item_2 = By.xpath("//option[@value='ms2'][contains(.,'Selection Item 2')]");
    By Dropdown_item_2 = By.xpath("/html/body/div/div[3]/form/table/tbody/tr[8]/td/select/option[2]");
    By boton_sudmit = By.xpath("//input[contains(@type,'submit')]");
    By boton_cancel = By.xpath("//input[contains(@type,'reset')]");
    By assert_submit = By.xpath("//h1[contains(.,'Processed Form Details')]");

    // Methods

    public Form_Page(ChromeDriver driver)
    {
        this.driver = driver;
    }

    public void ingresaUserName(String userName)
    {
        driver.findElement(name).sendKeys(userName);
    }

    public void ingresaPass(String pass)
    {
        driver.findElement(password).sendKeys(pass);
    }

    public void ingresaMail(String mail)
    {
        driver.findElement(email).sendKeys(mail);
    }

    public void seleccionaCheckbox2()
    {
        driver.findElement(checkbox_position_2).click();
    }

    public void seleccionaRadiobox2()
    {
        driver.findElement(radio_item_2).click();
    }

    public void seleccionaItem2()
    {
        driver.findElement(selection_item_2).click();
    }

    public void seleccionaDropItem2()
    {
        driver.findElement(Dropdown_item_2).click();
    }

    public void seleccionaSubmit()
    {
        driver.findElement(boton_sudmit).click();
    }

    public void seleccionaCancel()
    {
        driver.findElement(boton_cancel).click();
    }
    public void assertSubmitForm()
    {
        assert(driver.findElement(assert_submit).isDisplayed());
    }

    public void takeScreenshotSucessRegister() throws IOException
    {       
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);        
        FileUtils.copyFile(screenshot, new File("src/test/resources/screenshots/Form_Exitoso.png"));
    }
}