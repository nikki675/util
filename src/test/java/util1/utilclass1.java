package util1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class utilclass1 extends java_codes {
	public static String man="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver;
		@BeforeTest
		public void bt() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 driver.get(man);
			 driver.manage().window().maximize();
			 Thread.sleep(3000);
			 
		}
		@Test
		public void gt() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin123");
			Thread.sleep(3000);
		WebElement go=driver.findElement(By.xpath("//*[@type='submit']"));
		Thread.sleep(3000);
			 JavascriptExecutor js= ((JavascriptExecutor)driver);
		        js.executeScript("arguments[0].scrollIntoView(true);", go);
		        Thread.sleep(3000);
		        JavascriptExecutor js1= ((JavascriptExecutor)driver);
		        js.executeScript("arguments[0].style.border = '3px solid red '", go);
		        Thread.sleep(3000);
		        JavascriptExecutor js2= ((JavascriptExecutor)driver);
		        js.executeScript("arguments[0].click();",go);
		        Thread.sleep(2000);
		        JavascriptExecutor js3= ((JavascriptExecutor)driver);
		        js.executeScript("history.go(0)");
		       WebElement ad=driver.findElement(By.linkText("Admin"));
		        Thread.sleep(2000);
		        JavascriptExecutor js4= ((JavascriptExecutor)driver);
		        
		        js.executeScript("arguments[0].style.backgroundColor = '" + "green" + "'", ad);
		        
		        try {
		            Thread.sleep(3000);
		        }catch(InterruptedException e) {
		            
		        }
		        WebElement ad1=driver.findElement(By.linkText("Recruitment"));
		        String bgcolor= ad1.getCssValue("backgroundColor");//gives the background color of the element
		         // JavascriptExecutor js5= ((JavascriptExecutor)driver);
		        
		        for(int i=0; i<500; i++) {  // change the background color multiple times
		           changeColor("green",ad1,driver);  //#000000 -> This represent black
		            changeColor(bgcolor,ad1,driver);  // change to it's original color 
		            
		        
		}
		}
}
