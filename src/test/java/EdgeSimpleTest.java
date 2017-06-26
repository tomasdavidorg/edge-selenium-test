import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EdgeSimpleTest {

    private static final String EDGE_WEBDRIVER_PROPERTY = "webdriver.edge.driver";

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty(EDGE_WEBDRIVER_PROPERTY, "C:\\Selenium\\MicrosoftWebDriver.exe");
    }

    @Test
    public void searchDogOnGoogleTest() throws InterruptedException {
        driver = new FirefoxDriver();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("index.html").getFile());

        driver.get("file://" + file.getAbsolutePath());

        WebElement firstDiv = driver.findElement(By.className("first"));
        Assert.assertTrue(firstDiv.getText().equals("Hello world!"));

        WebElement addDivButton = driver.findElement(By.className("button"));
        addDivButton.click();

        WebElement secondDiv = driver.findElement(By.className("second"));
        Assert.assertTrue(secondDiv.getText().equals("Goodbye world!"));
    }

    @After
    public void clean() {
        System.clearProperty(EDGE_WEBDRIVER_PROPERTY);
        if (driver != null) {
            driver.quit();
        }
    }

}
