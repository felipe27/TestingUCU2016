import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class OpenCartTest extends BaseTest {

	private String domain;
	private boolean expected;
	String nombrePrimerElemento = "";

	public OpenCartTest(String domain, Boolean expected) {
		super();
		this.domain = domain;
		this.expected = expected;
	}
 	
 	@Parameters(name= "{index}: isValid({0})={1}")
 	public static Iterable<Object[]> data() {
 		return SaveLoadFile.LoadFile();
    } 
 	
	@Test
	public void test_Elementos() {
		nombrePrimerElemento = ""; 
		HomePage storePage = new HomePage(driver);
		storePage.enterItemToSearch(domain);
		SearchPage searchPage = storePage.clickSearchButton(domain);		
        
	     try{
	    	 ItemPage itemPage = searchPage.enterItem(domain);
	    	 nombrePrimerElemento = itemPage.getItemName();
	     }catch (Exception e){
			}
        
		assertEquals(expected, nombrePrimerElemento.contains(domain));
	}

}