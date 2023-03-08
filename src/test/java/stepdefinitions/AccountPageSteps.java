package stepdefinitions;

import com.factory.DriverFactory;
import com.pages.AccountPage;
import com.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class AccountPageSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountPage accountPage;
    private String title;

    @Given("User is already logged in")
    public void user_is_already_logged_in(DataTable dataTable) {
      List<Map<String, String>> listCred = dataTable.asMaps();
        String userName = listCred.get(0).get("username");
        String password = listCred.get(0).get("password");

        DriverFactory.getDriver().get("https://www.vervecoffee.com/account/login");
        accountPage = loginPage.login(userName, password);
    }

    @Given("User is on Account Page")
    public void user_is_on_account_page() {
        title = accountPage.getTitle();
    }
    @Then("User gets categories")
    public void user_gets_categories(DataTable categoriesTable) {
     List<String> expectedCategories = categoriesTable.asList();
     List<String> actualCategories = accountPage.getCategoriesList();
        System.out.println("Expected " + expectedCategories);
        System.out.println("Actual " + actualCategories);
    }

    @Then("Categories count should be {int}")
    public void categories_count_should_be(Integer int1) {
        System.out.println(accountPage.getCategoriesCount());
    }


}
