import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoAccount {

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void test_capabilities(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.setHeadless(true);
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver();
        //driver.get("https://seleniumeasy.com/test/");
        driver.get("https://badssl.com/");
        Assert.assertTrue(driver.findElement(By.id("Content")).isDisplayed());

        driver.manage().window().maximize();
    }

    @Test
    public void test_waits(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.get("");
        driver.findElement(By.id("dowloadButton")).click();

        boolean result = false;
        //manejo de excepciones
        try{
        result = wait.until(
        ExpectedConditions.textToBe(
        By.className("progress-label"), "Complete!"));
    }
    catch (WebDriverException exception){
    System.out.println("No funciono");
}
    }

    @Test
    public void drag_and_drop(){
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");

        Actions actions = new Actions(driver);

        WebElement draggable1 = driver.findElement(By.xpath("//*[@id=\"todrag\"]/span[1]"));
        WebElement drop = driver.findElement(By.id("mydropzone"));
        Assert.assertTrue(drop.isDisplayed());

        Point punto = drop.getLocation();

        actions.dragAndDrop(draggable1,drop).release().build().perform();
        //actions.dragAndDrop(draggable1,punto.getX(),punto.getY()).release().build().perform();
        //actions.perform();
        }

    @AfterTest
    public void close(){

        }

        }
