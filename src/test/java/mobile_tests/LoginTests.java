package mobile_tests;

import config.AppiumConfig;
import dto.UserDtoLombok;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.SplashScreen;

import static helper.PropertiesReader.getProperty;
import static helper.RandomUtils.generateEmail;

public class LoginTests extends AppiumConfig {
    @Test
    public void loginPositiveTest() {
        UserDtoLombok user=UserDtoLombok.builder()
                .username(getProperty("data.properties","email"))
                .password(getProperty("data.properties","password"))
                .build();
        new SplashScreen(driver).goToAuthScreen();
        AuthenticationScreen authenticationScreen = new AuthenticationScreen(driver);
        authenticationScreen.typeAuthenticationForm(user);
        authenticationScreen.clickBtnLogin();
    }
}