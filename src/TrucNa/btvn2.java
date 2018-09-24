package btvn1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class btvn2 {

	public static void main(String[]args) {
		System.setProperty("webdriver.gecko.driver", "lib/geckodriver");
		
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver");
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		
		Actions action = new Actions(driver);
		
		String firstName = "Nguyen";
		String lastName = "Thi Truc Na";
		String phone = "01694992319";
		String userName = "TrucNa";
		String address = "Lien Chieu";
		String state = "Da Nang";
		String city = "Da Nang";
		String postalcode = "01";
		String email = "nguyendaisytp@gmail.com";
		String password = "123456";
				
		//register
		driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);
        driver.findElement(By.name("phone")).sendKeys(phone);
        driver.findElement(By.name("userName")).sendKeys(userName);
        driver.findElement(By.name("address1")).sendKeys(address);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("state")).sendKeys(state);
        driver.findElement(By.name("postalCode")).sendKeys(postalcode);
        Select drpCountry = new Select(driver.findElement(By.name("country")));
		drpCountry.selectByValue("VIETNAM");
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmPassword")).sendKeys(password);
		
		WebElement submitE = driver.findElement(By.name("submit"));
		action.click(submitE).build().perform();
		
		//check info
		String expected = "Note: Your user name is " + email +".";
		String actual = driver.findElement(By.xpath("//b[text()=' Note: Your user name is " + email + ".']")).getText();
		
		if (expected.equals(actual)) {
			WebElement signinE = driver.findElement(By.linkText("sign-in"));
			action.click(signinE).build().perform();
			
			//sign in
			driver.findElement(By.name("userName")).sendKeys(email);
			driver.findElement(By.name("password")).sendKeys(password);
			
			WebElement submitE1 = driver.findElement(By.name("submit"));
			action.click(submitE1).build().perform();
		}
		else
		{
			System.out.println("Login fail, please check again");
		}
	
	}
}

