import PageObjects.HeaderPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.rmi.log.LogInputStream;

import java.util.Locale;


public class TestAccount extends BaseClass{

    @Description("Validate that the login is working with valid credentials")
    @Test (description = "Test Login Success")
    public void Test_Login_Sucessful(){
        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String username = "juan.piedra@ucreativa.com";
        String password = "asdf";

        //String pathToDriver = Test.class.getResource("/chromedriver.exe").getPath();
        //System.setProperty("webdriver.chrome.driver",pathToDriver);

        //WebDriver driver = new ChromeDriver();


        //Go to Login Page
        headerPage.clickOnMyAccount();
        headerPage.clickOnLoginButton();
        //driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
        //driver.findElement(By.linkText("Login")).click();

        //Enter login credentials
        loginPage.EnterEmail(username);
        loginPage.EnterPassword(password);
        loginPage.ClickSubmitButton();
        //driver.findElement(By.name("email")).sendKeys(username);
        //driver.findElement(By.name("password")).sendKeys(password);
        //driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();


        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logOutButton.isDisplayed());

        TakeScreenshot();

        driver.close();
        driver.quit();

    }
    @Description("Validate that the login fails with invalid credentials")
    @Test(description = "Test Login Unsuccessful")
    public void Test_Login_Unsucessful() {
        LoginPage loginPage = new LoginPage(driver);
        String username = "juan.piedra@ucreativa.com";
        String password = "asfdu";
        String expectedMessage = "warning: no match for e-mail address and/or password.";

        //String pathToDriver = Test.class.getResource("/chromedriver.exe").getPath();
        //System.setProperty("webdriver.chrome.driver", pathToDriver);

        //WebDriver driver = new ChromeDriver();
        //driver.get("https://demo.opencart.com/");
        //driver.manage().window().maximize();

        //Go to Login Page
       // driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
        //driver.findElement(By.linkText("Login")).click();

        //Enter login credentials
        //driver.findElement(By.name("email")).sendKeys(username);
        //driver.findElement(By.name("password")).sendKeys(password);
        //driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
        loginPage.GoTo();
        loginPage.login(username,password);

        WebElement alertMessage = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]"));
        Assert.assertEquals(alertMessage.getText().toLowerCase().trim(),expectedMessage.toLowerCase());

        TakeScreenshot();

        driver.close();
        driver.quit();
    }

    @Test
    public void Test_Create_New_Account(){
        //Setup
        String firstName = "Test";
        String lastName = "User";
        String email = "test.user@test.com";
        String telephone = "33336677";
        String password = "test123";
        String expectedMessage = "Your Account Has Been Created!";
        RegisterPage registerPage = new RegisterPage(driver);

        //Run
        registerPage.GoTo();
        registerPage.FillForm(firstName,lastName,email,telephone,password);

        Assert.assertEquals(registerPage.GetConfirmationMessage(),expectedMessage);
    }

}
