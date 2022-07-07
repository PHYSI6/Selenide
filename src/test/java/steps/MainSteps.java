package steps;
import org.junit.Assert;
import pages.MainPage;

public class MainSteps {
    MainPage mainPage = new MainPage();

    public MainSteps openMainPage(){
        mainPage.open();
        Assert.assertTrue(mainPage.pageIsOpened());

        return this;
    }

    public MainSteps inputFirstAndLastName(String firstname, String lastname){
        mainPage.inputFirstName(firstname);
        mainPage.inputLastName(lastname);

        return this;
    }

    public MainSteps inputEmail(String email){
        mainPage.inputEmail(email);

        return this;
    }

    public MainSteps selectMaleCheckBox(){
        mainPage.selectMailCheckBox();

        return this;
    }

    public MainSteps inputPhoneNumber(String number){
        mainPage.inputPhoneNumber(number);

        return this;
    }

    public MainSteps inputAndSelectSubject(String text, int number){
        mainPage.inputSubject(text);

        return this;
    }

    public MainSteps inputDateOfBirth(String date){
        mainPage.inputDateOfBirth(date);

        return this;
    }

    public MainSteps selectSportCheckBox(){
        mainPage.selectSportCheckBox();

        return this;
    }

    public MainSteps uploadFile(String filepath){
        mainPage.uploadFile(filepath);

        return this;
    }

    public MainSteps inputCurrentAddress(String address){
        mainPage.inputCurrentAddress(address);

        return this;
    }
}
