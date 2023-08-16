package tests;

import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        searchPage = searchPage.openRegistrationPage().fillRegistrationForm(userDTO);
        Assert.assertTrue(searchPage.validateTitle());
    }
}
