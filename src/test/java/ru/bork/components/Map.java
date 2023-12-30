package ru.bork.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Map {

    private final SelenideElement
            boutiques = $(".bork-header-modern__boutiques"),
            map = $("#boutique-map"),
            mapList = $(".boutique-map__list");

    @Step("Переход на страницу с картой бутиков")
    public Map openMap() {
        boutiques.click();
        return this;
    }

    @Step("Проверка отображения карты и списка бутиков")
    public Map checkMapList() {
        map.shouldHave(visible);
        mapList.shouldHave(visible);
        return this;
    }
}
