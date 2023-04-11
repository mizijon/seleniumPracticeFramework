package FrameworkDesign;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.FacebookPage;
import utils.DataReader;
import utils.driver;

public class ReusableObjects {
public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\khilo\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		
	ReusableObjects obj = new ReusableObjects();
		obj.testcase1();
		//obj.testcase2();
		//obj.getTextPractice();
}
	

	FacebookPage fbPage;
	
	public void testcase1() {
	fbPage = new FacebookPage();
		
	driver.getDriver().get(DataReader.getProperty("testingUrl"));
	// find the Email or phone number field and type Automation
			fbPage.FBemailField.sendKeys(DataReader.getProperty("facebookUsername"));
				
		     // find the Password field and type Automation
				fbPage.FBpassField.sendKeys(DataReader.getProperty("facebookPassword"));
		     // find the Login button and click on it.
				fbPage.FBloginBtn.click();
	
	driver.quitDriver();
	}
	public void testcase2() throws InterruptedException {
		
		
		driver.getDriver().get(DataReader.getProperty("testingUrl"));
	
		driver.getDriver().findElement(By.linkText("Create new account")).click();
	Thread.sleep(2000);
	driver.getDriver().findElement(By.name("firstname")).sendKeys("Automation");
	driver.getDriver().findElement(By.name("lastname")).sendKeys("Automation");
	driver.getDriver().findElement(By.name("reg_email__")).sendKeys("Automation");
	driver.getDriver().findElement(By.name("reg_passwd__")).sendKeys("Automation");
	driver.getDriver().findElement(By.name("websubmit")).click();
	driver.quitDriver();
	}
	public void getTextPractice() {
    
		
//	// go to facebook.com
		driver.getDriver().get(DataReader.getProperty("appUrl"));

//	// find the login button and get text of it
	String loginText = driver.getDriver().findElement(By.name("login")).getText();
	System.out.println("Login button text is: "+ loginText);
	// verify that it is Log In
	if(loginText.equals("Log In")) {
		System.out.println("Test Passed");
	}else {
		System.out.println("Test Failed! Text does not equal");
	}
	driver.quitDriver();
}
}
