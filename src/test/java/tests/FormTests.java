package tests;

import org.junit.BeforeClass;
import org.junit.Test;
import pages.forms.FormPage;

public class FormTests {
    private static FormPage formPage;

    @BeforeClass
    public static void Before(){
        formPage = new FormPage();
    }

    @Test
    public void fillingOutTheFormTest(){

        formPage
                .open()
                .inputFirstName("Daniil")
                .inputLastName("Borisevich")
                .inputEmail("borisevich.daniel@gmail.com")
                .selectMailCheckBox()
                .inputPhoneNumber("1234567890")
                .inputDateOfBirth("15 Mar 2002")
                .selectSportCheckBox()
                .uploadFile("src/test/java/resources/me.jpg")
                .inputCurrentAddress("Minsk");
    }
}
