package myAllPracticeQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q18_IFrame_Preclass {
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
        //● Bir class olusturun: IframeTest02
        // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        // 2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeNumber = driver.findElements(By.xpath("//iframe"));
        int iframeSayisi = iframeNumber.size();
        System.out.println(iframeSayisi);
        // 3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement ilkIframe = driver.findElement(By.xpath("//*[@wmode='transparent']"));
        driver.switchTo().frame(ilkIframe);
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();
        // 4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().parentFrame();
        //5) ikinci iframe'deki (Jmeter Made Easy) linke (
        //https://www.guru99.com/live-selenium-project.html
        //) tıklayınız
        driver.switchTo().frame(driver.findElement(By.id("a077aa5e")));
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();
    }
}
