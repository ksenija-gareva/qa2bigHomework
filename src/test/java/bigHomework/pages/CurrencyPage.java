package bigHomework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.util.*;

public class CurrencyPage {
    BaseFunc baseFunc;
    private By DELFI_DATE = By.xpath(".//input[@name='date']");
    private By DROPDOWN_CURRENCY = By.xpath(".//select[@name='currency']");
    private By DROPDOWN_HOW = By.xpath(".//select[@name='euro']");
    private By SUMMA = By.xpath(".//input[@name='amount']");
    private By SUMBIT_BTN = By.xpath(".//input[contains(@class, 'btn-porcelain')]");
    private By RESULT = By.xpath(".//span[contains(@class, 'text-size-30')]");

    public CurrencyPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }


    public String getDelfiDate() {
        return baseFunc.getElement(DELFI_DATE).getAttribute("placeholder");
    }

    public void selectCurrencyType(String currency) {
        baseFunc.selectFromDropdown(DROPDOWN_CURRENCY, currency);
    }

    public void selectHowToConvert(String convertion) {
        baseFunc.selectFromDropdown(DROPDOWN_HOW, convertion);

    }

    public void inputSumma(String text) {
        baseFunc.sendKey(SUMMA, text);
    }

    public void clickConvertButton() {
        baseFunc.getElement(SUMBIT_BTN).click();
    }

    public String getResult() {
        String result = baseFunc.getElement(RESULT).getText();
        result.replace(",", ".");
        return result;
    }


}
