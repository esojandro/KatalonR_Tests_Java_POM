package Pages;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	By sucess_register = By.xpath("(//font[contains(@face,'Arial, Helvetica, sans-serif')])[3]");
	By sucess_login = By.xpath("//h3[contains(.,'Login Successfully')]");
	// DDL Test
	By flights_botton = By.xpath("//a[@href='reservation.php'][contains(.,'Flights')]");
	By drop_down_list_passenger = By.xpath("//select[contains(@name,'passCount')]");
		By ddl_passenger_options = By.tagName("option"); // Depende del selector anterior
	By drop_down_list_departing = By.xpath("//select[contains(@name,'fromPort')]");
		By ddl_departing_options = By.tagName("option");

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

	public void asserSucessRegister() {
		assert(driver.findElement(sucess_register).isDisplayed());
	}

	public void assertTextSuccessLogin() {
		assert(driver.findElement(sucess_login).isDisplayed());
	}

	public void bottonFlights() {
		driver.findElement(flights_botton).click();
	}

	// Drop Down List Test Methods
	
	// Si hubiese una Clase base los siguientes dos metodos serian parte de en esta
	// en este caso no se utilizan
	//	private void click(WebElement element) {
	//		element.click();
	//	}

	//		private String getText(By locator) {
	//			return driver.findElement(locator).getText();
	//		}

	public String DDLPassenger(String passengers) { 
		WebElement dropdownlist = driver.findElement(drop_down_list_passenger);
		List<WebElement> options = dropdownlist.findElements(ddl_passenger_options);

		for(int i = 0; i < options.size(); i++) {
			if((options.get(i).getText()).equals(passengers)) {
				(options.get(i)).click();
			}
		}

		String selectedOption = "";

		for (int i = 0; i < options.size(); i++) {
			if(options.get(i).isSelected()) {
				selectedOption = (options.get(i).getText());
			}
		}
		return selectedOption;
	}
	
	public String DDLDeparting(String departing) { 
		WebElement dropdownlist = driver.findElement(drop_down_list_departing);
		List<WebElement> options = dropdownlist.findElements(ddl_departing_options);

		for(int i = 0; i < options.size(); i++) {
			if((options.get(i).getText()).equals(departing)) {
				(options.get(i)).click();
			}
		}

		String selectedOption = "";

		for (int i = 0; i < options.size(); i++) {
			if(options.get(i).isSelected()) {
				selectedOption = (options.get(i).getText());
			}
		}
		return selectedOption;
	}
}