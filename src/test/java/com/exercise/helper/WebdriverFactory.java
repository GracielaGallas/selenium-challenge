package com.exercise.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static com.exercise.helper.PropertiesConfiguration.properties;

public class WebdriverFactory {

    public static final File TARGET_FOLDER = new File("assets");
    public static final String URL = "https://thg-greenair.dev.wgv.onpier.de/landing";

    public static WebDriver build() throws AssertionError {
        String chromedriver = properties.getProperty("webdriver.location");

        //opening browser
        System.setProperty("webdriver.chrome.driver", chromedriver);
        //to run headless
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");

        //default Download
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.download_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", TARGET_FOLDER.getAbsolutePath());
        chromePrefs.put("upload.default_directory", TARGET_FOLDER.getAbsolutePath());
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, options);

        WebDriver browser = new ChromeDriver(options);
        browser.manage().window().maximize();

        //open desired page
        browser.get(String.format(URL));
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return browser;
    }


}
