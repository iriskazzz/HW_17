package ru.bork.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.bork.pages.components.SideMenu;
import ru.bork.pages.RecipesPage;
import ru.bork.pages.StartPage;

@Owner("izolina")
@Feature("Дополнительное меню каталога")
public class RecipesTests extends TestBase {
    StartPage startPage = new StartPage();
    RecipesPage recipesPage = new RecipesPage();
    SideMenu sideMenu = new SideMenu();

    @Test
    @Tag("recipes")
    @Story("Рецепты")
    @DisplayName("Проверка открытия страницы рецепта")
    void checkOpenRecipeTest() {
        startPage.openPage();
        sideMenu.openSideMenu()
                .openSectionSideMenu("Рецепты");
        recipesPage.openRecipe()
                .checkRecipe();
    }
}
