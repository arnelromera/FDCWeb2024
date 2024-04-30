import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class testing {

	
	@Test
	public  void main() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\LULU_Automation\\Chrome_Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://dev-front.machetalk.jp/liver/");
		System.out.println("The" + "https://dev-front.machetalk.jp/liver/" + " is entered`");
	}

}
