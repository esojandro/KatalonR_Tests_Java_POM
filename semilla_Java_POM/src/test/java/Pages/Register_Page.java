package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register_Page {
	
	WebDriver driver;
    By userName = By.id("input-firstname");
    By userLast_name = By.id("input-lastname");
    By userEmail = By.id("input-email");
    By userPhone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirm_password = By.id("input-confirm");
    By check_agre = By.name("agree");
    By register_button = By.xpath("//input[@value='Continue']");
    By text_double_email = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
    By text_wrong_register = By.xpath("//div[@class='text-danger'][contains(.,'Password confirmation does not match password!')]");

    public Register_Page(WebDriver driver){
        this.driver = driver;
    }

    public void ingresaUserName(String name) {
        driver.findElement(userName).sendKeys(name);
    }

    public void ingresaLastName(String lastName) {
        driver.findElement(userLast_name).sendKeys(lastName);
    }

    public void ingresaEmail(String mail) {
        driver.findElement(userEmail).sendKeys(mail);
    }
    public void ingresaPhone(String phone) {
        driver.findElement(userPhone).sendKeys(phone);
    }
    public void ingresaPass(String pass) {
        driver.findElement(password).sendKeys(pass);
    }
    public void confirmPass(String confirm_pass) {
        driver.findElement(confirm_password).sendKeys(confirm_pass);
    }
    public void clickBoton() {
        driver.findElement(register_button).click();
    }

    public void checkAgree() {
        driver.findElement(check_agre).click();
    }

    public void confirmTextMailDuplicado() {
        assert(driver.findElement(text_double_email).isDisplayed());
    }

    public void confirmTextWrongLogin() {
        assert(driver.findElement(text_wrong_register).isDisplayed());
    }
}