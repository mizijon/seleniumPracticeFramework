package SeleniumSelect;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class iframeDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\khilo\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		//frameDemo();
		//guru99();
		iframeHomework();
	}
	
	public static void iframeHomework() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.get("http://practice.primetech-apps.com/practice/frames");
		boolean isframetxt = driver.findElement(By.xpath("//h3[text()='Frames']")).isDisplayed();
		if (isframetxt) {
			System.out.println("Frame text is there");
		}else {
			System.out.println("Frame text is NOT there.");
		}
		driver.switchTo().frame("iframe1");
		driver.findElement(By.id("firstName")).sendKeys("John");
		driver.findElement(By.id("lastName")).sendKeys("Smith");
		driver.findElement(By.id("address")).sendKeys("123 North St");
		driver.findElement(By.id("city")).sendKeys("Fairfax");
		driver.findElement(By.id("zipCode")).sendKeys("12354");
		
		driver.findElement(By.id("state")).sendKeys("Virginia");
		
		//Select letSelect = new Select(driver.findElement(By.id("state")));
		//letSelect.selectByVisibleText("Virginia");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		boolean infoText = driver.findElement(By.xpath("..h3[text()='You have submitted below information:']")).isDisplayed();
		if (infoText) {
			System.out.println("Info text is NOT there.");
		}
		driver.switchTo().parentFrame();
		boolean isTxt = driver.findElement(By.xpath("//h3[text()='Frames']")).isDisplayed();
		if (isTxt) {
			System.out.println("Frame text is there");
		}else {
			System.out.println("Frame text is NOT there.");
		}
	}
	
	public static void guru99() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
//		go to http://demo.guru99.com/popup.php
		driver.get("http://demo.guru99.com/popup.php");
//		     Get title and store it in a variable.
		String mainPageTitle = driver.getTitle();
		String mainPageWindowId = driver.getWindowHandle();
//		     Click on Click Here button and switch over to next window, provide an email click Submit.
		driver.findElement(By.linkText("Click Here")).click();
		// we got the window ids from two tabs
		Set<String> windowIds = driver.getWindowHandles();
		for (String str : windowIds) {
			if (!str.equals(mainPageWindowId)) {
				driver.switchTo().window(str);
			}
		
		driver.findElement(By.name("emailid")).sendKeys("jon.jon@gmail.com");
		driver.findElement(By.name("btnLogin")).click();
//		     Get text of the user ID and password and store them in variables, print them out. 
		String userId = driver.findElement(By.xpath("//td[contains(text(),'mn')]")).getText(); 
		System.out.println("User id: " + userId);
		String password = driver.findElement(By.xpath("//td[text()='Password :']//following-sibling::td")).getText().trim();
		System.out.println("Password :" + password);
		
//		     Then verify the text "This access is valid only for 20 days."
		String message = driver.findElement(By.xpath("//h3[contains(text(), 'This access')]")).getText();
		if (message.equals("This Access is valid only for 20 days.")) {
			System.out.println("Test pass!");
		}else {
			System.out.println("Test Fail!");
		}
//		     Close the window.
		driver.close();
//		     Go back to main window, and get title then verify it equals to your stored title.
		driver.switchTo().window(mainPageWindowId);
		if (driver.getWindowHandle().equals(mainPageWindowId)) {
			System.out.println("We are back to the main window.");
		}else {
			System.out.println("We are lost.");
		}
//		     Quite driver. 
		driver.quit();
		}
	}
		public static void frameDemo() {
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			
			driver.get("http://practice.primetech-apps.com/practice/frames");
			
			//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframe1']")));
			driver.switchTo().frame(0);
			driver.findElement(By.id("firstName")).sendKeys("Hello");
			
			driver.switchTo().parentFrame(); // goes back to one step out of the iframe. 
			//driver.switchTo().defaultContent(); // goes back to original page.
			
			System.out.println(driver.findElement(By.xpath("//h3[text()='Frames']")).getText());
			
		}
		

	}


