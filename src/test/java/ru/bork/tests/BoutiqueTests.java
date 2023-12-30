package ru.bork.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.bork.components.Map;
import ru.bork.pages.StartPage;

@Owner("izolina")
@Feature("Карта бутиков")
public class BoutiqueTests extends TestBase {
    StartPage startPage = new StartPage();

    Map map = new Map();

    @Test
    @Tag("boutique")
    @DisplayName("Проверка отображения карты и списка бутиков")
    void checkMap() {
        startPage.openPage();
        map.openMap()
                .checkMapList();
    }
}
