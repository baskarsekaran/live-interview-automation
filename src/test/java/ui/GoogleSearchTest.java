package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();

	options.addArguments("--headless");
	options.addArguments("--no-sandbox");
	options.addArguments("--disable-dev-shm-usage");

	driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    @Test
    void googleSearchTest() {

        // Open Google
        driver.get("https://www.google.com");

        // Validate Google page
        assertTrue(
                driver.getTitle()
                        .toLowerCase()
                        .contains("google"),
                "Google page title should contain Google"
        );

        // Find search box
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.name("q")
                )
        );

        // Enter search text
        searchBox.sendKeys("Selenium Java");

        // Submit search
        searchBox.submit();

        // Wait for search result page
        wait.until(
                ExpectedConditions.titleContains("Selenium")
        );

        // Validate search result
        assertTrue(
                driver.getTitle()
                        .toLowerCase()
                        .contains("selenium"),
                "Search result title should contain Selenium"
        );
    }

    @AfterEach
    void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}