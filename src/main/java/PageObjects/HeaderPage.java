package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage{

    //Elementos
    private By myAccountLinkLocator = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i");
    private By loginButtonLocator = By.linkText("Login");
    private By registerButtonLocator = By.linkText("Register");
    private By CartButtonLocator = By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/i");
    private By yourStoreButtonLocator = By.linkText("Your Store");

    public HeaderPage(WebDriver _driver) {
        super(_driver);
    }
    public void clickOnMyAccount(){
        driver.findElement(myAccountLinkLocator).click();
        }

    public void clickOnLoginButton(){
        driver.findElement(loginButtonLocator).click();
        }
    public void clickOnRegisterButton(){
        driver.findElement(registerButtonLocator).click();
    }

    public void clickOnCartButton(){
        driver.findElement(CartButtonLocator).click();
    }

    public void clickOnYourStoreButton() {
        driver.findElement(yourStoreButtonLocator).click();
    }

}
