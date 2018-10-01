package com.epam.pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Pavan_Kotha
 *
 */
public abstract class Page {
    /**
     * contains action object
     */
    protected final Actions action;
    /**
     * contains web driver
     */
    protected final WebDriver driver;
    /**
     * @param driver contains the webdriver object.
     */
    public Page(WebDriver driver) {
            this.driver = driver;
            action = new Actions(driver); 
    }
    /**
     * @return the webdriver object.
     */
    public WebDriver getDriver() {
            return this.driver;
    }
    /**
     * @return the action object
     */
    public Actions getActions() {
        return this.action;
    }
}
