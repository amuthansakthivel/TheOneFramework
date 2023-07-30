**Selenide + Rest Assured + Junit5 + Allure for Web, Mobile,and Api Automation**

[Video Tutorials about how to create this framework](https://www.youtube.com/watch?v=5vrYMfsxkGY&list=PL9ok7C7Yn9A9YyRISFrxHdaxb5qqrxp_i)

**To run web tests:**

```mvn clean test -Dgroups=web -Dselenide.browser=chrome```

```mvn clean test -Dgroups=web -Dselenide.browser=firefox```

**To run mobile tests:**

android - ```mvn clean test -Dgroups=mobile -Dselenide.browser=com.tmb.provider.SauceLabAndroidProvider```

ios     - ```mvn clean test -Dgroups=mobile -Dselenide.browser=com.tmb.provider.SauceLabIosAppProvider```

**To run api tests:**

api     - ```mvn clean test -Dgroups=api```

**To generate allure report after execution**

```allure serve ./target/allure-results```

**Download apps from here**

https://github.com/saucelabs/my-demo-app-rn/releases

https://github.com/appium/android-apidemos/releases
