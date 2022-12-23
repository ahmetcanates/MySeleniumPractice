package myAllPracticeQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q04_TekrarTesti_PreClass2 {
    //C01_TekrarTesti isimli bir class olusturun
    //2- https://www.google.com/ adresine gidin
    //3- cookies uyarisini kabul ederek kapatin
    //4Sayfa basliginin “Google” ifadesi icerdigini test edin
    //5Arama cubuguna “Nutella” yazip aratin
    //6Bulunan sonuc sayisini yazdirin
    //7sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    //8Sayfayi kapatin
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin
        //????????????????

        //4Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        if(actualTitle.contains(expectedTitle)) {
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //5Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

        //6Bulunan sonuc sayisini yazdirin
        String sonucSayisi = driver.findElement(By.cssSelector("div[id='result-stats']")).getText();
        System.out.println(sonucSayisi);//Yaklaşık 150.000.000 sonuç bulundu (0,36 saniye)

        //7sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String[] sonucSayisiArr = sonucSayisi.split(" ");//Yaklaşık    150.000.000     sonuç     bulundu     (0,36 saniye)
        long asilSayi = Long.parseLong(sonucSayisiArr[1].replaceAll("\\.",""));// Burada sayiyi aldik sonuc 150000000
        if(asilSayi>10000000) {
            System.out.println("TEST PASSED --> " + asilSayi);
        }else {
            System.out.println("TEST FAILED --> " + asilSayi);
        }

        //8Sayfayi kapatin
        driver.close();

    }
}
