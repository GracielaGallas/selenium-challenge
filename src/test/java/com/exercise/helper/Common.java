package com.exercise.helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Common {

    public static String dateTimeToFile() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(ts);
    }

    public static void printLog(String message) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss").format(ts) + " " + message);
    }

    public static void take(WebDriver browser, String file) {
        File screenshot = ((TakesScreenshot) browser).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(file));
        } catch (Exception e) {
            System.out.println("It was impossible to take a screenshot" + e.getMessage());
        }
    }

}
