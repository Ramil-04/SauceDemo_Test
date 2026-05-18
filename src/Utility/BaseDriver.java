package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    static { // tearStart()
        driver = new ChromeDriver();
        MyFunc.wait(3); // shert deyil, sadece tedris ucun lazimdir
        driver.manage().window().maximize(); // brauzerimi cihaza gore maximum olaraq ach
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // driver cagirilarken problem yaranarsa 20 saniye gozlesin, eger 20 saniyeden cox olarsa
        // o zaman exception versin
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // Sehife yuklenmesi
        // max 20 saniye sehifenin yuklenmesine icaze ver, bu o demek deyil ki ! - sehifeni 20 saniyeye yujklecek
        // Xeyr! - eksine eger 3 saniyede yuklese elave 17 saniye gozlemecek. Sehife yuklenen kimi davam edecek
        // Bu bize sehifenin html-senedinin tam yuklenmesi ve var olan butun elementleri ishlemiz ucun vacidir

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Elementi gozlemek
        // Sehife yuklenen sonra (bezen sehife boyuk ve ya cihazimiz zeif ishleye biler)
        // Elementi tapmaq ucun max 20 saniye icazesi var. Ne zaman tapsa gozleme elave etmeyecek
    }

    public static void WaitQuit() { // tearDown()
        MyFunc.wait(2);
        driver.quit();
    }
}
