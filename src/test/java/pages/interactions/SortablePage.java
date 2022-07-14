package pages.interactions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class SortablePage {
    private final SelenideElement demoTabPaneList = $(By.id("demo-tabpane-list"));
    private final String END_POINT = "/sortable";

    public SortablePage open(){
        Selenide.open(AppConfig.baseUrl+END_POINT);
        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){
        return demoTabPaneList.isDisplayed();
    }

    public SortablePage moveElement(int numberOfElement, int numberOfPosition){
        SelenideElement movedElement =
                $(By.xpath("(//*[@class='list-group-item list-group-item-action'])[" + numberOfElement + "]"));

        SelenideElement slidingElement =
                $(By.xpath("(//*[@class='list-group-item list-group-item-action'])[" + numberOfPosition + "]"));

        actions().dragAndDrop(movedElement,slidingElement).perform();

        List<SelenideElement>listOfElements = $$(By.cssSelector(".vertical-list-container > div"));

        Assert.assertEquals(numberOfPosition,listOfElements.indexOf(slidingElement) + 1);

        return this;
    }
}
