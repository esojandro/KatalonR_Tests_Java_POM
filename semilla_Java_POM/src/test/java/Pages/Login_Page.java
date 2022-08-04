package Pages;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Login_Page {
	
	WebDriver driver;
    By userEmail = By.id("input-email");
    By password = By.id("input-password");
    By login_button = By.xpath("//input[contains(@type,'submit')]");
    By text_sucess_login = By.xpath("(//a[contains(@class,'list-group-item')])[13]");
    By text_wrong_login = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
    
    public Login_Page(WebDriver driver)
    {
        this.driver = driver;
    }
    
    public void ingresaEmail(String mail)
    {
        driver.findElement(userEmail).sendKeys(mail);
    }

    public void ingresaPass(String pass)
    {
        driver.findElement(password).sendKeys(pass);
    }
 
    public void clickBoton()
    {
        driver.findElement(login_button).click();
    }

    public void confirmTextSuccessLogin()
    {
        assert(driver.findElement(text_sucess_login).isDisplayed());
    }

    public void confirmTextWrongLogin()
    {
        assert(driver.findElement(text_wrong_login).isDisplayed());
    }

    public void takeScreenshotSucessLogin() throws IOException
    {        
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);        
        FileUtils.copyFile(screenshot, new File("src/test/resources/screenshots/SucessloginPhoto.png"));
    }
}
