package com.project.tests;

import com.project.pages.HomePage;
import com.project.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isDisplayed(), "Home page should be displayed after login");
    }

    @Test
    public void invalidUsernameTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("invalid_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"),
                "Expected error for invalid username");
    }

    @Test
    public void invalidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("wrong_password");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"),
                "Expected error for invalid password");
    }

    @Test
    public void emptyUsernameTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"),
                "Expected error for empty username");
    }

    @Test
    public void emptyPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.getErrorMessage().contains("Password is required"),
                "Expected error for empty password");
    }
}

