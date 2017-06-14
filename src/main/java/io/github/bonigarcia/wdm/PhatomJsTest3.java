/*
 * (C) Copyright 2016 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.github.bonigarcia.wdm;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;

/**
 * Test with PhantomJS.
 *
 * @author Boni Garcia (boni.gg@gmail.com)
 * @since 1.0.0
 */
public class PhatomJsTest3 {

	public static void main(String[] args) throws InterruptedException, IOException {
//		PhantomJsDriverManager.getInstance().setup();
//		WebDriver driver = new PhantomJSDriver();
		ChromeDriverManager.getInstance().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("no-sandbox");
		options.addArguments("disable-gpu");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(1024,768));
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
		
		Thread.sleep(5000);
//		File scrFile = ((TakesScreenshot) driver)
//				.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile, new File(("screenshot.jpg")));
		if (driver != null) {
			System.out.println("quitting...");
		  driver.quit();
		}
	}
  

}
