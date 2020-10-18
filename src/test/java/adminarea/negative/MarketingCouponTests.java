package adminarea.negative;

import adminarea.core.BaseTest;
import org.testng.annotations.Test;
import pages.adminarea.MarketingCouponCreation;
import pages.adminarea.MarketingCouponsDashboard;

public class MarketingCouponTests extends BaseTest {

    @Test
    public static void unsuccessfulDuplicateCouponCreation() {
        MarketingCouponCreation.createMarketingCoupon("admin", "parola123!","Coupon123","Coupon123","10","10");
        MarketingCouponCreation.verifyUnsuccessfulDuplicateCouponCreation("Coupon code is already in use!");
    }
}
