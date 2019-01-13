package bigHomework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankPage {
    BaseFunc baseFunc;
    private By BANK_DATE = By.id("date2");
    private By DROPDOWN = By.xpath(".//*[@id='currency_name']/option");
    private By SUMMA = By.id("summa");
    private By CONVERT_BTN = By.id("convert");
    private By RESULT = By.id("currency_show");

    public BankPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getBankPageDate() {
        String bankDate = baseFunc.getElement(BANK_DATE).getAttribute("value");
        String[] formattedBankDate = bankDate.split("\\.");
        String finalBankDate = formattedBankDate[2] + "-" + formattedBankDate[1] + "-" + formattedBankDate[0];
        return finalBankDate;
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

    public Map<List, List> getCurrencyValues() {
        Map<List, List> currency = new HashMap<List, List>();
        List<WebElement> wValues = baseFunc.getElements(DROPDOWN);
        List<String> key = new ArrayList<String>();
        List<String> value = new ArrayList<String>();
        for (WebElement option : wValues) {
            key.add(option.getAttribute("value"));
        }
        for (WebElement type : wValues) {
            value.add(type.getText());
        }
        currency.put(key, value);
        return currency;
    }
}
