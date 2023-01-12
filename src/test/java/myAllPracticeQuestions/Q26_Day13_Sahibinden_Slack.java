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

public class Q26_Day13_Sahibinden_Slack {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() throws InterruptedException {
        //sahibinden.com a gidin
        driver.get("https://www.sahibinden.com");
        driver.manage().deleteAllCookies();
        //anasayfada oldugunuzu dogrulayin
        WebElement anaSayfa = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(anaSayfa.isDisplayed());

        //detayli arama tiklayin
        driver.findElement(By.xpath("//*[@title='Detaylı Arama']")).click();

        //detayli arama sayfasina geldiginizi dogrulatin
        String detayliAramaBaslik = driver.findElement(By.xpath("(//h2)[1]")).getText();
        Assert.assertEquals("Detaylı Arama",detayliAramaBaslik);

        //emlak-konut-satilik seceneklerini secip
        driver.findElement(By.xpath("//*[.='Emlak']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[.='Konut']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[.='Satılık']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        //altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin
        WebElement aramayap = driver.findElement(By.cssSelector("button[value='Arama Yap']"));
        aramayap.click();

        //filtreler için sağıdakilere benzer methodlar oluşturun

        detayli_Arama_Adres("Sakarya","Arifiye");
        //detayli_Arama_Adres("izmir", "bayrakli", "adalet mah.");
        //detayli_Arama_Fiyat("4.000","4.000.000","USD");
        //detayli_Arama_Brut("180","400");
        //detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi
        ////cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin
    }

    public void detayli_Arama_Adres(String il,String ilce) {
        driver.findElement(By.xpath("//*[@class='faceted-select']")).click();
        driver.findElement(By.xpath("//*[@placeholder='İl']")).sendKeys(il);
        driver.findElement(By.xpath("//*[.='"+il+"']")).click();

        driver.findElement(By.xpath("(//*[@class='faceted-select'])[2]")).click();
        driver.findElement(By.xpath("//*[@placeholder='İlçe']")).sendKeys(ilce);
        driver.findElement(By.xpath("//a[.='"+ilce+"']")).click();
    }




}
