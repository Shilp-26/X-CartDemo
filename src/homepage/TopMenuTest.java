package homepage;

import browserTesting.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully(){
        clickOnElement(By.xpath("(//span[contains(text(),'Shipping')])[2]"));
        verifyText("Shipping",getTextFromElement(By.xpath("//h1[@id='page-title']")),"Error-Message not displayed");
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully(){
        clickOnElement(By.xpath("(//span[contains(text(),'New!')])[2]"));
        verifyText("New arrivals",getTextFromElement(By.xpath("//h1[@id='page-title']")),"Error-Message not displayed");
    }
    @Test
    public void verifyUserShouldNavigateToComingSoonPageSuccessfully(){
        clickOnElement(By.xpath("(//span[contains(text(),'Coming soon')])[2]"));
        verifyText("Coming soon",getTextFromElement(By.xpath("//h1[@id='page-title']")),"Error-Message not displayed");
    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
        clickOnElement(By.xpath("(//span[contains(text(),'Contact us')])[2]"));
        verifyText("Contact us",getTextFromElement(By.xpath("//h1[@id='page-title']")),"Error-Message not displayed");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }




}
