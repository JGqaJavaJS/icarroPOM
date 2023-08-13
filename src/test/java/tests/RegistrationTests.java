package tests;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import pages.SearchPage;
import utils.RandomUtils;

public class RegistrationTests extends BaseTest {

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
        searchPage.openRegistrationPage();
        registrationPage.fillRegistrationForm(userDTO);
        Assert.assertTrue(searchPage.validateTitle());
    }
}
