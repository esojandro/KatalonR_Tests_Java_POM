package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Travel_Page {
	
	WebDriver driver;
	//Login test
	By user_mail = By.xpath("//input[contains(@type,'text')]");
	By user_pass = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input");
	By submit_botton = By.xpath("//input[@type='submit']");
	By text_wrong_login = By.xpath("//span[contains(.,'Enter your userName and password correct')]");
	// Register test
	By register_botton = By.xpath("//a[@href='register.php'][contains(.,'REGISTER')]");
	By write_first_name = By.xpath("//input[@name='firstName']");
	By write_last_name = By.xpath("//input[@name='lastName']");
	By write_phone = By.xpath("//input[contains(@name,'phone')]");
	By write_email = By.xpath("//input[contains(@id,'userName')]");
	By write_address = By.xpath("//input[contains(@name,'address1')]");
	By write_city = By.xpath("//input[@name='city']");
	By write_state = By.xpath("//input[contains(@maxlength,'40')]");
	By write_zip = By.xpath("//input[contains(@name,'postalCode')]");
	By write_country = By.xpath("//select[contains(@name,'country')]");
	By write_username = By.xpath("//input[contains(@id,'email')]");
	By write_pass = By.xpath("//input[contains(@name,'password')]");
	By confrim_pass = By.xpath("//input[contains(@name,'confirmPassword')]");
	By send_botton = By.xpath("//input[@src='images/submit.gif']");
	By sucess_login = By.xpath("(//font[contains(@face,'Arial, Helvetica, sans-serif')])[3]");
	
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
	
	public void registerBotton() {
		driver.findElement(register_botton).click();
	}
	
	//Register test
	
	public void writeFisrtName(String firstName) {
		driver.findElement(write_first_name).sendKeys(firstName);
	}
	
	public void writeLastName(String lastName) {
		driver.findElement(write_last_name).sendKeys(lastName);
	}
	
	public void writePhone(String phone) {
		driver.findElement(write_phone).sendKeys(phone);
	}
	
	public void writeEmail(String mail) {
		driver.findElement(write_email).sendKeys(mail);
	}
	
	public void writeAddress(String address) {
		driver.findElement(write_address).sendKeys(address);
	}
	
	public void writeCity(String city) {
		driver.findElement(write_city).sendKeys(city);
	}
	
	public void writeState(String state) {
		driver.findElement(write_state).sendKeys(state);
	}
	
	public void writeZip(String zip) {
		driver.findElement(write_zip).sendKeys(zip);
	}
	
	public void writeCountry(String country) {
		driver.findElement(write_country).sendKeys(country);
	}
	
	public void writeUsername(String user) {
		driver.findElement(write_username).sendKeys(user);
	}
	
	public void writePass(String pass) {
		driver.findElement(write_pass).sendKeys(pass);
	}
	
	public void confirmPass(String confirPass) {
		driver.findElement(confrim_pass).sendKeys(confirPass);
	}
	
	public void sendBotton() {
		driver.findElement(send_botton).click();
	}
	
	public void asserSucessLogin() {
		assert(driver.findElement(sucess_login).isDisplayed());
	}
}