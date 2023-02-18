import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class KitchenPageTest {

    BaseTest baseTest = new BaseTest();
    ChromeDriver driver;

    @BeforeClass
    public void setUp() {
        driver = baseTest.setUp("https://www.worldmarket.com/category/kitchen.do");
    }

    @Test(priority = 1)
    public void verifyThatClickingXButtonIsCloseSignUpModal() {
        WebElement closeButton = driver.findElement(By.xpath("//*[@id='cpwm-additionaldisclaimer3']/button"));
        closeButton.click();
    }

    @Test(priority = 2)
    public void verifyThatClickingkitchenButtonOpenskitchenPage() {
        WebElement kitchenButton = driver.findElement(By.xpath("//*[@id='ml-accessible-megamenu-kitchen-1']"));
        BaseTest.wait.until(ExpectedConditions.elementToBeClickable(kitchenButton));
        kitchenButton.click();
        WebElement kitchenimage = driver.findElement(By.id("gateway_leftnav_4_fillslot-1"));
        assertTrue(kitchenimage.isDisplayed());
    }

    @Test(priority = 3)
    public void verifyThatNewKitchenButtonIsDisplayed() {
        WebElement newkitchenButton = driver.findElement(By.xpath("//*[@id='ml-body-container']/main/div[3]/div/div[1]/div[2]/div[2]/div[6]/ul/li[2]/a"));
        assertTrue(newkitchenButton.isDisplayed());
    }
  /*  @Test(priority = 4)
        public void verifyThatClickingkitchenButtonOpenskitchenPage() {
            WebElement kitchenButton = Setup.driver.findElement(By.xpath("//*[@id='ml-accessible-megamenu-kitchen-1']"));
            kitchenButton.click();
            WebElement kitchenimage = Setup.driver.findElement(By.id("gateway_leftnav_4_fillslot-1"));
            assertTrue(kitchenimage.isDisplayed());
        }
*/

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


