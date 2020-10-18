package pages.adminarea;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Browser;

public class MarketingCouponsDashboard {

    /**
     * Invoking this method will validate if a coupon creation has been successful
     */
    public static void verifyMarketingCouponCreation(String expectedMessageSuccessfulCreation) {
        Assert.assertTrue(Browser.driver.findElement(By.cssSelector("div.alert-success")).getText().contains(expectedMessageSuccessfulCreation));

    }
}
