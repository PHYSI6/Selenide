package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.FileDownloadMode.PROXY;


public class BaseTest {

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.downloadsFolder = "D:/OKAY QA/src/test/java/resources/files/";
        Configuration.proxyEnabled = true;
        Configuration.fileDownload = PROXY;
        Configuration.driverManagerEnabled = true;
    }

    @Before
    public void init(){
        setUp();
    }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }

}
