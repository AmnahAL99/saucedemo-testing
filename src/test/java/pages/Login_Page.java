package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static qa.GenericWrappers.*;

public class Login_Page {
    @FindBy(xpath = "//div[@class='login_logo']")
    WebElement logo_swaglab;
    @FindBy(id = "user-name")
    WebElement txt_username;
    @FindBy(id = "password")
    WebElement txt_password;
    @FindBy(xpath = "//input[@id='login-button']")
    WebElement btn_login;
    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    WebElement error_message;

    WebDriver driver;
    public Login_Page (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean swaglab_logo_present(){
        return logo_swaglab.isDisplayed();
    }

    public void enter_username(){
        txt_username.sendKeys("standard_user");
    }

    public void enter_password(){
        txt_password.sendKeys("secret_sauce");
    }

    public void enter_wrong_username(){
        txt_username.sendKeys("Amnah");
    }
    public void enter_wrong_password(){
        txt_password.sendKeys("Amnah123");
    }
    public void click_login_btn(){
        btn_login.click();
    }
    public boolean uname_pswd_not_match_msg(){
        return error_message.isDisplayed();
    }
    public void enter_uname_pawd_using_example(String string, String string2){
        txt_username.sendKeys(string);
        txt_password.sendKeys(string2);
    }


    public void enter_wrong_uname_pswd_using_example(String userName , String password){
        txt_username.sendKeys(userName);
        txt_password.sendKeys(password);
    }
        public boolean login_button_present(){
        return btn_login.isDisplayed();
        }

    public void click_login_btn_thru_generic_wrapper() {
        ClickButton("//*[@id=\"login-button\"]");
    }

    public void enter_uname_pswd_using_example2(String uname ,String pawd){
        txt_username.sendKeys(uname);
        txt_password.sendKeys(pawd);
    }

    public void enter_username_and_password_thru_generic_wrapper() {
        SendKeys("user-name");
        sendkeys("password");

    }
}
