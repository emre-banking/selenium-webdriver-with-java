// This class provides a constructor to initialize the WebDriver instance and contains methods to interact with the page.

package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Objects;

public class LoginPage extends BasePage{

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.xpath("//button[@class='radius']");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public SecureAreaPage login(String username, String password) {
        return Allure.step("Login with valid username and password", step -> {
            step.parameter("Username", username);
            step.parameter("Passsword", password);
            enterUsername(username);
            enterPassword(password);
            return clickLoginButton();
        });
    }

    public void assertLoginSuccess(String actualText) {
        Allure.step("Verify login success message is displayed", () ->
                Assert.assertTrue(
                        actualText.contains("You logged into a secure area!"),
                        "Login failed."
                )
        );
    }

    private void enterUsername(String username){
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField))).sendKeys(username);
    }

    private void enterPassword(String password){
        Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField))).sendKeys(password);
    }

    private SecureAreaPage clickLoginButton(){
        Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(loginButton))).click();
        return new SecureAreaPage(driver);
    }
}
