package ui.base;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.platform.engine.TestExecutionResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeAll
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        goHome();

        homePage = new HomePage(driver);
    }

    @BeforeEach
    void goHome(){
        driver.get("https://the-internet.herokuapp.com");
    }

    @AfterAll
    public void tearDown(){
        driver.quit();
    }

    @AfterEach
    public void recordFailure(){
        var camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(
                    screenshot.toPath(),
                    new File("resources/screenshots/" + Math.random() + ".png").toPath()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
}
