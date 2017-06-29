import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.openqa.selenium.WebElement;

/**
 * Created by tdavid on 6/29/17.
 */
public class SecondDiv {

    @FindByJQuery("div.third")
    WebElement thirdInput;
    @FindByJQuery("input.textinput")
    WebElement input;

    public String getDivText() {
        return thirdInput.getText();
    }

    public void setInput(String text) {
        input.sendKeys(text);
    }

}
