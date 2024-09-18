import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class WikipediaSearchTest {
    public static void main(String[] args) {
        // Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\BHAVANA\\Downloads\\chromedriver-win32-02-09-24 (2)\\chromedriver-win32\\chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the URL
            driver.get("https://qawikisearch.ccbp.tech/");

            // Find the input field using Relative XPath
            WebElement searchInput = driver.findElement(By.xpath("//input[@id='searchInput']"));

            // Enter the text "HTML" in the input field
            searchInput.sendKeys("HTML");

            // Find the 'Search' button using Relative XPath
            WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class, 'search-button')]"));

            // Click the button
            searchButton.click();

            // Wait until the search results are loaded
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'result-item')]")));

            // Find all the search results using Relative XPath
            List<WebElement> searchResults = driver.findElements(By.xpath("//div[contains(@class, 'result-item')]"));

            // Print the number of results found
            System.out.println(searchResults.size() + " Results Found");
        } finally {
            // Close the browser window
            driver.quit();
        }
    }
}
