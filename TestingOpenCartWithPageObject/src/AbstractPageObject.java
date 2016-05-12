import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractPageObject {
	protected WebDriver driver;
	protected WebElement element;

	public AbstractPageObject(WebDriver driver) {
		this.driver = driver;
	}

}