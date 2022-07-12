package pages.elements;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LinksPage {
    private final SelenideElement simpleLink = $(By.id("simpleLink"));
    private final String END_POINT = "/links";

    public LinksPage open(){
        Selenide.open(AppConfig.baseUrl + END_POINT);

        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){
        return simpleLink.isDisplayed();
    }

    public LinksPage clickLink(){
        simpleLink.click(ClickOptions.usingJavaScript());

        switchTo().window(1);

        webdriver().shouldHave(url("https://demoqa.com/"));

        return this;
    }
}
