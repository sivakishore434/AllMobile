import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Signup {
 
            static {
                 System.setProperty("webdriver.chrome.driver","C:\\Users\\siva.kishore\\Downloads\\chromedriver_win32\\chromedriver.exe");
                   }
            WebDriver driver;

       @Test(priority = 1)
            public void launchBrowser() throws InterruptedException {
                driver = new ChromeDriver();
                driver.get("https://qualicoach.org/mwapp/index.html");
                driver.manage().window().maximize();
            }
         @Test(priority = 2)
            public void clickOnSignUp() throws InterruptedException {
                driver.findElement(By.xpath("//button[text()='SIGN IN']")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//a[text()='Sign up']")).click();
                Thread.sleep(1000);
            }
         @Test(priority = 3)
            public void enterFirstName() throws InterruptedException {
                driver.findElement(By.id("myName")).sendKeys("Siva");
                Thread.sleep(1000);
            }
         @Test(priority = 4)
            public void enterLastName() throws InterruptedException {
                driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Kishore");
                Thread.sleep(1000);
            }
          @Test(priority = 5)
            public void enterMail() throws InterruptedException {
                driver.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys("siva@gmail.com");
                Thread.sleep(1000);
            }
          @Test(priority = 6)
            public void enterPassword() throws InterruptedException {
                driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("kishore@123");
                Thread.sleep(1000);
            }
          @Test(priority = 7)
            public void enterDOB() throws InterruptedException {
                driver.findElement(By.xpath("//input[@type='date']")).sendKeys("12/17/2000");
                Thread.sleep(1000);
            }
          @Test(priority = 8)
            public void selectGender() throws InterruptedException {
                driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
                Thread.sleep(1000);
            }
          @Test(priority = 9)
            public void enterPhoneNumber() throws InterruptedException {
                driver.findElement(By.xpath("//input[@type='number']")).sendKeys("9182736405");
                Thread.sleep(1000);
            }
          @Test(priority = 10)
            public void clickOnRegister() throws InterruptedException {
                driver.findElement(By.xpath("//textarea[@placeholder='Short Bio']")).sendKeys("Hi, Welcome to Qualitest");
                driver.findElement(By.xpath("//button[text()='Register']")).click();
                driver.switchTo().alert().accept();
                Thread.sleep(1000);
            }
          @Test(priority = 11)
            public void clickOnSignIn() throws InterruptedException {
                driver.findElement(By.xpath("//button[text()='Sign In']")).click();
                //driver.switchTo().alert().accept();
                Thread.sleep(2000);
                driver.quit();
            }
            
        }
         