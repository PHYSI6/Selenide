package tests;

import org.junit.BeforeClass;
import org.junit.Test;
import pages.widgets.*;

public class WidgetsTests extends BaseTest{
    private static AutoCompletePage autoCompletePage;
    private static SliderPage sliderPage;
    private static ProgressBarPage progressBarPage;
    private static ToolTipsPage toolTipsPage;
    private static MenuPage menuPage;
    private static SelectMenuPage selectMenuPage;

    @BeforeClass
    public static void Before(){
        autoCompletePage = new AutoCompletePage();
        sliderPage = new SliderPage();
        progressBarPage = new ProgressBarPage();
        toolTipsPage = new ToolTipsPage();
        menuPage = new MenuPage();
        selectMenuPage = new SelectMenuPage();
    }

    @Test
    public void autoCompleteTest(){
        autoCompletePage
                .open()
                .typeValueIntoContainer("R", "Red")
                .typeValueIntoContainer("G", "Green");
    }

    @Test
    public void sliderTest(){
        sliderPage
                .open()
                .setSliderValue(50)
                .setSliderValue(30)
                .setSliderValue(0)
                .setSliderValue(100);
    }

    @Test
    public void progressBarTest(){
        progressBarPage
                .open()
                .clickWaitAndResetProgressBar();
    }

    @Test
    public void topTipsTest(){
        toolTipsPage
                .open()
                .checkTextFromHoverButton("You hovered over the Button");
    }

    @Test
    public void menuTest(){
        menuPage
                .open()
                .selectMenuItems();
    }

    @Test
    public void selectMenuTest(){
        selectMenuPage
                .open()
                .selectOldByText("Green");
    }
}
