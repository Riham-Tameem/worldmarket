import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchTest {


    BaseTest baseTest = new BaseTest();
    ChromeDriver driver;

    @BeforeClass
    public void setUp() {
        driver = baseTest.setUp("https://www.worldmarket.com/");
    }

    @Test(priority = 1)
    public void verifyThatClickingXButtonIsCloseSignUpModal() {
        WebElement closeButton = driver.findElement(By.xpath("//*[@id='cpwm-additionaldisclaimer3']/button"));
        closeButton.click();
    }

    @Test(priority = 2)
    public void verifyThatSearchInputIsDisplayed() {
        WebElement navsearchbox = driver.findElement(By.id("navsearchbox"));
        assertTrue(navsearchbox.isDisplayed());
    }

    @Test(priority = 3)
    public void verifyThatSearchForSaltCandle() {
        WebElement navsearchbox = driver.findElement(By.id("navsearchbox"));
        BaseTest.wait.until(ExpectedConditions.elementToBeClickable(navsearchbox));
        navsearchbox.sendKeys(TestData.SerchData.name);
        WebElement searchBtn = driver.findElement(By.id("searchBtn"));
        BaseTest.wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        driver.manage().deleteAllCookies();
        searchBtn.click();
    }

    @Test(priority = 4)
    public void verifyThatSaltCandlePageIsOpended() {
        WebElement searchHeader = driver.findElement(By.xpath("//*[@id='catalogResult']/div[2]/div[1]"));
        assertTrue(searchHeader.isDisplayed());

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
