package pages.widgets;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ProgressBarPage {
    private final SelenideElement startStopButton = $(By.id("startStopButton"));
    private final SelenideElement resetButton = $(By.id("resetButton"));
    private final SelenideElement progressBar = $(By.cssSelector("#progressBar > div"));
    private final String END_POINT = "/progress-bar";

    public ProgressBarPage open(){
        Selenide.open(AppConfig.baseUrl+END_POINT);
        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){
        return startStopButton.isDisplayed();
    }

    public ProgressBarPage clickWaitAndResetProgressBar(){
        startStopButton.click();

        (new WebDriverWait(getWebDriver(), Duration.ofSeconds(10)))
                .until(ExpectedConditions.attributeToBe(progressBar, "aria-valuenow","100"));

        resetButton.click();

        Assert.assertEquals("0", progressBar.getAttribute("aria-valuenow"));

        return this;
    }
}
