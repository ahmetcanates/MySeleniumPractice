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

public class Q17_IFrame_Preclass {
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
        //Bir class olusturun: IframeTest
        //● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //● Bir metod olusturun: iframeTest
        //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement baslik = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslik.isDisplayed());
        System.out.println(baslik.getText());

        //○Text Box’a “Merhaba Dunya!” yazin.
        driver.switchTo().frame(0);
        WebElement iframeParagraph = driver.findElement(By.id("tinymce"));
        iframeParagraph.clear();
        iframeParagraph.sendKeys("Merhaba Dunya!");

        //○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //dogrulayin ve konsolda yazdirin.
        driver.switchTo().parentFrame();
        WebElement bottomText = driver.findElement(By.xpath("//*[@style='text-align: center;']"));
        Assert.assertTrue(bottomText.isDisplayed());
        System.out.println(bottomText.getText());
    }
}
