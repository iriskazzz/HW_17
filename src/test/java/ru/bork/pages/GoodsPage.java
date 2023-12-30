package ru.bork.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoodsPage {

    private String urlCart;
    private final SelenideElement
            basketTitle = $(".purchase-basket__title");

    @Step("Проверка отображения товаров на странице")
    public GoodsPage checkArticle() {
        $$("article").shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Переход на карточку товара")
    public GoodsPage openArticle() {
        $("article a").click();
        return this;
    }

    @Step("Добавление товара в корзину")
    public GoodsPage addArticleInCart() {
        $(byText("Купить")).click();
        basketTitle.shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверка открытия нужной страницы товара")
    public GoodsPage checkArticle(String value) {
        urlCart = WebDriverRunner.url();
        assertEquals(value, urlCart);
        return this;
    }

}
