package pages.interactions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SelectablePage {
    private final SelenideElement verticalListContainer = $(By.id("verticalListContainer"));
    private final String END_POINT = "/selectable";

    public SelectablePage open(){
        Selenide.open(AppConfig.baseUrl+END_POINT);
        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){
        return verticalListContainer.isDisplayed();
    }

    public SelectablePage selectElement(int numberOfElement){
        SelenideElement selectedElement =
                $(By.xpath("(//*[@id='verticalListContainer']/li)[" + numberOfElement + "]"));

        selectedElement.click();

        Assert.assertTrue(selectedElement.getAttribute("class").contains("active"));

        return this;
    }

}
