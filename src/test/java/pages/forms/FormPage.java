package pages.forms;

import com.codeborne.selenide.*;
import config.AppConfig;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.io.File;
import static com.codeborne.selenide.Selenide.$;


public class FormPage {
    private final SelenideElement firstnameField = $(By.id("firstName"));
    private final SelenideElement lastNameField = $(By.id("lastName"));
    private final SelenideElement emailField = $(By.id("userEmail"));
    private final SelenideElement maleCheckbox = $(By.xpath("//input[@value='Male']"));
    private final SelenideElement phoneField = $(By.id("userNumber"));
    private final SelenideElement subjectsField = $(By.id("subjectsContainer"));
    private final SelenideElement sportCheckBox = $(By.id("hobbies-checkbox-1"));
    private final SelenideElement dateOfBirthField = $(By.id("dateOfBirthInput"));
    private final SelenideElement uploadPictureButton = $(By.id("uploadPicture"));
    private final SelenideElement currentAddressField = $(By.id("currentAddress"));
    private final String END_POINT = "/automation-practice-form";

    public FormPage open(){
        Selenide.open(AppConfig.baseUrl+END_POINT);
        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){
        return firstnameField.isDisplayed();
    }

    public FormPage inputFirstName(String firstname){
        firstnameField.click();
        firstnameField.setValue(firstname);

        Assert.assertEquals(firstname, firstnameField.getValue());

         return this;
    }

    public FormPage inputLastName(String lastname){
        lastNameField.click();
        lastNameField.setValue(lastname);

        Assert.assertEquals(lastname, lastNameField.getValue());

        return this;
    }

    public FormPage inputEmail(String email){
        emailField.click();
        emailField.setValue(email);

        Assert.assertEquals(email,emailField.getValue());

        return this;
    }

    public FormPage inputCurrentAddress(String address){
        currentAddressField.click(ClickOptions.usingJavaScript());
        currentAddressField.setValue(address);

        Assert.assertEquals(address,currentAddressField.getValue());

        return this;
    }

    public FormPage selectMailCheckBox(){
        maleCheckbox.click(ClickOptions.usingJavaScript());

        maleCheckbox.shouldBe(Condition.checked);

        return this;
    }

    public FormPage inputPhoneNumber(String number){
        phoneField.click();
        phoneField.setValue(number);

        Assert.assertEquals(number,phoneField.getValue());

        return this;
    }

    public FormPage inputDateOfBirth(String date){
        dateOfBirthField.click();

        dateOfBirthField.sendKeys(Keys.CONTROL + "A");
        dateOfBirthField.sendKeys(date);
        dateOfBirthField.sendKeys(Keys.ENTER);

        Assert.assertEquals(date,dateOfBirthField.getValue());

        return this;
    }

    public FormPage selectSportCheckBox(){
        sportCheckBox.click(ClickOptions.usingJavaScript());

        sportCheckBox.shouldBe(Condition.checked);

        return this;
    }

    public FormPage uploadFile(String filePath){
        File file = new File(filePath);
        uploadPictureButton.uploadFile(file);

        return this;
    }

}
