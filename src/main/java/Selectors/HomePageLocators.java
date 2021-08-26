package Selectors;

import org.openqa.selenium.By;

public class HomePageLocators {

    public static By FirstProductTitleSelector = By.cssSelector(".caption a");
    public static String FirstH4Locator = "//h4/a[text()='<name>']";
    public static By FirstH4LocatorXpath = By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a");
    public static By searchBarLocator = By.xpath("//*[@id=\"search\"]/input");
    public static By searchButtonLocator = By.xpath("//div[@id='search']/span/button");
}
