package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By inventoryContainer = By.id("inventory_container");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return isDisplayed(inventoryContainer);
    }
}

