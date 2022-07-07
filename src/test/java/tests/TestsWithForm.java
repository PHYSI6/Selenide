package tests;

import org.junit.Before;
import org.junit.Test;
import steps.MainSteps;

public class TestsWithForm extends BaseTest {
    private MainSteps mainSteps;

    @Before
    public void Before(){
        mainSteps = new MainSteps();
    }

    @Test
    public void fillingOutTheFormTest(){
        mainSteps.openMainPage()
                .inputFirstAndLastName("Danii","Borisevich")
                .inputEmail("borisevich.daniel@gmail.com")
                .selectMaleCheckBox()
                .inputPhoneNumber("1234567890")
                .inputDateOfBirth("15 Mar 2002")
                //.inputAndSelectSubject("Computer",1);
                .selectSportCheckBox()
                .uploadFile("src/test/java/resources/me.jpg")
                .inputCurrentAddress("Minsk");
    }
}
