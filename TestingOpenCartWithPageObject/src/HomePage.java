import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPageObject {
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	By buscar = By.name("search");
	By botonBuscar = By.xpath("//span[@class='input-group-btn']/button");
	
	public void enterItemToSearch(String item){
		WebElement element = driver.findElement(buscar);
		element.clear();
		element.sendKeys(item);
	}
	
	public SearchPage clickSearchButton(String item){
		WebElement element = driver.findElement(botonBuscar);
		element.click();
		return new SearchPage(driver);
	}
	
}