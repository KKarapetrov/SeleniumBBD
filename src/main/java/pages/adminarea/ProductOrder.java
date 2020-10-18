package pages.adminarea;

import components.HeaderCurrency;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Browser;

public class ProductOrder {

    /**
     * Invoking this method will navigate to a specific product URL and will try to place an order with the specified quantity
     * @param URLofProduct This is the URL that leads directly to the product
     * @param orderQuantity Specifies the quantity of the product to be put on order
     */

    public static void orderProductWithMinimumQty(String URLofProduct, String orderQuantity){
        HeaderCurrency.navigate(URLofProduct);
        WebElement orderQty = Browser.driver.findElement(By.id("input-quantity"));
        orderQty.clear();
        orderQty.sendKeys(orderQuantity);
        Browser.driver.findElement(By.id("button-cart")).click();
        WebDriverWait wait = new WebDriverWait(Browser.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert-success")));
        Browser.driver.findElement(By.cssSelector("div.alert-success>a:nth-of-type(2)")).click();
    }

}
