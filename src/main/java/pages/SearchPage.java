package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/findTitle']")
    MobileElement title;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editLocation']")
    MobileElement inputLocation;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editFrom']")
    MobileElement inputDateFrom;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editTo']")
    MobileElement inputDateTo;

    @FindBy(xpath = "//*[@resource-id='android:id/next']")
    MobileElement nextMonthCalendar;

    @FindBy(xpath = "//*[@resource-id='android:id/month_view']//*")
    List<MobileElement> dayOnCalendar;

    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement okBTNCalendar;

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/searchBtn']")
    MobileElement yallaBTN;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    MobileElement openMenu;
    // //android.widget.ImageView[@content-desc="More options"]

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"More options\"]")
    MobileElement openMenuLogout;

    @FindBy(xpath = "//*[@text='Login']")
    MobileElement login;

    @FindBy(xpath = "//*[@text='Registration']")
    MobileElement registration;

    @FindBy(xpath = "//*[@text='Logout']")
    MobileElement logout;

    public void fillSearchForm(String city, int dateFrom, int dateTo) {
        wait(inputLocation, 15);
        typeText(inputLocation, city);

        click(inputDateFrom);
        wait(nextMonthCalendar, 3);
        click(nextMonthCalendar);
        click(dayOnCalendar.get(dateFrom-1));
        click(okBTNCalendar);

        click(inputDateTo);
        wait(nextMonthCalendar, 3);
        click(nextMonthCalendar);
        click(dayOnCalendar.get(dateTo-1));
        click(okBTNCalendar);

        click(yallaBTN);
    }

    public void openRegistrationPage() {
        wait(inputLocation, 15);
        click(openMenu);
        wait(registration, 5);
        click(registration);
    }

    public boolean validateTitle() {
        wait(title, 20);
        String expectedResult = "Find your car now!".toUpperCase();
        String actualResult = getText(title);
        if(expectedResult.equals(actualResult)) {
            return true;
        } else {
            System.out.println("Expected result: " + expectedResult +
                    " actual result: " + actualResult);
            return false;
        }
    }

    public void openLoginPage() {
        wait(inputLocation, 15);
        click(openMenu);
        wait(login, 5);
        click(login);
    }

    public boolean logoutIfExist() {

        try {
            wait(openMenuLogout, 3);
            click(openMenuLogout);
            wait(logout, 2);
            click(logout);
            return true;
        } catch (Exception e){
            return false;
        }
    }






    /*
int leftX = element.getLocation().getX();
int rightX = leftX + element.getSize().getWidth();
int middleX = (rightX + leftX) / 2;
int upperY = element.getLocation().getY();
int lowerY = upperY + element.getSize().getHeight();
int middleY = (upperY + lowerY) / 2;

TouchAction action= new TouchAction(driver);
action.press(271, 642).release().perform();

TouchAction action= new TouchAction(driver);
action.press(x, y).perform();

    public void tapByCoordinates (int x,  int y) {
        new TouchAction(driver)
            .tap(point(x,y))
            .waitAction(waitOptions(ofMillis(250))).perform();
    }



     */

}
