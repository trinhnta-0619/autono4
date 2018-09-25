package guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Register_signin {
	public static void main(String[] args) {
	 	String path = "D:\\trinh\\SELENIUM\\chromedriver.exe";
	    System.setProperty("webdriver.chrome.driver", path);
    	WebDriver driver = new ChromeDriver();
        String baseUrl = "http://demo.guru99.com/test/newtours/register.php";
        driver.get(baseUrl);
               
        WebElement usernametxb = driver.findElement(By.id("email"));
        WebElement pwtxb = driver.findElement(By.name("password"));
        WebElement cfpwtxb = driver.findElement(By.name("confirmPassword"));
        WebElement submitbtn = driver.findElement(By.name("submit"));
        
        String username = "trinhnta";
        String password = "123456";
        usernametxb.sendKeys(username);
        pwtxb.sendKeys(password);
        cfpwtxb.sendKeys(password);
        
        submitbtn.click();
        
        WebElement messagelb = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/font/b"));
        String message = messagelb.getText();
        Assert.assertEquals(message, "Note: Your user name is "+username+".");
      
        WebElement signinlink = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/a"));
        signinlink.click();
        
	}
	}
