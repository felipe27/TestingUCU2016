import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage extends AbstractPageObject{

	public ItemPage(WebDriver driver) {
		super(driver);
	}
	
	By nombreElemento = By.xpath("//*[@id='content']/div[1]/div[2]/h1");
	
	public String getItemName(){
		WebElement element = driver.findElement(nombreElemento);
		return element.getText();
	}
	
	
}
