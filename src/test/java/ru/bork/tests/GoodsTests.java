package ru.bork.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.bork.components.SideMenu;
import ru.bork.pages.CartPage;
import ru.bork.pages.GoodsPage;
import ru.bork.pages.StartPage;

@Owner("izolina")
@Feature("Товары")
public class GoodsTests extends TestBase {
    StartPage startPage = new StartPage();
    GoodsPage goodsPage = new GoodsPage();
    CartPage cartPage = new CartPage();
    SideMenu sideMenu = new SideMenu();

    @Tag("goods")
    @CsvSource(value = {
            "Красота и здоровье,  Все для спорта",
            "Дом и климат,  Пылесосы",
            "Кухня, Тостеры"
    })
    @ParameterizedTest(name = "Проверка открытия раздела {0} и подраздела {1} с карточками товаров")
    void openSectionsFromSideMenuTest(String section, String subsection) {
        startPage.openPage();
        sideMenu.openSideMenu()
                .openSectionSideMenu(section)
                .openSubsectionMenu(subsection);
        goodsPage.checkArticle();
    }

    @Test
    @Tag("goods")
    @DisplayName("Проверка добавления товара в корзину")
    void checkAddGoodTest() {
        startPage.openPage();
        sideMenu.openSideMenu()
                .openSectionSideMenu("Кухня")
                .openSubsectionMenu("Чайники");
        goodsPage.openArticle()
                .addArticleInCart();
        cartPage.checkCart();
    }

    @Test
    @Tag("goods")
    @DisplayName("Проверка удаления товара из корзины")
    void checkDeleteGoodTest() {
        startPage.openPage();
        sideMenu.openSideMenu()
                .openSectionSideMenu("Кухня")
                .openSubsectionMenu("Чайники");
        goodsPage.openArticle()
                .addArticleInCart()
                .deleteArticleFromCart();
        cartPage.checkEmptyCart();
    }
}
