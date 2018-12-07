package bigHomework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    BaseFunc baseFunc;

    private By COOKIES = By.xpath(".//a[@class='close cookie']");
//    private By TABS = By.xpath(".//a[@class='headerSeparatedNavLink']");
    private By TABS = By.xpath(".//nav[@class='nav ml-4']//span");


    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

    }

    public void acceptCookies() {
        baseFunc.waitForElement(COOKIES);
        baseFunc.getElement(COOKIES).click();
    }

    public CurrencyPage getTabByName(String name) {
        List<WebElement> tabs = baseFunc.getElements(TABS);
        for (WebElement tab : tabs) {
            if (tab.findElement(TABS).getText().contains(name)) {
                tab.click();
                return new CurrencyPage(baseFunc);
            }
        }
        return null;
    }

}
