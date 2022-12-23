package myAllPracticeQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03_AutomationExerciseQ01 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        //1. Launch browser
        WebDriver driver = new ChromeDriver();

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        if(logo.isDisplayed()) {
            System.out.println("VISIBILITY TEST PASSED");
        }else {
            System.out.println("VISIBILITY TEST FAILED");
        }

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSUp = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        // //*[.='New User Signup!']"
        if(newUserSUp.isDisplayed()) {
            System.out.println("VISIBILITY TEST PASSED");
        }else {
            System.out.println("VISIBILITY TEST FAILED");
        }

        //6. Enter name and email address
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("Ahmet Can");
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("asdfghjkl1@hotmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccInfo = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        if(enterAccInfo.isDisplayed()) {
            System.out.println("VISIBILITY TEST PASSED");
        }else {
            System.out.println("VISIBILITY TEST FAILED");
        }

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//*[@data-qa='name']")).sendKeys(" Ates");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-qa='password']")).sendKeys("12345678");

        driver.findElement(By.xpath("//*[@data-qa='days']")).sendKeys("1");
        driver.findElement(By.xpath("//*[@data-qa='months']")).sendKeys("January");
        driver.findElement(By.xpath("//*[@data-qa='years']")).sendKeys("1999");

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[@id='newsletter']")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@id='optin']")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//*[@data-qa='first_name']")).sendKeys("ACA");
        driver.findElement(By.xpath("//*[@data-qa='last_name']")).sendKeys("BGM");
        driver.findElement(By.xpath("//*[@data-qa='company']")).sendKeys("ATES");
        driver.findElement(By.xpath("//*[@data-qa='address']")).sendKeys("USA");
        driver.findElement(By.xpath("//*[@data-qa='address2']")).sendKeys("California");
        driver.findElement(By.xpath("//*[@value='Israel']")).click();
        driver.findElement(By.xpath("//*[@data-qa='state']")).sendKeys("Louisiana");
        driver.findElement(By.xpath("//*[@data-qa='city']")).sendKeys("NEW ORLEANS");
        driver.findElement(By.xpath("//*[@data-qa='zipcode']")).sendKeys("70000");
        driver.findElement(By.xpath("//*[@data-qa='mobile_number']")).sendKeys("199999990");

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();


        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accCreated = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        if(accCreated.isDisplayed()) {
            System.out.println("VISIBILITY TEST PASSED");
        }else {
            System.out.println("VISIBILITY TEST FAILED");
        }

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
        Thread.sleep(4000);
        WebElement reklam = driver.findElement(By.xpath("//*[text()='Ad']"));
        System.out.println(reklam.isDisplayed());
        driver.findElement(By.xpath("//*[@d='M38 12.83L35.17 10 24 21.17 12.83 10 10 12.83 21.17 24 10 35.17 12.83 38 24 26.83 35.17 38 38 35.17 26.83 24z']")).click();


        //16. Verify that 'Logged in as username' is visible
        WebElement loggedInAsUsName = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        if(loggedInAsUsName.isDisplayed()) {
            System.out.println("VISIBILITY TEST PASSED");
        }else {
            System.out.println("VISIBILITY TEST FAILED");
        }

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accDeleted = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        if(accDeleted.isDisplayed()) {
            System.out.println("VISIBILITY TEST PASSED");
        }else {
            System.out.println("VISIBILITY TEST FAILED");
        }

        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
    }
}
