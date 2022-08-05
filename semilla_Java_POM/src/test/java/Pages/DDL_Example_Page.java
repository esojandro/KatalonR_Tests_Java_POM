package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DDL_Example_Page {
	
	WebDriver driver;
	By dd_botton = By.xpath("//button[@id='dropdown-basic']");
	By dd_option = By.xpath("//*[@id=\"rb-docs-content\"]/div[2]/div[1]/div/div/div/a[2]");
	
	public DDL_Example_Page(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickDDBoton() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(dd_botton).click();
		Thread.sleep(3000);
		driver.findElement(dd_option).click();
	}
}