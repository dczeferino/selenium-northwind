package app.vercel.northwind.tests.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest {

    protected final String  baseurl = "https://northwind-test-platform.vercel.app/";
    protected WebDriver driver;

    @BeforeEach
    public void setUp(){
        //desativa log que apresenta no terminal
        System.setProperty("webdriver.chrome.selentOutput", "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

        //inicia o webdriver e referencia na classe LoginTest
        driver = new ChromeDriver();
        //baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
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
