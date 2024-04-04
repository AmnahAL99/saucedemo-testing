package pages;

import com.github.javafaker.Faker;
import com.google.common.collect.Table;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Checkout_Page {

    @FindBy(xpath = "//*[@id=\"first-name\"]")
    WebElement txt_first_name;

    @FindBy(xpath = "//*[@id=\"last-name\"]")
    WebElement txt_last_name;

    @FindBy(xpath = "//*[@id=\"postal-code\"]")
    WebElement txt_postal_code;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    WebElement btn_continue;

    @FindBy(xpath = "//*[@id=\"finish\"]")
    WebElement btn_finish;

    @FindBy(xpath = "//*[@id=\"checkout_complete_container\"]/h2")
    WebElement msg_order_successful;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    WebElement title_checkout_your_information;

    WebDriver driver;
    Faker faker;

    public Checkout_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        faker = new Faker();
    }

    public void enter_first_name() {
        txt_first_name.sendKeys("Sumit");
    }

    public void enter_last_name() {
        txt_last_name.sendKeys("Rana");
    }

    public void enter_postal_code() {
        txt_postal_code.sendKeys("246734");
    }

    public void click_continue_btn() {
        btn_continue.click();
    }

    public void click_finish_btn() {
        btn_finish.click();
    }

    public boolean order_successful_msg() {
        return msg_order_successful.isDisplayed();
    }

    public boolean title_checkout_present() {
        return title_checkout_your_information.isDisplayed();
    }


    public void enter_random_checkout_details() {

            String first_name = faker.name().firstName();
            String last_name = faker.name().lastName();
            String zip_postal_code = faker.address().zipCode();

            txt_first_name.sendKeys(first_name);
            txt_last_name.sendKeys(last_name);
            txt_postal_code.sendKeys(zip_postal_code);

        }

}
