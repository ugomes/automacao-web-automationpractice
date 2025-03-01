package testWeb;

import org.junit.jupiter.api.*;
import com.github.javafaker.Faker;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CadastroPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class cadastroTest extends Hooks {
    private Faker faker;

    @Test
    @Order(1)
    @DisplayName("Cadastro com sucesso")
    public void cadastroSucesso() {
        faker = new Faker(Locale.forLanguageTag("pt-BR"));


        CadastroPage cadastroPage = new CadastroPage(driver);

        String name = faker.name().firstName();
        String lastName = faker.name().lastName();
        String password = faker.internet().password();
        cadastroPage.selectGender();
        cadastroPage.enterFirstName(name);
        cadastroPage.enterLastName(lastName);
        cadastroPage.enterPassword(password);
        cadastroPage.selectDateOfBirth("1", "Janeiro", "1999");
        cadastroPage.clickRegister();
        String mensagemEsperada = "Your account has been created.";
        String mensagemObtida = cadastroPage.getSuccessMessage();

        Assertions.assertEquals(mensagemEsperada, mensagemObtida);
    }

    @Test
    @Order(2)
    @DisplayName("Cadastro Falha - Email inválido")
    public void cadastroFalha() {
        faker = new Faker(Locale.forLanguageTag("pt-BR"));
        CadastroPage cadastroPage = new CadastroPage(driver);

        String name = faker.name().firstName();
        String lastName = faker.name().lastName();
        String password = faker.internet().password();
        String email = "testerEmailInvalido";

        cadastroPage.selectGender();
        cadastroPage.enterFirstName(name);
        cadastroPage.enterLastName(lastName);
        cadastroPage.enterEmail(email);
        cadastroPage.enterPassword(password);
        cadastroPage.selectDateOfBirth("1", "Janeiro", "1999");
        cadastroPage.clickRegister();

        String mensagemEsperadaEmail = "email is invalid.";
        String mensagemObtidaEmail = cadastroPage.emailInvalido();

        Assertions.assertEquals(mensagemEsperadaEmail, mensagemObtidaEmail);
    }

    @Test
    @Order(3)
    @DisplayName("Cadastro Falha - Todos os campos Vazios")
    public void cadastroCamposVazios() throws InterruptedException {
        CadastroPage cadastroPage = new CadastroPage(driver);

        cadastroPage.clickRegister();

        List<String> mensagens = cadastroPage.getErrorMessages();

                // Verifica se a lista contém as mensagens esperadas

        assertThat(mensagens, hasItem(containsString("lastname is required.")));
        assertThat(mensagens, hasItem(containsString("firstname is required.")));
        assertThat(mensagens, hasItem(containsString("passwd is required.")));

    }
}



