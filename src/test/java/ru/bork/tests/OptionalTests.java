package ru.bork.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.bork.components.Searcher;
import ru.bork.pages.GoodsPage;
import ru.bork.pages.StartPage;

@Owner("izolina")
@Feature("Меню пользователя")
public class OptionalTests extends TestBase {
    StartPage startPage = new StartPage();

    GoodsPage goodsPage = new GoodsPage();
    Searcher searcher = new Searcher();

    @Test
    @Tag("rightMenu")
    @Tag("searcher")
    @Story("Поисковик")
    @DisplayName("Проверка работы поисковика")
    void checkSearchTest() {
        startPage.openPage();
        searcher.clickSearch()
                .inputSearch("Воздухоочиститель-увлажнитель A705");
        goodsPage.checkArticle("https://www.bork.ru/eShop/Air-Cleaners/a705/");
    }

    @Test
    @Tag("rightMenu")
    @Tag("personal")
    @Story("Личный кабинет")
    @DisplayName("Проверка смены языка")
    void checkLangTest() {
        startPage.openPage()
                .clickByText("Личный кабинет")
                .clickByText("Eng")
                .checkVisibleElement("Cleanliness and climate");
    }
}
