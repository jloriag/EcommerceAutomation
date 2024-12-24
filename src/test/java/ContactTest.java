import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Ruta al ChromeDriver (ajusta según tu sistema)
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testWhatsApp() {
        
        driver.get("http://localhost/Ecommerce/public/index.php?action=contacto");
        WebElement btnW = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/p[2]/button"));
        btnW.click();
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        assertTrue(currentUrl.contains("api.whatsapp.com/send/?"));
    }

    @AfterEach
    public void tearDown() {
        // Cerrar el navegador
        if (driver != null) {
            driver.quit();
        }
    }
}
