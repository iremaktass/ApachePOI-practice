package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class GoogleSearch {

    GoogleSearchPage searchPage = new GoogleSearchPage();

    @Given("user is on google home page")
    public void user_is_on_google_home_page() {
        Driver.getDriver().get("https://www.google.com");
    }
    @When("user searches SDET")
    public void user_searches_sdet() {
        searchPage.searchBar.sendKeys("SDET"+ Keys.ENTER);
    }
    @Then("user should see SDET in title")
    public void user_should_see_sdet_in_title() {

        String actualTitle= Driver.getDriver().getTitle();
        String expectedTitle = "SDET";

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Then("user should be able to search for following:")
    public void user_should_be_able_to_search_for_following(List<String> items) {
        System.out.println("items: "+ items);

        for(String each : items){
            searchPage.searchBar.clear();
            searchPage.searchBar.sendKeys(each+Keys.ENTER);
        }

    }

    @When("user searches for {string} capital")
    public void user_searches_for_capital(String countryName) {
        System.out.println("Searching for capital city of "+countryName);
        searchPage.searchBar.sendKeys("What is the capital city of "+countryName+Keys.ENTER);
    }

    @Then("user should see {string} in the result")
    public void user_should_see_in_the_result(String capitalCity) {
        System.out.println("Expected capital city name "+capitalCity);
        Assert.assertEquals(capitalCity,searchPage.searchResultCityName.getText());
    }
}
