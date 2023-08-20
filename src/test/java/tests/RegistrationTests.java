package tests;

import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

    @BeforeMethod
    public void checkLogout() {
        if (searchPage.logoutIfExist()) {
            registrationPage = searchPage.clickOpenMenu(15).openRegistrationPage();
        } else if (loginPage.isPopUpErrorOpen()) {
            loginPage.clickOkPopUp();
            searchPage.clickBackBTNPhone();
        } else {
          //  searchPage.clickBackBTNPhone();
            registrationPage = searchPage.clickOpenMenu(15).openRegistrationPage();
        }
    }

    /*
        String name;
    String lastName;
    String email;
    String password;
     */

    @Test
    public void registrationTestPositive() {
        String email = randomUtils.generateRandomEmail();
        System.out.println(email + "________________ email");
        UserDTO userDTO = UserDTO.builder()
                .name("John")
                .lastName("smith")
                .email(email)
                .password("$12345Rrmn")
                .build();
        searchPage = registrationPage.fillRegistrationForm(userDTO);
        Assert.assertTrue(searchPage.validateTitle());
       // Assert.assertTrue(searchPage.openRegistrationPage().fillRegistrationForm(userDTO).validateTitle());
    }
}
