package app.vercel.northwind.tests.login;


//import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
//import static org.junit.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;
    //private String baseUrl;

    @BeforeEach
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        //baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Test
    public void testValidarAcessoSemCredenciais() throws Exception {
        driver.get("https://northwind-test-platform.vercel.app/");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assertions.assertTrue(driver.findElement(By.cssSelector("[data-testid='password-error']")).isDisplayed(), "Email e senha são obrigatórios");
        //Assertions.assertTrue(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Senha'])[1]/following::p[1]")).getText().matches("^Não tem conta[\\s\\S] Cadastre-se$"));
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
        /*
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }*/
    }
}

