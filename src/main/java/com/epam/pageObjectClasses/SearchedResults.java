package com.epam.pageObjectClasses;

import java.util.List;
import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchedResults extends Page{
    /**
     * element of stars($ stars and more)
     */
    @FindBy(xpath = "//span[text()='4 Stars & Up'] ")
    WebElement stars;
    /**
     * selenium book name element
     */
    @FindBy(xpath = "//h2[text()='Selenium Testing Tools Cookbook -'] ")
    WebElement seleniumBookName;
    /**
     * element of seemore option
     */
    @FindBy(xpath = "//i[@class = 'a-icon a-icon-extender-expand']")
    WebElement seeMoreOption;
    /**
     * element of seemore option
     */
    @FindBy(xpath = "//i[@class = 'a-icon a-icon-extender-collapse']")
    WebElement seeLessOption;
    /**
     * element of paperback option
     */
    @FindBy(xpath ="//span[@class = 'a-size-small a-color-base s-ref-text-link s-ref-link-cursor' and text() = 'Paperback']")
    WebElement paperBack;
    /**
     * contains the name of the selenium book
     */
    private String bookName;
    /**
     * object for webdriver wait
     */
    WebDriverWait wait = new WebDriverWait(driver, 5);
    /**
     * @param driver object
     */
    public SearchedResults(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    /**
     * @return tests whether seemore option is running or not.
     */
    public Supplier<Boolean> seeMore = () -> {
    	 stars.click();
         wait.until(ExpectedConditions.visibilityOf(seeMoreOption));
         seeMoreOption.click();
         List <WebElement> seeMoreTags = driver.findElements(By.xpath("//"
                 + "div[@class = 'a-expander-content a-ex"
                 + "pander-extend-content a-expander-content-expanded']"));
         if (seeMoreTags.size() == 1)
        	 return true;
         else return false;
    };
    /**
     * @return tests whether seeless option is running or not.
     */
    public Supplier<Boolean> seeLess = () -> {
         boolean testSeemore = false;
 		WebDriverWait wait = new WebDriverWait(driver, 10);
 		WebElement element1 = wait.until(ExpectedConditions.visibilityOf(seeLessOption));
 		element1.click();
 		if (seeMoreOption != null) {
 			testSeemore = true;
 		}
 		return testSeemore;
    };
    /**
     * selects paperback option
     */
    public void selectPaperback() {
        paperBack.click();
    }
    /**
     * @return the book name.
     */
    public String getBookName() {
        bookName = seleniumBookName.getText();
        return bookName;
    }
    /**
     * @return if paperback is selected or not.
     */
    public Supplier<Boolean> isPaperbackSelected = () -> {
    	return paperBack.isEnabled();
    };
}
