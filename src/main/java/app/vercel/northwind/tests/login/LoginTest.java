package app.vercel.northwind.tests.login;

//import org.junit.Test;
import app.vercel.northwind.tests.base.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
//import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {
    //private WebDriver driver;
    //private String baseUrl;

    /*
    //esse metodo inicia na classe BaseTest
    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        //baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }
     */

    @Test
    public void testValidarCamposObrigatoriosVazios() throws Exception {

        //pega a url do site
        driver.get(baseurl);
        //clica nos input da tela
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("password")).click();

        //clica no botão submit
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Valida se a mensagem esta apresentando na tela
        Assertions.assertTrue(driver.findElement(By.cssSelector("[data-testid='password-error']")).isDisplayed(), "Email e senha são obrigatórios");

        //validar mensagem que apresenta da tela
        WebElement mensagem = driver.findElement(By.cssSelector("[data-testid='password-error']"));
        Assertions.assertTrue(mensagem.isDisplayed());
        Assertions.assertEquals("Email e senha são obrigatórios",  mensagem.getText());


        //Assertions.assertTrue(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Senha'])[1]/following::p[1]")).getText().matches("^Não tem conta[\\s\\S] Cadastre-se$"));
    }

    @Test
    public void testValidarFormatoEmailInvalido() throws Exception {
        driver.get(baseurl);
        driver.findElement(By.name("email")).sendKeys("usuario.invalido");
        driver.findElement(By.name("password")).sendKeys("Senha123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Assertions.assertTrue(driver.findElement(By.cssSelector("[data-testid='email-error']")).isDisplayed(), "Formato de email inválido. Use: nome@dominio.com");

        //validar se a mensagem que apresenta da tela esta de acordo com a regra de negocio
        WebElement mensagem = driver.findElement(By.cssSelector("[data-testid='email-error']"));
        Assertions.assertTrue(mensagem.isDisplayed());
        Assertions.assertEquals("Formato de email inválido. Use: nome@dominio.com", mensagem.getText());
        //Assertions.assertTrue(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Senha'])[1]/following::p[1]")).getText().matches("^Não tem conta[\\s\\S] Cadastre-se$"));
    }

    @Test
    public void testValidarUsuarioNaoEncontrado() throws Exception {
        driver.get(baseurl);
        driver.findElement(By.name("email")).sendKeys("usuario@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Senha123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //validar se a mensagem que apresenta da tela esta de acordo com a regra de negocio
        WebElement mensagem = driver.findElement(By.cssSelector("[data-testid='email-error']"));
        Assertions.assertTrue(mensagem.isDisplayed());
        Assertions.assertEquals("Usuário não encontrado. Verifique o email ou cadastre-se.", mensagem.getText());
        //Assertions.assertTrue(driver.findElement(By.cssSelector("[data-testid='email-error']")).isDisplayed(), "Usuário não encontrado. Verifique o email ou cadastre-se");
        //Assertions.assertTrue(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Senha'])[1]/following::p[1]")).getText().matches("^Não tem conta[\\s\\S] Cadastre-se$"));
    }


    /*
    // Esse metodo finaliza na classe Basetest
    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }*/
}

