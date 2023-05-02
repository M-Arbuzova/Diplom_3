import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final By nameInput = By.xpath("//label[contains(text(),'Имя')]/../input"); // поле имя
    private final By emailInput = By.xpath("//label[contains(text(),'Email')]/../input"); // поле email
    private final By passwordInput = By.xpath("//label[contains(text(),'Пароль')]/../input"); // поле пароль
    private final By registrationBtn = By.xpath(".//button[text()='Зарегистрироваться']"); //кнопка зарегистрироваться
    private final By singInBtn = By.xpath(".//a[text()='Войти']"); //кнопка вход


    private final WebDriver driver;

    public RegistrationPage(WebDriver webDriver) {
        driver = webDriver;
    }
    public void setNameInput(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }
    public void setEmailInput(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public void setPasswordInput(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickRegistrationBtn() {
        driver.findElement(registrationBtn).click();
    }
    public void clickSingInBtn(){
        driver.findElement(singInBtn).click();
    }
    public void setRegistrationNewUser(String name, String email, String password){
        setNameInput(name);
        setEmailInput(email);
        setPasswordInput(password);
        clickRegistrationBtn();
    }
}
