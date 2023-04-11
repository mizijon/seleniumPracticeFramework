package SeleniumSelect;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dropdownSelect {

	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\khilo\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		 //dropdownDemo();
		// nonSelectDropDown();
		 alertDemo();
	}
	public static void dropdownDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		//and select Home & Kitchen option from the dropdown
				WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));
				Select choose = new Select(selectElement);
				
				WebElement firstSelectedOption = choose.getFirstSelectedOption();
				System.out.println(firstSelectedOption.getText());
				
				choose.selectByVisibleText("Home & Kitchen");
				Thread.sleep(1000);
				choose.selectByIndex(2);
				Thread.sleep(1000);
				choose.selectByValue("search-alias=stripbooks");
				
				System.out.println(choose.getFirstSelectedOption().getText());
				
				
				List<WebElement> allOptions = choose.getOptions();
				System.out.println(allOptions.size());
				for (WebElement element : allOptions) {
				System.out.println(element.getText());
				Thread.sleep(500);
				driver.quit();
}
	}
	
		public static void nonSelectDropDown()throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			// go to this website
			driver.get("https://semantic-ui.com/modules/dropdown.html");
			//wait until the dropdown element is visible
			WebElement dropdown = 
			driver.findElement(By.xpath("(//div[@class='ui fluid selection dropdown'])[1]"));
			wait.until(ExpectedConditions.visibilityOf(dropdown));
			// and click on the dropdown element
			dropdown.click();
			
			// wait until the Matt guy visible
			WebElement mattOption = driver.findElement(By.xpath("//div[@data-value='matt']"));
			
			wait.until(ExpectedConditions.visibilityOf(mattOption));
			mattOption.click();
			Thread.sleep(500);
			driver.quit();
		
		}
		public static void alertDemo() throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			
			driver.get("http://practice.primetech-apps.com/practice/alerts");
			driver.findElement(By.id("confirm")).click();
			wait.until(ExpectedConditions.alertIsPresent());
			
			Alert handle = driver.switchTo().alert();
			Thread.sleep(1000);
			handle.accept();
			
			driver.findElement(By.id("prompt")).click();
			wait.until(ExpectedConditions.alertIsPresent());
			
			Alert handle2 = driver.switchTo().alert();
			System.out.println(handle2.getText());
			handle2.sendKeys("Shav");
			handle2.dismiss();
			Thread.sleep(500);
			driver.quit();
		} 
}