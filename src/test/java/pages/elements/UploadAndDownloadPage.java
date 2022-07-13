package pages.elements;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AppConfig;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.FileDownloadMode.PROXY;
import static com.codeborne.selenide.Selenide.$;


public class UploadAndDownloadPage {
    private final SelenideElement downloadButton = $(By.id("downloadButton"));
    private final String END_POINT = "/upload-download";

    public UploadAndDownloadPage open(){
        Selenide.open(AppConfig.baseUrl + END_POINT);

        Assert.assertTrue(pageIsOpened());

        return this;
    }

    public boolean pageIsOpened(){
        return downloadButton.isDisplayed();
    }

    public UploadAndDownloadPage downloadFile() throws IOException {
        Configuration.downloadsFolder = "D:/OKAY QA/src/test/java/resources/files/";
        Configuration.proxyEnabled = true;
        Configuration.fileDownload = PROXY;
        File file = downloadButton.download();
        Assert.assertTrue(file.exists());

        FileUtils.deleteDirectory(new File(Configuration.downloadsFolder));

        return this;
    }

}
