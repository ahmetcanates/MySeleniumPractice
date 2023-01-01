package myAllPracticeQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q15_GrupTekrar {
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
        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna "standard_user" yazdirin
        //3. Password kutusuna "secret_sauce" yazdirin
        //4. Login tusuna basin
        driver.findElement(By.id("user-name")).sendKeys("standard_user",Keys.TAB,"secret_sauce",Keys.ENTER);
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        List<WebElement> urunler = driver.findElements(By.className("inventory_item_name"));
        String ilkUrun = urunler.get(0).getText();
        System.out.println(ilkUrun);
        urunler.get(0).click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.id("shopping_cart_container")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepet = driver.findElement(By.xpath("//*[@class='cart_item']"));
        Assert.assertTrue(sepet.isDisplayed());
        //9. Sayfayi kapatin
        driver.close();






    }
}
