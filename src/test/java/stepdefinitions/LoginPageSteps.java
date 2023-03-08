package stepdefinitions;


import com.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {
    private com.pages.LoginPage loginPage = new com.pages.LoginPage(DriverFactory.getDriver());
    private static String title;
    @Given("User is on Login Page")
    public void user_is_on_login_page() {
     DriverFactory.getDriver().get("https://www.vervecoffee.com/account/login");
    }

    @When("User gets Page title")
    public void user_gets_page_title() {
        title = loginPage.getLoginPageTitle();
        System.out.println("Title is "+ title);
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String string) {
        Assert.assertEquals(string, title);
    }

    @Then("Forgot password link is displayed")
    public void forgot_password_link_is_displayed() {
        Assert.assertTrue(loginPage.isPasswordLinkDisplayed());
    }

    @When("User enters email {string}")
    public void user_enters_email(String string) {
     loginPage.enterEmail(string);
    }
    @When("User enters password {string}")
    public void user_enters_password(String string) {
       loginPage.enterPassword(string);
    }
    @When("User clicks Sign in button")
    public void user_clicks_sign_in_button() {
       loginPage.clickSignin();
    }


}
