package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BasePage {
    public String ProductNameLocator = "//div[@id='content']//a[text()='<name>']";
    public By ProductQuantityLocator = By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/input");
    private String productRowLocator = "//div[@id='content']//tr[contains(.,'<name>')]";
    private WebElement productRow;
    private By inputRowSelector = By.cssSelector("input");
    private By imageSelector = By.cssSelector("img");
    private By shoppingCartRows = By.xpath("//div[@id='content']//div[contains(@class, 'table-responsive')]//tr");
    private By alertProductNotAvailableLocator = By.xpath("//*[@id=\"checkout-cart\"]/div[1]");
    private By CheckoutButtonLocator = By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a");

    public ShoppingCartPage(WebDriver _driver){
        super(_driver);
    }

    public boolean isProductRowDisplayed(String name){
        this.productRow =
                driver.findElement(
                        By.xpath(productRowLocator.replace("<name>", name)));
        return this.productRow.isDisplayed();
    }
    public int getProductRowQuantity(){
        String sAmount = productRow.findElement(inputRowSelector)
                .getAttribute("value");
        return Integer.parseInt(sAmount);
    }
    public String getProductImageURL(){
        String imageURL = productRow.findElement(imageSelector)
                .getAttribute("src");
        return imageURL;
    }
    public int getAmountOfShoppingCartRows(){
        return driver.findElements(shoppingCartRows).size() - 1;
    }

    public String getAlertProductNotAvailable(){
        driver.findElement(CheckoutButtonLocator).click();
<<<<<<< HEAD
        String alertProductNotAvailableMessage = driver.findElement(alertProductNotAvailableLocator).getText();
        alertProductNotAvailableMessage = alertProductNotAvailableMessage.substring(0,alertProductNotAvailableMessage.length()-2);
        return alertProductNotAvailableMessage;
=======
        return driver.findElement(alertProductNotAvailableLocator).getText();
>>>>>>> origin/main
    }
}
