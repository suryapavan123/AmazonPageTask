package com.epam.pageObjectClasses;

import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserNamePage extends Page {
    /**
     * username element
     */
    @FindBy(id = "ap_email")
    WebElement username; 
    /**
     * @param driver object
     */
    public UserNamePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    /**
     * enters the username and submits
     * @return the object of PasswordPage class
     */
    public Function<String, PasswordPage> enterUserName = (userName) -> {
    	 username.sendKeys(userName);
         username.submit();
         return new PasswordPage(driver);
    };
}
