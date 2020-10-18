package pages.adminarea;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Browser;

public class ShoppingCart {

    /**
     * Invoking this method will verify that the minimum ordering quantity is not met
     *
     * @param expectedMessageForNotMeetingMinQty This is the expected message that the shopping cart will display upon attempting to purchase a quantity less than the minimum order quantity
     */

    public static void verifyMinimumOrderQtyIsMet(String expectedMessageForNotMeetingMinQty) {

        WebDriverWait wait = new WebDriverWait(Browser.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert-danger")));
        Assert.assertTrue(Browser.driver.findElement(By.cssSelector("div.alert-danger")).getText().contains(expectedMessageForNotMeetingMinQty), "Order was placed without meeting the minimum order quantity, this is a BUG");
    }
}


