package tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.elements.*;

import java.io.IOException;


public class ElementsTests extends BaseTest {
    private static CheckboxPage checkboxPage;
    private static RadioButtonPage radioButtonPage;
    private static WebTablesPage webTablesPage;
    private static ButtonsPage buttonsPage;
    private static LinksPage linksPage;
    private static UploadAndDownloadPage uploadAndDownloadPage;
    private static DynamicPropertiesPage dynamicPropertiesPage;

    @BeforeClass
    public static void Before(){
        checkboxPage = new CheckboxPage();
        radioButtonPage = new RadioButtonPage();
        webTablesPage = new WebTablesPage();
        buttonsPage = new ButtonsPage();
        linksPage = new LinksPage();
        uploadAndDownloadPage = new UploadAndDownloadPage();
        dynamicPropertiesPage = new DynamicPropertiesPage();
    }

    @Test
    public void dynamicPropertiesPage(){
        dynamicPropertiesPage
                .open()
                .clickEnableAfterButton()
                .clickColorChangeButton()
                .clickVisibleAfterButton();
    }

    @Test
    public void downLoadFileTest() throws IOException {
        uploadAndDownloadPage
                .open()
                .downloadFile();
    }


    @Test
    public void linksTest(){
        linksPage
                .open()
                .clickLink();
    }

    @Test
    public void checkBoxTest(){
        checkboxPage
                .open()
                .checkCheckBox()
                .checkCheckBox();
    }

    @Test
    public void radioButtonTest(){
        radioButtonPage
                .open()
                .selectYes()
                .selectImpressive()
                .selectNo();
    }

    @Test
    public void getValueFromTableTest(){
        String value = webTablesPage
                .open()
                .getValueFromTable(1, 1);

        Assert.assertEquals("Cierra", value);

        value = webTablesPage.getValueFromTable(2, 2);

        Assert.assertEquals("Cantrell", value);
    }

    @Test
    public void buttonTest(){
        buttonsPage
                .open()
                .doubleClickButton();
    }
}
