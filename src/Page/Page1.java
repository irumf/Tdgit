package Page;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page1 {
	WebDriver driver ;

	@FindBy(xpath="//a[@role='button'and@href='/ca/en/personal-banking/products/mortgages/calculators-tools']")
	public static WebElement calculator;
	

	@FindBy(xpath="//span[contains(text(),'Get pre-approved')]")
	public static WebElement GetPreApproved;
	
	@FindBy(xpath="//a[@href='/ca/en/personal-banking/products/mortgages/mortgage-rates']")
	public static WebElement GetRates;
	
	@FindBy(xpath="//span[contains(text(),'Calculate now')]")
	public static WebElement calculate;


	public void openBrowser() throws IOException {
		FileInputStream fs = new FileInputStream("C:\\Users\\irumf\\OneDrive\\Documents\\prop1.properties");
		Properties prop = new Properties();
		prop.load(fs);
		String browser = prop.getProperty("browser");
		
		if(browser.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\Users\\irumf\\Desktop\\web driver\\geckodriver.exe" );

			driver = new FirefoxDriver();
		}else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\irumf\\Desktop\\web driver\\chromedriver.exe" );
		
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\irumf\\Desktop\\web driver\\geckodriver.exe" );
		
			driver = new FirefoxDriver();
				}
	PageFactory.initElements(driver, this);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));


	}

	
	
	public void openpage() {
		String baseUrl = "https://www.td.com/ca/en/personal-banking/products/mortgages";
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	public void GoToCalculator() throws InterruptedException {
	Thread.sleep(2000);
	calculator.click();
	
	}
	
	public void ClickOnPreApproved() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		GetPreApproved.click();
		
	}
	
	public void GetMortgagerates() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		String navigateUrl = "https://www.td.com/ca/en/personal-banking/products/mortgages/calculators-tools";
        driver.navigate().to(navigateUrl);
		Thread.sleep(2000);
		GetRates.click();
	}
	
	public void CalculateRates() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		String navigateUrl = "https://www.td.com/ca/en/personal-banking/products/mortgages/calculators-tools";
        driver.navigate().to(navigateUrl);
		Thread.sleep(2000);
		calculate.click();
	}
}
