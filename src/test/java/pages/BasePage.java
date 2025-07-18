package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private final By cookieBannerButton = By.id("cookie-agree");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriverWait getWait(int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        WebElement element = getWait(5).until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public void acceptCookies(int timeoutSeconds) {
        try {
            WebElement acceptCookiesBtn = getWait(timeoutSeconds).until(ExpectedConditions.elementToBeClickable(cookieBannerButton));
            acceptCookiesBtn.click();
        } catch (Exception ignored) {
        }
    }

    public void waitForExactUrl(String expectedUrl, int timeoutSeconds) {
        getWait(timeoutSeconds).until(ExpectedConditions.urlToBe(expectedUrl));
    }

    public String getText(By locator) {
        return getWait(5).until(
                ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public String getPlaceholder(By locator) {
        return driver.findElement(locator).getAttribute("placeholder");
    }
}