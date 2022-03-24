import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.time.Duration;
import java.util.List;

public class Assignment3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sahankh\\Downloads\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        //launchUrl(driver);
        Booking(driver);

    }

    public static void launchUrl(WebDriver driver) throws InterruptedException {
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Frames")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Nested Frames")).click();
        Thread.sleep(3000);
        String title = driver.getTitle();
        String Exp = "Left";
        if(title.equals(Exp))
        {
            System.out.println("PASS");
        }
        else
        {
            System.out.println("FAIL");
        }
        driver.close();

    }
        public static void Dragdrop(WebDriver driver) throws InterruptedException {
            driver.get("https://www.google.com");
            driver.manage().window().maximize();
            driver.navigate().to("https://jqueryui.com/droppable/");
            Thread.sleep(5000);
            Actions act = new Actions(driver);
            WebElement src=driver.findElement(By.xpath("/html/body/div[1]"));
            WebElement dest=driver.findElement(By.xpath("/html/body/div[2]"));
            act.clickAndHold(src).pause(Duration.ofSeconds(2)).moveToElement(dest).pause(Duration.ofSeconds(2)).release().build().perform();

        }
    public static void Alert(WebDriver driver) throws InterruptedException {
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
        Alert simpleAlert = driver.switchTo().alert();
        String popup = simpleAlert.getText();
        System.out.println(popup);
        String Exp = "I am a JS Alert";
        if(popup.equals(Exp))
        {
            System.out.println("PASS");
        }
        else
        {
            System.out.println("FAIL");
        }
        Thread.sleep(2000);
        driver.quit();
    }
    public static void Booking(WebDriver driver) throws InterruptedException {
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.navigate().to("https://www.goibibo.com/");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/ul/li[2]/span[2]")).click();
        Thread.sleep(3000);
        String URL = "https://www.goibibo.com/flights/air-NYC-SEA-20220707-20220707-1-0-0-E-I?exp=n";
        driver.get(URL);

        List<WebElement> priceList = driver.findElements(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div/div"));
        for(int i=0;i<priceList.size();i++)
        {
            String str=priceList.get(i).getText().replace(",","");
            int price=Integer.parseInt(str);
            if(price>35000){
                driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div/button"));
                break;
            }
            Thread.sleep(3000);
        }
    }
}

