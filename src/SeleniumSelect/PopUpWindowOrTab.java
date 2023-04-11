package SeleniumSelect;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpWindowOrTab {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\khilo\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		actvityTest1(); 
	}
	public static void actvityTest1() {
		WebDriver driver = new ChromeDriver();
		//maximize window. implicitly wait for 5 seconds.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		//1. Get the main window ID and store it in a String called mainWindowId, 
		String mainWindowId = driver.getWindowHandle();
	//	2. Click on the 'New Tab' button
		 driver.findElement(By.id("newTab")).click();
		//Get window IDs and store it into a Set
		 Set<String> windowIds = driver.getWindowHandles();
		 //4. Get the first window ID from the Set and Verify it matches with the main window id in step 1.  
		 //Then get the second window id and store it in variable called secondWindowId.
		 Iterator<String> iterate = windowIds.iterator();
		 String firstWindowId = iterate.next();
	        if (firstWindowId.equals(mainWindowId)) {
	            System.out.println("First window ID matches the main window ID.");
	        } else {
	            System.out.println("First window ID does not match the main window ID.");
	        }
	        
	        String secondWindowId = iterate.next();
	        //5. Switch to the second window
	        driver.switchTo().window(secondWindowId);
	        //6. Verify that there is a button called 'New Tab'
	        if (driver.findElement(By.id("newTab")).isDisplayed()) {
	            System.out.println("The 'New Tab'  is displayed on the second window.");
	        } else {
	            System.out.println("The 'New Tab' is not displayed on the second window.");
	        }
	        //7. Close the window,  Switch back to the main window, Verify you are on the main window.
	        driver.close();
	        driver.switchTo().window(mainWindowId);
	        if (driver.getWindowHandle().equals(mainWindowId)) {
	            System.out.println("PASS switched back to the main window.");
	        } else {
	            System.out.println("FAIL Could not switch back to the main window.");
	        }
	        
		 
}
}