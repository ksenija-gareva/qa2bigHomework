package bigHomework.pages;

import org.junit.jupiter.api.Test;

public class CurrencyTest {
    BaseFunc baseFunc = new BaseFunc();
        private String BANK_PAGE = "www.bank.lv/statistika/valutu-kursi/aktualie";
        private String DELFI_PAGE = "www.rus.delfi.lv";

        @Test
        public void checkDate() {
            baseFunc.goToPage(DELFI_PAGE);
            baseFunc.goToPage(BANK_PAGE);

            HomePage homePage = new HomePage(baseFunc);
            homePage.getCurrencyTab("Валюта");

            BankPage bankPage = new BankPage(baseFunc);
            bankPage.getBankPageDate("02.12.2018");

            CurrencyPage currencyPage = new CurrencyPage(baseFunc);
            currencyPage.getDelfiDate("2018-12-02");
        }
}