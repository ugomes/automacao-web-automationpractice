package testWeb;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import pages.LoginPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class loginTest {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn();

    }

    @Test
    @DisplayName("Login com sucesso")
    @Order(1)
    public void loginSucesso() {
        LoginPage loginPage = new LoginPage(driver);

        String email = "teste23@teste.com.br";
        String password = "123456";

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickButtonSignIn();
        String nomeUsuarioLogado = loginPage.loginSucesso();
        assertThat("O nome do usuário logado não corresponde ao esperado.", nomeUsuarioLogado, is("Teste Teste"));

    }

    @Test
    @DisplayName("Login com falha - Todos Campos Vazios")
    @Order(2)
    public void loginFalha() {
        LoginPage loginPage = new LoginPage(driver);


        loginPage.clickButtonSignIn();

        String mensagemErro = loginPage.loginFalha();
        assertThat("A mensagem de erro nao corresponde ao esperado.", mensagemErro, is("An email address required."));
    }
    @Test
    @DisplayName("Login com falha - Campo Password Vazio")
    @Order(3)
    public void loginCampoPasswordVazio() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("teste23@teste.com.br");
        loginPage.clickButtonSignIn();
        String mensagemErro = loginPage.loginFalhaSenha();
        assertThat("A mensagem de erro nao corresponde ao esperado.", mensagemErro, is("Password is required."));
    }
    @Test
    @DisplayName("Login com falha - Campo Email Vazio")
    @Order(4)
    public void loginFalhaEmail() {
       LoginPage loginPage = new LoginPage(driver);

        loginPage.enterPassword("123456");
        loginPage.clickButtonSignIn();
        String mensagemErro = loginPage.loginFalhaEmail();
        assertThat("A mensagem de erro nao corresponde ao esperado.", mensagemErro, is("An email address required."));

    }

    @Test
    @DisplayName("Login com falha - Email Inválido")
    @Order(5)
    public void loginFalhaEmailInvalido() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("testerEmailInvalido");
        loginPage.enterPassword("123456");
        loginPage.clickButtonSignIn();
        String mensagemErro = loginPage.loginFalhaEmailInvalido();
        assertThat("A mensagem de erro nao corresponde ao esperado.", mensagemErro, is("Invalid email address."));
    }
    @Test
    @DisplayName("Login com falha - Senha Inválida")
    @Order(6)
    public void loginFalhaSenhaInvalida() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("teste23@teste.com.br");
        loginPage.enterPassword("1234");
        loginPage.clickButtonSignIn();
        String mensagemErro = loginPage.loginFalhaSenhaInvalida();
        assertThat("A mensagem de erro nao corresponde ao esperado.", mensagemErro, is("Invalid password."));
    }
    @AfterEach
    public void tearDown() {
        driver.quit();

    }
}


