import PageObjects.LoginPage;
import PageObjects.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class TestSearch extends BaseClass {

    @Test
    public void Validate_Valid_Search(){
        String searchCriteria = "Macbook";
        int expectedResult = 3;
        SearchPage searchPage = new SearchPage(driver);

        searchPage.EnterValidSearchCriteria(searchCriteria,expectedResult);
        //WebElement searchInput = driver.findElement(By.name("search"));
        //searchInput.sendKeys(searchCriteria, Keys.ENTER);
        //Assert.assertTrue(driver.getCurrentUrl().contains("search="+searchCriteria));
        //Assert.assertEquals(getResults(),expectedResult,
                //"Expecting" + expectedResult + "results, but got" + getResults());
    }

    @Test
    public void Validate_Invalid_Search(){
        String searchCriteria = "Macdonals";
        int expectedResult = 0;
        String expectedErrorMessage = "There is no product that matches the search criteria.";
        SearchPage searchPage = new SearchPage(driver);

        searchPage.EnterInvalidSearchCriteria(searchCriteria,expectedResult);
        Assert.assertEquals(searchPage.GetNoSearchMatchMessage(),expectedErrorMessage);

        //WebElement searchInput = driver.findElement(By.name("search"));
        //searchInput.sendKeys(searchCriteria, Keys.ENTER);

        //Assert.assertTrue(driver.getCurrentUrl().contains("search="+searchCriteria));
        //List<WebElement> results = driver.findElements(By.cssSelector(".product-thumb"));

        //Assert.assertEquals(results.size(),expectedResult,
                //"Expecting" + expectedResult + "results, but got" + results.size());
    }

    //public int getResults(){
       //return driver.findElements(By.cssSelector(".product-thumb")).size();
    //}
}
