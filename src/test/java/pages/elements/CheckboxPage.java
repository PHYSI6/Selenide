package pages.elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckboxPage {
    private final SelenideElement checkbox = $(By.cssSelector(".rct-checkbox > svg"));
    private final String END_POINT = "/checkbox";

    public CheckboxPage open(){
        Selenide.open(AppConfig.baseUrl + END_POINT);

        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){
        return checkbox.isDisplayed();
    }

    public CheckboxPage checkCheckBox(){
        String statusBefore = checkbox.getAttribute("class");
        checkbox.click();
        if(statusBefore.equals("rct-icon rct-icon-uncheck")){
            Assert.assertEquals(checkbox.getAttribute("class"), "rct-icon rct-icon-check");
        }
        else Assert.assertEquals(checkbox.getAttribute("class"), "rct-icon rct-icon-uncheck");

        return this;
    }
}