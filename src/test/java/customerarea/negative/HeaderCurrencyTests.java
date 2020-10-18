package customerarea.negative;

import adminarea.core.BaseTest;
import components.HeaderCurrency;
import org.testng.annotations.Test;

public class HeaderCurrencyTests extends BaseTest {

    @Test
    public void unsuccessfulCurrencyChange(){
        HeaderCurrency.navigate("http://shop.pragmatic.bg/");
        HeaderCurrency.currencySelect("BGN");
    }

}
