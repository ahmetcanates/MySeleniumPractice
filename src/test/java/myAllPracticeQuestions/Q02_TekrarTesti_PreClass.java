package myAllPracticeQuestions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q02_TekrarTesti_PreClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //1. Yeni bir class olusturun (TekrarTesti)
        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        //doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
        //doğru URL'yi yazdırın.
        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        //5. Youtube sayfasina geri donun
        //6. Sayfayi yenileyin
        //7. Amazon sayfasina donun
        //8. Sayfayi tamsayfa yapin
        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        //Yoksa doğru başlığı(Actual Title) yazdırın.
        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        //URL'yi yazdırın
        //11.Sayfayi kapatin

        driver.get("https://www.youtube.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Youtube";
        if(actualTitle.equals(expectedTitle)) {
            System.out.println("TITLE TEST PASSED");
        }else {
            System.out.println("TITLE TEST FAILED. ACTUAL TITLE IS --> " + actualTitle);
        }

        String actualUrl = driver.getCurrentUrl();
        String expectedUrlC = "youtube";
        if(actualUrl.contains(expectedUrlC)) {
            System.out.println("URL TEST PASSED");
        }else {
            System.out.println("URL TEST FAILED. ACTUAL URL IS --> " +actualUrl);
        }
        driver.navigate().to("https://www.amazon.com");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.manage().window().fullscreen();
        String actualTitle2 = driver.getTitle();
        String expectedTitleC2 = "Amazon";
        if(actualTitle2.contains(expectedTitleC2)) {
            System.out.println("AMAZON TITLE TEST PASSED");
        }else {
            System.out.println("AMAZON TITLE TEST FAILED. ACTUAL TITLE IS --> " + actualTitle2);
        }
        String actualUrl2 = driver.getCurrentUrl();
        String expectedUrl2 = "https://www.amazon.com/";
        if(actualUrl2.equals(expectedUrl2)) {
            System.out.println("AMAZON URL TEST PASSED");
        }else {
            System.out.println("AMAZON URL TEST FAILED. ACTUAL URL IS --> " + actualUrl2);
        }

        driver.close();

    }
}
