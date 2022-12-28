package myAllPracticeQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Q11_DropDownOptions_Practice2 {
        // ...Exercise 2...

        // https://www.amazon.com/ sayfasina gidin
        // dropdown'dan "Baby" secenegini secin
        // sectiginiz option'i yazdirin
        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @After
    public void teardown() {
        driver.close();
    }

    @Test
    public void test() {
        driver.get("https://www.amazon.com");
        WebElement allCategory = driver.findElement(By.xpath("//*[@aria-describedby='searchDropdownDescription']"));
        Select select = new Select(allCategory);
        select.selectByVisibleText("Baby");
        System.out.println(select.getFirstSelectedOption().getText());
        List<WebElement> categories = select.getOptions();
        Assert.assertEquals(28,categories.size());
    }
}
