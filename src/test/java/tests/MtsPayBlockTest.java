package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PaySection;
import pages.PaymentFrame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsPayBlockTest {
    private static WebDriver driver;
    PaySection paySection;
    PaymentFrame paymentFrame;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        paySection = new PaySection(driver);
        paymentFrame = new PaymentFrame(driver);
        paySection.acceptCookies(5);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Проверить название блока 'Онлайн пополнение без комиссии'")
    public void testBlockTitle() {
        String actualTitle = paySection.getBlockTitle();
        assertEquals("Онлайн пополнение без комиссии", actualTitle);
    }

    @Test
    @DisplayName("Проверить наличие логотипов платёжных систем")
    public void testPaymentSystemLogos() {
        int logosCount = paySection.getPaymentSystemLogosCount();
        assertEquals(5, logosCount);
    }

    @Test
    @DisplayName("Проверить работу ссылки 'Подробнее о сервисе'")
    public void testMoreInfoLink() {
        paySection.clickMoreInfoLink();
        paySection.waitForExactUrl(PaySection.LINK_INFO_URL, 10);
        assertEquals(PaySection.LINK_INFO_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Проверить placeholder для незаполненных полей всех вариантов оплаты")
    public void testPlaceholders() {

        paySection.selectHeader("Услуги связи");
        assertEquals("Номер телефона", paySection.getConnectionPhonePlaceholder());
        assertEquals("Сумма", paySection.getConnectionSumPlaceholder());
        assertEquals("E-mail для отправки чека", paySection.getConnectionEmailPlaceholder());

        paySection.selectHeader("Домашний интернет");
        assertEquals("Номер абонента", paySection.getInternetPhonePlaceholder());
        assertEquals("Сумма", paySection.getInternetSumPlaceholder());
        assertEquals("E-mail для отправки чека", paySection.getInternetEmailPlaceholder());

        paySection.selectHeader("Рассрочка");
        assertEquals("Номер счета на 44", paySection.getInstalmentScorePlaceholder());
        assertEquals("Сумма", paySection.getInstalmentSumPlaceholder());
        assertEquals("E-mail для отправки чека", paySection.getInstalmentEmailPlaceholder());

        paySection.selectHeader("Задолженность");
        assertEquals("Номер счета на 2073", paySection.getArrearsScorePlaceholder());
        assertEquals("Сумма", paySection.getArrearsSumPlaceholder());
        assertEquals("E-mail для отправки чека", paySection.getArrearsEmailPlaceholder());
    }

    @Test
    @DisplayName("Заполнить 'Услуги связи', проверить оплату")
    public void testFormSubmitAndPaymentFrame() {

        paySection.selectHeader("Услуги связи");

        paySection.fillConnectionForm("297777777", "10");
        paySection.submitButtonClick();

        paySection.switchToPaymentFrame();

        paySection.acceptCookies(5);

        assertEquals("10.00 BYN", paymentFrame.getPayDscrtnCost());
        assertTrue(paymentFrame.getPayDscrtnText().contains("297777777"));

        assertEquals("Номер карты", paymentFrame.getCardNumberPlaceholder());
        assertEquals("Срок действия", paymentFrame.getExpDateField());
        assertEquals("CVC", paymentFrame.getCvcField());
        assertEquals("Имя и фамилия на карте", paymentFrame.getHolderField());

        assertEquals(5, paymentFrame.getCardsBrandsCount());

        assertEquals("Оплатить 10.00 BYN", paymentFrame.getButtonPayText());
    }
}
