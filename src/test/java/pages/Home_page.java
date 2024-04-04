package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static qa.GenericWrappers.ClickButton;
import static qa.GenericWrappers.FilterButton;

public class Home_page {
    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement logo_app;
    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    WebElement btn_menu;
    @FindBy(xpath = "//*[@id=\"menu_button_container\"]/div/div[2]/div[1]")
    WebElement menu_container;
    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    WebElement btn_logout;
    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    WebElement title_item;
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    WebElement btn_add_to_cart;
    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement icn_shopping_cart;
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    WebElement btn_add_to_cart_light;
    @FindBy(className = "inventory_item_name")
    WebElement item_name;
    @FindBy(className = "inventory_item_price")
    WebElement item_price;

    WebDriver driver;
    public Home_page (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean app_logo_present() {
        return logo_app.isDisplayed();
    }

    public void click_menu_btn() {
        btn_menu.click();
    }

    public boolean menu_present() {
        return menu_container.isDisplayed();
    }

    public void click_logout_btn() {
        btn_logout.click();
    }

    public void click_item_title() {
        title_item.click();
    }

    public void click_add_to_cart_backpack() {
        btn_add_to_cart.click();
    }

    public void click_shopping_cart_icn() {
        icn_shopping_cart.click();
    }

    public void click_add_to_cart_light() {
        btn_add_to_cart_light.click();
    }

    public void click_filter_dropdown_thru_generic_wrapper() {
        FilterButton("product_sort_container");
    }



    public void select_name_a_to_z_thru_generic_wrapper() {
    //    ClickButton("//select[@class='product_sort_container']/option[1]");

        List<WebElement> beforeFilterNameAToZ = driver.findElements(By.className("inventory_item_name"));
        // 1.1 Remove symbol if not needed and convert the string into double
        List<String> beforeFilterNameListAToZ = new ArrayList<>();

        for (WebElement atoz : beforeFilterNameAToZ) {
            beforeFilterNameListAToZ.add(atoz.getText().replace("Test.allTheThings() T-Shirt (Red)","Sauce Labs T-Shirt Red"));
        }

        // 2. Select the filter from dropdown
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Name (A to Z)");

        // 3. Capture name after filtering
        List<WebElement> afterFilterNameAToZ = driver.findElements(By.className("inventory_item_name"));
        // 3.1 Remove symbol if not needed and convert the string into double
        List<String> afterFilterNameListAToZ = new ArrayList<>();

        for (WebElement atoz : afterFilterNameAToZ) {
            afterFilterNameListAToZ.add(atoz.getText().replace("Test.allTheThings() T-Shirt (Red)","Sauce Labs T-Shirt Red"));
        }

        // Compare the values/Assert the values (sort the values of beforeFilterName
        Collections.sort(beforeFilterNameListAToZ); // It will sort the values in the list (Ascending orders)
        Assert.assertEquals(beforeFilterNameListAToZ, afterFilterNameListAToZ);

    }





    public boolean see_the_product_a_to_z() {
        return item_name.isDisplayed();
    }

    public void select_name_z_to_a_thru_generic_wrapper() {
      //  ClickButton("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[2]");
        // 1. Capture name before filtering and make ascending order
        List<WebElement> beforeFilterNameZToA = driver.findElements(By.className("inventory_item_name"));
        // 1.1 Remove symbol if not needed and convert the string into double
        List<String> beforeFilterNameListZToA = new ArrayList<>();

        for (WebElement ztoa : beforeFilterNameZToA) {
            beforeFilterNameListZToA.add(ztoa.getText().replace("Test.allTheThings() T-Shirt (Red)","Sauce Labs T-Shirt Red"));
        }

        // 2. Select the filter from dropdown
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Name (Z to A)");

        // 3. Capture name after filtering
        List<WebElement> afterFilterNameZToA = driver.findElements(By.className("inventory_item_name"));
        // 3.1 Remove symbol if not needed and convert the string into double
        List<String> afterFilterNameListZToA = new ArrayList<>();

        for (WebElement ztoa : afterFilterNameZToA) {
            afterFilterNameListZToA.add(ztoa.getText().replace("Test.allTheThings() T-Shirt (Red)","Sauce Labs T-Shirt Red"));
        }

        // Compare the values/Assert the values (sort the values of beforeFilterName
        Collections.reverse(beforeFilterNameListZToA); // It will sort the values in the list (Descending orders)
        Assert.assertEquals(beforeFilterNameListZToA, afterFilterNameListZToA);

    }

    public boolean see_the_product_z_to_a() {
        return item_name.isDisplayed();
    }

    public void select_price_low_to_high_thru_generic_wrapper() {
      //  ClickButton("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]");
        // 1. Capture name before filtering and make ascending order
        List<WebElement> beforeFilterPriceLoToHi = driver.findElements(By.className("inventory_item_price"));
        // 1.1 Remove symbol if not needed and convert the string into double
        List<Double> beforeFilterPriceListLoToHi = new ArrayList<>();

        for (WebElement lowhigh : beforeFilterPriceLoToHi) {
            beforeFilterPriceListLoToHi.add(Double.valueOf(lowhigh.getText().replace("$","")));
        }

        // 2. Select the filter from dropdown
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Price (low to high)");

        // 3. Capture name after filtering
        List<WebElement> afterFilterPriceLoToHi = driver.findElements(By.className("inventory_item_price"));
        // 3.1 Remove symbol if not needed and convert the string into double
        List<Double> afterFilterPriceListLoToHi = new ArrayList<>();

        for (WebElement lowhigh : afterFilterPriceLoToHi) {
            afterFilterPriceListLoToHi.add(Double.valueOf(lowhigh.getText().replace("$","")));
        }

        // Compare the values/Assert the values (sort the values of beforeFilterName
        Collections.sort(beforeFilterPriceListLoToHi); // It will sort the values in the list (Ascending orders)
        Assert.assertEquals(beforeFilterPriceListLoToHi, afterFilterPriceListLoToHi);
    }

    public boolean see_the_price_low_to_high() {
        return item_price.isDisplayed();
    }

    public void select_price_high_to_low_thru_generic_wrapper() {
     //   ClickButton("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]");

        // 1. Capture name before filtering and make ascending order
        List<WebElement> beforeFilterPriceHiLo = driver.findElements(By.className("inventory_item_price"));
        // 1.1 Remove symbol if not needed and convert the string into double
        List<Double> beforeFilterPriceListHiLo = new ArrayList<>();

        for (WebElement highlow : beforeFilterPriceHiLo) {
            beforeFilterPriceListHiLo.add(Double.valueOf(highlow.getText().replace("$", "")));
        }

        // 2. Select the filter from dropdown
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Price (high to low)");

        // 3. Capture name after filtering
        List<WebElement> afterFilterPriceHiLo = driver.findElements(By.className("inventory_item_price"));
        // 3.1 Remove symbol if not needed and convert the string into double
        List<Double> afterFilterPriceListHiLo = new ArrayList<>();

        for (WebElement highlow : afterFilterPriceHiLo) {
            afterFilterPriceListHiLo.add(Double.valueOf(highlow.getText().replace("$", "")));
        }

        // Compare the values/Assert the values (sort the values of beforeFilterName
        Collections.sort(beforeFilterPriceListHiLo);
        Collections.reverse(beforeFilterPriceListHiLo); // It will sort the values in the list (Descending orders)
        Assert.assertEquals(beforeFilterPriceListHiLo, afterFilterPriceListHiLo);

    }

    public boolean see_the_price_high_to_low() {
        return item_price.isDisplayed();
    }

    public void click_menu_btn_thru_generic_wrapper() {
        ClickButton("//*[@id=\"react-burger-menu-btn\"]");
    }

    public void click_logout_btn_thru_generic_wrapper() {
        ClickButton("//a[@id='logout_sidebar_link']");
    }

    public boolean able_to_see_items(){
        return icn_shopping_cart.isDisplayed();
    }
}
