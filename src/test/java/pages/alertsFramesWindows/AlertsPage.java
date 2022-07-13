package pages.alertsFramesWindows;

import com.codeborne.selenide.ClickOptions;
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

public class AlertsPage {
    private final SelenideElement alertButton = $(By.id("alertButton"));
    private final SelenideElement timerAlertButton = $(By.id("timerAlertButton"));
    private final SelenideElement confirmButton = $(By.id("confirmButton"));
    private final SelenideElement promtButton = $(By.id("promtButton"));
    private final String END_POINT = "/alerts";

    public AlertsPage open(){
        Selenide.open(AppConfig.baseUrl + END_POINT);

        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){return alertButton.isDisplayed();}

    public AlertsPage clickAndConfirmAlertButton(){
        alertButton.click(ClickOptions.usingJavaScript());

        Selenide.switchTo().alert().accept();

        return this;
    }

    public AlertsPage clickAndConfirmTimerAlertButton(){
        timerAlertButton.click(ClickOptions.usingJavaScript());

        (new WebDriverWait(getWebDriver(), Duration.ofSeconds(5)))
                .until(ExpectedConditions.alertIsPresent()).accept();

        return this;
    }

    public AlertsPage clickAndConfirmConfirmAlertButton(){
        confirmButton.click(ClickOptions.usingJavaScript());

        Selenide.switchTo().alert().accept();

        return this;
    }
    public AlertsPage clickAndEnterTextAlertPromtButton(String text){
        promtButton.click(ClickOptions.usingJavaScript());

        Selenide.switchTo().alert().sendKeys(text);
        Selenide.switchTo().alert().accept();

        return this;
    }
}
