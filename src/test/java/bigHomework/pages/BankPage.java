package bigHomework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class BankPage {
    BaseFunc baseFunc;
    private By BANK_DATE = By.id("date2");
    private By SELECT = By.id("currency_name");
    private By DROPDOWN = By.xpath(".//*[@id='currency_name']/option");
    private By SUMMA = By.id("summa");
    private By CONVERT_BTN = By.id("convert");
    private By RESULT = By.xpath(".//*[@id='result']");

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

    public String getResult() {
       String result = baseFunc.getElement(RESULT).getText();
        return result;
    }

    public void getCurrencyValues(String currencyType) {
        baseFunc.waitForElement(DROPDOWN);
        List<WebElement> wValues = baseFunc.getElements(DROPDOWN);
        String textToSelect = "";
        for (WebElement we : wValues) {
            if (we.getText().contains(currencyType)) {
                textToSelect = we.getText();
                break;
            }
        }
        Select select = new Select(baseFunc.getElement(SELECT));
        select.selectByVisibleText(textToSelect);
    }

}
