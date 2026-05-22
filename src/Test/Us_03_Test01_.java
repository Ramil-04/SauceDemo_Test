package Test;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Us_03_Test01_ extends BaseDriver {
    @Test
    public void Test01() {
        driver.get("https://www.saucedemo.com/"); //Sehifeye getdi
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));// xanalar dolduruldu ve login buttonuna klik edildi
        login.click();
        MyFunc.wait(2);

        WebElement backpackAdd = driver.findElement(By.name("add-to-cart-sauce-labs-backpack")); // ilk mehsul elave edildi
        backpackAdd.click();
        WebElement bikelightAdd = driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));// ikinci mehsul elave edildi
        bikelightAdd.click();

        WebElement basket  = driver.findElement(By.className("shopping_cart_link"));//sebete gedildi
        basket.click();
        MyFunc.wait(2);
        Assert.assertTrue("The page is not correct" , driver.getCurrentUrl().equals("https://www.saucedemo.com/cart.html"));

        WebElement removeBackpack = driver.findElement(By.id("remove-sauce-labs-backpack")); //mehsulun biri sebetden  silindi
        removeBackpack.click();

        List<WebElement> products = driver.findElements(By.className("inventory_item_name")); // mehsul silindikden sonra sebetin uzerindeki reqem azaldi
        Assert.assertEquals(1, products.size());
        Assert.assertEquals("Sauce Labs Bike Light", products.get(0).getText());

        WaitQuit();




    }

}
