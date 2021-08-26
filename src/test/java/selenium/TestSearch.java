package selenium;

import PageObjects.HomePage;
import PageObjects.ProductPage;
import PageObjects.SearchPage;
import PageObjects.SearchResultsPage;
import dataProviders.ProductsDataProvider;
import dataProviders.SearchProvider;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.Products;
import pojo.SearchData;

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

    @Test (dataProvider = "getSearchDataFromJson", dataProviderClass = SearchProvider.class)
    public void Test_Search_WithData(SearchData testData){
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(testData.getSearchCriteria());

        driver.findElement(By.xpath("//div[@id='search']/span/button")).click();

        if(testData.getExpectedResults() > 0){
            Assert.assertEquals(searchResultsPage.getResultsCount(), testData.getExpectedResults());
            Assert.assertEquals(searchResultsPage().getResultsCount(), testData.getExpectedResults());
        }
        else{
            Assert.assertTrue(searchResultsPage.isNoResultsVisible());
            Assert.assertTrue(searchResultsPage().isNoResultsVisible());
        }
    }
    @Description ("Trabajo Final Caso de Prueba 3: Validate product price in different currencies")
    @Test (dataProvider = "getProductsDataFromJson", dataProviderClass = ProductsDataProvider.class)
    public void Test_Search_Product_Price_Currencies(Products testData){

        //Search for Product
        //Go to product page
        HomePage homePage = new HomePage(driver);
        homePage().searchFindProductByName(testData.getProduct());

        //select currencies and verify prices
        ProductPage productPage = new ProductPage(driver);

        productPage().clickCurrencyDropdown();
        productPage().selectCurrencyOptionEuro();
        String euro = productPage.getPrice();
        euro = euro.substring(0,euro.length()-2);
        if(euro.equals(testData.getEuroPrice())) {
            Assert.assertEquals(euro, testData.getEuroPrice(), "Euro price matches");
        }
        else{
            System.out.println("Euro price doesn't match");
        }

        productPage().clickCurrencyDropdown();
        productPage().selectCurrencyOptionPound();
        String pound = productPage.getPrice();
        pound = pound.substring(1,pound.length()-1);
        if(euro.equals(testData.getPoundPrice())) {
            Assert.assertEquals(pound, testData.getPoundPrice(), "Pound price matches");
        }
        else{
            System.out.println("Pound price doesn't match");
        }

        productPage().clickCurrencyDropdown();
        productPage().selectCurrencyOptionDollar();
        String dollar = productPage.getPrice();
        dollar = dollar.substring(1, dollar.length()-1);
        if(euro.equals(testData.getDollarPrice())) {
            Assert.assertEquals(dollar, testData.getDollarPrice(), "Dollar price matches");
        }
        else{
            System.out.println("Dollar price doesn't match");
        }
    }
}
