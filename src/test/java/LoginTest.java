import Base.BaseTest;
import Pages.AccountsPage;
import Pages.HomePage;
import io.qameta.allure.Feature;
import org.testng.annotations.*;


@Feature("Login test cases")
public class LoginTest extends BaseTest {

    //TC001 username: tester , password: engineer
    @Test(description = "TC001 Successful login")
    public void TC001() {
        HomePage homePage = new HomePage(driver);
        AccountsPage accountsPage = new AccountsPage(driver);

        homePage
                .usernameSet("tester")
                .passwordSet("engineer")
                .loginClick();

        accountsPage
                .accountsPageTextControl("Accounts Overview");
        attachScreenshot(driver);

    }

    @Test(description = "TC002 fail login-fail username and password")
    public void TC002() {
        HomePage homePage = new HomePage(driver);
        homePage
                .usernameSet("ddd")
                .passwordSet("aa")
                .loginClick()
                .loginErrorTextCheck("An internal error has occurred and has been logged.");
        attachScreenshot(driver);
    }

    @Test(description = "TC003 fail login-null password")
    public void TC003() {
        HomePage homePage = new HomePage(driver);
        homePage
                .usernameSet("ddd")
                .passwordSet("")
                .loginClick()
                .loginErrorTextCheck("Please enter a username and password.");
        attachScreenshot(driver);
    }

    @Test(description = "TC004 fail login-null username")
    public void TC004() {
        HomePage homePage = new HomePage(driver);
        homePage
                .usernameSet("")
                .passwordSet("sss")
                .loginClick()
                .loginErrorTextCheck("Please enter a username and password.");
        attachScreenshot(driver);
    }

   /* @Test
    public void TC005() {
    }*/
}
