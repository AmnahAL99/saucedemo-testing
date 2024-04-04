package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Checkout_Page;
import pages.Home_page;
import pages.Login_Page;
import pages.Your_Cart_page;


public class Shopping {
    WebDriver driver;
    Login_Page objLogin;
    Home_page objHome;
    Your_Cart_page objYourCart;
    Checkout_Page objCheckout;

    @Given("launch chrome browser")
    public void launch_chrome_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("open SwagLab Login Page")
    public void open_login_page() {
        driver.get("https://www.saucedemo.com/");
        objLogin = new Login_Page(driver);
        objHome = new Home_page(driver);
        objYourCart = new Your_Cart_page(driver);
        objCheckout = new Checkout_Page(driver);
    }

    @Then("user is on swaglab login page")
    public void swaglab_login_page() {
        Assert.assertTrue(objLogin.swaglab_logo_present());
    }

    @When("user give {string} and {string}")
    public void user_enter_login_details(String string, String string2) {
        objLogin.enter_wrong_uname_pswd_using_example(string, string2);
    }

    @Then("user give UserName and Password")
    public void user_give_username_and_password() {
        objLogin.enter_username();
        objLogin.enter_password();
    }

    @Then("user is able to login")
    public void user_able_to_login() {
        objLogin.click_login_btn();
        Assert.assertTrue(objHome.app_logo_present());
    }

    @And("Close the browser")
    public void close_the_Browser() {
        driver.close();
    }

    @Given("user is on SwagLab Home Page")
    public void user_on_home_page() {
        Assert.assertTrue(objHome.app_logo_present());
    }

    @When("user added multiple products to cart")
    public void user_added_multiple_product() {
        objHome.click_add_to_cart_backpack();
        objHome.click_add_to_cart_light();
    }

    @Then("user able to go to shopping cart page")
    public void user_go_to_shopping_cart() {
        objHome.click_shopping_cart_icn();
        Assert.assertTrue(objYourCart.title_your_cart_present());
    }

    @Then("user able to checkout")
    public void user_checkout() {
        objYourCart.click_checkout_btn();
        Assert.assertTrue(objCheckout.title_checkout_present());
    }

    @When("I enter the checkout details with random data")
    public void enterRandomCheckoutDetails() {
        objCheckout.enter_random_checkout_details();
       objCheckout.click_continue_btn();
    }

    @Then("finish the order and get order successful message")
    public void finish_order_and_get_success_message() {
        objCheckout.click_finish_btn();
        Assert.assertTrue("THANK YOU FOR YOUR ORDER", objCheckout.order_successful_msg());
    }


    @Then("user is able to logout")
    public void user_logout() {
        objHome.click_menu_btn();
        objHome.menu_present();
        objHome.click_logout_btn();
        Assert.assertTrue(objLogin.swaglab_logo_present());
    }
}
