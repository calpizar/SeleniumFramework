package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class RegisterPage extends BasePage {

    //Elements
    private By NameLocator = By.name("firstname");
    private By LastNameLocator = By.name("lastname");
    private By EmailLocator = By.id("input-email");
    private By TelephoneLocator = By.name("telephone");
    private By PasswordLocator = By.name("password");
    private By ConfirmLocator = By.name("confirm");
    private By ConfirmRegisterMessageLocator = By.xpath("//div[@id='content']/h1");
    private By TermsCheckboxLocator = By.name("agree");
    private By ContinueButtonLocator = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
    private By DuplicateEmailWarningMessageLocator = By.xpath("//*[@id=\"account-register\"]/div[1]");



    public RegisterPage(WebDriver _driver){
        super(_driver);
    }

    public void GoTo(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnMyAccount();
        headerPage.clickOnRegisterButton();
    }

    public void FillForm(String firstName, String lastName, String email, String telephone, String password){
        driver.findElement(NameLocator).sendKeys(firstName);
        driver.findElement(LastNameLocator).sendKeys(lastName);
        driver.findElement(EmailLocator).sendKeys(email);
        driver.findElement(TelephoneLocator).sendKeys(telephone);
        driver.findElement(PasswordLocator).sendKeys(password);
        driver.findElement(ConfirmLocator).sendKeys(password);
        driver.findElement(TermsCheckboxLocator).click();
        driver.findElement(ContinueButtonLocator).click();
    }
    public String GetConfirmationMessage(){
        return driver.findElement(ConfirmRegisterMessageLocator).getText();
    }

    public String GetDuplicateEmailWarningMessage(){
        return driver.findElement(DuplicateEmailWarningMessageLocator).getText();
    }

    public String generateRandomEmail(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String newRandomEmail = "username" + randomInt + "@idk.com";
        return newRandomEmail;
    }
}
