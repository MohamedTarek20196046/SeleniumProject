package demo;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {

    String path = "E:\\SeleniumLab/";
    
    public String getCellData(int row, int col) throws Exception {
        XSSFSheet ExcelWSheet;
        XSSFWorkbook ExcelWBook;

        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(path + "Login.xlsx");

            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet("Sheet1");
            String cellData = ExcelWSheet.getRow(row).getCell(col).getStringCellValue();
            ExcelWBook.close();
            return cellData;
        }
        catch (IOException e){
            return "Error in opening the file";
        }
    }
    
    @Test
    public void FirefoxInvalidTest() throws Exception {

    	String username = getCellData(1, 0);
    	String password = getCellData(1, 1);

        // Set Firefox Web Driver
        System.setProperty("webdriver.gecko.driver", path + "geckodriver.exe");
    	WebDriver driver = new FirefoxDriver();

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
        // Launch website
        driver.navigate().to("https://twitter.com/?logout=1654210188242/");
        // Maximize the browser
        driver.manage().window().maximize();
        
        // Click on Sign in button
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/main/div/div/div[1]/div[1]/div/div[3]/div[5]/a")).click();

        // Enter the username and password
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[5]/label/div/div[2]/div/input")).sendKeys(username);
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[6]/div")).click();
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[3]/div/label/div/div[2]/div[1]/input")).sendKeys(password);
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div")).click();
          Thread.sleep(4000);
        // Click on Sign in button
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[2]/div")).click();

        // Check whether a certain element appears which confirms that the login was successful
        assertEquals(true, driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[2]/div")).isDisplayed());
        Thread.sleep(8000);
        driver.close();
    }

    @Test
    public void FirefoxValidTest() throws Exception {

    	String username = getCellData(2, 0);
    	String password = getCellData(2, 1);

        // Set Firefox Web Driver
        System.setProperty("webdriver.gecko.driver", path + "geckodriver.exe");
    	WebDriver driver = new FirefoxDriver();

          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
        // Launch website
        driver.navigate().to("https://twitter.com/?logout=1654210188242/");
        // Maximize the browser
        driver.manage().window().maximize();
        
        // Click on Sign in button
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[1]/div[1]/div/div[3]/div[5]/a/div")).click();

        // Enter the username and password
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[5]/label/div/div[2]/div/input")).sendKeys(username);
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[6]/div")).click();
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[3]/div/label/div/div[2]/div[1]/input")).sendKeys(password);
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div")).click();
          Thread.sleep(4000);
        // Click on Sign in button
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[2]/div")).click();

        // Check whether a certain element appears which confirms that the login was successful
        assertEquals(true, driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[2]/div")).isDisplayed());
        Thread.sleep(8000);
        driver.close();
    }

    @Test
    public void ChromeInvalidTest() throws Exception {

    	String username = getCellData(1, 0);
    	String password = getCellData(1, 1);

        System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
    	WebDriver driver = new ChromeDriver();

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
        // Launch website
        driver.navigate().to("https://twitter.com/?logout=1654210188242/");
        // Maximize the browser
        driver.manage().window().maximize();
        
        // Click on Sign in button
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[1]/div[1]/div/div[3]/div[5]/a/div")).click();

        // Enter the username and password
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[5]/label/div/div[2]/div/input")).sendKeys(username);
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[6]/div")).click();
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[3]/div/label/div/div[2]/div[1]/input")).sendKeys(password);
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div")).click();
          Thread.sleep(4000);
        // Click on Sign in button
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[2]/div")).click();

        // Check whether a certain element appears which confirms that the login was successful
        assertEquals(true, driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[2]/div")).isDisplayed());
        Thread.sleep(8000);
        driver.close();
    }

    @Test
    public void ChromeValidTest() throws Exception {

    	String username = getCellData(2, 0);
    	String password = getCellData(2, 1);

        // Set Google Chrome Web Driver
    	System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
    	WebDriver driver = new ChromeDriver();

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
        // Launch website
        driver.navigate().to("https://twitter.com/?logout=1654210188242/");
        // Maximize the browser
        driver.manage().window().maximize();
        
        // Click on Sign in button
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[1]/div[1]/div/div[3]/div[5]/a/div")).click();

        // Enter the username and password
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[5]/label/div/div[2]/div/input")).sendKeys(username);
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[6]/div")).click();
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[3]/div/label/div/div[2]/div[1]/input")).sendKeys(password);
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div")).click();
          Thread.sleep(4000);
        // Click on Sign in button
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[2]/div")).click();

        // Check whether a certain element appears which confirms that the login was successful
        assertEquals(true, driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[2]/div")).isDisplayed());
        Thread.sleep(8000);
        driver.close();
    }

    @Test
    public void EdgeInvalidTest() throws Exception {

    	String username = getCellData(1, 0);
    	String password = getCellData(1, 1);

        // Set Edge Web Driver
    	System.setProperty("webdriver.edge.driver", path + "msedgedriver.exe");
    	WebDriver driver = new EdgeDriver();

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
        // Launch website
        driver.navigate().to("https://twitter.com/?logout=1654210188242/");
        // Maximize the browser
        driver.manage().window().maximize();
        
        // Click on Sign in button
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[1]/div[1]/div/div[3]/div[5]/a")).click();

        // Enter the username and password
         driver.findElement(By.xpath("//*[@id=\"layers\"]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[5]/label/div/div[2]/div/input")).sendKeys(username);
         driver.findElement(By.xpath("//*[@id=\"layers\"]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[6]")).click();
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[3]/div/label/div/div[2]/div[1]/input")).sendKeys(password);
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div")).click();
          Thread.sleep(4000);
        // Click on Sign in button
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[2]/div")).click();

        // Check whether a certain element appears which confirms that the login was successful
        assertEquals(true, driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[2]/div")).isDisplayed());
        Thread.sleep(8000);
        driver.close();
    }

    @Test
    public void EdgeValidTest() throws Exception {

    	String username = getCellData(2, 0);
    	String password = getCellData(2, 1);

        // Set Edge Web Driver
    	System.setProperty("webdriver.edge.driver", path + "msedgedriver.exe");
    	WebDriver driver = new EdgeDriver();

        // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
        // Launch website
        driver.navigate().to("https://twitter.com/?logout=1654210188242/");
        // Maximize the browser
        driver.manage().window().maximize();
        
        // Click on Sign in button
         driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[1]/div[1]/div/div[3]/div[5]/a")).click();

        // Enter the username and password
            driver.findElement(By.xpath("//*[@id=\"layers\"]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[5]/label/div/div[2]/div/input")).sendKeys(username);
         driver.findElement(By.xpath("//*[@id=\"layers\"]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[6]")).click();
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div/div/div[3]/div/label/div/div[2]/div[1]/input")).sendKeys(password);
         driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div")).click();
          Thread.sleep(4000);
        // Click on Sign in button
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[2]/div")).click();

        // Check whether a certain element appears which confirms that the login was successful
        assertEquals(true, driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[2]/div")).isDisplayed());
        Thread.sleep(8000);
        driver.close();
    }
}
