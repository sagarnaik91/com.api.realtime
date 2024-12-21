package cucumberStepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginFunctionality {

    @Given("user navigates to the facesbook website")
    public void user_navigates_to_the_facesbook_website() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Given------user_navigates_to_the_facesbook_website");
    }
    @When("user validates the homepage title")
    public void user_validates_the_homepage_title() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("when----user_validates_the_homepage_title");
    }
    @Then("user enters {string} username")
    public void user_enters_username(String username) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then-----user_enters_username---->"+username);
    }
    @Then("user enters {string} password")
    public void user_enters_password(String password) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then ---- user_enters_password---->"+password);
    }
    @Then("user clicks on the signin button")
    public void user_clicks_on_the_signin_button() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then---user_clicks_on_the_signin_button");
    }

    @Then("validate the captcha image {string} and {string}")
    public void validate_the_captcha_image(String image1, String image2) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then---validate the captcha image------>"+image1+"---"+image2);
    }
}
