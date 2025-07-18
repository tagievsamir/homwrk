package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PaySection extends BasePage {
    private final By blockTitle = By.xpath("//h2[contains(text(), 'Онлайн пополнение')]");
    private final By dropdownButton = By.cssSelector(".select__header");
    private final String optionXpath = "//p[@class='select__option' and text()='%s']";
    //Услуги связи
    private final By connectionPhone = By.id("connection-phone");
    private final By connectionSum = By.id("connection-sum");
    private final By connectionEmail = By.id("connection-email");
    private final By submitButton = By.cssSelector("#pay-connection button[type='submit']");
    private final By paymentFrame = By.cssSelector("iframe.bepaid-iframe");
    //Домашний интернет
    private final By internetPhone = By.id("internet-phone");
    private final By internetSum = By.id("internet-sum");
    private final By internetEmail = By.id("internet-email");
    //Рассрочка
    private final By instalmentScore = By.id("score-instalment");
    private final By instalmentSum = By.id("instalment-sum");
    private final By instalmentEmail = By.id("instalment-email");
    //Задолженность
    private final By arrearsScore = By.id("score-arrears");
    private final By arrearsSum = By.id("arrears-sum");
    private final By arrearsEmail = By.id("arrears-email");

    private By logosLocator = By.cssSelector(".pay__partners img");
    private By moreInfoLink = By.linkText("Подробнее о сервисе");
    public static final String LINK_INFO_URL = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";


    public PaySection(WebDriver driver) {
        super(driver);
    }

    public void selectHeader(String visibleText) {
        click(dropdownButton);
        By header = By.xpath(String.format(optionXpath, visibleText));
        getWait(5).until(ExpectedConditions.visibilityOfElementLocated(header));
        click(header);
    }

    public void clickMoreInfoLink() {
        getMoreInfoLink().click();
    }

    public void fillConnectionForm(String phone, String sum) {
        type(connectionPhone, phone);
        type(connectionSum, sum);
    }

    public void submitButtonClick() {
        click(submitButton);
    }

    public void switchToPaymentFrame() {
        WebElement frame = getWait(5).until(ExpectedConditions.visibilityOfElementLocated(paymentFrame));
        driver.switchTo().frame(frame);
    }

    public String getBlockTitle() {
        return getText(blockTitle).replace("\n", " ");
    }

    public String getConnectionPhonePlaceholder() {
        return getPlaceholder(connectionPhone);
    }

    public String getConnectionSumPlaceholder() {
        return getPlaceholder(connectionSum);
    }

    public String getConnectionEmailPlaceholder() {
        return getPlaceholder(connectionEmail);
    }

    public String getInternetPhonePlaceholder() {
        return getPlaceholder(internetPhone);
    }

    public String getInternetSumPlaceholder() {
        return getPlaceholder(internetSum);
    }

    public String getInternetEmailPlaceholder() {
        return getPlaceholder(internetEmail);
    }

    public String getInstalmentScorePlaceholder() {
        return getPlaceholder(instalmentScore);
    }

    public String getInstalmentSumPlaceholder() {
        return getPlaceholder(instalmentSum);
    }

    public String getInstalmentEmailPlaceholder() {
        return getPlaceholder(instalmentEmail);
    }

    public String getArrearsScorePlaceholder() {
        return getPlaceholder(arrearsScore);
    }

    public String getArrearsSumPlaceholder() {
        return getPlaceholder(arrearsSum);
    }

    public String getArrearsEmailPlaceholder() {
        return getPlaceholder(arrearsEmail);
    }

    public int getPaymentSystemLogosCount() {
        return driver.findElements(logosLocator).size();
    }

    public WebElement getMoreInfoLink() {
        return driver.findElement(moreInfoLink);
    }
}
