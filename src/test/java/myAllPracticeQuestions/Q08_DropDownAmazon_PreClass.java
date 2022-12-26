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
import java.util.List;

public class Q08_DropDownAmazon_PreClass {
    // https://www.amazon.com/ adresine gidin.
    //- Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    //oldugunu test edin

    WebDriver driver;
    WebElement allDropdown;
    Select select;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");

        allDropdown = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        select = new Select(allDropdown);
    }


    @Test
    public void test01() {
        List<WebElement> options = select.getOptions();
        int i=0;
        for(WebElement w:options) {
            System.out.println(w.getText());
            i++;
        }
        System.out.println(i);
        Assert.assertEquals(45,i);
    }

//-Test 2
//1. Kategori menusunden Books secenegini secin
//2. Arama kutusuna Java yazin ve aratin
//3. Bulunan sonuc sayisini yazdirin
//4. Sonucun Java kelimesini icerdigini test edin

    @Test
    public void test02() throws InterruptedException {
    select.selectByVisibleText("Books");
    Thread.sleep(3000);
    WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
    aramaKutusu.sendKeys("Java");
    aramaKutusu.submit();

    String sonucSayisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
    Assert.assertTrue(sonucSayisi.contains("Java"));
    }
}
