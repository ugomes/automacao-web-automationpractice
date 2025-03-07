package testWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import java.util.Locale;
import com.github.javafaker.Faker;
public class Hooks {
    WebDriver driver;
    private Faker faker;
    @BeforeEach
    public void setup() {
        faker = new Faker(Locale.forLanguageTag("pt-BR"));
        String email = faker.internet().emailAddress();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/index.php");
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn();
        homePage.enterEmail(email);
        homePage.clickCreateAccount();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
