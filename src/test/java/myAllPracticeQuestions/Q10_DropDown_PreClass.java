package myAllPracticeQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Q10_DropDown_PreClass {
        //Bir class oluşturun: DropDown
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        //4.Tüm dropdown değerleri(value) yazdırın
        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //False yazdırın.
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownMenu = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(dropdownMenu);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        List<WebElement> options = driver.findElements(By.xpath("//*[@id='dropdown']"));
        for(WebElement w:options) {
            System.out.println(w.getText());
        }
        int dropdownSize = options.size();
        if(dropdownSize==4) {
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
}
