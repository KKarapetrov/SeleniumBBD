package customerarea.positive;

import adminarea.core.BaseTest;
import org.testng.annotations.Test;
import pages.adminarea.Checkout;
import pages.adminarea.ProductOrder;

public class ProductOrderTests extends BaseTest {

    @Test
    public static void successfulOrderWithMinimumQty(){
        ProductOrder.orderProductWithMinimumQty("http://shop.pragmatic.bg/index.php?route=product/product&product_id=43","5");
        Checkout.verifyMinimumOrderQtyIsMet("Checkout");
    }

}
