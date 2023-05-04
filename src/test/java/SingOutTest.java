import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class SingOutTest extends TestBase {

    @Test
    @DisplayName("Выход из аккаунта авторизованного пользователя")
    @Description("Проверка, что можно выйти из аккаунта авторизованного пользователя")
    public void canSingOutFromProfile() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        user = new UserGenerateData().getRandomUser();

        mainPage.clickPersonalAccountBtn();
        loginPage.clickRegistrationBtn();
        registrationPage.setRegistrationNewUser(user.getName(), user.getEmail(), user.getPassword());
        loginPage.setSingInUserAccount(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountBtn();
        profilePage.clickSingOutBtn();
        profilePage.checkAccountTextIsDisplayed();
    }
}
