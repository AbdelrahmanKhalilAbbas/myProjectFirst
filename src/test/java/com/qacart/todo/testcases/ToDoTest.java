package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Feature("Todo Feature")
public class ToDoTest extends BaseTest {
    @Story("Add Todo")
    @Test(description = "Should be able to add a new todo correctly")
    public void shouldBeAbleToAddNewTodo()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        String actualResult;
        actualResult = loginPage
                .load()
                .login(ConfigUtils.getInstance().getEmail(),
                        ConfigUtils.getInstance().getPassword())
                .clickOnPlusButton()
                .addNewTask("Learn Selenium")
                .getTodoText();
        Assert.assertEquals(actualResult,"Learn Selenium");
    }

    @Story("Delete Todo")
    @Test(description = "Should be able to a delete todo correctly")
    public void shouldBeAbleToDeleteTodo ()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        boolean isNotTodoMessageDisplayed = loginPage
                .load()
                .login(ConfigUtils.getInstance().getEmail(),
                        ConfigUtils.getInstance().getPassword())
                .clickOnPlusButton()
                .addNewTask("Learn Selenium")
                .clickOnDeleteItemButton()
                .notTodoMessageDisplay();
        Assert.assertTrue(isNotTodoMessageDisplayed);
    }
}
