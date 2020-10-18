package customerarea.negative;

import adminarea.core.BaseTest;
import org.testng.annotations.Test;
import pages.adminarea.ProductOrder;
import pages.adminarea.ShoppingCart;

public class ProductOrderTests extends BaseTest {


    @Test
    public static void unsuccessfulOrderWithMinimumQty(){
        ProductOrder.orderProductWithMinimumQty("http://shop.pragmatic.bg/index.php?route=product/product&product_id=43","1");
        ShoppingCart.verifyMinimumOrderQtyIsMet("Minimum order amount for MacBook is 2!");
    }

}

