package Test;

import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utility.BaseDriver.WaitQuit;
import static Utility.BaseDriver.driver;

public class US_01_Test02_ {
    @Test
    public void Test01_Test02(){
        driver.navigate().to("https://www.saucedemo.com/");
        MyFunc.wait(2);
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='user-name']"));
        inputUsername.sendKeys("standard_user");
        MyFunc.wait(2);

        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        inputPassword.sendKeys("secret_sauc");
        MyFunc.wait(2);

        WebElement clickLoginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        clickLoginButton.click();
        MyFunc.wait(2);

        WebElement errorText = driver.findElement(By.xpath("//h3[@data-test='error']"));
        System.out.println(errorText.getText());

        Assert.assertEquals("Epic sadface: Username and password do " +
                "not match any user in this service", errorText.getText());


        MyFunc.wait(2);
        WaitQuit();

    }
}
