package components;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Browser;

import java.util.List;

public class HeaderCurrency {

    /**
     * Invoking this method will navigate to a desired URL address specified as the parameter
     * @param URL The URL address that needs to be navigated to
     */
    public static void navigate(String URL) {
        Browser.driver.get(URL);
    }

    /**
     * Invoking this method will select a currency option from the currency button and apply it.
     * The method also prints out the selected currency for easier understanding of the result
     * @param desiredCurrency currency to be applied. N.B Always use correct abbreviations of currencies i.e EUR,GBP etc.
     */
    public static void currencySelect(String desiredCurrency){
        try {
            Browser.driver.findElement(By.cssSelector("div.btn-group>button.btn-link")).click();
            if (!desiredCurrency.equals(Browser.driver.findElement(By.name(desiredCurrency))))
                Browser.driver.findElement(By.name(desiredCurrency)).click();
            if (desiredCurrency.equals("EUR")) {
                Assert.assertTrue(Browser.driver.findElement(By.cssSelector("div.btn-group>button.btn-link")).getText().contains("€ Currency"), "Desired Currency has not been applied correctly");
                System.out.println("Currency changed to EUR " + Browser.driver.findElement(By.cssSelector("div.btn-group>button.btn-link")).getText());
            }
            if (desiredCurrency.equals("GBP")) {
                Assert.assertTrue(Browser.driver.findElement(By.cssSelector("div.btn-group>button.btn-link")).getText().contains("£ Currency"), "Desired Currency has not been applied correctly");
                System.out.println("Currency changed to GBP " + Browser.driver.findElement(By.cssSelector("div.btn-group>button.btn-link")).getText());
            }
            if (desiredCurrency.equals("USD")) {
                Assert.assertTrue(Browser.driver.findElement(By.cssSelector("div.btn-group>button.btn-link")).getText().contains("$ Currency"), "Desired Currency has not been applied correctly");
                System.out.println("Currency changed to USD " + Browser.driver.findElement(By.cssSelector("div.btn-group>.btn-link")).getText());
            }
        }catch (org.openqa.selenium.NoSuchElementException nse){
            System.out.println("Currency cannot be set or is not supported");
        }

    }

}
