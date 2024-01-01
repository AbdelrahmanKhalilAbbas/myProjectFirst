package com.qacart.todo.pages;
import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Properties;

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(css = "[data-testid=\"email\"]")
    private WebElement emailInput;
    @FindBy(css = "[data-testid=\"password\"]")
    private WebElement passwordInput;
    @FindBy(css = "[data-testid=\"submit\"]")
    private WebElement submitButton;
    @Step("Load the login page")
    public LoginPage load(){

        driver.navigate().to(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }
    @Step
    public TodoPage login(String email, String password)
    {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitButton.click();
        return new TodoPage(driver);
    }
}
