package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage
{
    public TodoPage(WebDriver driver) {super(driver);}

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcome;

    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement addButton;

    @FindBy(css = "[data-testid=\"todo-item\"]" )
    private WebElement todoItems ;

    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement deleteItem;

    @FindBy (css = "[data-testid=\"no-todos\"]")
    private WebElement noTodo;

    @Step
    public boolean isWelcomeMessageDisplayed()
    {
       return welcome.isDisplayed();
    }
    @Step
    public String getTodoText()
    {
        return todoItems.getText();
    }
    @Step
    public boolean notTodoMessageDisplay(){
        return noTodo.isDisplayed();
    }
    @Step
    public NewTodoPage clickOnPlusButton(){
        addButton.click();
        return new NewTodoPage(driver);
    }
    @Step
    public TodoPage clickOnDeleteItemButton(){
        deleteItem.click();
        return this;
    }
}
