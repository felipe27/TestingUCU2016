import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends AbstractPageObject{
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	By primerElemento = By.xpath("//div[@id='content']/div[4]/div[1]/div/div[1]/a/img");
	
	public ItemPage enterItem(String domain){
		WebElement element = driver.findElement(primerElemento); 
		element.click();
		return new ItemPage(driver);
	}
	
	public String getElementName(int id){
		By nombrePrimerElemento = By.xpath("//*[@id='content']/div[4]/div["+id+"]/div/div[2]/h4/a");
		WebElement element = driver.findElement(nombrePrimerElemento); 
		return element.getText();
	}
}
