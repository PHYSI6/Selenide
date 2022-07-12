package pages.elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class DynamicPropertiesPage {
    private final SelenideElement textWithRandomId = $(By.tagName("p"));
    private final SelenideElement enableAfterButton = $(By.id("enableAfter"));
    private final SelenideElement colorChangeButton = $(By.id("colorChange"));
    private final SelenideElement visibleAfterButton = $(By.id("visibleAfter"));
    private final String END_POINT = "/dynamic-properties";

    public DynamicPropertiesPage open(){
        Selenide.open(AppConfig.baseUrl + END_POINT);

        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){
        return textWithRandomId.isDisplayed();
    }

    public DynamicPropertiesPage clickEnableAfterButton(){
        enableAfterButton.click();

        return this;
    }

    public DynamicPropertiesPage clickColorChangeButton(){
        colorChangeButton.click();

        return this;
    }
    public DynamicPropertiesPage clickVisibleAfterButton(){
        visibleAfterButton.click();

        return this;
    }
}
