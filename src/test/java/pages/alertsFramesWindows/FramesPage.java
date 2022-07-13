package pages.alertsFramesWindows;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FramesPage {
    private final SelenideElement frame1 = $(By.id("frame1"));
    private final SelenideElement sampleHeading = $(By.id("sampleHeading"));
    private final String END_POINT = "/frames";

    public FramesPage open(){
        Selenide.open(AppConfig.baseUrl + END_POINT);

        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){return frame1.isDisplayed();}

    public void checkTextInFrame(String textForCheck){
        Selenide.switchTo().frame(frame1);
        Assert.assertEquals(textForCheck, sampleHeading.text());
    }
}
