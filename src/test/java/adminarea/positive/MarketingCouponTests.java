package adminarea.positive;

import adminarea.core.BaseTest;
import org.testng.annotations.Test;
import pages.adminarea.MarketingCouponCreation;
import pages.adminarea.MarketingCouponsDashboard;

public class MarketingCouponTests extends BaseTest {

    @Test
    public static void successfulCouponCreation(){
        MarketingCouponCreation.createMarketingCoupon("admin", "parola123!","Coupon123","Coupon123","10","10");
        MarketingCouponsDashboard.verifyMarketingCouponCreation("Success: You have modified coupons");
    }

}
