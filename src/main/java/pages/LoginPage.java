// This class represents the Login Page of the application.
// It provides a constructor to initialize the WebDriver instance and contains methods to interact with the page.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@class='radius']");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    // Enters the given username in the username field
    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    // Enters the given password in the password field
    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    // Clicks the login button and returns a new instance of the SecureAreaPage
    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }
}
