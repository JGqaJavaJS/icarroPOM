package pages;

import config.AppiumConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumConfig.getDriver()), this);
    }

    public String getText(MobileElement element, int time) {
        wait(element, time);
        return element.getText().trim().toUpperCase();
    }

    public void click(MobileElement element, int time) {
        wait(element, time);
        element.click();
    }

    public void typeText(MobileElement element, String text, int time) {
        wait(element, time);
        click(element, time);
        element.clear();
        element.sendKeys(text);
        AppiumConfig.getDriver().hideKeyboard(); // driver.hideKeyboard();
    }

    private void wait(MobileElement element, int time) {
        new WebDriverWait(AppiumConfig.getDriver(), time)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void clickBackBTNPhone() {
        AppiumConfig.getDriver().navigate().back();
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

}
