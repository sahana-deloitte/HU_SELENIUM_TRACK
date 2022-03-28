package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import Pages.LoginPage;
import java.util.List;

public class LoginTest {
    LoginPage login;
    WebDriver driver;
    String url = "https://www.saucedemo.com/";

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sahankh\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Test(priority = 1)
    public void validateLogin() throws InterruptedException {
        login = new LoginPage(this.driver);
        login.enterUsername();
        login.enterPassword();
        login.clickLogin();
        Thread.sleep(3000);
    }
}

    /*@Test(priority = 2)
    public void HighToLow() throws InterruptedException
    {
        List<WebElement> beforeFilterPrice = driver.findElements(By.className("inventory_item_price"));
        List<Double>beforeFilterPriceList = new ArrayList();
        for(WebElement p: beforeFilterPrice){
            beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$","")));
        }
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Price (high to low)");
        List<WebElement> afterFilterPrice = driver.findElements(By.className("inventory_item_price"));
        List<Double>afterFilterPriceList = new ArrayList<>();
        for(WebElement p: afterFilterPrice){
            beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$","")));
        }
        Collections.sort(beforeFilterPriceList);
        Collections.reverse(beforeFilterPriceList);
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void testAddToCart() throws InterruptedException
    {
        String price = driver.findElement(By.className("inventory_item_price")).getText();
        int limit = 100;
        price = price.replace("$","");
        double priceValue = Integer.parseInt(price.substring(0,price.indexOf(".")));
        System.out.println("PriceValue : "+priceValue);
        if( limit > priceValue) {
            driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
            Thread.sleep(3000);
        }
        else {
            System.out.println("It is grater than 100");
        }
    }

    @Test(priority = 4)
    public void removeProducts() throws InterruptedException
    {
        List<WebElement> removeProductBtnList = driver.findElements(By.id("remove-sauce-labs-fleece-jacket"));
        for (WebElement removeProductBtn : removeProductBtnList ) {
            removeProductBtn.click();
            Thread.sleep(3000);//you can also use this line instead of the above,
            //but it will probably return a StaleElementReferenceException after the first click.
        }
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("shopping_cart_container")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("continue-shopping")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 5)
    public void LowToHigh() throws InterruptedException
    {
        List<WebElement> beforeFilterPrice = driver.findElements(By.className("inventory_item_price"));
        List<Double>beforeFilterPriceList = new ArrayList();
        for(WebElement p: beforeFilterPrice)
        {
            beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$","")));
        }

        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Price (low to high)");

        List<WebElement> afterFilterPrice = driver.findElements(By.className("inventory_item_price"));
        List<Double>afterFilterPriceList = new ArrayList<>();
        for(WebElement p: afterFilterPrice)
        {
            beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$","")));
        }
        Collections.sort(beforeFilterPriceList);
        Thread.sleep(3000);
    }
    @Test(priority = 6)
    public void testAddToCartAgain() throws InterruptedException
    {
        String price = driver.findElement(By.className("inventory_item_price")).getText();
        int limit = 100;
        price = price.replace("$","");
        double priceValue = Double.parseDouble(price.substring(0,price.indexOf(".")));
        System.out.println("PriceValue : "+priceValue);
        if( limit > priceValue)
        {
            driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
            Thread.sleep(3000);
        }
        else
        {
            driver.quit();
        }
        driver.findElement(By.id("shopping_cart_container")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 7)
    public void checkout() throws InterruptedException
    {
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 8)
    public void enterCredentials() throws InterruptedException
    {
        login=new LoginPage(this.driver);
        login.enterFirstName();
        login.enterLastName();
        login.enterPinCode();
        Thread.sleep(3000);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='finish']")).click();
    }
    @AfterSuite
    public void backToHome(){
        driver.findElement(By.xpath("//*[@id=\'back-to-products\']")).click();
    }*/


