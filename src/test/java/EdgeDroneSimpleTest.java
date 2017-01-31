import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@RunWith(Arquillian.class)
public class EdgeDroneSimpleTest {

    @Drone
    WebDriver webDriver;

    @Test
    public void searchCatOnGoogleTest() throws InterruptedException {
        webDriver.get("http://www.google.com");

        WebElement searchBox = webDriver.findElement(By.id("lst-ib"));

        searchBox.sendKeys("Cat");

        Thread.sleep(1000);

        System.out.println("Page title is: " + webDriver.getTitle());
    }
}
