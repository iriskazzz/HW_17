package ru.bork.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.bork.pages.FormPage;

import static com.codeborne.selenide.Selenide.$;

public class Map {

  private final SelenideElement
          boutiques = $("#wrapper .bork-header-modern__boutiques"),
          map = $("#boutique-map"),
          mapList = $(".boutique-map__list");

  @Step("Переход на страницу с картой бутиков")
  public Map openMap() {
    boutiques.click();
    return this;
  }

  @Step("Проверка отображения карты и списка бутиков")
  public Map checkMapList() {
    map.shouldHave(Condition.visible);
    mapList.shouldHave(Condition.visible);
    return this;
  }
}
