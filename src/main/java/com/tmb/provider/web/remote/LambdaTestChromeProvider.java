package com.tmb.provider.web.remote;

import com.codeborne.selenide.WebDriverProvider;
import com.tmb.config.FrameworkConfig;
import com.tmb.config.factory.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LambdaTestChromeProvider implements WebDriverProvider {

    private static final FrameworkConfig CONFIG = ConfigFactory.config();
    private static final String LAMBDA_TEST_USER_NAME = CONFIG.lambdaTestUserName();
    private static final String LAMBDA_TEST_ACCESS_KEY = CONFIG.lambdaTestAccessKey();

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("114.0");
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("video", true);
        ltOptions.put("build", "test-build");
        ltOptions.put("name", "test-demo");
        ltOptions.put("project", "demo-project");
        browserOptions.setCapability("LT:Options", ltOptions);
        String lambdaTestRemoteUrl = String.format("https://%s:%s@hub.lambdatest.com/wd/hub", LAMBDA_TEST_USER_NAME, LAMBDA_TEST_ACCESS_KEY);
        try {
            return new RemoteWebDriver(new URL(lambdaTestRemoteUrl), browserOptions);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}