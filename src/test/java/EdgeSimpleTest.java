import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class EdgeSimpleTest {

    @Test
    public void main() throws InterruptedException {

        System.setProperty("webdriver.edge.driver", "C:\\Selenium\\MicrosoftWebDriver.exe");
        WebDriver driver = new EdgeDriver();

        driver.get("http://www.google.com");

        WebElement searchBox = driver.findElement(By.id("lst-ib"));

        searchBox.sendKeys("Dog");

        Thread.sleep(1000);

        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "C:\\Selenium\\MicrosoftWebDriver.exe");
        EdgeDriver driver = new EdgeDriver();
        driver.get("http://www.google.com");
        Thread.sleep(1000);
        driver.quit();
    }
}
