package shopping;

import browserTesting.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ShoppingTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForAvengersFabrikationsPlush() throws InterruptedException {

        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverClick(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        verifyText("Sale", getTextFromElement(By.xpath("//h1[@id='page-title']")), "Error-Message not displayed");
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Name A - Z']"));
        mouseHoverOnly(By.xpath("//a[@class='product-thumbnail next-previous-assigned']"));
        Thread.sleep(2000);
        mouseHoverClick(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]//span[contains(text(),'Add to cart')]"));
        verifyText("Product has been added to your cart", getTextFromElement(By.xpath("//li[@class='info']")), "Failed to add");
        clickOnElement(By.xpath("//a[@title='Close']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));
        verifyText("Your shopping cart - 1 item", getTextFromElement(By.xpath("//h1[contains(text(),'Your shopping cart - 1 item')]")), "Error, Message not displayed as expected");
        sendKeysToElement(By.xpath("//input[contains(@id, 'amount16')]"), Keys.BACK_SPACE + "2");
        Thread.sleep(2000);
        verifyText("Your shopping cart - 2 items", getTextFromElement(By.xpath("//h1[contains(text(),'Your shopping cart - 2 item')]")), "Error, Message not displayed as expected");
        verifyText("29", getTextFromElement(By.xpath("//ul[@class='sums']//span[@class='part-integer'][normalize-space()='29']")), "Error, Message not displayed as expected");
        verifyText("98", getTextFromElement(By.xpath("//ul[@class='sums']//span[@class='part-decimal'][normalize-space()='98']")), "Error, Message not displayed as expected");
        verifyText("36", getTextFromElement(By.xpath("//span[normalize-space()='36']")), "Error, Message not displayed as expected");
        verifyText("00", getTextFromElement(By.xpath("//span[normalize-space()='00']")), "Error, Message not displayed as expected");
        clickOnElement(By.xpath("//button[contains(@class,'regular-button regular-main-button checkout')]"));
        verifyText("Log in to your account", getTextFromElement(By.xpath("//h3[contains(text(),'Log in to your account')]")), "Page not found");
        sendTextToElement(By.xpath("//input[@id='email']"), "Prime345@gmail.com");
        clickOnElement(By.xpath("//button[contains(@class,'regular-button anonymous-continue-button submit')]"));
        verifyText("Secure Checkout", getTextFromElement(By.xpath("//h1[normalize-space()='Secure Checkout']")), "Page not founf");
        sendKeysToElement(By.xpath("//input[@id='shippingaddress-firstname']"), "Bob");
        sendKeysToElement(By.xpath("//input[@id='shippingaddress-lastname']"), "Alexa");
        sendKeysToElement(By.xpath("//input[@id='shippingaddress-street']"), "69 Haydon Drive");
        sendKeysToElement(By.xpath("//input[@id='shippingaddress-city']"), Keys.BACK_SPACE + "London");
        selectByVisibleTextFromDropdown(By.xpath("//select[@id='shippingaddress-country-code']"), "United Kingdom");
        sendKeysToElement(By.xpath("//input[@id='shippingaddress-custom-state']"), "London, City of");
        sendKeysToElement(By.xpath("//input[@id='shippingaddress-zipcode']"), Keys.BACK_SPACE + "6");
        clickOnElement(By.xpath("//input[@id='create_profile']"));
        sendKeysToElement(By.xpath("//input[@id='password']"), "abc123");
        clickOnElement(By.xpath("//span[normalize-space()='Local shipping']"));
        clickOnElement(By.xpath("//span[normalize-space()='COD']"));
        verifyText("Place order: $37.03", getTextFromElement(By.xpath("//span[contains(text(),'$37.03')]")), "Error, Message not displayed as expected");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']"));
        Thread.sleep(2000);
        verifyText("Thank you for your order", getTextFromElement(By.xpath("//h1[contains(.,'Thank you for your order')]")), "Error, Message not displayed as expected");
    }
    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyText("Bestsellers", getTextFromElement(By.xpath("//h1[@id='page-title']")), "Error-Message not displayed");
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Name A - Z']"));
        Thread.sleep(3000);
        mouseHoverOnly(By.xpath("//a[@class='product-thumbnail next-previous-assigned']"));
        Thread.sleep(3000);
        mouseHoverClick(By.xpath("//button[contains(@class,'btn  regular-button add-to-cart product-add2cart productid-13')]"));
        verifyText("Product has been added to your cart", getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]")), "Error, Message not displayed");
        clickOnElement(By.xpath("//a[@title='Close']"));
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[@class='regular-button cart']"));
        verifyText("Your shopping cart - 1 item", getTextFromElement(By.xpath("//h1[contains(text(),'Your shopping cart - 1 item')]")), "Error, Message not displayed as expected");
        clickOnElement(By.xpath("//a[normalize-space()='Empty your cart']"));
        Thread.sleep(2000);
        String Message = getTextFromAlert();
        verifyText("Are you sure you want to clear your cart?", Message, "Error, Message not displayed as expected");
        acceptAlert();
        verifyText("Item(s) deleted from your cart", getTextFromElement(By.xpath("//li[contains(.,'Item(s) deleted from your cart')]")), "Error, Message not displayed");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[@title='Close']"));
        Thread.sleep(2000);
        verifyText("Your cart is empty", getTextFromElement(By.xpath("//h1[contains(.,'Your cart is empty')]")), "Error, Message not displayed");

    }

    @After
    public void tearDown(){
        closeBrowser();
    }


}
