package pages.alertsFramesWindows;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NestedFramesPage {
    private final SelenideElement parentFrame = $(By.id("frame1"));
    private final SelenideElement childFrame = $(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
    private final SelenideElement body1 = $(By.tagName("body"));
    private final SelenideElement pChild = $(By.tagName("p"));
    private final String END_POINT = "/nestedframes";

    public NestedFramesPage open(){
        Selenide.open(AppConfig.baseUrl + END_POINT);

        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){return parentFrame.isDisplayed();}

    public NestedFramesPage checkTextInParentFrame(String textForCheck){
        Selenide.switchTo().frame(parentFrame);
        Assert.assertEquals(textForCheck, body1.text());

        return this;
    }

    public NestedFramesPage checkTextInChildFrame(String textForCheck){
        Selenide.switchTo().frame(childFrame);
        Assert.assertEquals(textForCheck, pChild.text());

        return this;
    }
}
