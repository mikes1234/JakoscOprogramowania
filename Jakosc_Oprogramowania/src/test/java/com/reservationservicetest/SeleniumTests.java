package com.reservationservicetest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class SeleniumTests {

	@BeforeEach
	public void startBrowser(){
		SeleniumManager.initWebDriver();
	}
	@AfterEach
	public void tearDown(){
		SeleniumManager.shutdownDriver();
	}


	@Test
	public void seleniumTestPositive() throws InterruptedException {
		System.setProperty("webdriver.opera.driver", "/Users/zashiwaki/Desktop/Java/operadriver_mac64/operadriver");
		WebDriver driver = new OperaDriver();
		driver.get("http://localhost:8080/");

		driver.findElement(By.linkText("Create new reservation")).click();
		WebElement myDynamicElement = (new WebDriverWait(driver, 100))
				.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Create new reservation")));
		driver.findElement(By.id("resObject")).sendKeys("Table10");
		driver.findElement(By.id("firstName")).sendKeys("Adrian");
		driver.findElement(By.id("lastName")).sendKeys("Nowak");
		driver.findElement(By.id("resDate")).sendKeys("300620191010");

		Thread.sleep(2500);
		driver.findElement(By.id("submit")).click();
		driver.quit();
	}

	@Test
	public void seleniumTestDisplyingReservations() {
		System.setProperty("webdriver.opera.driver", "/Users/zashiwaki/Desktop/Java/operadriver_mac64/operadriver");
		WebDriver driver = new OperaDriver();
		driver.get("http://localhost:8080/");

		driver.findElement(By.linkText("Reservations")).click();
		long end = System.currentTimeMillis() + 5000;
		while (System.currentTimeMillis() < end) {
			ArrayList<WebElement> resultDiv = (ArrayList<WebElement>) driver.findElements(By.className("sbsb_a"));
			if (resultDiv.size() > 0) {
				break;
			}
		}

		List<WebElement> allSugestions = driver.findElements(By.className("data"));
		for (WebElement suggestions : allSugestions) {
			System.out.println(suggestions.getText());
		}

		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}

	@Test
	public void seleniumTestNegative() throws InterruptedException {
		System.setProperty("webdriver.opera.driver", "/Users/zashiwaki/Desktop/Java/operadriver_mac64/operadriver");
		WebDriver driver = new OperaDriver();
		driver.get("http://localhost:8080/");

		driver.findElement(By.linkText("Create new reservation")).click();
		WebElement myDynamicElement = (new WebDriverWait(driver, 100))
				.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Create new reservation")));
		driver.findElement(By.id("resObject")).sendKeys("@#$$");
		driver.findElement(By.id("firstName")).sendKeys("!#@#!@#!@#");
		driver.findElement(By.id("lastName")).sendKeys(".........");

		myDynamicElement = (new WebDriverWait(driver, 100))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(4000);
		driver.quit();
	}
}
