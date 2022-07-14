package pages.widgets;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ToolTipsPage {
    private final SelenideElement toolTipButton = $(By.id("toolTipButton"));
    private final String END_POINT = "/tool-tips";

    public ToolTipsPage open(){
        Selenide.open(AppConfig.baseUrl+END_POINT);
        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){
        return toolTipButton.isDisplayed();
    }

    public ToolTipsPage checkTextFromHoverButton(String expectedText){
       /* toolTipButton.;
        Assert.assertEquals(expectedText, );*/

        return this;
    }
}
