package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    @Before
    public void loadUrl() {

        openBrowser();
    }

    @Test

    public void userShouldNavigateToLoginPageSuccessfully(){

        WebElement loginbutton = driver.findElement(By.xpath("//a[@href='/users/sign_in']"));
        loginbutton.click();

        String expectedMessage = "Welcome Back!";
        WebElement actualElement = driver.findElement(By.xpath("//h1[normalize-space()='Welcome Back!']"));
       String actualMessage= actualElement.getText();
        System.out.println(actualMessage);

        WebElement emailId = driver.findElement(By.name("user[email]"));
        emailId.sendKeys("geeta1945p@gmail.com"); // entering username

        WebElement password = driver.findElement(By.xpath("//input[@name='user[password]']"));
        password.sendKeys("secret_sauce"); //finding element and enetering password

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button button-primary g-recaptcha']"));
        loginButton.click();// first we find webelement with xpath in above line and then we used clicked method

        String expectedMessage1 = "Invalid email or password.";

        WebElement actualMessageElement = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualMessage2 = actualMessageElement.getText();

        Assert.assertEquals(expectedMessage1,actualMessage2);


    }

    public void closeUrl(){

        quitAllUrl();
    }

}
