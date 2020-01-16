package com.search.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BrowserManager {

    static {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver webDriver;

    public BrowserManager(WebDriver webDriver){
        this.webDriver = webDriver;
        initWebDriverOptions();
    }

    public void openBrowserWitUrl(String url) {
        webDriver.get(url);
    }

    public void closeBrowser(){
        webDriver.close();
    }

    public WebDriver getDriver() {
        return webDriver;
    }

    private void initWebDriverOptions() {
        PageFactory.initElements(webDriver,this);
        WebDriver.Options driverOption = webDriver.manage();
        driverOption.timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
