package myAllPracticeQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Q25_Day12HoverOver_Slack {

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
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement hoverButton1 = driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        actions.moveToElement(hoverButton1).perform();

        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();

        //4. Popup mesajini yazdirin
        String popUpMessage = driver.switchTo().alert().getText();
        System.out.println(popUpMessage);

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement clickHoldButton = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickHoldButton).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        String clickHoldButtonText = clickHoldButton.getText();
        System.out.println(clickHoldButtonText);

        //8. "Double click me" butonunu cift tiklayin
        //cift tiklamadan rengini aliyorum
        WebElement doubleClickButton = driver.findElement(By.id("double-click"));
        String ilkRenk = doubleClickButton.getAttribute("class");
        System.out.println(ilkRenk);
        //yukarida almis oldum
        actions.doubleClick(doubleClickButton).perform();
        Thread.sleep(2000);

        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        String ikinciRenk = doubleClickButton.getAttribute("class");
        Assert.assertNotEquals(ilkRenk,ikinciRenk);
    }
}
