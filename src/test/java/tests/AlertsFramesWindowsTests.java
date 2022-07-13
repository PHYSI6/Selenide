package tests;

import org.junit.BeforeClass;
import org.junit.Test;
import pages.alertsFramesWindows.AlertsPage;
import pages.alertsFramesWindows.FramesPage;
import pages.alertsFramesWindows.ModalDialogsPage;
import pages.alertsFramesWindows.NestedFramesPage;

public class AlertsFramesWindowsTests extends BaseTest{
    private static AlertsPage alertsPage;
    private static FramesPage framesPage;
    private static NestedFramesPage nestedFramesPage;
    private static ModalDialogsPage modalDialogsPage;


    @BeforeClass
    public static void Before() {
        alertsPage = new AlertsPage();
        framesPage = new FramesPage();
        nestedFramesPage = new NestedFramesPage();
        modalDialogsPage = new ModalDialogsPage();
    }

    @Test
    public void alertsTest(){
        alertsPage
                .open()
                .clickAndConfirmAlertButton()
                .clickAndConfirmTimerAlertButton()
                .clickAndConfirmConfirmAlertButton()
                .clickAndEnterTextAlertPromtButton("Daniil");
    }

    @Test
    public void framesTest(){
        framesPage
                .open()
                .checkTextInFrame("This is a sample page");
    }

    @Test
    public void nestedFramesTest(){
        nestedFramesPage
                .open()
                .checkTextInParentFrame("Parent frame")
                .checkTextInChildFrame("Child Iframe");
    }

    @Test
    public void modalDialogsTest(){
        modalDialogsPage
                .open()
                .openAndCloseSmallModal();
    }
}
