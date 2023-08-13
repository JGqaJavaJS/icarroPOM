package pages;

import dto.UserDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editLoginEmail']")
    MobileElement inputEmail;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editLoginPassword']")
    MobileElement inputPassword;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/loginBtn']")
    MobileElement btnYalla;

    public void fillLoginForm(UserDTO userDTO) {
        wait(inputPassword, 10);
        typeText(inputEmail, userDTO.getEmail());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        typeText(inputPassword, userDTO.getPassword());
        click(btnYalla);
    }
}
