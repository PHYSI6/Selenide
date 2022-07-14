package pages.widgets;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class SliderPage {
    private final SelenideElement slider = $(By.className("range-slider--primary"));
    private final String END_POINT = "/slider";

    public SliderPage open(){
        Selenide.open(AppConfig.baseUrl+END_POINT);
        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){
        return slider.isDisplayed();
    }

    public SliderPage setSliderValue(int value){
        slider.click(ClickOptions.usingJavaScript());
        int currentValue = Integer.parseInt(slider.getAttribute("value"));
        int countOfSteps = Math.abs(value - currentValue);
        for(int i = 0; i < countOfSteps; i++){
            slider.sendKeys(value > currentValue ? Keys.ARROW_RIGHT : Keys.ARROW_LEFT);
        }
        Assert.assertEquals(value, Integer.parseInt(slider.getAttribute("value")));

        return this;
    }
}
