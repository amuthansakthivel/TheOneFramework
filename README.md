[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-orange.svg)](https://sonarcloud.io/summary/new_code?id=amuthansakthivel_theoneframework)

**Selenide + Rest Assured + Junit5 + Allure for Web, Mobile,and Api Automation**

One single framework to automate web, mobile and api.

**Preferred Java Version : JDK-11**

**Libraries Used**:
1. [Selenide for web and mobile automation](https://github.com/selenide/selenide)
2. [Rest Assured for Api automation](https://github.com/rest-assured/rest-assured)
3. [Junit5 as testing framework](https://junit.org/junit5/)
4. [Allure for reporting](https://docs.qameta.io/allure/)
5. [Owner for properties file management](https://github.com/matteobaccan/owner)
6. [Lombok to avoid boilerplates](https://github.com/projectlombok/lombok)
7. [PODAM for test data generation](https://mtedone.github.io/podam/usage.html)
8. [Java Faker for random data](https://github.com/DiUS/java-faker)
9. [AssertJ for fluent assertion of Api](https://assertj.github.io/doc/)

**Video tutorials**

[Selenide](https://www.youtube.com/watch?v=5vrYMfsxkGY&list=PL9ok7C7Yn9A9YyRISFrxHdaxb5qqrxp_i)

[Selenide-Appium](https://www.youtube.com/watch?v=fvATui0vptM&list=PL9ok7C7Yn9A-zVNGOdON0vYGevPD9nVwy)

[Rest-Assured](https://www.youtube.com/watch?v=aMkFmtqRUbE&list=PL9ok7C7Yn9A-JaUtcMwevO_FfbFNRYLfU)

[SDET Essentials playlist](https://www.youtube.com/watch?v=VpsnP9-jMNc&list=PL9ok7C7Yn9A_JtAB1-ZmrO7ugRq0rP83q)

**Sample Web Test**

```java
@SmokeTest
class AddEmployeeTest extends WebTestSetup {

  private final EmployeeDetails employeeDetails = EmployeeTestData.getRandomEmployeeDetails();
  private final LoginDetails loginDetails = LoginTestData.getValidLoginDetails();

  @WebTest
  void testAddEmployee() {
    LoginPage.getInstance()
        .loginToApplication(loginDetails)
        .navigateToEmployeeInformationPage()
        .addNewEmployee(employeeDetails)
        .checkWhetherEmployeeCreatedSuccessfully();
  }
}
```
**Sample Mobile Test**

```java
@RegressionTest
class AddToCartTest extends MobileTestSetup {

    @MobileTest
    void addAProductToCart() {
        ProductDetailsScreen productDetailsScreen = screen(ProductDetailsScreen.class);
        productDetailsScreen
                .selectProduct()
                .checkWhetherAddToCartButtonIsPresent();
    }
}
```

**Sample Api Test**

```java
@RegressionTest
class CreateUserTest extends ApiTestSetUp {

    private final UserDetails userDetails = UserTestData.getUserDetails();

    @ApiTest
    void createUser() {
        Response response = CreateUserApi.createUser(userDetails);

        assertThat(response)
                .statusCodeIs(201)
                .canBeDeserializedTo(CreateUserResponse.class)
                .hasKeyWithValue("job", userDetails.getJob())
                .andMatchingRule(e-> e.jsonPath().getString("name").equalsIgnoreCase(userDetails.getName()))
                .matchesSchemaInFile("create-user-response-schema.json")
                .assertAll(); //don't forget to call assertAll
    }
}
```

**To run web tests:**

```mvn clean test -Dgroups=web -Dselenide.browser=chrome```

```mvn clean test -Dgroups=web -Dselenide.browser=firefox```

**To run mobile tests:**

Local-Android | ```mvn clean test -Dgroups=mobile -Dselenide.browser=com.tmb.provider.mobile.local.AndroidAppProvider```

Local-Ios | ```mvn clean test -Dgroups=mobile -Dselenide.browser=com.tmb.provider.mobile.local.IosAppProvider```

Lambda-Test-Android | ```mvn clean test -Dgroups=mobile -Dselenide.browser=com.tmb.provider.mobile.remote.LambdaTestAndroidAppProvider```

**To run api tests:**

API     - ```mvn clean test -Dgroups=api```

**To generate allure report after execution**

Install Allure in the machine - ```brew install allure```

Open allure reports - ```allure serve ./target/allure-results```
