package ru.bork.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPage {

    private String URLCURRENT = "https://www.bork.ru/eShop/basket/";
    private String BASKETTEXT = "Корзина";

    private final SelenideElement
            basketTitle = $(".purchase-basket__title"),
            products = $(".purchase-products__single-inner"),
            emptyCart = $(".bork-header-modern__empty-cart-icon");

    @Step("Проверка открытия корзины с товаром")
    public CartPage checkCart() {
        assertEquals(URLCURRENT, WebDriverRunner.url());
        basketTitle.shouldHave(text(BASKETTEXT));
        products.shouldBe(visible);
        return this;
    }

    @Step("Проверка пустой корзины")
    public CartPage checkEmptyCart() {
        emptyCart.shouldBe(visible);
        assertEquals(baseUrl, WebDriverRunner.url());
        return this;
    }
}
