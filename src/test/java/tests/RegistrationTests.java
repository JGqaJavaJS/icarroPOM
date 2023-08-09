package tests;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import pages.SearchPage;
import utils.RandomUtils;

public class RegistrationTests extends AppiumConfig {

    /*
        String name;
    String lastName;
    String email;
    String password;
     */

    @Test
    public void registrationTestPositive() {
        RandomUtils randomUtils = new RandomUtils();
        String email = randomUtils.generateRandomEmail();
        System.out.println(email + "________________ email");
        UserDTO userDTO = UserDTO.builder()
                .name("John")
                .lastName("smith")
                .email(email)
                .password("$12345Rrmn")
                .build();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.openRegistrationPage();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegistrationForm(userDTO);
        Assert.assertTrue(searchPage.validateTitle());
    }
}
