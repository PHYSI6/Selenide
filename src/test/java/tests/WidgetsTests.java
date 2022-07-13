package tests;

import org.junit.BeforeClass;
import org.junit.Test;
import pages.widgets.AutoCompletePage;
import pages.widgets.SliderPage;

public class WidgetsTests extends BaseTest{
    private static AutoCompletePage autoCompletePage;
    private static SliderPage sliderPage;

    @BeforeClass
    public static void Before(){
        autoCompletePage = new AutoCompletePage();
        sliderPage = new SliderPage();
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
}
