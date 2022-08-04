package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ecommerce_Page {
	
	ChromeDriver driver;
    By assert_title = By.xpath("//a[@href='http://opencart.abstracta.us:80/index.php?route=common/home']");
    By search_box = By.name("search");
    By search_botton = By.xpath("//div[@id='search']/span/button");
    By selec_element = By.xpath("//img[contains(@src,'1-228x228.jpg')]");
    By cuantity_box = By.xpath("//input[contains(@id,'input-quantity')]");
    By add_boton = By.xpath("//button[contains(@id,'button-cart')]");

    public Ecommerce_Page(ChromeDriver driver)
    {
        this.driver = driver;
    }

    public void assertTitle()
    {
        assert(driver.findElement(assert_title).isDisplayed());
    }

    public void typeElement(String typeSearch)
    {
        driver.findElement(search_box).sendKeys(typeSearch);
    }

    public void selectSearchBoton()
    {
        driver.findElement(search_botton).click();
    }

    public void clearSearhBox()
    {
        driver.findElement(search_box).clear();
    }

    public void clickOnElement()
    {
        driver.findElement(selec_element).click();
    }

    public void typeNumberElements(String inputQuantity)
    {
        driver.findElement(cuantity_box).clear(); // Primero hay que limiar la caja de texto que tiene por defecto la cantidad "1"
        driver.findElement(cuantity_box).sendKeys(inputQuantity);
    }

    public void addToCart()
    {
        driver.findElement(add_boton).click();
    }
}
