package bigHomework.pages;

import org.openqa.selenium.By;

public class BankPage {
    BaseFunc baseFunc;
    private By BANK_DATE = By.id("date2");
    private By DROPDOWN = By.id("currency_name");
    private By SUMMA = By.id("summa");
    private By CONVERT_BTN = By.id("convert");
    private By RESULT = By.id("currency_show");

    public BankPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void getBankPageDate() {
        baseFunc.getElement(BANK_DATE).getAttribute("value");
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

    public boolean getResult(String name) {
       return baseFunc.getElement(RESULT).getText().contains(name);
    }
}
