package myAllPracticeQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class Q23_Day10WindowHandle_Slack {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() {
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        String ilkSiteHandle = driver.getWindowHandle();

        //Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("(//*[@class='card mt-4 top-card'])[3]")).click();

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement yazi = driver.findElement(By.xpath("//*[.='Please select an item from left to start practice.']"));
        Assert.assertTrue(yazi.isDisplayed());

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//*[.='Browser Windows']")).click();

        //New Tab butonunun görünür olduğunu doğrula
        WebElement button = driver.findElement(By.xpath("//*[@id='tabButton']"));
        Assert.assertTrue(button.isDisplayed());

        //New Tab butonuna click yap
        button.click();

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        Set<String> windowHandles = driver.getWindowHandles();
        for(String eachHandle : windowHandles) {
            if(!eachHandle.equals(ilkSiteHandle)) {
                driver.switchTo().window(eachHandle);
                break;
            }
        }

        WebElement yeniTabText = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(yeniTabText.isDisplayed());

        //İlk Tab'a geri dön
        driver.switchTo().window(ilkSiteHandle);

        ////New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(button.isDisplayed());
    }
}
