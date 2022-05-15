package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginStep extends AbstractFuncTest{

    WebDriver driver;

    @Given("Be on the main screen")
    public void beOnTheMainScreen() throws InterruptedException {
        AbstractFuncTest.mainUrl = mainUrl;
        driver = new ChromeDriver();
        driver.get(mainUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @And("Access the login screen")
    public void accessTheLoginScreen() {
        driver.findElement(By.cssSelector(".right_list_fix > li > a > .fa-user")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Given("I fill {string} as {string}")
    public void iFillAs(String fieldImputName, String fieldImputValue) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement imputName = driver.findElement(By.id(fieldImputName));
        imputName.sendKeys(fieldImputValue);
    }
    @When("I click on login button")
    public void iClickOnLoginButton() throws InterruptedException {
        Thread.sleep(9000);
        driver.findElement(By.id("btnLogin")).click();
    }
    @Then("I am logged in")
    public void iAmLoggedIn() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String loggedInMessage = driver.findElement(By.id("swal2-title")).getText();
        Assert.assertEquals("Login realizado", loggedInMessage);
        driver.quit();
    }
    @Then("I receive the error message {string}")
    public void iReceiveTheErrorMessage(String errorMessageDefined) {
        String errorMessageReceive = driver.findElement(By.className("invalid_input")).getText();
        Assert.assertEquals(errorMessageReceive, errorMessageDefined);
        driver.quit();
    }
}
