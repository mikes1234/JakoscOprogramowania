package com.reservationservicetest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class SeleniumTest {

	@Test
    public void seleniumTest1(){
    	System.setProperty("webdriver.edge.driver", "C:/Users/Mikęs/Desktop/MicrosoftWebDriver.exe");
        WebDriver driver = new EdgeDriver();
        
        driver.get("http://localhost:8080/");
        
        driver.findElement(By.linkText("Create new reservation")).click();
        WebElement myDynamicElement = 
        		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Create new reservation")));
        driver.findElement(By.id("resObject")).sendKeys("Table10");
        driver.findElement(By.id("firstName")).sendKeys("Adrian");
        driver.findElement(By.id("lastName")).sendKeys("Nowak");
        driver.findElement(By.id("resDate")).sendKeys("2019-06-30T10:10");
        driver.findElement(By.id("submit")).click();

        myDynamicElement = 
        		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
        driver.quit();
       
    }
	@Test
    public void seleniumTest2(){
    	System.setProperty("webdriver.edge.driver", "C:/Users/Mikęs/Desktop/MicrosoftWebDriver.exe");
        WebDriver driver = new EdgeDriver();
        
        driver.get("http://localhost:8080/");
        
        driver.findElement(By.linkText("Reservations")).click();
        
        long end = System.currentTimeMillis() + 5000;

        while(System.currentTimeMillis() < end){
            ArrayList<WebElement> resultDiv = (ArrayList<WebElement>) driver.findElements(By.className("sbsb_a"));
            if(resultDiv.size() > 0) {
                break;
            }
        }
        List<WebElement> allSugestions = driver.findElements(By.className("data"));

        for(WebElement suggestions : allSugestions){
            System.out.println(suggestions.getText());
        }

        System.out.println(driver.getTitle());
        //driver.quit();
	}
}
