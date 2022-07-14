package tests;

import org.junit.BeforeClass;
import org.junit.Test;
import pages.interactions.SelectablePage;
import pages.interactions.SortablePage;

public class InteractionsTest extends BaseTest{
    private static SortablePage sortablePage;
    private static SelectablePage selectablePage;

    @BeforeClass
    public static void Before(){
        sortablePage = new SortablePage();
        selectablePage = new SelectablePage();
    }

    @Test
    public void sortableTest(){
        sortablePage
                .open()
                .moveElement(1, 2)
                .moveElement(1, 2);
    }

    @Test
    public void selectablePage(){
        selectablePage
                .open()
                .selectElement(2)
                .selectElement(3);
    }
}
