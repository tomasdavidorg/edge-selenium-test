import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.findby.ByJQuery;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@RunWith(Arquillian.class)
public class EdgeSimpleTest {

    @Drone
    private WebDriver driver;

    @Test
    public void searchDogOnGoogleTest() throws InterruptedException {
        driver.get("http://10.202.13.147:8080/business-central");

        Thread.sleep(1000);

        WebElement name = driver.findElement(ByJQuery.selector("input[name='j_username']"));
        name.sendKeys("testadmin");

        WebElement pass = driver.findElement(ByJQuery.selector("input[name='j_password']"));
        pass.sendKeys("admin1234;");

        WebElement button = driver.findElement(ByJQuery.selector("input.button"));
        button.click();

        Thread.sleep(15000);

        driver.findElement(ByJQuery.selector("td > a:contains('Project Authoring')")).click();
        Thread.sleep(1000);
        driver.findElement(ByJQuery.selector("a:contains('Teams')")).click();
        Thread.sleep(1000);
        driver.findElement(ByJQuery.selector("button:contains('Create Team')")).click();
        Thread.sleep(1000);

        Modal pageFragment = Graphene.createPageFragment(Modal.class,
                                                         driver.findElement(By.className("modal-dialog")));
        pageFragment.setInput("aaa");
        WebElement webelement = pageFragment.getWebelement();
        webelement.clear();
        webelement.sendKeys("sdasdas");
        pageFragment.setInput("adasdasdas");
        Thread.sleep(2000);
    }


}
