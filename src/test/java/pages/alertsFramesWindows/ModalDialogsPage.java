package pages.alertsFramesWindows;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ModalDialogsPage {
    private final SelenideElement showSmallModalButton = $(By.id("showSmallModal"));
    private final SelenideElement closeSmallModalButton = $(By.id("closeSmallModal"));
    private final String END_POINT = "/modal-dialogs";

    public ModalDialogsPage open(){
        Selenide.open(AppConfig.baseUrl + END_POINT);

        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){return showSmallModalButton.isDisplayed();}

    public void openAndCloseSmallModal(){
        showSmallModalButton.click();

        closeSmallModalButton.click();
    }
}
