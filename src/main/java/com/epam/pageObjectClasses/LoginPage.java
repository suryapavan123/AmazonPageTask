package com.epam.pageObjectClasses;

import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page{
    /**
     * login button web element
     */
    @FindBy(id = "nav-link-yourAccount")
    private WebElement loginButton;
    /**
     * @param driver contains driver element
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    /**
     * @return the UserNamePage object
     */
    public Supplier<UserNamePage> clickLoginButton = () -> {
    	action.moveToElement(loginButton);
        action.click();
        action.perform();
        return new UserNamePage(driver);
    };
}
