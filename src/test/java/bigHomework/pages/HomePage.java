package bigHomework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    BaseFunc baseFunc;

    private By COOKIES = By.xpath(".//a[@class='close cookie']");
//    private By TABS = By.xpath(".//a[@class='headerSeparatedNavLink']");
//    private By TABS = By.xpath(".//nav[@class='nav ml-4']//span");
    private By TABS = By.xpath(".//a[contains(@class, 'pr-1')]");


    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

    }

    public void acceptCookies() {
        baseFunc.waitForElement(COOKIES);
        baseFunc.getElement(COOKIES).click();
    }

    public CurrencyPage getTabByCount() {
        List<WebElement> tabs = baseFunc.getElements(TABS);
        tabs.get(1).click();
        return new CurrencyPage(baseFunc);
    }
}
