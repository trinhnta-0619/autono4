package btvn1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class btvn1 {

	public static void main(String[]args) {
		System.setProperty("webdriver.gecko.driver", "lib/geckodriver");
		
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		//WebDriver driver= new FirefoxDriver();
		Actions action = new Actions(driver);
		
		String email = "nguyendaisytp@gmail.com";
		String password = "123456";
		
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		
		
		//register
		WebElement emailE = driver.findElement(By.name("email"));
		WebElement passwordE = driver.findElement(By.name("password"));
		WebElement cfPasswordE = driver.findElement(By.name("confirmPassword"));
		
		emailE.sendKeys(email);
		passwordE.sendKeys(password);
		cfPasswordE.sendKeys(password);
		
		WebElement submitE = driver.findElement(By.name("submit"));
		action.moveToElement(submitE).build().perform();
		action.click(submitE).build().perform();
		
		//check info
		String expected = "Note: Your user name is " + email +".";
		String actual = driver.findElement(By.xpath("//b[text()=' Note: Your user name is " + email + ".']")).getText();
		
		if (expected.equals(actual)) {
			WebElement signinE = driver.findElement(By.linkText("sign-in"));
			action.click(signinE).build().perform();
			
			//sign in
			WebElement usernameE = driver.findElement(By.name("userName"));
			WebElement passwordE1 = driver.findElement(By.name("password"));
			
			usernameE.sendKeys(email);
			passwordE1.sendKeys(password);
			
			WebElement submitE1 = driver.findElement(By.name("submit"));
			action.moveToElement(submitE1).build().perform();
			action.click(submitE1).build().perform();
		}
		else
		{
			System.out.println("Login fail, please check again");
		}
		
		
	}
}

