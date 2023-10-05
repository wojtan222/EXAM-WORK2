package pl.coderslab.shop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopSteps {
    private static WebDriver driver;
    public String totalPriceBeforeSubmittingText;

    @Given("the user opens a web browser and navigates to the main page")
    public void theUserOpensAWebBrowserAndNavigatesToTheMainPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://mystore-testlab.coderslab.pl");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }


    @When("the user logs in with their email and password")
    public void theUserEntersTheirEmailAndPassword() {
        driver.findElement(By.cssSelector("#_desktop_user_info a")).click();
        driver.findElement(By.id("field-email")).sendKeys("wojtektest@wp.pl");
        driver.findElement(By.id("field-password")).sendKeys("test123");
        driver.findElement(By.id("submit-login")).click();
    }


    @And("the user searches for the desired product")
    public void theUserLocatesTheDesiredProduct() {
        WebElement product = driver.findElement(By.className("ui-autocomplete-input"));
        product.sendKeys("Hummingbird Printed Sweater");
        product.submit();
        driver.findElement(By.xpath("//a//img[@alt='Brown bear printed sweater']")).click();
    }

    @And("the user selects the product's size and quantity")
    public void theUserSelectsTheSizeAndQuantityOfTheProduct() {
        driver.findElement(By.id("quantity_wanted")).clear();
        driver.findElement(By.id("quantity_wanted")).sendKeys("5");
        driver.findElement(By.xpath("//div//select//option[@title='M']")).click();
    }

    @And("the user adds the product to the shopping cart")
    public void theUserAddsTheProductToTheShoppingCart() {
        {
            driver.findElement(By.cssSelector("button.btn.btn-primary.add-to-cart[type='submit']")).click();

        }
    }

    @And("the user proceeds to the checkout section")
    public void theUserProceedsToTheCheckoutSection() {
        driver.findElement(By.xpath("//*[contains(text(),\"Proceed to checkout\")]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[contains(text(),\"Proceed to checkout\")]")).click();
    }

    @And("the user verifies the shipping address")
    public void theUserVerifiesTheShippingAddress() {
        driver.findElement(By.xpath("//div//button[@name='confirm-addresses']")).click();
    }

    @And("the user selects the payment and delivery method")
    public void theUserChoosesThePaymentAndDeliveryMethod() {
        driver.findElement(By.id("delivery_option_6")).click();
        driver.findElement(By.name("confirmDeliveryOption")).click();
        driver.findElement(By.id("payment-option-1")).click();
        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
        driver.findElement(By.xpath("//*[contains(text(),\"Place order\")]")).click();

    }

    @Then("I take a screenshot of order details")
    public void iTakeAScreenshotOfOrderDetails() throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("SSSssmmHHddMMyyyy");
        String timestamp = dateFormat.format(new Date());
        String orderDetails = "orderdetails_" + timestamp + ".png";
        WebElement orderDetailsPartOfThePage = driver.findElement(By.id("content-wrapper"));
        File orderDetailsPartOfThePageScreenshot = orderDetailsPartOfThePage.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(orderDetailsPartOfThePageScreenshot, new File("C:\\CodersLab\\EXAM-WORK2\\Screenshots" + orderDetails));
    }

    @And("the user closes the web browser")
    public void theUserClosesTheWebBrowser() {
        driver.quit();
    }


}

