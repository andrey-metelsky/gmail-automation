package com.gmail.automation;

import client.DriverFactory;

public class BaseTest {

    public void setDriver (String browserType, String appURL) {
        DriverFactory.getInstance().setDriver(browserType, appURL);
    }

    public void tearDown() {
        DriverFactory.getInstance().getWebDriver().quit();
    }
}