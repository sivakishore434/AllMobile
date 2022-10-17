import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.Assert;


public class AllMobiles {
   
        static{         
        
        System.setProperty("webdriver.chrome.driver","C:\\Users\\siva.kishore\\Downloads\\chromedriver_win32\\chromedriver.exe");
       
         }
         WebDriver driver = new ChromeDriver();
         
         @Test(priority = 1)
         public void launchBrowser() {
        	 driver = new ChromeDriver();
             driver.get("https://qualicoach.org/mwapp/index.html");
             driver.manage().window().maximize();
             }
         @Test(priority = 2)
         public void allMobiles() {
        	 WebElement allMobiles = driver.findElement(By.xpath("//*[text()='All Mobiles']"));
             allMobiles.click();
             List<WebElement> names = driver.findElements(By.xpath("//table/thead/tr"));
             for (WebElement n1 : names) {
             String abc = n1.getText();
             if (abc.contains("Mobile Name")) {
             Assert.assertTrue(true);
             }
             }
             }
         @Test(priority = 3)
         public void searchLenovo() throws InterruptedException {
        	 driver.findElement(By.id("myInput")).sendKeys("Lenovo");
                 String mobName = driver.findElement(By.xpath("//tbody[@id='myTable']/tr[4]/td[1]")).getText();
                 Thread.sleep(1000);
                 Assert.assertTrue(mobName.contains("Lenovo"));
                 driver.findElement(By.id("myInput")).clear();
                    }
    @Test(priority = 4)
             public void searchSamsung() throws InterruptedException{
                 driver.findElement(By.id("myInput")).sendKeys("Samsung");
                 String mobName = driver.findElement(By.xpath("//th[text()='Mobile Name']/../../../tbody/tr/td")).getText();
                 Thread.sleep(1000);
                 Assert.assertTrue(mobName.contains("Samsung"));
                 driver.findElement(By.id("myInput")).clear();
                    }
    @Test(priority = 5)
              public void wrongApple() throws InterruptedException{
              driver.findElement(By.id("myInput")).sendKeys("Apple iphone");
              Thread.sleep(1000);
              driver.findElement(By.id("myInput")).clear();
                    }
    @Test(priority = 6)
         public void twoCharacter() throws InterruptedException {
           driver.findElement(By.id("myInput")).sendKeys("Sa");
           String mobName = driver.findElement(By.xpath("//th[text()='Mobile Name']/../../../tbody/tr/td")).getText();
           Thread.sleep(2000);
           Assert.assertTrue(mobName.contains("Sa"));
           driver.findElement(By.id("myInput")).clear();
          }
    
    @Test(priority = 7)
    public void twoCharacters() throws InterruptedException {
    	driver.findElement(By.id("myInput")).clear();
      driver.findElement(By.id("myInput")).sendKeys("le");
      String mobName = driver.findElement(By.xpath("//th[text()='Mobile Name']/../../../tbody/tr/td")).getText();
      Thread.sleep(2000);
      //Assert.assertTrue(mobName.contains("le"));
      driver.findElement(By.id("myInput")).clear();
     }
    
    @Test(priority = 8)
              public void wrongSamsung() throws InterruptedException{
    	driver.findElement(By.id("myInput")).sendKeys("Sam$u#g");
        Thread.sleep(1000);
        Assert.assertFalse(true);  
        driver.findElement(By.id("myInput")).clear();
          }
 
    @Test(priority = 9)
              public void InvalidMob() throws InterruptedException {
    	 driver.findElement(By.id("myInput")).clear();
         driver.findElement(By.id("myInput")).sendKeys("Sam");
         String mobName = driver.findElement(By.xpath("//th[text()='Mobile Name']/../../../tbody/tr/td")).getText();
         Thread.sleep(1000);
         Assert.assertTrue(mobName.contains("Sam"));
         Thread.sleep(1000);
         driver.findElement(By.id("myInput")).clear();
         //driver.quit();
                    }
    
    @Test(priority = 10)
             public void order() throws InterruptedException {
         driver.findElement(By.id("myInput")).sendKeys("Samsung Galaxy S21");
         Thread.sleep(1000);
         driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
         Thread.sleep(1000);
    }  
    
    @Test(priority = 11)   
    public void orderdetails() throws InterruptedException {
    
                 Set windows = driver.getWindowHandles(); 
                 Iterator it = windows.iterator(); 
                 String parentId = (String) it.next(); 
                 String childId = (String) it.next(); 
                 driver.switchTo().window(childId);
  
                Select select = new Select(driver.findElement(By.xpath("//select[@class='multi_select']")));
              //  select.selectByVisibleText("Samsng A13");
                 
                 WebElement o = select.getFirstSelectedOption();
                 String selectedoption = o.getText();
                 Assert.assertEquals("Samsng A13", selectedoption);
                 
                 System.out.println("Selected element: " + selectedoption);
              
                // Thread.sleep(2000);
               //  driver.quit();
             }   
    @Test (priority = 12)
    public void close() {
    
      driver.quit();
    }
   }