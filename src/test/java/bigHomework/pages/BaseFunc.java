package bigHomework.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseFunc {

    WebDriver driver;

    public BaseFunc() {
        System.setProperty("webdriver.gecko.driver", "/Users/ksenijagareva/Desktop/QA/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public void goToPage(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }
    public List<WebElement> getElements (By locator) {
        Assertions.assertFalse(getElement(locator).isDisplayed(), "Error 404, element not found");
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator) {
        Assertions.assertFalse(getElements(locator).isEmpty(), "There are no elements!");
        return driver.findElement(locator);

    }

    public void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void sendKey(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void selectFromDropdown(By locator, String text) {
        Select dropdown = new Select(getElement(locator));
        dropdown.selectByVisibleText(text);
    }

    public void closeDriver() {
        driver.close();
    }
}
