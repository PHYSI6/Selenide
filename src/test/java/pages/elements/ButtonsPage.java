package pages.elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ButtonsPage {
    private final SelenideElement doubleClickBtn = $(By.id("doubleClickBtn"));
    private final SelenideElement doubleClickMessage = $(By.id("doubleClickMessage"));
    private final String END_POINT = "/buttons";

    public ButtonsPage open(){
        Selenide.open(AppConfig.baseUrl + END_POINT);

        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){return doubleClickBtn.isDisplayed();}

    public ButtonsPage doubleClickButton(){
        doubleClickBtn.doubleClick();

        Assert.assertTrue(doubleClickMessage.isDisplayed());
        Assert.assertEquals("You have done a double click", doubleClickMessage.text());

        return this;
    }
}
