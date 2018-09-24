package BaiTapVeNha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AccessForm {
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
        driver.findElement(By.name(firstName)).sendKeys("Hang");
        driver.findElement(By.name(lastName)).sendKeys("Nguyen");
        driver.findElement(By.name(phone)).sendKeys("0989999999");
        driver.findElement(By.name(email)).sendKeys("nguyen.thi.hang@framgia.com");
        driver.findElement(By.name(address)).sendKeys("15 Le Huu Trac");
        driver.findElement(By.name(city)).sendKeys("Da Nang");
        driver.findElement(By.name(state)).sendKeys("Da Nang");
        driver.findElement(By.name(postalCode)).sendKeys("DANA1101");
        Select ctry = new Select(driver.findElement(By.name(country)));
        ctry.selectByIndex(11);
        driver.findElement(By.name(userName)).sendKeys("hangnt22");
        driver.findElement(By.name(password)).sendKeys("H12345678");
        driver.findElement(By.name(confirmPassword)).sendKeys("H12345678");
        Thread.sleep(1000);
        driver.findElement(By.name(submit)).click();

    }

    public static void login(WebDriver driver) throws InterruptedException {
        WebElement check = driver.findElement(By.xpath(verifyLogin));
        if (check.isDisplayed()) {
            driver.findElement(By.xpath(btnLogin)).click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.findElement(By.name(email)).sendKeys("hangnt22");
            driver.findElement(By.name(password)).sendKeys("H12345678");
            driver.findElement(By.name(submit)).click();
            Thread.sleep(1000);
        }

    }

}
