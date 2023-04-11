package FrameworkDesign;

import pages.IndeedPage;
import utils.BrowserUtils;
import utils.DataReader;
import utils.driver;

public class BrowserUtilsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		indeedTest();
	}
	static IndeedPage indeedpage;
	
	static BrowserUtils utils = new BrowserUtils();
		public static void indeedTest() throws InterruptedException {
			 indeedpage = new IndeedPage();
		//go to indeed.com
		driver.getDriver().get(DataReader.getProperty("indeedUrl"));
		Thread.sleep(1000);
//		find the where field and clear the text
		utils.waitForElementVisible(indeedpage.whereField);
		utils.clearText(indeedpage.whereField);
		
		
	
		
		
		}	
	
}
