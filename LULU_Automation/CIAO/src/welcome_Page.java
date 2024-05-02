import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class welcome_Page {

	@Test
	public  void main() {
		System.setProperty("webdriver.chrome.driver", "/Users/fdc-mac/Documents/LULU_Automation/LULU_Automation/Chrome_Driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://dev-front.machetalk.jp/liver/");
		System.out.println(driver.getTitle());
		
		
		// Locate the logo image element
        WebElement brandImageElement = driver.findElement(By.xpath("//div[@class='description']//div[@class='brand']//img"));
        
        // Check if the image element exists
        if (brandImageElement != null) {
	            // Get the src attribute of the image
	            String imageSrc = brandImageElement.getAttribute("src");
	            
	            // Check if the src attribute is not empty
	            if (!imageSrc.isEmpty()) {
	                System.out.println("Brand image is present with source: " + imageSrc);
	            } else {
	                System.out.println("Brand image src is empty");
	            }
	        } else {
	            System.out.println("Brand image element not found");
        }
        
        //Locate the 今をもっと楽しめるライブ配信アプリ element
        WebElement 今をもっと楽しめるライブ配信アプリ = driver.findElement(By.xpath("//h1[@class='visual_ttl']//img"));
        
        // Check if the image element exists
        if (今をもっと楽しめるライブ配信アプリ != null) {
	            // Get the src attribute of the image
	            String imageSrc = 今をもっと楽しめるライブ配信アプリ.getAttribute("src");
	            
	            // Check if the src attribute is not empty
	            if (!imageSrc.isEmpty()) {
	                System.out.println("今をもっと楽しめるライブ配信アプリ is present with source: " + imageSrc);
	            } else {
	                System.out.println("今をもっと楽しめるライブ配信アプリ src is empty");
	            }
	        } else {
	            System.out.println("今をもっと楽しめるライブ配信アプリ element not found");
        }
        
        //Locate the PCからの配信はこちら element
        WebElement PCからの配信はこちら = driver.findElement(By.xpath("//div[@class='description']//dt[contains(text(),'PCからの配信はこちら')]"));
        
        // Get the text of the button
        String labelText = PCからの配信はこちら.getText();
        
        // Verify the text of the button
        if (labelText.equals("PCからの配信はこちら")) {
            System.out.println("Label text is correct: " + labelText);
        } else {
            System.out.println("Label text is incorrect: " + labelText);
        }


	}

}
