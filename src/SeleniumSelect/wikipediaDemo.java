package SeleniumSelect;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class wikipediaDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\khilo\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://www.wikipedia.org/");
		driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("Lionel Messi");
		String name = driver.findElement(By.xpath("//span[text()='Lionel Messi']")).getText();
		System.out.println(name);
		
		
		
		
		
	}

}
