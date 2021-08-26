package selenium;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseClass {
    @Description("Validate that add to cart is working")
    @Test
    public void Test_Add_To_Cart_Functionality() {
        /**
         * opciones de navegación
         * 1. search
         * 2. home add to cart  *****
         * 3. home -> Product Page -> add to cart
         * 4. construir la URL
         * */
        int quantity = 5;


        String imageURL = "macbook_1-47x47.jpg";
        String name = homePage().selectFirstProductAndGetName();
        Assert.assertTrue(productPage().isTitleDisplayed(name));
        productPage().SetQuantity(quantity);
        productPage().clickAddButton();
        Assert.assertTrue(productPage().isAlertSuccessDisplayed());
        headerPage().clickOnCartButton();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(shoppingCartPage().isProductRowDisplayed(name), "Title was not displayed");
        Assert.assertEquals(shoppingCartPage().getProductRowQuantity(), quantity, "Quantity is not matching");
        Assert.assertTrue(shoppingCartPage().getProductImageURL().contains(imageURL), "Image is not the one expected");

    }

    @Description("Validate several items added to the cart")
    @Test
    public void Test_Several_Items_Added_To_The_Cart() {
        homePage().selectProductByName("MacBook");
        productPage().SetQuantity(2);
        productPage().clickAddButton();
        homePage().GoTo();
        homePage().selectProductByName("iPhone");
        productPage().SetQuantity(5);
        productPage().clickAddButton();
        headerPage().clickOnCartButton();
        Assert.assertEquals(shoppingCartPage().getAmountOfShoppingCartRows(), 2, "Expected to get 2 rows");
    }

    @Description("Trabajo Final Caso de Prueba 2: Validate product is added to the cart")
    @Test
    public void Test_Product_Added_To_The_Cart() {
        int quantity = 1;
        String SHOPPING_CART_PRODUCTS_NOT_AVAILABLE_WARNING_MESSAGE = "Products marked with *** are not available in the desired quantity or not in stock!";

        //Search product
        homePage().selectProductByName("MacBook");
        productPage().SetQuantity(2);
        //Add product to cart
        productPage().clickAddButton();
        Assert.assertTrue(productPage().isAlertSuccessDisplayed());
        headerPage().clickOnCartButton();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Validate checkout is not allowed
        headerPage().clickOnCartButton();
        Assert.assertEquals(shoppingCartPage().getAmountOfShoppingCartRows(), 1, "Expected to get 1 row");
        Assert.assertEquals(shoppingCartPage().getAlertProductNotAvailable(),SHOPPING_CART_PRODUCTS_NOT_AVAILABLE_WARNING_MESSAGE);
    }
}