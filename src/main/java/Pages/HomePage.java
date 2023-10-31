package Pages;

import Base.BaseLib;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BaseLib {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    @Step("Username is filled")
    public HomePage usernameSet(String text){
        driver.findElement(By.name("username")).sendKeys(text);

        return this;
    }
    @Step("Password is filled")
    public HomePage passwordSet(String pass){
        driver.findElement(By.name("password")).sendKeys(pass);

        return this;
    }
    @Step("Click on the login button")
    public HomePage loginClick(){
        driver.findElement(By.cssSelector("#loginPanel > form > div:nth-child(5) > input")).click();

        return this;
    }
    @Step("Login Error text check: {text}")
    public HomePage loginErrorTextCheck(String text){
        String loginErrorText = driver.findElement(By.cssSelector("#rightPanel > p")).getText();
        Assert.assertEquals(loginErrorText,text);
        Allure.addAttachment(text+ ": error message displayed","#rightPanel > p");
        attachScreenshot(driver);
        return this;
    }

    public HomePage topPanelCaption(String text){
        String topPanelCaptionCheck = driver.findElement(By.className("caption")).getText();
        Assert.assertEquals(topPanelCaptionCheck,text);
        Allure.addAttachment(text+ ": Home Page topPanel title displayed","By.className(\"caption\")");
        attachScreenshot(driver);
        return this;
    }
    public HomePage customerLogin(String text){
        String customerLoginTextCheck = driver.findElement(By.cssSelector("#leftPanel > h2")).getText();
        Assert.assertEquals(customerLoginTextCheck,text);
        attachScreenshot(driver);

        return this;
    }
    public HomePage aboutClick(){
        driver.findElement(By.cssSelector("#headerPanel > ul.button > li.aboutus > a")).click();

        return this;
    }
    public HomePage aboutTitleTextCheck(String text){
        String aboutTextTitle  = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/h1")).getText();
        Assert.assertEquals(aboutTextTitle,text);
        Allure.addAttachment(text+ ": About Page title displayed","//*[@id=\"rightPanel\"]/h1");
        attachScreenshot(driver);
        return this;
    }

}
