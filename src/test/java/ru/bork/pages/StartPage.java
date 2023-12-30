package ru.bork.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StartPage {

    @Step("Открытие главной страницы")
    public StartPage openPage() {
        open(baseUrl);
        return this;
    }

    @Step("Клик по тексту {value}")
    public StartPage clickByText(String value) {
        $(byText(value)).click();
        return this;
    }

    @Step("Проверка видимости элемента {value} на странице")
    public StartPage checkVisibleElement(String value) {
        $(byText(value)).shouldBe(Condition.visible);
        return this;
    }
}
