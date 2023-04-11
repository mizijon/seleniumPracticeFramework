package SeleniumSelect;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class amazonDropdownPractice {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\khilo\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		amazonSelectDropdown();
		alertTest();
	}
	public static void alertTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		String text = "PrimeTech";
		driver.findElement(By.id("prompt")).click();
		wait.until(ExpectedConditions.alertIsPresent());

		Alert handle = driver.switchTo().alert();
		handle.sendKeys(text);
		handle.accept();	
		
		WebElement greetingTextElement = driver.findElement(By.id("demo"));
		wait.until(ExpectedConditions.visibilityOf(greetingTextElement));
		String greetingText = greetingTextElement.getText();
		if (greetingText.equals("Hello " + text + "! How are you Today")) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		
	
	}		
	public static void amazonSelectDropdown() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
		String expectedTitle = "Amazon.com. Spend less. Smile more.";
		if(driver.getTitle().equals(expectedTitle)) {
			System.out.println("We are on the Home Page");
		}else {
			System.out.println("We are not on the Home Page");
		}
		String defaultDropdownValue = "All Departments";
		WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
		
		Select letSelect = new Select(dropDown);
		String actualletSelectOption = letSelect.getFirstSelectedOption().getText();
		if(actualletSelectOption.equals(defaultDropdownValue)) {
			System.out.println("Dropdown value matches");
		}else {
			System.out.println("Dropdown value does not match");
		}
		String searchItem = "Cofee Mug";
		letSelect.deselectByVisibleText("Home & Kitchen");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchItem);
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		String itemPageTitle = driver.getTitle();
		//Amazon.com : Coffee Mug 23-10=13
		int beginningIndex = itemPageTitle.length() - searchItem.length();
		if (itemPageTitle.substring(beginningIndex).equals(searchItem)) {
			System.out.println("Search item title match");
		}else {
			System.out.println("Search item title Does not match");
		}
		WebElement dropdown2 = driver.findElement(By.id("searchDropdownBox"));
		Select letSelect2 = new Select(dropdown2);
		String selectedOption = letSelect2.getFirstSelectedOption().getText();
		if (selectedOption.equals("Home & Kitchen")) {
			System.out.println("Test Pass.");
		}else {
			System.out.println("Test Fail.");
		}
}
}
