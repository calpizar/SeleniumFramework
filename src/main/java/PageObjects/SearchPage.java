package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchPage extends BasePage{
    private WebDriver driver;

    //Elements
    private By SearchBarLocator = By.name("search");
    private By SearchResults = By.cssSelector(".product-thumb");
    private By NoSearchMatchError = By.xpath("//*[@id=\"content\"]/p[2]");



    public SearchPage(WebDriver _driver) {
        super(_driver);
    }

    public void EnterValidSearchCriteria (String searchCriteria, int expectedResult){
        driver.findElement(SearchBarLocator).sendKeys(searchCriteria,Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().contains("search="+searchCriteria));
        Assert.assertEquals(SizeSearchResults(),expectedResult,
                "Expecting" + expectedResult + "results, and got" + SizeSearchResults());
    }


    public int SizeSearchResults() {
        return driver.findElements(SearchResults).size();
    }

    public void EnterInvalidSearchCriteria(String searchCriteria, int expectedResult){
        driver.findElement(SearchBarLocator).sendKeys(searchCriteria,Keys.ENTER);
        Assert.assertTrue(driver.getCurrentUrl().contains("search="+searchCriteria));
        Assert.assertEquals(SizeSearchResults(),expectedResult,
                "Expecting" + expectedResult + "results, but got" + SizeSearchResults());

    }

    public String GetNoSearchMatchMessage(){
        return driver.findElement(NoSearchMatchError).getText();
    }
}