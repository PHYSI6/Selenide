package pages.elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class WebTablesPage {
    private final SelenideElement addNewRecordButton = $(By.id("addNewRecordButton"));
    private final String END_POINT = "/webtables";

    public WebTablesPage open(){
        Selenide.open(AppConfig.baseUrl + END_POINT);

        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){return addNewRecordButton.isDisplayed();}

    public String getValueFromTable(int numberOfRow, int numberOfColumn){
        return $(By.xpath("((//div[@class='rt-tr-group'])[" + numberOfRow + "]//div[@class='rt-td'])[" + numberOfColumn + "]")).text();
    }
}
