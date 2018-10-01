package com.epam.pageObjectClasses;

import java.util.function.Function;

import org.openqa.selenium.WebDriver;


/**
 * @author Pavan_Kotha
 *
 */
public class HomePage extends Page {
    /**
     * @param driver contains the driver object.
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }
    /**
     * opens the webpage.
     */
    public Function<String, LoginPage> open = (URL) -> {
    	getDriver().get(URL);
        return new LoginPage(driver);
    };
}
