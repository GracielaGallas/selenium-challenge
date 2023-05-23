package com.exercise.pages;


import com.exercise.helper.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.exercise.helper.Common.printLog;
import static com.exercise.helper.Common.take;
import static com.exercise.helper.WebdriverFactory.TARGET_FOLDER;
import static org.junit.Assert.assertEquals;

public class StepOnePage {

    private final WebDriver browser;
    private final WebDriverWait wait;
    private static final String TEST_REPORT_FOLDER = "./reports/StepOnePage/";

    public StepOnePage(WebDriver browser) {
        this.browser = browser;
        this.wait = new WebDriverWait(browser, 5);
    }

    public StepOnePage checkAddAttachment(String addAttachmentPath, String fileToAttach) {
        String newAttachmentNamePath = "//a[contains(.,'" + fileToAttach + "')]";

        browser
                .findElement(By.id(addAttachmentPath))
                .sendKeys(TARGET_FOLDER.getAbsolutePath() + "/" + fileToAttach);
        String actualFileName = browser.findElement(By.xpath(newAttachmentNamePath)).getText();
        assertEquals(fileToAttach, actualFileName);
        take(browser, TEST_REPORT_FOLDER + "checkAddAttachment" + Common.dateTimeToFile() + ".png");
        printLog("checkAddAttachment = Passed");
        return this;
    }

    public void checkNextPageButton(String expectedTitle) {
        String nextPageButtonPath = "//span[2]/div";
        String stepTwoPageTitlePath = "//app-step2/h2";

        browser.findElement(By.xpath(nextPageButtonPath)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(stepTwoPageTitlePath)));
        String actualTitle = browser.findElement(By.xpath(stepTwoPageTitlePath)).getText();

        assertEquals(expectedTitle, actualTitle);
        take(browser, TEST_REPORT_FOLDER + "checkNextPageButton" + Common.dateTimeToFile() + ".png");
        printLog("checkNextPageButton = Passed");
    }

}
