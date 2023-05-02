import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;
    private UserApi userApi;
    private String bearerToken;
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

//       @After
//        public void tearDown() {
//        driver.quit();
//        if (bearerToken == null) return;
//        userApi.deleteUser(bearerToken);
//  }
}

