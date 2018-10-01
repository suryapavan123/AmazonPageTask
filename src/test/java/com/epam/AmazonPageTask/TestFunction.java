package com.epam.AmazonPageTask;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.epam.pageObjectClasses.BooksCategoryPage;
import com.epam.pageObjectClasses.HomePage;
import com.epam.pageObjectClasses.LoginPage;
import com.epam.pageObjectClasses.PasswordPage;
import com.epam.pageObjectClasses.SearchedResults;
import com.epam.pageObjectClasses.UserNamePage;
import com.epam.pageObjectClasses.UsersHomePage;

/**
 * @author Pavan_Kotha
 *
 */
public class TestFunction {
     /**
     * object of searched results page.
     */
    static SearchedResults searchedResults;
     /**
     * object of books category page
     */
    static BooksCategoryPage booksCategoryPage;
     /**
     * object of web driver
     */
    static WebDriver driver;
    /**
     * performs the before actions
     */
    @BeforeClass
    public static void loadPage() {
        driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.open.apply("https://www.amazon.in");
        UserNamePage userNamePage = loginPage.clickLoginButton.get();
        PasswordPage passwordPage = userNamePage.enterUserName.apply("kothasurya2@gmail.com");
        UsersHomePage userHomePage = passwordPage.submitPassword.apply("Pavan@123");
        booksCategoryPage = userHomePage.selectCategory.get();
        searchedResults = booksCategoryPage.searchBook.get();
    }
    /**
     * tests the book name
     */
    @Test
    public void testBookName() {
        assertEquals("Selenium Testing Tools Cookbook -", searchedResults.getBookName());
    }
    /**tests the paperback
     * 
     */
    @Test
    public void testPaperBack() {
        searchedResults.selectPaperback();
        assertTrue(searchedResults.isPaperbackSelected.get());
    }
    /**
     * tests the search label
     */
    @Test
    public void testLabel() {
        assertEquals("Books", booksCategoryPage.getLabelName.get());
    }
    /**
     * tests the seemore functionality
     */
    @Test
    public void testSeeMoreLess() {
        assertTrue(searchedResults.seeMore.get() && searchedResults.seeLess.get());
    }
    /**
     * quits the driver
     */
    @AfterClass
    public static void end() {
        driver.quit();
    }
}
