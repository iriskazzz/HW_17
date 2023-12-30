package ru.bork.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoodsPage {
    private final SelenideElement
            basketTitle = $(".purchase-basket__title"),
            article = $("article a"),
    removeButton = $("[data-test=basket-products-remove-button]");

    @Step("Проверка отображения товаров на странице")
    public GoodsPage checkArticle() {
        $$("article").shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Переход на карточку товара")
    public GoodsPage openArticle() {
        article.click();
        return this;
    }

    @Step("Добавление товара в корзину")
    public GoodsPage addArticleInCart() {
        $(byText("Купить")).click();
        basketTitle.shouldBe(visible);
        return this;
    }

    @Step("Удаление товара из корзины")
    public GoodsPage deleteArticleFromCart() {
        removeButton.click();
        return this;
    }

    @Step("Проверка открытия найденной страницы товара")
    public GoodsPage checkArticle(String value) {
        assertEquals(value, WebDriverRunner.url());
        return this;
    }
}
