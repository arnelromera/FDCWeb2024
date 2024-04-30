import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class liveLogin {
	
	DataFormatter format = new DataFormatter();
	@DataProvider(name="driveTest")
	public Object[][] getData() throws IOException {		
		FileInputStream fis = new FileInputStream("C://Users//fdcar//Downloads//LULU_Automation//ExcelFiles//LiverLogin.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		
		XSSFSheet sheets =	workBook.getSheetAt(0);
		int rowCount = sheets.getPhysicalNumberOfRows();
		XSSFRow row = sheets.getRow(0);
		int colCount = row.getLastCellNum();
		
		Object data[][] = new Object[rowCount-1][colCount];
		for(int i=0; i<rowCount-1; i++)
		{
			row = sheets.getRow(i+1);
			for(int j=0; j<colCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i][j] = format.formatCellValue(cell);
			}
		}
		return data;
	}


	@Test(dataProvider="driveTest")
	public void testCaseData(String URL, String USERNAME, String PASSWORD) throws InterruptedException
	{	
	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--use-fake-ui-for-media-stream=10");
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\LULU_Automation\\Chrome_Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.get(URL);
		System.out.println("The" + URL + " is entered`");
		
		// login button
		WebElement viewerLoginButton = driver.findElement(By.cssSelector(".button_login.btn_style.btn_green-o"));
		String viewerLoginButtonText = viewerLoginButton.getText();
		viewerLoginButton.click();
		System.out.println("The "+ viewerLoginButtonText + "button is clicked");
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("login_mail")));
		
		//Viewer username
		driver.findElement(By.name("login_mail")).sendKeys(USERNAME);
		System.out.println("The " + USERNAME + " username is enetered");
		
		//viewer password
		driver.findElement(By.name("login_password")).sendKeys(PASSWORD);
		System.out.println("The " + PASSWORD + " password is enetered");

		//continue login button
		WebElement viewerContinueLoginButton = driver.findElement(By.xpath("//button[@class='btn_style btn_green']"));
		String viewerContinueLoginButtonText = viewerContinueLoginButton.getText();
		viewerContinueLoginButton.click();
		System.out.println("The " + viewerContinueLoginButtonText + " button is clicked");
		
		Thread.sleep(5000);
		
		//daily login bunos
		Bonus("dailybonus",driver);

		driver.quit();
	}
	public void Bonus(String act,WebDriver driver) throws InterruptedException
	{		
		switch (act) {
		case "dailybonus" :
			try {
				boolean doGetBonusPresence = driver.findElement(By.id("doGetBonus")).isDisplayed();
				boolean doGetBonusEnabled = driver.findElement(By.id("doGetBonus")).isDisplayed();
				if(doGetBonusPresence == true && doGetBonusEnabled == true)	
				{
					//daily login bunos modal
					System.out.println("The daily login modal bonus is displayed");
					WebElement claimBunos = driver.findElement(By.id("doGetBonus"));
					String claimBunosText = claimBunos.getText();
					claimBunos.click();
					System.out.println("The " + claimBunosText + " button is clicked");
					
					Thread.sleep(3000);
					
					//get modal bonus
					System.out.println("The daily login get modal bonus is displayed");
					WebElement getModalBonus = driver.findElement(By.cssSelector(".btn_style.btn_green.modal_close"));	
					String getModalBonusText = getModalBonus.getText();
					getModalBonus.click();
					System.out.println("The " + getModalBonusText + " button is clicked");
				}
			}
			catch(Exception e){
				
				System.out.println("The get bonus modal is not displayed.");
			}
			break;
			
		  default :
			  break;
		}
	}

}
