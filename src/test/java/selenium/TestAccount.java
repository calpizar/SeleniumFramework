import PageObjects.HeaderPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.BaseClass;


public class TestAccount extends BaseClass {

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

    @Description("Trabajo Final Caso de Prueba 1: Validate that duplicate email check validation is performed at Register Page")
    @Test
    public void Test_Duplicate_Email_Check(){
        //Setup
        String firstName = "Test";
        String lastName = "User";
        String email = "juan@piedra.com";
        String telephone = "999991234";
        String password = "Test123";
        String expectedMessage = "Warning: E-Mail Address is already registered!";
        RegisterPage registerPage = new RegisterPage(driver);

        //Run
        registerPage.GoTo();
        registerPage.FillForm(firstName, lastName, email, telephone, password);

        Assert.assertEquals(registerPage.GetDuplicateEmailWarningMessage(), expectedMessage);
    }

    @Description("Trabajo Final Caso de Prueba 1: Validate that random email is generated as expected at Register Page")
    @Test
    public void Test_Create_New_Account_With_Random_Email_Generation(){

        RegisterPage registerPage = new RegisterPage(driver);
        //Setup
        String firstName = "Carmen";
        String lastName = "Test";
        String email = registerPage().generateRandomEmail();
        String telephone = "33336677";
        String password = "test123";
        String expectedMessage = "Your Account Has Been Created!";
        String expectedAccountLogoutMessage = "Account Logout";

        //Run
        registerPage.GoTo();
        registerPage.FillForm(firstName,lastName,email,telephone,password);
        //Validate Account Registered
        Assert.assertEquals(registerPage.GetConfirmationMessage(),expectedMessage);
        //Validate User is logged in
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[13]")).click();
        String AccountLogoutMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
        Assert.assertEquals(AccountLogoutMessage, expectedAccountLogoutMessage, "User has logged out successfully");
    }

}
