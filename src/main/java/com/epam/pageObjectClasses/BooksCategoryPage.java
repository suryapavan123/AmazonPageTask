package com.epam.pageObjectClasses;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BooksCategoryPage extends Page{
    /**
     * search box element
     */
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;
    /**
     * element of searchlabel category
     */
    @FindBy(className = "nav-search-label")
    WebElement searchLabel;
    /**
     * stores the searchLabel name
     */
    private String labelName;
    /**
     * object for web driver wait
     */
    WebDriverWait wait = new WebDriverWait(driver, 5);
    /**
     * @param driver object
     */
    public BooksCategoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    /**
     * seraches the book and,
     * @return the object of searched results
     */
    public Supplier<SearchedResults> searchBook = () -> {
    	searchBox.sendKeys("Selenium with java");
        searchBox.submit();
        return new SearchedResults(driver);
    };
    /**
     * @return the search label name
     */
    public Supplier<String> getLabelName = () -> {
        wait.until(ExpectedConditions.visibilityOf(searchLabel));              
        labelName = searchLabel.getText();
        System.out.println(labelName);
        return labelName;
    };
}
