package com.epam.pageObjectClasses;

import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PasswordPage extends Page{
    /**
     * element of password textbox
     */
    @FindBy(id = "ap_password")
    WebElement password;
    /**
     * @param driver object
     */
    public PasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    /**
     * enters the password into textbox and submits
     * @return the HomeLoginPage object
     */
    public Function<String, UsersHomePage> submitPassword = (loginPassword) -> {
    	 password.sendKeys(loginPassword);
         password.submit();
         return new UsersHomePage(driver);
    };
}
