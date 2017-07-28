package org.tomasdavid.selenium.test.edge;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeSimpleTest {

    private static final String TESTING_HTML_FILE = "index.html";

    private WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.edge.driver", "C:\\Selenium\\MicrosoftWebDriver.exe");
        driver = new EdgeDriver();
    }

    @Test
    public void searchDogOnGoogleTest() throws InterruptedException {
        String htmlFilePath = getClass().getClassLoader().getResource(TESTING_HTML_FILE).getPath();
        driver.get("file://" + htmlFilePath);

        driver.findElement(By.id("openDialogButton")).click();
        Thread.sleep(1000);
        WebElement testingInput = driver.findElement(By.id("testingInput"));
        testingInput.sendKeys("Hello");

        testingInput.clear(); // org.openqa.selenium.ElementNotVisibleException:
    }

    @After
    public void clean() {
        if (driver != null) {
            driver.quit();
        }
    }
}
