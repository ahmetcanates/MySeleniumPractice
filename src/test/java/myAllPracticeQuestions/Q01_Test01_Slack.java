package myAllPracticeQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q01_Test01_Slack {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //1-Test01 isimli bir class olusturun
        //2- https://www.amazon.com/ adresine gidin
        //3- Browseri tam sayfa yapin
        //4-Sayfayi “refresh” yapin
        //5-”Salesforce Apex Questions Bank” icin arama yapiniz
        //6- Kac sonuc bulundugunu yaziniz
        //7-Sayfayi kapatin
        driver.get("https://www.amazon.com");
        driver.manage().window().fullscreen();
        driver.navigate().refresh();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Salesforce Apex Questions Bank", Keys.ENTER);
        WebElement aramaSonucu = driver.findElement(By.className("sg-col-inner"));
        System.out.println(aramaSonucu.getText());

    }
}
