package pages.widgets;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class SelectMenuPage {
    private final SelenideElement oldSelectMenu = $(By.id("oldSelectMenu"));
    private final SelenideElement withOptGroup = $(By.id("withOptGroup"));
    private final String END_POINT = "/select-menu";

    public SelectMenuPage open(){
        Selenide.open(AppConfig.baseUrl+END_POINT);
        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){
        return oldSelectMenu.isDisplayed();
    }

    public SelectMenuPage selectOldByText(String text){
        oldSelectMenu.selectOption(text);

        Assert.assertEquals(text, oldSelectMenu.getText());

        return this;
    }

}
