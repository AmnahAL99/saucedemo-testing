package stepdefinitions;

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

import java.time.Duration;


public class Login {
     WebDriver driver;
     Login_Page objLogin;
     Home_page objHome;
     Your_Cart_page objYourCart;
     Checkout_Page objCheckout;


    @Given("Open the browser")
    public void open_the_browser() {
   driver= new ChromeDriver();
   driver.manage().window().maximize();
    }


    @When("Navigate to saucedemo login page")
    public void navigate_to_saucedemo_login_page() {
      driver.get("https://www.saucedemo.com");
      objLogin = new Login_Page(driver);
      objHome = new Home_page(driver);
      objYourCart = new Your_Cart_page(driver);
      objCheckout = new Checkout_Page(driver);
    }
    @Given("Swaglabs logo should exist")
    public void swaglabs_logo_should_exist() {
        Assert.assertTrue(objLogin.login_button_present());
    }
    @When("Login button should exist")
    public void login_button_should_exist() {
    Assert.assertTrue(objLogin.login_button_present());
    driver.close();
    }


    @When("^I enter valid (.*) and (.*)$")
    public void enter_valid_standard_user_and_secret_sauce(String Username, String Password) {
        objLogin.enter_uname_pswd_using_example2(Username, Password);
    }

    @Then("I click on log in button")
    public void i_verify_that_the_user_should_be_login() {
        objLogin.click_login_btn();


    }

    @Then("I should be login")
    public void i_verify_that_the_user_should_be_able_to_login() {
        Assert.assertTrue(objHome.app_logo_present());
        driver.close();
    }

    @When("enter username as standard_user and password as secret_sauce")
    public void user_give_right_username_and_password() {
        objLogin.enter_username();
        objLogin.enter_password();
    }

    @Given("click on log in button")
    public void user_login() {
        objLogin.click_login_btn();
        Assert.assertTrue(objHome.app_logo_present());
    }

    @When("able to see product page")
    public void swag_lab_home_page() {
        Assert.assertTrue(objHome.app_logo_present());
    }

    @When("able to see item in the cart")
    public void able_to_see_item_in_cart() {
        Assert.assertTrue(objHome.able_to_see_items());
    }

    @Then("add an item to cart")
    public void add_to_cart() {
        objHome.click_add_to_cart_backpack();
    }

    @Then("I click Shopping Cart icon")
    public void shopping_cart_icon() {
        objHome.click_shopping_cart_icn();
    }

    @Then("I Checkout an item and finish the order")
    public void checkout_and_finish() {
        objYourCart.click_checkout_btn();
        objCheckout.enter_first_name();
        objCheckout.enter_last_name();
        objCheckout.enter_postal_code();
        objCheckout.click_continue_btn();
        objCheckout.click_finish_btn();
        Assert.assertTrue("THANK YOU FOR YOUR ORDER", objCheckout.order_successful_msg());
    }

    @Then("click on logout button")
    public void user_able_to_logout() {
        objHome.click_menu_btn();
        objHome.menu_present();
        objHome.click_logout_btn();
        Assert.assertTrue(objLogin.swaglab_logo_present());
    }

    @Then("close browser")
    public void Close_browser() {
        driver.close();
    }


    }

