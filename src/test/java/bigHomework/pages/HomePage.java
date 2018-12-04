package bigHomework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    BaseFunc baseFunc;

    private By CURRENCY = By.xpath(".//a[@class='headerSeparatedNavLink']");
    private By COOKIES = By.xpath(".//a[@class='close cookie']");

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

    }

    public void acceptCookies() {
        baseFunc.waitForElement(COOKIES);
        baseFunc.getElement(COOKIES).click();
    }

    public CurrencyPage getCurrencyTab(String title) {
        List<WebElement> tabs = baseFunc.getElements(CURRENCY);
        for (WebElement tab : tabs) {
            if (tab.findElement(CURRENCY).getText().contains(title)) {
                tab.click();
                return new CurrencyPage(baseFunc);
            }
        }
        return null;
    }

}
