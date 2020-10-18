package pages.adminarea;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Browser;

public class MarketingCouponCreation {

    /**
     * Invoking this method, you will get navigated to http://shop.pragmatic.bg/admin, and logged in with the admin credentials provided.
     * After being logged in you will be navigated to the Marketing dashboard and a coupon code will be generated with the details provided for the parameters.
     * @param administratorAccount Account which will be used for the log-in procedure
     * @param administratorPassword Password that will be used for the log-in procedure
     * @param couponName Coupon code name which will be visible in the Marketing -> Coupons tab.
     * @param code Coupon code name/number which will be used by the customers
     * @param discount Amount of the discount per coupon use
     * @param totalAmount Total amount of the discount on this coupon
     */
    public static void createMarketingCoupon(String administratorAccount, String administratorPassword,String couponName, String code, String discount, String totalAmount){
        AdminLogin.navigate();
        AdminLogin.login(administratorAccount,administratorPassword);
        Browser.driver.findElement(By.id("menu-marketing")).click();
        Browser.driver.findElement(By.cssSelector("li#menu-marketing li:nth-of-type(2)")).click();
        Assert.assertTrue(Browser.driver.findElement(By.cssSelector("div.container-fluid>h1")).getText().contains("Coupons"));
        Browser.driver.findElement(By.cssSelector("div.pull-right>a.btn")).click();
        Browser.driver.findElement(By.id("input-name")).sendKeys(couponName);
        Browser.driver.findElement(By.id("input-code")).sendKeys(code);
        Browser.driver.findElement(By.id("input-discount")).sendKeys(discount);
        Browser.driver.findElement(By.id("input-total")).sendKeys(totalAmount);
        Browser.driver.findElement(By.cssSelector("div.pull-right>button")).click();

    }

    /**
     * Invoking this method will verify if a creation attempt of a duplicate marketing coupon has been successfull
     * @param expectedMessageUnsuccessfulCreation This is the expected message that should be displayed on the coupon page when creating a duplicate coupon
     */
    public static void verifyUnsuccessfulDuplicateCouponCreation(String expectedMessageUnsuccessfulCreation){
        Assert.assertTrue(Browser.driver.findElement(By.cssSelector("div.alert")).getText().contains(expectedMessageUnsuccessfulCreation), "Duplicate coupon has been created, this is a BUG");
    }


}
