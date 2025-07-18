package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PaymentFrame extends BasePage {
    private final By payDscrtnCost = By.xpath("//div[contains(@class, 'pay-description__cost')]/span");
    private final By payDscrtnText = By.xpath("//span[contains(text(), '297777777')]");
    private final By buttonPay = By.xpath("//button[normalize-space()='Оплатить 10.00 BYN']");

    private final By cardNumber = By.xpath("//div[input[@id = 'cc-number']]/label");
    private final By expDateField = By.xpath("//div[input[@placeholder='MM / YY']]/label");
    private final By cvcField = By.xpath("//label[text()='CVC']");
    private final By holderField = By.xpath("//label[text()='Имя и фамилия на карте']");
    private final By cardsBrands = By.className("cards-brands__container");

    public PaymentFrame(WebDriver driver) {
        super(driver);
    }

    public String getPayDscrtnCost() {
        return getText(payDscrtnCost);
    }

    public String getPayDscrtnText() {
        return getText(payDscrtnText);
    }

    public String getButtonPayText() {
        return getText(buttonPay);
    }

    public String getCardNumberPlaceholder() {
        return getText(cardNumber);
    }

    public String getExpDateField() {
        return getText(expDateField);
    }

    public String getCvcField() {
        return getText(cvcField);
    }

    public String getHolderField() {
        return getText(holderField);
    }

    public int getCardsBrandsCount() {
        WebElement container = getWait(5).until(ExpectedConditions.visibilityOfElementLocated(cardsBrands));
        List<WebElement> icons = container.findElements(By.tagName("img"));
        return icons.size();
    }
}
