package myAllPracticeQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q22_IFrame_Slack {
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
        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        //maximize the web site
        //          above

        // ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // ikinci emoji altındaki tüm öğelere tıklayın
        List<WebElement> hayvanEmojileri = driver.findElements(By.xpath("//div[@id='nature']//div//img"));
        hayvanEmojileri.forEach(t->t.click());

        // ana iframe'e geri dön
        driver.switchTo().defaultContent();

        //formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> formKisimlari = driver.findElements(By.xpath("//*[@class='mdl-textfield__input']"));
        List<String> basicForm = new ArrayList<>(Arrays.asList("ahmet","can","ates","lambda","selenium","java","merhaba","sql",
                "html","css","javascripts","locator","authentication"));
        for (int i = 0; i < formKisimlari.size(); i++) {
            formKisimlari.get(i).sendKeys(basicForm.get(i));
        }
        Thread.sleep(3000);
        // uygula butonuna tıklayın
        driver.findElement(By.xpath("//*[@id='send']")).click();
    }
}
