package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FooterPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(className = "footer")
    WebElement footerElement;

    @FindBy(className = "social_twitter")
    WebElement twitterIcon;

    @FindBy(className = "social_facebook")
    WebElement facebookIcon;

    @FindBy(className = "social_linkedin")
    WebElement linkedInIcon;

    public FooterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        PageFactory.initElements(driver, this);
    }

    public void verifyFooterAndIcons() {
        wait.until(ExpectedConditions.visibilityOf(footerElement));
        wait.until(ExpectedConditions.visibilityOf(twitterIcon));
        wait.until(ExpectedConditions.visibilityOf(facebookIcon));
        wait.until(ExpectedConditions.visibilityOf(linkedInIcon));
    }

    public void clickTwitterIcon() {
        twitterIcon.click();
    }

    public void verifyTwitterRedirect() {
        wait.until(ExpectedConditions.urlContains("twitter.com"));
    }

    public void clickFacebookIcon() {
        facebookIcon.click();
    }

    public void verifyFacebookRedirect() {
        wait.until(ExpectedConditions.urlContains("facebook.com"));
    }

    public void clickLinkedInIcon() {
        linkedInIcon.click();
    }

    public void verifyLinkedInRedirect() {
        wait.until(ExpectedConditions.urlContains("linkedin.com"));
    }
}
