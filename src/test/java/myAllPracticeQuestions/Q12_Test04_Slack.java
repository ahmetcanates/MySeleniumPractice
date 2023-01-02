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

public class Q12_Test04_Slack {
    /* Given kullanici "https://editor.datatables.net/" sayfasina gider
        Then new butonuna basar
        And editor firstname kutusuna "<firstName>" bilgileri girer
        And editor lastname kutusuna "<lastName>" bilgileri girer
        And editor position kutusuna "<position>" bilgileri girer
        And editor office kutusuna "<office>" bilgileri girer
        And editor extension kutusuna "<extension>" bilgileri girer
        And editor startdate kutusuna "<startDate>" bilgileri girer
        And editor salary kutusuna "<salary>" bilgileri girer
        When Create tusuna basar
        Then Kullanıcının eklendiğini doğrular.
        And Eklediği kullanıcı kaydını siler
        Then Kullanıcinin silindiğini doğrular.
        */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

//    @After
//    public void tearDown() {
//        driver.close();
//    }

    @Test
    public void test() {
        //Given kullanici "https://editor.datatables.net/" sayfasina gider
        driver.get("https://editor.datatables.net/");

        //Then new butonuna basar
        driver.findElement(By.xpath("//*[@class='dt-button buttons-create']")).click();

        //And editor firstname kutusuna "<firstName>" bilgileri girer
        //And editor lastname kutusuna "<lastName>" bilgileri girer
        //And editor position kutusuna "<position>" bilgileri girer
        //And editor office kutusuna "<office>" bilgileri girer
        //And editor extension kutusuna "<extension>" bilgileri girer
        //And editor startdate kutusuna "<startDate>" bilgileri girer
        //And editor salary kutusuna "<salary>" bilgileri girer
        //When Create tusuna basar
        WebElement isim = driver.findElement(By.xpath("//*[@id='DTE_Field_first_name']"));
        isim.sendKeys("Ahmet", Keys.TAB,"Ates",Keys.TAB,"QA Engineer",Keys.TAB,"Izmir",Keys.TAB,"4",Keys.TAB,
                "2022-12-29",Keys.TAB,"10000",Keys.ENTER);

        //Then Kullanıcının eklendiğini doğrular.
        String isim1 = "Ahmet Ates";
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Ahmet Ates");
        WebElement kullaniciElement = driver.findElement(By.xpath("//*[@class='sorting_1']"));
        String kullaniciIsmi = kullaniciElement.getText();
        Assert.assertEquals(kullaniciIsmi,isim1);
        //And Eklediği kullanıcı kaydını siler
        WebElement kayitSilme = driver.findElement(By.xpath("//*[@id='row_58']"));
        kayitSilme.click();
        WebElement deleteButton = driver.findElement(By.xpath("//*[text()='Delete']"));
        deleteButton.click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();  //for verify
        //Then Kullanıcinin silindiğini doğrular.
        WebElement noMatch = driver.findElement(By.xpath("//*[text()='No matching records found']"));
        Assert.assertTrue("silinmemis",noMatch.isDisplayed());

    }
}
