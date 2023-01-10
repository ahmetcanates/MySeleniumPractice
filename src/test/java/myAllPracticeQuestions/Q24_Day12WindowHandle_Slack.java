package myAllPracticeQuestions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Q24_Day12WindowHandle_Slack {

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
         /*
      #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
     #Fill in capitals by country
    */
  /*
   #url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
  #Ülkeye göre başkentleri doldurun
 */

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        //DRAGGABLE ELEMENTS
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement stockolm = driver.findElement(By.id("box2"));
        WebElement washington = driver.findElement(By.id("box3"));
        WebElement copenhagen = driver.findElement(By.id("box4"));
        WebElement seoul = driver.findElement(By.id("box5"));
        WebElement rome = driver.findElement(By.id("box6"));
        WebElement madrid = driver.findElement(By.id("box7"));

        //DROPPABLE ELEMENTS

        WebElement italy = driver.findElement(By.id("box106"));
        WebElement spain = driver.findElement(By.id("box107"));
        WebElement norway = driver.findElement(By.id("box101"));
        WebElement denmark = driver.findElement(By.id("box104"));
        WebElement southkorea = driver.findElement(By.id("box105"));
        WebElement sweden = driver.findElement(By.id("box102"));
        WebElement unitedstates = driver.findElement(By.id("box103"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(oslo,norway).perform();
        actions.dragAndDrop(stockolm,sweden).perform();
        actions.dragAndDrop(washington,unitedstates).perform();
        actions.dragAndDrop(copenhagen,denmark).perform();
        actions.dragAndDrop(seoul,southkorea).perform();
        actions.dragAndDrop(rome,italy).perform();
        actions.dragAndDrop(madrid,spain).perform();

    }
}
