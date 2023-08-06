package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SplashPage extends BasePage{
    public SplashPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/textView']")
    MobileElement widgetTextView;

    public String getTextTitle2() {
        return getText(widgetTextView);
    }
}
