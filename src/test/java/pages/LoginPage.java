package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    WebDriver driver;
    public WebDriverWait wait;
    public By emailAddressInput = By.id("email");
    public By passwordInput = By.id("passwd");
    public By signInButton = By.xpath("//span[contains(.,'Sign in')]");
    public By loginSucesso = By.xpath("//span[contains(.,'Teste Teste')]");
    public By loginFalha = By.xpath("//li[contains(text(), 'An email address required.')]");
    public By loginSenha = By.xpath("//li[contains(text(), 'Password is required.')]");
    public By loginFalhaEmail = By.xpath("//li[contains(text(), 'An email address required.')]");
    public By loginFalhaEmailInvalido = By.xpath("//li[contains(.,'Invalid email address.')]");
    public By loginFalhaSenhaInvalida = By.xpath("//li[contains(.,'Invalid password.')]");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void enterEmail(String email) {
        escrever(emailAddressInput, email);
    }

    public void enterPassword(String password) {
        escrever(passwordInput, password);
    }

    public void clickButtonSignIn() {
        clicar(signInButton);
    }
     public String loginSucesso(){
         wait.until(ExpectedConditions.visibilityOfElementLocated(loginSucesso));
         return driver.findElement(loginSucesso).getText();


     }

    public String loginFalha() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginFalha));
        return driver.findElement(loginFalha).getText();
    }

    public String loginFalhaSenha() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginSenha));
        return driver.findElement(loginSenha).getText();
    }

    public String loginFalhaEmail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginFalhaEmail));
        return driver.findElement(loginFalhaEmail).getText();
    }

    public String loginFalhaEmailInvalido() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginFalhaEmailInvalido));
        return driver.findElement(loginFalhaEmailInvalido).getText();
    }

    public String loginFalhaSenhaInvalida() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginFalhaSenhaInvalida));
        return driver.findElement(loginFalhaSenhaInvalida).getText();
    }
}
