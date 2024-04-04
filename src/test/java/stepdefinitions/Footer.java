package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;

public class Footer {

       WebDriver driver;
        Login_Page objLogin;
        FooterPage footerPage;

        @Given("User is on a login page")
        public void userIsOnALoginPage() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/v1/");
            objLogin = PageFactory.initElements(driver, Login_Page.class);
            footerPage = PageFactory.initElements(driver, FooterPage.class);

            Duration duration = Duration.ofSeconds(8);
            WebDriverWait wait = new WebDriverWait(driver, duration);
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/"));
        }

        @When("User fill a username and password")
        public void userFillAUsernameAndPassword() {
            objLogin.enter_username();
            objLogin.enter_password();
        }

        @And("User click the login")
        public void userClickTheLogin() {
            objLogin.click_login_btn();
        }

        @Then("Website direct to products page and contains footer and social media icons")
        public void websiteDirectToProductsPageAndContainsFooterAndSocialMediaIcons() {
            footerPage.verifyFooterAndIcons();
        }

        @And("User click twitter icon")
        public void userClickTwitterIcon() {
            footerPage.clickTwitterIcon();
        }

        @Then("Website will direct to twitter page")
        public void websiteWillDirectToTwitterPage() {
            footerPage.verifyTwitterRedirect();
        }

        @And("User click facebook icon")
        public void userClickFacebookIcon() {
            footerPage.clickFacebookIcon();
        }

        @Then("Website will direct to facebook page")
        public void websiteWillDirectToFacebookPage() {
            footerPage.verifyFacebookRedirect();
        }

        @And("User click linkedin icon")
        public void userClickLinkedinIcon() {
            footerPage.clickLinkedInIcon();
        }

        @Then("Website will direct to linkedin page")
        public void websiteWillDirectToLinkedinPage() {
            footerPage.verifyLinkedInRedirect();
        }

        
    }





