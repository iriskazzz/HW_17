package ru.bork.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RecipesPage {

    private String recipecontent = "Ингредиенты";

    private final SelenideElement
            recipeTitle = $(".recipe__content_title"),
            article = $("article");

    @Step("Открытие страницы рецепта")
    public RecipesPage openRecipe() {
        article.click();
        return this;
    }

    @Step("Проверка контента на странице рецепта")
    public RecipesPage checkRecipe() {
        recipeTitle.shouldHave(text(recipecontent));
        return this;
    }
}
