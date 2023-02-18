import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ProductDetailsPage {
    BaseTest baseTest = new BaseTest();
    ChromeDriver driver;

    @BeforeClass
    public void setUp() {
        driver = baseTest.setUp("https://www.worldmarket.com/product/hand+painted+strawberry+figural+salt+and+pepper+shaker+set.do?sortby=ourPicks&from=fn");
    }



    @Test(priority = 1)
    public void verifyThatProductHeaderElementIsDisplayed() {
        WebElement productHeaderTittle = driver.findElement(By.xpath("//*[@id='mainForm']/div[2]/div/div[2]/h1"));
        assertTrue(productHeaderTittle.isDisplayed());
    }

    @Test(priority = 2)
    public void verifyThatAddToCartButtonIsDisplayed() {
        WebElement addToCart = driver.findElement(By.id("addToBasket462234"));
        assertTrue(addToCart.isDisplayed());
    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
