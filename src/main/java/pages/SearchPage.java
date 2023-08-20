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

//    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"More options\"]")
//    MobileElement openMenuLogout;

    @FindBy(xpath = "//*[@text='Login']")
    MobileElement login;

    @FindBy(xpath = "//*[@text='Registration']")
    MobileElement registration;

    @FindBy(xpath = "//*[@text='Logout']")
    MobileElement logout;

    public SearchResultPage fillSearchForm(String city, int dateFrom, int dateTo) {
        typeText(inputLocation, city, 15);

        click(inputDateFrom, 15);
        click(nextMonthCalendar, 15);
        click(dayOnCalendar.get(dateFrom-1), 15);
        click(okBTNCalendar, 15);

        click(inputDateTo, 15);
        click(nextMonthCalendar, 15);
        click(dayOnCalendar.get(dateTo-1), 15);
        click(okBTNCalendar, 15);

        click(yallaBTN, 15);
        return new SearchResultPage();
    }

    public boolean validateTitle() {
        String expectedResult = "Find your car now!".toUpperCase();
        String actualResult = getText(title, 15);
        if(expectedResult.equals(actualResult)) {
            return true;
        } else {
            System.out.println("Expected result: " + expectedResult +
                    " actual result: " + actualResult);
            return false;
        }
    }

    public SearchPage clickOpenMenu (int time) {
        click(openMenu, time);
        return this;
    }

    public LoginPage openLoginPage() {
        click(login, 15);
        return new LoginPage();
    }

    public RegistrationPage openRegistrationPage() {
        click(registration, 15);
        return new RegistrationPage();
    }

    public boolean logoutIfExist() {
        try {
            clickOpenMenu(15);
            click(logout, 3);
            return true;
        } catch (Exception e){
          //  clickBackBTNPhone();
            return false;
        }
    }

    public void clickTitle() {
        click(title, 15);
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
