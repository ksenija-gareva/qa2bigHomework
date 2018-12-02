package bigHomework.pages;

import org.openqa.selenium.By;

public class CurrencyPage {
    BaseFunc baseFunc;
    private By DELFI_DATE = By.id("dp1543760512948");
    private By DROPDOWN_CURRENCY = By.xpath(".//select[@name='currency']");
    private By DROPDOWN_HOW = By.xpath(".//select[@name='euro']");
    private By SUMMA = By.xpath(".//input[@name='amount']");
    private By SUMBIT_BTN = By.xpath(".//input[contains(@class, 'currency-submit')]");

    public CurrencyPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void getDelfiDate(String text) {
        baseFunc.getElement(DELFI_DATE).getAttribute(text);
    }
}
