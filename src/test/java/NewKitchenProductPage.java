import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NewKitchenProductPage {
    BaseTest baseTest = new BaseTest();
    ChromeDriver driver;

    @BeforeClass
    public void setUp() {
        driver = baseTest.setUp("https://www.worldmarket.com/category/kitchen/new.do");
    }

    @Test(priority = 1)
    public void verifyThatClickingXButtonIsCloseSignUpModal() {
        WebElement closeButton = driver.findElement(By.xpath("//*[@id='cpwm-additionaldisclaimer3']/button"));
        closeButton.click();
    }

    @Test(priority = 2)
    public void verifyThatNewkitchenPageIsOpenedSuccessfully() {
        WebElement newKitchenheaderElement = driver.findElement(By.xpath("//*[@id='ml-body-container']/main/div[3]/div/div/div/div[3]/h1"));
        assertTrue(newKitchenheaderElement.isDisplayed());
    }


    @Test(priority = 3)
    public void verifyThatElementIsDisplayed() {
        WebElement saltAndPepperElement = driver.findElement(By.xpath("//*[@id=\"ml-grid-view-items\"]/div[2]/div/div[1]/div[2]/div/a"));
        assertTrue(saltAndPepperElement.isDisplayed());
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
