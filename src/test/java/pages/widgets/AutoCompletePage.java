package pages.widgets;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import static com.codeborne.selenide.Selenide.$;

public class AutoCompletePage {
    private final SelenideElement autoCompleteMultipleInput = $(By.id("autoCompleteMultipleInput"));
    private final SelenideElement lastEnteredValue = $(By.xpath("(//*[contains(@class, 'auto-complete__multi-value__label')])[last()]"));
    private final String END_POINT = "/auto-complete";

    public AutoCompletePage open(){
        Selenide.open(AppConfig.baseUrl+END_POINT);
        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){
        return autoCompleteMultipleInput.isDisplayed();
    }

    public AutoCompletePage typeValueIntoContainer(String textToWrite, String expectedText){
        autoCompleteMultipleInput.click();

        autoCompleteMultipleInput.sendKeys(textToWrite);
        autoCompleteMultipleInput.sendKeys(Keys.ENTER);

        Assert.assertEquals(expectedText, lastEnteredValue.text());
        return this;
    }

}
