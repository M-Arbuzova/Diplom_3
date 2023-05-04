import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class SingInProfileTest extends TestBase{

    @Test
    @DisplayName("Вход в профиль через кнопку 'Войти в аккаунт' на главной странице")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Войти в аккаунт' на главной странице")
    public void singInWithBtnOnHeadPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        user = new UserGenerateData().getRandomUser();

        mainPage.clickSingInCentralBtn();
        loginPage.clickRegistrationBtn();
        registrationPage.setRegistrationNewUser(user.getName(), user.getEmail(), user.getPassword());
        loginPage.setSingInUserAccount(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountBtn();
        profilePage.checkAccountTextIsDisplayed();
    }
    @Test
    @DisplayName("Вход в профиль через кнопку 'Личный кабинет'")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Личный кабинет'")
    public void singInWithProfileBtn() {
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
    }
    @Test
    @DisplayName("Вход в профиль через кнопку 'Войти' в форме регистрации")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Войти' в форме регистрации")
    public void singInWithBtnOnRegistrationPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        user = new UserGenerateData().getRandomUser();

        mainPage.clickPersonalAccountBtn();
        loginPage.clickRegistrationBtn();
        registrationPage.setRegistrationNewUser(user.getName(), user.getEmail(), user.getPassword());
        loginPage.clickRegistrationBtn();
        registrationPage.clickSingInBtn();
        loginPage.setSingInUserAccount(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountBtn();
        profilePage.checkAccountTextIsDisplayed();
    }
    @Test
    @DisplayName("Вход в профиль через кнопку 'Войти' в форме восстановления пароль")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Войти' в форме регистрации")
    public void singInWithBtnOnForgottPasswordPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        ForgottPasswordPage forgottPasswordPage = new ForgottPasswordPage(driver);
        user = new UserGenerateData().getRandomUser();

        mainPage.clickPersonalAccountBtn();
        loginPage.clickRegistrationBtn();
        registrationPage.setRegistrationNewUser(user.getName(), user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountBtn();
        loginPage.clickForgottPasswordBtn();
        forgottPasswordPage.clickSingInBtn();
        loginPage.setSingInUserAccount(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountBtn();
        profilePage.checkAccountTextIsDisplayed();

    }
}
