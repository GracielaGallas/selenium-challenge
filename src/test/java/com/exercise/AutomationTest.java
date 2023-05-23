package com.exercise;

import com.exercise.helper.WebdriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public class AutomationTest {

    protected WebDriver browser;

    @BeforeClass
    protected void setup() {
        browser = WebdriverFactory.build();
    }

    @AfterClass
    protected void tearDown() {
        browser.close();
    }

    public void cleanReports(String targetFolder) {
        //clean reports folder
        try {
            File folder = new File(targetFolder);
            if (folder.exists()) {
                FileUtils.cleanDirectory(folder);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
