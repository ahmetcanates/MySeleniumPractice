package myAllPracticeQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q16_Test05_Slack {

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

//    1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//    2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
        WebElement dropdownExampleMenu = driver.findElement(By.id("dropdown-class-example"));
        Assert.assertTrue(dropdownExampleMenu.isDisplayed());
//    3-Option3 ü seçin.
        Select select = new Select(dropdownExampleMenu);
        select.selectByVisibleText("Option3");
//    4-Option3 ün seçili olduğunu doğrulayın.
        WebElement option3 = driver.findElement(By.xpath("//option[@value='option3']"));
        Assert.assertTrue(option3.isSelected());
    }
}
