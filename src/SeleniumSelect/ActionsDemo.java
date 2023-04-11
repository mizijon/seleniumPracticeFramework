package SeleniumSelect;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\khilo\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");		
		
		//actionsA();
		//dragAndDropDemo();
		dragNdrop();
	
	}

	public static void actionsA() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		Actions  letsdo = new Actions(driver);
		
		//go to Etsy.com
				driver.get("https://etsy.com");
				//Hover Over on Jewelry & Accessories
				WebElement jewelaryTab = 
						driver.findElement(By.xpath("//span[contains(text(), 'Jewelry & Accessories')]"));
				letsdo.moveToElement(jewelaryTab).build().perform();
				Thread.sleep(1000);
				//Mouseover on Bags & Purses
				WebElement bagsPurses = 
						driver.findElement(By.xpath("(//span[contains(text(), 'Bags & Purses')])[1]"));
				letsdo.moveToElement(bagsPurses).build().perform();
				Thread.sleep(1000);
				//Mouseover to Shoulder Bags
				WebElement shoulderBags = 
						driver.findElement(By.xpath("//a[contains(text(), 'Shoulder Bags')]"));
				letsdo.moveToElement(shoulderBags).build().perform();
				//Click on the shoulder bags
				shoulderBags.click();
				//Verify you are on the Shoulder bags page
				if (driver.findElement(By.xpath("//h1[text()='Shoulder Bags']")).isDisplayed()) {
					System.out.println("We are on the Bag page.");
				}else {
					System.out.println("We are NOT on the Bag page.");
				}
	}
				
			public static void dragAndDropDemo() {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver, 5);
					
			Actions letsdo = new Actions(driver);
					
					// go to "http://practice.primetech-apps.com/practice/drag-and-drop"
					driver.get("http://practice.primetech-apps.com/practice/drag-and-drop");
					//  drag the Text element to next window
					WebElement sourceElement = driver.findElement(By.id("text"));
					WebElement targetElement = driver.findElement(By.id("dropzone"));
					letsdo.dragAndDrop(sourceElement, targetElement).build().perform();
					
					
				
	
}
			public static void dragNdrop() throws InterruptedException {
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				WebDriverWait wait = new WebDriverWait(driver, 5);
						
				Actions letsdo = new Actions(driver);
				// go to "http://practice.primetech-apps.com/practice/drag-and-drop"
				driver.get("http://practice.primetech-apps.com/practice/drag-and-drop");
				// Verify Drag And Drop text displays
				if (driver.findElement(By.xpath("//h3[text()='Drag And Drop']")).isDisplayed()) {
					System.out.println("Text Is there");
				}else {
					System.out.println("Text is NOT there");
				}
				
				
				// drag the Text element to target window
				WebElement sourceText= driver.findElement(By.id("text"));
				WebElement targetZone = driver.findElement(By.id("dropzone"));
				
				letsdo.dragAndDrop(sourceText, targetZone).build().perform();
				Thread.sleep(1000);
				// drag the Textarea element to target window
				WebElement sourceTextArea= driver.findElement(By.id("textarea"));
				letsdo.dragAndDrop(sourceTextArea, targetZone).build().perform();
				Thread.sleep(1000);
				// drag the Number element to target window
				
				WebElement sourceNumber= driver.findElement(By.id("Number"));
				letsdo.dragAndDrop(sourceNumber, targetZone).build().perform();
				Thread.sleep(1000);
				// delete all those dragged items from target window
				List<WebElement> removeButton = driver.findElements(By.cssSelector(".remove"));
				for (WebElement webElement : removeButton ) {
					webElement.click();
					Thread.sleep(1000);
				}
				
			}	
}
		
			
		
