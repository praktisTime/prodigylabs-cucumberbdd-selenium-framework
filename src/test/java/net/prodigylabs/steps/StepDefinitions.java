package net.prodigylabs.steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.prodigylabs.pages.ContactPage;
import net.prodigylabs.utilities.ConfigReader;
import net.prodigylabs.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitions {
    ContactPage contactPage = new ContactPage();
    WebDriverWait explicitWait = new WebDriverWait(Driver.getDriver(),5 );
    Faker faker = new Faker();


    @Given("user navigates to the homepage")
    public void user_navigates_to_the_homepage() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }

    @Then("verify that Contact link is available on the page")
    public void verify_that_link_is_available_on_the_page() {
        Assert.assertTrue(contactPage.contactLink.isDisplayed());

    }

    @When("user clicks the on Contact link")
    public void user_clicks_the_on_link() {
        contactPage.contactLink.click();

    }

    @Then("verify  contact email is {string}")
    public void verify_contact_email_is(String givenEmail) {
        explicitWait.until(ExpectedConditions.visibilityOf(contactPage.emailText));
        Assert.assertEquals(givenEmail, contactPage.emailText.getText());

    }

    @Then("verify  office address  is {string}")
    public void verify_office_address_is(String givenAddress) {
        explicitWait.until(ExpectedConditions.visibilityOf(contactPage.addressText));
        Assert.assertEquals(givenAddress, contactPage.addressText.getText().replace("\n"," "));

    }

    @When("user fills the form with random valid information")
    public void user_fills_the_form_with_random_valid_information()  {
        Driver.getDriver().switchTo().frame(contactPage.iframeID);
        contactPage.firstnameBox.sendKeys(faker.name().firstName());
        contactPage.lastnameBox.sendKeys(faker.name().lastName());

        contactPage.messageBox.sendKeys(faker.chuckNorris().fact());

    }

    @When("user enter invalid email address")
    public void user_enter_invalid_email_address()  {
        contactPage.emailBox.sendKeys(faker.name().firstName());

    }

    @Then("verify that error message {string} is displayed")
    public void verify_that_error_message_email_must_be_formatted_correctly_is_displayed(String message)  {
        explicitWait.until(ExpectedConditions.visibilityOf(contactPage.emailErrorMessage));

        Assert.assertEquals(message, contactPage.emailErrorMessage.getText());
    }

    @Then("user enter valid email address")
    public void user_enter_valid_email_address() {
        contactPage.emailBox.clear();
        contactPage.emailBox.sendKeys(faker.internet().emailAddress());

    }

    @Then("user selects Industry as {string} from the dropdown")
    public void user_selects_industry_as_banking_from_the_dropdown(String givenIndustry)  {

        Select industry = new Select(contactPage.industryDropdown);
        industry.selectByVisibleText(givenIndustry);
    }

    @Then("user enters City as {string}")
    public void user_enters_city_as(String cityName) {
        contactPage.cityBox.sendKeys(cityName);

    }

    @Then("user clicks submit the form")
    public void user_clicks_submit_the_form()  {
        contactPage.submitButton.click();

    }


}
