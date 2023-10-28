import Base.BaseTest;
import Pages.HomePage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;


@Feature("Home Page test cases")
public class HomePageTest extends BaseTest{
    @Test(description = "TC001 Homepage Text Check")
    public void TC001(){

      HomePage homePage = new HomePage(driver);
      homePage
              .topPanelCaption("Experience the difference")
              .customerLogin("Customer Login");

  }
    @Test(description = "TC002 About Test")
    public void TC002(){

        HomePage homePage = new HomePage(driver);
        homePage
                .aboutClick()
                .aboutTitleTextCheck("ParaSoft Demo Website");

    }
}
