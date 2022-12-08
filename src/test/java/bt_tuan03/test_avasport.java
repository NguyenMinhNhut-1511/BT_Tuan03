package bt_tuan03;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class test_avasport {
    WebDriver drive;
    static Logger log = LogManager.getLogger(test_avasport.class.getName());
    @Test
    public void OpenAvasport() {
        try {

            log.info("start");
            WebDriverManager.chromedriver().setup();

            drive = new ChromeDriver();
            JavascriptExecutor js = (JavascriptExecutor) drive;
            drive.get("https://staging.avasport.com/");
            drive.manage().window().maximize();
            log.info("Mở trang: " + drive.getTitle());
            log.info("Tìm phần khung search");

            WebElement a = drive.findElement(By.xpath("//input[@placeholder='Tìm kiếm tên thương hiệu, môn thể thao...']"));
            log.info("Click vào khung search");
            a.click();
            Thread.sleep(2000);
            log.info("Nhập từ khoá tìm kiếm: áo");
            a.sendKeys("áo");
            Thread.sleep(2000);
            drive.findElement(By.xpath("//h3[normalize-space()='Áo Thun Tennis Nam Erke 11221291061-001']")).click();
            log.info("Click sản phẩm");
            timeOutPageLoad(10);
            Thread.sleep(2000);
            drive.findElement(By.xpath("//p[contains(text(),'THÊM VÀO GIỎ')]")).click();
            log.info("Thêm sp vào giỏ hàng");
            drive.findElement(By.xpath("//i[@class='icon-cart']")).click();
            log.info("Xem giỏ hàng");

            js.executeScript("document.querySelector(\"body > div:nth-child(5) > section:nth-child(1) > div:nth-child(2) > div:nth-child(3) > form:nth-child(2) > div:nth-child(1) > span:nth-child(3) > i:nth-child(1)\").click();");
            log.info("Chọn giới tính");

            WebElement hoTen = drive.findElement(By.cssSelector("#cusName"));
            hoTen.sendKeys("IT test");
            log.info("Nhập họ tên");
            Thread.sleep(500);

            WebElement soDienThoai = drive.findElement(By.cssSelector("#cusPhone"));
            soDienThoai.sendKeys("0336727019");
            log.info("Nhập sdt");
            Thread.sleep(500);

            drive.findElement(By.cssSelector("form[class='active'] div[class='btn-click country'] button[type='button']")).click();
            Thread.sleep(2000);
            js.executeScript("document.querySelector(\"span[class='active']\").click()");
            log.info("Chọn tỉnh/thành phố");


            drive.findElement(By.cssSelector("form[class='active'] div[class='btn-click district'] button[type='button']")).click();
            Thread.sleep(2000);
            js.executeScript("document.querySelector(\"div[class='btn-click district'] aside:nth-child(1) span:nth-child(1)\").click()");
            Thread.sleep(2000);
            log.info("Chọn quận/huyện");

            drive.findElement(By.cssSelector("div[class='wards'] button[type='button']")).click();
            Thread.sleep(2000);
            js.executeScript("document.querySelector(\"div[class='wards'] aside:nth-child(1) span:nth-child(1)\").click()");
            log.info("Chọn phường/xã");

            WebElement diaChi = drive.findElement(By.cssSelector("#cusAddr"));
            diaChi.sendKeys("744 Cách Mạng Tháng 8");
            log.info("Nhập số nhà, tên đường");
            Thread.sleep(1000);

            timeOutPageLoad(10);
            drive.findElement(By.cssSelector("button[class='submitorder']")).click();
            Thread.sleep(2000);
            log.info("Đặt hàng");


            Thread.sleep(2000);
            drive.quit();
            log.info("End");
        } catch (Exception error) {
            System.out.println(error.toString());
        }
    }
    public void timeOutPageLoad(int time) {
        drive.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
    }
}

