package bigHomework.pages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CurrencyTest {
    BaseFunc baseFunc = new BaseFunc();
        private String BANK_PAGE = "www.bank.lv/statistika/valutu-kursi/aktualie";
        private String DELFI_PAGE = "www.rus.delfi.lv";

        @Test
        public void checkDate() {
            String today = baseFunc.now();

            baseFunc.goToPage(DELFI_PAGE);
            HomePage homePage = new HomePage(baseFunc);

            homePage.acceptCookies();
            homePage.getTabByCount();

            CurrencyPage currencyPage = new CurrencyPage(baseFunc);

            String delfiDate = currencyPage.getDelfiDate();

            currencyPage.selectCurrencyType("CAD");
            currencyPage.selectHowToConvert("from");
            currencyPage.inputSumma("66.13");

            currencyPage.clickConvertButton();

            String delfiResult = currencyPage.getResult();
            Assertions.assertEquals(today, delfiDate, "Date is different");

            baseFunc.goToPage(BANK_PAGE);
            BankPage bankPage = new BankPage(baseFunc);

            String bankDate = bankPage.getBankPageDate();

            bankPage.getCurrencyValues("CAD");
            bankPage.inputSumma("66.13");

            bankPage.clickConvertButton();

            String bankResult = bankPage.getResult();
            Assertions.assertEquals(today, bankDate, "Date is different");

            Assertions.assertEquals(delfiResult, bankResult, "Result is different");

            baseFunc.closeDriver();
        }
}
