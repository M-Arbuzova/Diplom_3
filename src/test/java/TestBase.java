import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestBase {
    User user;
    UserApi userApi = new UserApi();
    private String bearerToken;
    public WebDriver driver;
    private final String URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

       @After
        public void tearDown() {
//          driver.quit();
           ValidatableResponse responseLogin = UserApi.userLogin(user);
           bearerToken = responseLogin.extract().path("accessToken");
           if (bearerToken == null) return;
           UserApi.deleteUser(bearerToken);

  }
}

