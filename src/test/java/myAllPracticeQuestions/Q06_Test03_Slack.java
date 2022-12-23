package myAllPracticeQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q06_Test03_Slack {
   static WebDriver driver;
    static List<WebElement> elementTiklama;
    static List<String> kartaEkleme = new ArrayList<>();
    static List<String> strMarka = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        /*
    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    ~ click on Phones & PDAs
    ~ get the brandName of phones
    ~ click on add to button for all elements
    ~ click on black total added cart button
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list
     */

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

        //~ click on Phones & PDAs
        driver.findElement(By.xpath("//*[text()='Phones & PDAs']")).click();

        String visibleTest = driver.findElement(By.xpath("//h2[text()='Phones & PDAs']")).getText();
        if(visibleTest.equals("Phones & PDAs")) {
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //~ get the brandName of phones
        List<WebElement> markalar = driver.findElements(By.cssSelector("div.caption>h4>a"));
        for(WebElement w : markalar) {
            strMarka.add(w.getText());
        }
        Collections.sort(strMarka);


        // ~ click on add to button for all elements
        clickAllElements();
        Thread.sleep(3000);
        //~ click on black total added cart button
        WebElement siyahSepet = driver.findElement(By.xpath("(//*[@data-toggle='dropdown'])[3]"));
        siyahSepet.click();

        //~ get the names of list from the cart
        getNames("//td[@class='text-left']");

        //~ compare the names from displaying list and cart list
        compareTwoList(strMarka,kartaEkleme);
    }

    public static void clickAllElements() {
        elementTiklama = driver.findElements(By.xpath("//*[text()='Add to Cart']"));
        for(WebElement s : elementTiklama) {
            s.click();
        }
    }

    public static void getNames(String xpath) {
        List<WebElement> kartaEkle = driver.findElements(By.xpath(xpath));
        for(WebElement w : kartaEkle) {
            kartaEkleme.add(w.getText());
        }
        Collections.sort(kartaEkleme);
    }

    public static void compareTwoList(List<String> a, List<String> b) {

        if(a.equals(b)) {
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
    }

}
