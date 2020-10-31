package com.library2.step_definitions;

import com.library2.pages.BooksPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Books_StepDefinitions {

    BooksPage booksPage = new BooksPage();


    @Given("I am at the Books Management page")
    public void i_am_at_the_books_management_page() {
        booksPage.loginAsStudent();
    }

    @When("I click column {string}")
    public void i_click_column(String string) {
        booksPage.clickOnHeaderElement(string);
    }
    @Then("records should be sorted in {string} order by column {string}")
    public void records_should_be_sorted_in_order_by_column(String string, String string2) {
        String actualSortOrder = booksPage.currentSortedOrderOfHeaderElement(string2);
        String expectedOrder = string;
        Assert.assertEquals(expectedOrder,actualSortOrder);
    }

}
