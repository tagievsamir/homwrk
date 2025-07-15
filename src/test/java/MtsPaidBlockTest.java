//Необходимо написать автотесты для сайта mts.by. Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
//
//Проверить название указанного блока;
//
//Проверить наличие логотипов платёжных систем;
//
//Проверить работу ссылки «Подробнее о сервисе»;
//
//Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер для теста 297777777)

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsPaidBlockTest {
    private static WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement acceptCookiesBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            acceptCookiesBtn.click();
        } catch (TimeoutException e) {
            System.out.println("Cookie banner not found or already accepted.");
        }

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Verify the block title 'Онлайн пополнение без комиссии'")
    public void testBlockTitle() {
        WebElement title = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]"));
        String x = title.getText().replace("\n", " ");
        assertEquals("Онлайн пополнение без комиссии", x);
    }

    @Test
    @DisplayName("Verify the logos of the payment systems")
    public void testPayLogo() {
        List<WebElement> logos = driver.findElements(By.cssSelector(".pay__partners img"));
        assertEquals(5, logos.size());
    }

    @Test
    @DisplayName("Check the functionality of the link 'Подробнее о сервисе'")
    public void testLink() {
        WebElement link = driver.findElement(By.linkText("Подробнее о сервисе"));
        assertTrue(link.isDisplayed());
        assertTrue(link.isEnabled());
        link.click();
        try {
            WebElement acceptCookiesBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            acceptCookiesBtn.click();
        } catch (TimeoutException e) {
            System.out.println("Cookie banner not found or already accepted.");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());

        List<WebElement> headers = driver.findElements(By.tagName("h3"));
        assertEquals("Оплата банковской картой", headers.get(0).getText());
        assertEquals("Информация о безопасности Интернет-платежей", headers.get(1).getText());
        assertEquals("Условия возврата денежных средств", headers.get(2).getText());
    }

    @Test
    @DisplayName("Verify form filling and 'Продолжить' button functionality")
    public void testFormSubmit() {
        WebElement phone = driver.findElement(By.id("connection-phone"));
        phone.click();
        phone.sendKeys("297777777");

        WebElement sum = driver.findElement(By.id("connection-sum"));
        sum.click();
        sum.sendKeys("10");

        WebElement button = driver.findElement(By.cssSelector("#pay-connection button[type='submit']"));
        button.click();

        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe.bepaid-iframe")));
        driver.switchTo().frame(iframe);

        String payDscrtnCost = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'pay-description__cost')]/span"))).getText();
        assertEquals("10.00 BYN", payDscrtnCost);

        String payDscrtnText = driver.findElement(
                By.xpath("//span[contains(text(), '297777777')]")).getText();
        assertTrue(payDscrtnText.contains("297777777"));

        WebElement gPayButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("google-pay-button")));
        assertTrue(gPayButton.isDisplayed());

        WebElement cardNumber = wait.until(ExpectedConditions.elementToBeClickable(By.id("cc-number")));
        assertTrue(cardNumber.isDisplayed());

        WebElement expDateField = wait.until(ExpectedConditions.elementToBeClickable(By.className("date-input")));
        assertTrue(expDateField.isDisplayed());

        WebElement cvcField = wait.until(ExpectedConditions.elementToBeClickable(By.className("cvc-input")));
        assertTrue(cvcField.isDisplayed());

        WebElement holderField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@formcontrolname = 'holder']")));
        assertTrue(holderField.isDisplayed());
    }
}
