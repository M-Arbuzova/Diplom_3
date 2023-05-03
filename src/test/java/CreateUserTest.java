import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class CreateUserTest extends TestBase{
    User user;
    UserApi userApi = new UserApi();
    private String bearerToken;

    @Test
    @DisplayName("Регистрация пользователя с валидными данными")
    @Description("Проверка, что можно зарегистрировать пользователя с валидными данными ")
    public void createNewUser() {
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
        profilePage.checkAccountTextIsDisplayed();

        ValidatableResponse responseLogin = UserApi.userLogin(user);
        bearerToken = responseLogin.extract().path("accessToken");
        if (bearerToken == null) return;
        UserApi.deleteUser(bearerToken);

    }
    @Test
    @DisplayName("Регистрация пользователя с валидными данными через API")
    @Description("Проверка, что можно зарегистрировать пользователя с валидными данными через API")
    public void createNewUserWithApi() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        userApi = new UserApi();
        user = new UserGenerateData().getRandomUser();

        userApi.userReg(user);
        mainPage.clickPersonalAccountBtn();
        loginPage.setSingInUserAccount(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountBtn();
        profilePage.checkAccountTextIsDisplayed();

        ValidatableResponse responseLogin = UserApi.userLogin(user);
        bearerToken = responseLogin.extract().path("accessToken");
        if (bearerToken == null) return;
        UserApi.deleteUser(bearerToken);
    }
    @Test
    @DisplayName("Регистрация пользователя с коротким паролем")
    @Description("Проверка, что нельзя зарегистрировать пользователя с паролем менее 6 символов")
    public void createNewUserWithShortPassword() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        user = new UserGenerateData().getRandomUser();
        user.setPassword(RandomStringUtils.randomAlphabetic(3));

        mainPage.clickPersonalAccountBtn();
        loginPage.clickRegistrationBtn();
        registrationPage.setRegistrationNewUser(user.getName(), user.getEmail(), user.getPassword());
        registrationPage.checkErrorAboutShortPassword();

        ValidatableResponse responseLogin = UserApi.userLogin(user);
        bearerToken = responseLogin.extract().path("accessToken");
        if (bearerToken == null) return;
        UserApi.deleteUser(bearerToken);
    }
}
