package Pages;

import Base.BaseLib;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage extends BaseLib {
    private WebDriver driver;
    public AccountsPage(WebDriver driver){
        this.driver=driver;
    }
    @Step("Account page successful text check: {text}")
    public AccountsPage accountsPageTextControl(String text){
        String accountGetText = driver.findElement(By.cssSelector("#rightPanel > div > div > h1")).getText();
        Assert.assertEquals(accountGetText,text);

        return this;
    }
}
