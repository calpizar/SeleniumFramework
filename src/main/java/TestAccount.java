import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestAccount extends BaseClass{

    @Description("Validate that the login is working with valid credentials")
    @Test (description = "Test Login Success")
    public void Test_Login_Sucessful(){
        String username = "juan.piedra@ucreativa.com";
        String password = "asdf";

        //String pathToDriver = Test.class.getResource("/chromedriver.exe").getPath();
        //System.setProperty("webdriver.chrome.driver",pathToDriver);

        //WebDriver driver = new ChromeDriver();


        //Go to Login Page
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
        driver.findElement(By.linkText("Login")).click();

        //Enter login credentials
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();


        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logOutButton.isDisplayed());

        TakeScreenshot();

        driver.close();
        driver.quit();

    }
    @Description("Validate that the login fails with invalid credentials")
    @Test(description = "Test Login Unsuccessful")
    public void Test_Login_Unsucessful() {
        String username = "juan.piedra@ucreativa.com";
        String password = "asfdu";

       //String pathToDriver = Test.class.getResource("/chromedriver.exe").getPath();
        //System.setProperty("webdriver.chrome.driver", pathToDriver);

        //WebDriver driver = new ChromeDriver();
        //driver.get("https://demo.opencart.com/");
        //driver.manage().window().maximize();

        //Go to Login Page
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
        driver.findElement(By.linkText("Login")).click();

        //Enter login credentials
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();

        WebElement alertMessage = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]"));
        Assert.assertEquals(alertMessage.getText().toLowerCase().trim(),alertMessage);

        TakeScreenshot();

        driver.close();
        driver.quit();
    }


}
