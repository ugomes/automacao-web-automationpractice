package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    private final WebDriverWait wait;
    WebDriver driver;
    public By signInLink = By.xpath("//a[@class='login'][contains(.,'Sign in')]");
    public By emailCreateInput = By.id("email_create");
    public By createAccountButton = By.xpath("//span[contains(.,'Create an account')]");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickSignIn() {
        clicar(signInLink);

    }

    public void enterEmail(String email) {
        escrever(emailCreateInput, email);
    }

    public void clickCreateAccount() {
        clicar(createAccountButton);
    }
}

