package pages;

import com.codeborne.selenide.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.io.File;
import static com.codeborne.selenide.Selenide.$;


public class MainPage {
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
    private final String URL = "https://demoqa.com/automation-practice-form";

    public MainPage open(){
        Selenide.open(URL);

        return this;
    }

    public boolean pageIsOpened(){
        return firstnameField.isDisplayed();
    }

    public void inputFirstName(String firstname){
        firstnameField.click();
        firstnameField.setValue(firstname);

        Assert.assertEquals(firstname, firstnameField.getValue());
    }

    public void inputLastName(String lastname){
        lastNameField.click();
        lastNameField.setValue(lastname);

        Assert.assertEquals(lastname, lastNameField.getValue());
    }

    public void inputEmail(String email){
        emailField.click();
        emailField.setValue(email);

        Assert.assertEquals(email,emailField.getValue());
    }

    public void inputCurrentAddress(String address){
        currentAddressField.click(ClickOptions.usingJavaScript());
        currentAddressField.setValue(address);

        Assert.assertEquals(address,currentAddressField.getValue());
    }

    public void selectMailCheckBox(){
        maleCheckbox.click(ClickOptions.usingJavaScript());

        maleCheckbox.shouldBe(Condition.checked);
    }

    public void inputPhoneNumber(String number){
        phoneField.click();
        phoneField.setValue(number);

        Assert.assertEquals(number,phoneField.getValue());
    }

    public void inputSubject(String subjects){
        subjectsField.sendKeys(subjects);
        Assert.assertEquals(subjects,subjectsField.getValue());
    }

    public void inputDateOfBirth(String date){
        dateOfBirthField.click();

        dateOfBirthField.sendKeys(Keys.CONTROL + "A");
        dateOfBirthField.sendKeys(date);
        dateOfBirthField.sendKeys(Keys.ENTER);

        Assert.assertEquals(date,dateOfBirthField.getValue());
    }

    public void selectSportCheckBox(){
        sportCheckBox.click(ClickOptions.usingJavaScript());

        sportCheckBox.shouldBe(Condition.checked);
    }

    public void uploadFile(String filePath){
        File file = new File(filePath);
        uploadPictureButton.uploadFile(file);
    }

}
