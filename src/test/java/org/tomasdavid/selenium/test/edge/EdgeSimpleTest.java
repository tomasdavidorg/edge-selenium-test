package org.tomasdavid.selenium.test.edge;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeSimpleTest {

    private static final String DROOLS_WB_URL = "http://www.patternfly.org/pattern-library/communication/wizard/#/code";

    private WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.edge.driver", "C:\\Selenium\\MicrosoftWebDriver.exe");
        driver = new EdgeDriver();
    }

    @Test
    public void searchDogOnGoogleTest() throws InterruptedException {
        driver.get(DROOLS_WB_URL);

        WebElement launchButton = driver.findElement(By.cssSelector("button.wizard-pf-open"));
        launchButton.click();

        Thread.sleep(1000);

        // interact with name input
        WebElement nameInput = driver.findElement(By.cssSelector("input[data-id='textInput-markup']"));
        nameInput.sendKeys("MyTeam");
        nameInput.clear(); //org.openqa.selenium.ElementNotVisibleException: Element not displayed
    }

    @After
    public void clean() {
        if (driver != null) {
            driver.quit();
        }
    }
}
