package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Travel_Page {
	
	WebDriver driver;
	By user_mail = By.xpath("//input[contains(@type,'text')]");
	By user_pass = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input");
	By submit_botton = By.xpath("//input[@type='submit']");
	By text_wrong_login = By.xpath("//span[contains(.,'Enter your userName and password correct')]");
	
	public Travel_Page(WebDriver driver)
    {
        this.driver = driver;
    }
	
	public void ingresaMail(String mail) {
		driver.findElement(user_mail).sendKeys(mail);
	}
	
	public void ingresaPass(String pass) {
		driver.findElement(user_pass).sendKeys(pass);
	}
	
	public void submitBotton() {
		driver.findElement(submit_botton).click();
	}
	
	public void assertTextWorgLogin() {
		assert(driver.findElement(text_wrong_login).isDisplayed());
	}
}