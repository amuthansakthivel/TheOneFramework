package com.tmb.provider.mobile.remote;

import com.codeborne.selenide.WebDriverProvider;
import com.tmb.config.FrameworkConfig;
import com.tmb.config.factory.ConfigFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class LambdaTestAndroidAppProvider implements WebDriverProvider {

    private static final FrameworkConfig CONFIG = ConfigFactory.config();
    private static final String LAMBDA_TEST_APP_URL = CONFIG.lambdaTestAppUrl();
    private static final String LAMBDA_TEST_REMOTE_URL = CONFIG.lambdaTestRemoteUrl();

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("w3c", true);
        ltOptions.put("platformName", "android");
        ltOptions.put("deviceName", "Pixel 4");
        ltOptions.put("platformVersion", "10");
        ltOptions.put("app", LAMBDA_TEST_APP_URL);
        ltOptions.put("video", true);
        ltOptions.put("build", "test-build");
        ltOptions.put("name", "test-demo");
        ltOptions.put("project", "demo-project");
        ltOptions.put("autoGrantPermissions", true);
        ltOptions.put("autoAcceptAlerts", true);
        ltOptions.put("isRealMobile", true);
        ltOptions.put("appiumVersion", "2.0");
        options.setCapability("lt:options", ltOptions);

        try {
            return new AndroidDriver(new URL(LAMBDA_TEST_REMOTE_URL), options);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}