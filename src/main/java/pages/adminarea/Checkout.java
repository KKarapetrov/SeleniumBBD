package pages.adminarea;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

public class Checkout {

    /**
     * Invoking this method will verify that the minimum order quantity has been met and an order has been successfully placed
     * @param expectedHeadingOfPage This is the expected heading after proceeding to the checkout page after successfully placing and order with sufficient minimum quantity
     */

    public static void verifyMinimumOrderQtyIsMet(String expectedHeadingOfPage){

        Browser.driver.findElement(By.cssSelector("div.pull-right>a.btn")).click();
        Assert.assertTrue(Browser.driver.findElement(By.cssSelector("div#content>h1")).getText().contains(expectedHeadingOfPage));

    }
}
