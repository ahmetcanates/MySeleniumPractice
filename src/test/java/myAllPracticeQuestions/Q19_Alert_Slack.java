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

public class Q19_Alert_Slack {
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
        //   // go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        //"Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
        driver.findElement(By.xpath("//*[.='Alert with OK ']")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();

        //    accept Alert(I am an alert box!) and print alert on console
        //Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        //"Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Alert with OK & Cancel ']")).click();
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();
        //    cancel Alert  (Press a Button !)
        //Alert'ü kapatın
        driver.switchTo().alert().dismiss();
        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        //"Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
        driver.findElement(By.xpath("//*[text()='Alert with Textbox ']")).click();
        driver.findElement(By.xpath("//*[@onclick='promptbox()']")).click();
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        //Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
        driver.switchTo().alert().sendKeys("Ahmet Can");
        driver.switchTo().alert().accept();
        //Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
        //    finally print on console this mesaaje "Hello TechproEducation How are you today"
        String sonuc = driver.findElement(By.id("demo1")).getText();
        String isim = "Ahmet Can";
        Assert.assertTrue(sonuc.contains(isim));
        System.out.println(sonuc);

    }
}
