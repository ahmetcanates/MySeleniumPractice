package myAllPracticeQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q05_Test02_Slack {
    static String ilkUrunText;
    //1. "https://www.saucedemo.com" Adresine gidin
    //2. Username kutusuna "standard_user" yazdirin
    //3. Password kutusuna "secret_sauce" yazdirin
    //4. Login tusuna basin
    //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    //6. Add to Cart butonuna basin
    //7. Alisveris sepetine tiklayin
    //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    //9. Sayfayi kapatin

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna "standard_user" yazdirin
        driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("standard_user");

        //3. Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("secret_sauce");

        //4. Login tusuna basin
        driver.findElement(By.xpath("//*[@class='submit-button btn_action']")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        List<WebElement> tumUrunler = driver.findElements(By.xpath("//*[@class='inventory_item_name']"));
        ilkUrunText = tumUrunler.get(0).getText();

        WebElement ilkUrunKonumu = tumUrunler.get(0);
        ilkUrunKonumu.click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[text()='Add to cart']")).click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        List<WebElement> urunisimleri = driver.findElements(By.xpath("//*[@class='inventory_item_name']"));
        String sepetKontrol = driver.findElement(By.id("item_4_title_link")).getText();
        if(sepetKontrol.equals(ilkUrunText)) {
               System.out.println("TEST PASSED");
            }else {
               System.out.println("TEST FAILED");
           }

        //9. Sayfayi kapatin
        driver.close();


    }

}
