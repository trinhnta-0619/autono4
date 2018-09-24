package BaiTapVeNha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class MouseKeyboard {
    static final String url = "http://demo.guru99.com/test/newtours/register.php";
    static final String firstName = "firstName";
    static final String lastName = "lastName";
    static final String phone = "phone";
    static final String email = "userName";
    static final String address = "address1";
    static final String city = "city";
    static final String state = "state";
    static final String postalCode = "postalCode";
    static final String country = "country";
    static final String userName = "email";
    static final String password = "password";
    static final String confirmPassword = "confirmPassword";
    static final String submit = "submit";
    static final String verifyLogin = "//b[contains(text(),'hangnt22')]";
    static final String btnLogin = "//a[@href='login.php']";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "/home/nguyen.thi.hang/Documents/chromedriver");
        driver = new ChromeDriver();

        openBrowser(url, driver);
        register(driver);
        login(driver);
        closeBrowser(driver);

    }

    public static void openBrowser(String url, WebDriver driver) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public static void closeBrowser(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    public static void register(WebDriver driver) throws InterruptedException {
        Actions action = new Actions(driver);
        action.sendKeys(driver.findElement(By.name(firstName)), "Hang");
        action.sendKeys(driver.findElement(By.name(lastName)), "Nguyen");
        action.sendKeys(driver.findElement(By.name(phone)), "0989999999");
        action.sendKeys(driver.findElement(By.name(email)), "nguyen.thi.hang@framgia.com");
        action.sendKeys(driver.findElement(By.name(address)), "15 Le Huu Trac");
        action.sendKeys(driver.findElement(By.name(city)), "Da Nang");
        action.sendKeys(driver.findElement(By.name(state)), "Da Nang");
        action.sendKeys(driver.findElement(By.name(postalCode)), "DANA1101");
        Select ctry = new Select(driver.findElement(By.name(country)));
        ctry.selectByIndex(11);
        action.sendKeys(driver.findElement(By.name(userName)), "hangnt22");
        action.sendKeys(driver.findElement(By.name(password)), "H12345678");
        action.sendKeys(driver.findElement(By.name(confirmPassword)), "H12345678");
        action.sendKeys(driver.findElement(By.name(submit)));
        action.build().perform();
        Thread.sleep(1000);
    }

    public static void login(WebDriver driver) throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement check = driver.findElement(By.xpath(verifyLogin));
        if (check.isDisplayed()) {
            action.sendKeys(driver.findElement(By.xpath(btnLogin))).click();
            action.perform();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            action.sendKeys(driver.findElement(By.name(email)), "hangnt22");
            action.sendKeys(driver.findElement(By.name(password)), "H12345678");
            action.sendKeys(driver.findElement(By.name(submit)));
            action.build().perform();
            Thread.sleep(1000);
        }
    }

}
