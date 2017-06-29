import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.openqa.selenium.WebElement;

public class Modal {

    @FindByJQuery("input[data-field='name']")
    WebElement thirdInput;

    public void setInput(String text) {
        thirdInput.sendKeys(text);
    }

}
