package guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class register_signin_keyboard {
	public static void main(String[] args) {
	String path = "D:\\trinh\\SELENIUM\\chromedriver.exe";
    System.setProperty("webdriver.chrome.driver", path);
	WebDriver driver = new ChromeDriver();
    String baseUrl = "http://demo.guru99.com/test/newtours/register.php";
    driver.get(baseUrl);
    
    String username = "anhtrinh";
    String password = "123456";
    
    WebElement usernametxb = driver.findElement(By.id("email"));
    Actions action1 = new Actions(driver);
    action1.sendKeys(usernametxb, (username)).build().perform();
 
    WebElement pwtxb = driver.findElement(By.name("password"));
    Actions action2 = new Actions(driver);
    action2.sendKeys(pwtxb, (password)).build().perform();
    
    WebElement cfpwtxb = driver.findElement(By.name("confirmPassword"));
    Actions action3 = new Actions(driver);
    action3.sendKeys(cfpwtxb, (password)).build().perform();
    
    WebElement submitbtn = driver.findElement(By.name("submit"));
    Actions action4 = new Actions(driver);
    action4.doubleClick(submitbtn).build().perform();
    
    
    WebElement messagelb = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/font/b"));
    String message = messagelb.getText();
    Assert.assertEquals(message, "Note: Your user name is "+username+".");
  
    WebElement signinlink = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/a"));
    Actions action5 = new Actions(driver);
    action5.doubleClick(signinlink).build().perform();
}
}