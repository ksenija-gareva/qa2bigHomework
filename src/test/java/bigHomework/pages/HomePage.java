package bigHomework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    BaseFunc baseFunc;

    private By EXCHANGE = By.xpath(".//a[@class='nav ml-4']");
    private By COOKIES = By.xpath(".//a[@class='close cookie']");

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

    }

    public CurrencyPage getCurrencyTab(String name) {
        List<WebElement> tabs = baseFunc.getElements(EXCHANGE);
        for (WebElement tab : tabs) {
            if (tab.findElement(EXCHANGE).getText().contains(name)) {
                tab.click();
                return new CurrencyPage(baseFunc);
            }
        }
        return null;
    }

}
