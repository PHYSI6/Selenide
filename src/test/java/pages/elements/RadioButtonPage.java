package pages.elements;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RadioButtonPage {
    private final SelenideElement yesRadio = $(By.id("yesRadio"));
    private final SelenideElement text = $(By.className("mb-3"));
    private final SelenideElement noRadio = $(By.id("noRadio"));
    private final SelenideElement impressiveRadio = $(By.id("impressiveRadio"));
    private final String END_POINT = "/radio-button";

    public RadioButtonPage open(){
        Selenide.open(AppConfig.baseUrl + END_POINT);

        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){return text.isDisplayed();}

    public RadioButtonPage selectYes(){
        yesRadio.click(ClickOptions.usingJavaScript());
        yesRadio.shouldBe(Condition.selected);

        return this;
    }

    public RadioButtonPage selectImpressive(){
        impressiveRadio.click(ClickOptions.usingJavaScript());
        impressiveRadio.shouldBe(Condition.selected);

        return this;
    }
    public RadioButtonPage selectNo(){
        noRadio.click(ClickOptions.usingJavaScript());
        noRadio.shouldBe(Condition.selected);

        return this;
    }
}
