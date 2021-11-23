package hotDeals;

import browserTesting.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class HotDealsTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverClick(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        verifyText("Sale",getTextFromElement(By.xpath("//h1[@id='page-title']")),"Error-Message not displayed");
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Name A - Z']"));
        verifyText("Name A - Z",getTextFromElement(By.xpath("//span[contains(text(),'Name A - Z')]")),"Error-Message not displayed");
    }
    @Test
    public void verifySaleProductsArrangeLowToHigh() throws InterruptedException {
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverClick(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        verifyText("Sale",getTextFromElement(By.xpath("//h1[@id='page-title']")),"Error-Message not displayed");
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Price Low - High']"));
        verifyText("Price Low - High",getTextFromElement(By.xpath("//span[contains(text(),'Price Low - High')]")),"Error-Message not displayed");
    }
    @Test
    public void verifySaleProductsArrangeByRates() throws InterruptedException {
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverClick(By.xpath("(//span[contains(text(),'Sale')])[2]"));
        verifyText("Sale",getTextFromElement(By.xpath("//h1[@id='page-title']")),"Error-Message not displayed");
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Rates']"));
        verifyText("Rates",getTextFromElement(By.xpath("//span[contains(text(),'Rates')]")),"Error-Message not displayed");
    }
    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyText("Bestsellers",getTextFromElement(By.xpath("//h1[@id='page-title']")),"Error-Message not displayed");
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("(//a[normalize-space()='Name Z - A'])[1]"));
        verifyText("Name Z - A",getTextFromElement(By.xpath("//span[contains(text(),'Name Z - A')]")),"Error-Message not displayed");
    }
    @Test
    public void verifyBestSellersProductsArrangeHighToLow() throws InterruptedException {
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyText("Bestsellers",getTextFromElement(By.xpath("//h1[@id='page-title']")),"Error-Message not displayed");
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Price High - Low']"));
        verifyText("Price High - Low",getTextFromElement(By.xpath("//span[contains(text(),'Price High - Low')]")),"Error-Message not displayed");
    }
    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        mouseHoverOnly(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"));
        mouseHoverClick(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        verifyText("Bestsellers",getTextFromElement(By.xpath("//h1[@id='page-title']")),"Error-Message not displayed");
        mouseHoverOnly(By.xpath("//span[@class='sort-by-label']"));
        mouseHoverClick(By.xpath("//a[normalize-space()='Rates']"));
        verifyText("Rates",getTextFromElement(By.xpath("//span[contains(text(),'Rates')]")),"Error-Message not displayed");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}

