package bigHomework.pages;

import org.openqa.selenium.By;

public class BankPage {
    BaseFunc baseFunc;
    private By BANK_DATE = By.id("date2");
    private By DROPDOWN = By.id("currency_name");
    private By SUMMA = By.id("summa");
    private By CONVERT_BTN = By.id("convert");

    public BankPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void getBankPageDate(String text) {
        baseFunc.getElement(BANK_DATE).getAttribute(text);
    }

    public void selectCurrencyType(String currency) {
        baseFunc.selectFromDropdown(DROPDOWN, currency);
    }

    public void inputSumma(String summa) {
        baseFunc.sendKey(SUMMA, summa);
    }

    public void clickConvertButton() {
        baseFunc.getElement(CONVERT_BTN).click();
    }
}
