package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

public class DynamicLoadingExample1Page {

    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadingIndicator = By.id("loading");
    private By loadingText = By.id("finish");

    public DynamicLoadingExample1Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStart(){
        driver.findElement(startButton).click();
//        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(5));
//        wait.until(invisibilityOf(driver.findElement(loadingIndicator)));

        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
    }

    public String getLoadingText(){
        return driver.findElement(loadingText).getText();
    }
}
