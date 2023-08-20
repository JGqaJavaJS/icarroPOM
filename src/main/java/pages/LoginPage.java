package pages;

import dto.UserDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editLoginEmail']")
    MobileElement inputEmail;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editLoginPassword']")
    MobileElement inputPassword;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/loginBtn']")
    MobileElement btnYalla;

    @FindBy(xpath = "//*[@resource-id='android:id/message']")
    MobileElement messagePopUpError;
    // Login or Password incorrect

    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement btnOkPopUpError;

    public SearchPage fillLoginForm(UserDTO userDTO) {
        typeText(inputEmail, userDTO.getEmail(), 15);
        typeText(inputPassword, userDTO.getPassword(), 15);
        click(btnYalla, 15);
        return new SearchPage();
    }

    public boolean validatePopUpErrorMessage() {
        String expectedResult = "Login or Password incorrect".toUpperCase();
        String actualResult = getText(messagePopUpError, 15);
        if(expectedResult.equals(actualResult)) {
            return true;
        } else {
            System.out.println("Expected result: " + expectedResult +
                    " actual result: " + actualResult);
            return false;
        }
    }

    public boolean isPopUpErrorOpen() {
        try {
            boolean b = isElementDisplayed(messagePopUpError);
            return b;
        } catch (Exception e){
            return false;
        }
    }

    public LoginPage clickOkPopUp() {
        click(btnOkPopUpError, 15);
        return this;
    }

}
