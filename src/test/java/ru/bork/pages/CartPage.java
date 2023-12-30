package ru.bork.pages;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPage {

    private String urlCurrent;

    @Step("Проверка открытия корзины")
    public CartPage checkOpenCart() {
        urlCurrent = WebDriverRunner.url();
        assertEquals("https://www.bork.ru/eShop/basket/", urlCurrent);
        return this;
    }

}
