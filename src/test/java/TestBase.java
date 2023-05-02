import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;
    private final String URL = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

