package com.epam.pageObjectClasses;

import java.util.List;
import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersHomePage extends Page {
    /**
     * element of shop by category option
     */
    @FindBy(xpath = "//*[@id=\"nav-link-shopall\"]/span[2]/span")
    WebElement shopByCategory;
    /**
     * element of books option
     */
    @FindBy(xpath = "//*[@id=\"nav-flyout-shopAll\"]/div[2]/span[15]/span")
    WebElement books;
    /**
     * element of all books option
     */
    @FindBy(xpath = "//*[@id=\"nav-flyout-shopAll\"]/div[3]/div[15]/div/a[1]/span")
    WebElement allBooks;
    /**
     * object for webdriver wait
     */
    WebDriverWait wait = new WebDriverWait(driver, 5);
    /**
     * @param driver object
     */
    public UsersHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    /**
     * selects the category of books and
     * @return the books category page object
     */
    public Supplier<BooksCategoryPage> selectCategory = () -> {
    	action.moveToElement(shopByCategory).perform();
        wait.until(ExpectedConditions.visibilityOf(shopByCategory));
        action.moveToElement(books).click();
        action.perform();
        wait.until(ExpectedConditions.visibilityOf(books));
        action.moveToElement(allBooks);
        action.click();
        action.perform();
        return new BooksCategoryPage(driver);
    };
}
