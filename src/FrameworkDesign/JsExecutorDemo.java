package FrameworkDesign;

import org.openqa.selenium.JavascriptExecutor;

import pages.IndeedPage;
import utils.BrowserUtils;
import utils.DataReader;
import utils.driver;

public class JsExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		
		IndeedPage indeedPage = new IndeedPage();
		BrowserUtils utils = new BrowserUtils();
		
		driver.getDriver().get(DataReader.getProperty("indeedUrl"));
		indeedPage.whatField.sendKeys("software test engineer");
		utils.highlightElement(indeedPage.searchBtn);
		indeedPage.searchBtn.click();
		Thread.sleep(3000);
		
		utils.scrollDownByPixel(1500);
		
		
		

	}

}
