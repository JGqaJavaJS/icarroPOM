package pages;

import dto.UserDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegName']")
    MobileElement inputName;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegLastName']")
    MobileElement inputLastName;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegEmail']")
    MobileElement inputEmail;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegPassword']")
    MobileElement inputPassword;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/checkBoxAgree']")
    MobileElement checkBar;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/regBtn']")
    MobileElement btnYalla;

    public SearchPage fillRegistrationForm(UserDTO userDTO) {
        typeText(inputName, userDTO.getName());
        typeText(inputLastName, userDTO.getLastName());
        typeText(inputEmail, userDTO.getEmail());
        typeText(inputPassword, userDTO.getPassword());
        click(checkBar);
        click(btnYalla);
        return new SearchPage();
    }

}
