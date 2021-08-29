package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    //elementos
    public String ProductTitleSelector = "//h1[text()='<name>']";
    public By ProductQuantityInputSelector = By.id("input-quantity");
    public By AddButtonSelector = By.id("button-cart");
    public By AlertSuccess = By.cssSelector(".alert-success");
<<<<<<< HEAD
    public By CurrencyDropdownLocator = By.xpath("//*[@id=\"form-currency\"]/div");
    public By CurrencyDropdownLocatorDollar = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]/button");
    public By CurrencyDropdownLocatorPound = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[2]/button");
    public By CurrencyDropdownLocatorEuro = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[3]/button");
    private By priceLocator = By.xpath("//*[@id=\"content\"]/div/div[2]/ul[2]/li[1]/h2");
=======
>>>>>>> origin/main

    public ProductPage(WebDriver _driver){
        super(_driver);
    }

    public boolean isTitleDisplayed(String name){
        return driver.findElement(By.xpath(ProductTitleSelector.replace("<name>",name))).isDisplayed();
    }

    public void SetQuantity(int quantity){
        driver.findElement(ProductQuantityInputSelector).clear();
        driver.findElement(ProductQuantityInputSelector).sendKeys("" + quantity);
    }

    public void clickAddButton(){
        driver.findElement(AddButtonSelector).click();
    }

    public boolean isAlertSuccessDisplayed(){
        return driver.findElement(AlertSuccess).isDisplayed();
    }

<<<<<<< HEAD
    public void clickCurrencyDropdown(){
        driver.findElement(CurrencyDropdownLocator).click();
    }

    public void selectCurrencyOptionEuro (){
        driver.findElement(CurrencyDropdownLocatorEuro).click();
    }


    public void selectCurrencyOptionPound (){
        driver.findElement(CurrencyDropdownLocatorPound).click();
    }

    public void selectCurrencyOptionDollar (){
        driver.findElement(CurrencyDropdownLocatorDollar).click();
    }

    public String getPrice(){
        return  driver.findElement(priceLocator).getText();
    }
=======
>>>>>>> origin/main
}
