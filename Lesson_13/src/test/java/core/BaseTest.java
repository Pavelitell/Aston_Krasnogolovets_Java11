package core;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.FindBy;


import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

abstract public class BaseTest {
    protected static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
        driver.manage().timeouts().implicitlyWait(20, SECONDS);
        BasePage.setDriver(driver);
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
        driver.quit();
    }
}

