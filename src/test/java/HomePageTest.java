import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomePageTest {


    BaseTest baseTest = new BaseTest();
    ChromeDriver driver;

    @BeforeClass
    public void setUp() {
        driver = baseTest.setUp("https://www.worldmarket.com");
    }


    @Test(priority = 1)
    public void verifyThatClickingXButtonIsCloseSignUpModal() {
        WebElement closeButton = driver.findElement(By.xpath("//*[@id='cpwm-additionaldisclaimer3']/button"));
        closeButton.click();
    }

    @Test(priority = 2)
    public void verifyThatHomeScreenIsOpenedSuccessfully() {
        WebElement heroSection = driver.findElement(By.id("slider-container"));
        assertTrue(heroSection.isDisplayed());
    }

    @Test(priority = 3)
    public void verifyThatKitchenButtonIsDisplayed() {
        //ml-accessible-megamenu-kitchen-1
        WebElement kitchenButton = driver.findElement(By.xpath("//*[@id='ml-accessible-megamenu-kitchen-1']"));
        assertTrue(kitchenButton.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}