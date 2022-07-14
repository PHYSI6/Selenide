package pages.widgets;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MenuPage {
    private final SelenideElement mainItem2 = $(By.xpath("//a[contains(text(), 'Main Item 2')]"));
    private final SelenideElement subItem = $(By.xpath("//a[contains(text(), 'Sub Item')]"));
    private final String END_POINT = "/menu#";

    public MenuPage open(){
        Selenide.open(AppConfig.baseUrl+END_POINT);
        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){
        return mainItem2.isDisplayed();
    }

    public MenuPage selectMenuItems(){
        mainItem2.hover();
        subItem.click();

        return this;
    }
}
