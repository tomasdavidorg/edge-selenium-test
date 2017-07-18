package org.tomasdavid.selenium.test.edge;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeSimpleTest {

    private static final String DROOLS_WB_URL = "http://kieci-02.lab.eng.brq.redhat.com:32867/kie-drools-wb/kie-drools-wb.jsp";

    private WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.edge.driver", "C:\\Selenium\\MicrosoftWebDriver.exe");
        driver = new EdgeDriver();
    }

    @Test
    public void searchDogOnGoogleTest() throws InterruptedException {
        driver.get(DROOLS_WB_URL);

        // login into kie-wb
        WebElement name = driver.findElement(By.cssSelector("input[name='j_username']"));
        name.sendKeys("admin");
        WebElement pass = driver.findElement(By.cssSelector("input[name='j_password']"));
        pass.sendKeys("admin");
        WebElement button = driver.findElement(By.cssSelector("input.button"));
        button.click();
        Thread.sleep(15000);

        // Open Project Authoring - Teams
        WebElement tableWithLinks = driver.findElement(By.cssSelector("table.well"));
        tableWithLinks.findElement(By.linkText("Project Authoring")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Teams")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button.btn-primary")).click();
        Thread.sleep(1000);

        // interact with name input
        WebElement nameInput = driver.findElement(By.cssSelector("input[data-field='name']"));
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
