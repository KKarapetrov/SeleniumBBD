package bg.pragmatic.shop.BDD;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.Browser;

import java.util.concurrent.TimeUnit;

public class ShopPragmaticStepDefinition {

    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RoaMingOne\\ChromeDriver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Given("the admin on the main page of shop.pragmatic.bg admin log in screen")
    public void the_Admin_On_The_Main_Page_Of_Shop_Pragmatic_Bg_Admin_Log_In_Screen() {
        driver.get("http://shop.pragmatic.bg/admin");
    }

    @When("he enters {string} as a username")
    public void he_Enters_As_A_Username(String userName) {
        driver.findElement(By.id("input-username")).sendKeys(userName);
    }

    @And("he enters {string} as a password")
    public void he_Enters_As_A_Password(String password) {
        driver.findElement(By.id("input-password")).sendKeys(password);
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @And("he navigates to the Marketing section of the admin dashboard")
    public void he_Navigates_To_The_Marketing_Section_Of_The_Admin_Dashboard() {
        driver.findElement(By.id("menu-marketing")).click();
        driver.findElement(By.cssSelector("li#menu-marketing li:nth-of-type(2)")).click();
    }

    @And("creates a coupon with coupon name {string}")
    public void creates_A_Coupon_With_Coupon_Name(String couponName) {
        driver.findElement(By.cssSelector("div.pull-right>a.btn")).click();
        driver.findElement(By.id("input-name")).sendKeys(couponName);
    }

    @And("enters as coupon code {string}")
    public void enters_As_Coupon_Code(String couponCode) {
        driver.findElement(By.id("input-code")).sendKeys(couponCode);
    }

    @And("enters discount amount {string}")
    public void enters_Discount_Amount(String discountAmount) {
        driver.findElement(By.id("input-discount")).sendKeys(discountAmount);
    }

    @And("enters total discount amount {string}")
    public void enters_Total_Discount_Amount(String totalDiscount) {
        driver.findElement(By.id("input-total")).sendKeys(totalDiscount);
    }

    @And("presses the save button")
    public void presses_The_Save_button(){
        driver.findElement(By.cssSelector("div.pull-right>button")).click();
    }

    @Then("ensure that the coupon was created with message {string}")
    public void ensure_That_The_Coupon_Was_Created_With_Message(String expectedMessageOnSuccessfulCreation) {
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-success")).getText().contains(expectedMessageOnSuccessfulCreation));
    }

    @Given("the user is on the product page with URL {string}")
    public void the_User_Is_On_The_Product_Page_With_URL(String productURL) {
        driver.get(productURL);
    }

    @When("enters quantity {string} which is less than the specified minimum ordering quantity")
    public void enters_Quantity_WhichIs_Less_Than_The_Specified_Minimum_Ordering_Quantity(String orderQuantity) {
        WebElement orderedQty = driver.findElement(By.id("input-quantity"));
        orderedQty.clear();
        orderedQty.sendKeys(orderQuantity);
    }

    @And("adds the product to their cart")
    public void adds_The_Product_To_Their_Cart() {
        driver.findElement(By.id("button-cart")).click();
    }

    @And("goes to their shopping cart")
    public void goes_To_Their_Shopping_Cart() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert-success")));
        driver.findElement(By.cssSelector("div.alert-success>a:nth-of-type(2)")).click();
    }

    @Then("ensure that the warning message {string}")
    public void ensure_That_The_Warning_Message(String expectedMinimumOrderQtyAlertMessage) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert-danger")));
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-danger")).getText().contains(expectedMinimumOrderQtyAlertMessage), "Order was placed without meeting the minimum order quantity, this is a BUG");
    }


    @Given("the user is on the main page of {string}")
    public void the_User_Is_On_The_Main_Page_Of(String URL) {
        driver.get(URL);
    }

    @When("the user selects the {string} option on the currency component")
    public void selects_The_The_Option_On_The_Currency_Component(String desiredCurrency) {
        driver.findElement(By.cssSelector("div.btn-group>button.btn-link")).click();
        driver.findElement(By.name(desiredCurrency)).click();
    }

    @Then("ensure that the currency has been changed to {string}")
    public void ensure_That_The_Currency_Has_Been_Changed_To(String expectedCurrency) {
        Assert.assertTrue(driver.findElement(By.cssSelector("div.btn-group>button.btn-link")).getText().contains(expectedCurrency), "Desired Currency has not been applied correctly");
    }


    @Then("ensure error message {string} warning there is already such a coupon")
    public void ensureErrorMessageWarningThereIsAlreadySuchACoupon(String expectedWarningForDuplicateCoupon) {
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert")).getText().contains(expectedWarningForDuplicateCoupon), "Duplicate coupon has been created, this is a BUG");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
