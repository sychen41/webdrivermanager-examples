package com.cmc.flextesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class MvnExecJavaTest {				
	public static void main(String[] args) throws MalformedURLException {
		//maybe mvn compile first
		System.out.println("Run this by using: mvn exec:java");
		
//		ChromeDriverManager.getInstance().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
//		options.addArguments("no-sandbox");
//		options.addArguments("disable-gpu");
//		WebDriver driver = new ChromeDriver(options);
		
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.101:4444/wd/hub"), DesiredCapabilities.chrome());

//		driver.manage().window().setSize(new Dimension(1024,768));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);


		driver.get("https://en.wikipedia.org/wiki/Main_Page"); // navigate to Wikipedia
		By searchInput = By.id("searchInput"); // search for "Software"
		driver.findElement(searchInput).sendKeys("Software");
		driver.findElement(searchInput).sendKeys(Keys.ENTER);
	//    By searchButton = By.id("searchButton");
	//    wait.until(ExpectedConditions.elementToBeClickable(searchButton));
	//    driver.findElement(searchButton).click();
	//    Robot r = new Robot();
	//    r.keyPress(KeyEvent.VK_ENTER);
	//    r.keyRelease(KeyEvent.VK_ENTER);
		
//		Thread.sleep(5000);
//		File scrFile = ((TakesScreenshot) driver)
//				.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile, new File(("screenshot.jpg")));
		if (driver != null) {
			System.out.println("quitting...");
		  driver.quit();
		}
		
    }		
}
