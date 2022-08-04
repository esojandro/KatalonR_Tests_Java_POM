package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shop_Page {
	
	ChromeDriver driver;
	By assert_page_title = By.xpath("//h1[contains(.,'Shop')]");
	By select_product = By.xpath("(//img[contains(@class,'thumbnail')])[1]");
	By write_cuantity = By.xpath("//input[contains(@type,'number')]");
	By add_botton = By.xpath("//button[@type='submit'][contains(.,'Add to cart')]");
	By assert_add_product = By.xpath("//div[@class='woocommerce-message']");
	By view_cart = By.xpath("//a[@tabindex='1']");
	By write_state = By.xpath("//input[contains(@id,'billing_state')]");
	By write_town = By.xpath("//input[contains(@id,'billing_city')]");
	By write_zip = By.xpath("//input[contains(@id,'billing_postcode')]");
	By checkout_botton = By.xpath("//a[@class='checkout-button button alt wc-forward']");
	By write_frist_name = By.xpath("//input[@id='billing_first_name']");
	By write_last_name = By.xpath("//input[contains(@id,'billing_last_name')]");
	By write_street = By.xpath("//input[contains(@name,'billing_address_1')]");
	By write_phone = By.xpath("//input[contains(@id,'billing_phone')]");
	By write_email = By.xpath("//input[@id='billing_email']");
	By order_botton = By.id("place_order");
	By assert_order = By.xpath("//p[contains(.,'Thank you. Your order has been received.')]");

	public Shop_Page(ChromeDriver driver) { this.driver = driver; }

	public void assertPageTitle() { assert(driver.findElement(assert_page_title).isDisplayed()); }

	public void selectProduct() { driver.findElement(select_product).click();  }

	public void writeCuantity(String cuantity) 
	{
		driver.findElement(write_cuantity).clear();
		driver.findElement(write_cuantity).sendKeys(cuantity); 
	}

	public void addProduct() { driver.findElement(add_botton).click(); }

	public void assertAddProduct() { assert(driver.findElement(assert_add_product).isDisplayed()); }

	public void viewCart() { driver.findElement(view_cart).click(); }

	public void changeState(String state) { driver.findElement(write_state).sendKeys(state); }

	public void changeTown(String town) { driver.findElement(write_town).sendKeys(town); }

	public void addZip(String zip) { driver.findElement(write_zip).sendKeys(zip); }

	public void clickCheckout() { driver.findElement(checkout_botton).click(); }

	public void writeFisrtName(String fristName) { driver.findElement(write_frist_name).sendKeys(fristName); }

	public void writeLastName(String lastName) { driver.findElement(write_last_name).sendKeys(lastName); }

	public void writeStreet(String street) { driver.findElement(write_street).sendKeys(street); }

	public void writePhone(String phone) { driver.findElement(write_phone).sendKeys(phone); }

	public void writeMail(String mail) { driver.findElement(write_email).sendKeys(mail); }

	public void orderProduct() { driver.findElement(order_botton).click(); }

	public void assertOrder() { assert(driver.findElement(assert_order).isDisplayed()); }
}